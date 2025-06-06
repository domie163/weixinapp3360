package com.controller;







import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/orders")
public class OrdersController {
    private static final Logger logger = LoggerFactory.getLogger(OrdersController.class);

    @Autowired
    private OrdersService ordersService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private AddressService addressService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = ordersService.queryPage(params);

        //字典表数据转换
        List<OrdersView> list =(List<OrdersView>)page.getList();
        for(OrdersView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        OrdersEntity orders = ordersService.selectById(id);
        if(orders !=null){
            //entity转view
            OrdersView view = new OrdersView();
            BeanUtils.copyProperties( orders , view );//把实体数据重构到view中

                //级联表
                AddressEntity address = addressService.selectById(orders.getAddressId());
                if(address != null){
                    BeanUtils.copyProperties( address , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setAddressId(address.getId());
                }
                //级联表
                GoodsEntity goods = goodsService.selectById(orders.getGoodsId());
                if(goods != null){
                    BeanUtils.copyProperties( goods , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setGoodsId(goods.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(orders.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody OrdersEntity orders, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,orders:{}",this.getClass().getName(),orders.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            orders.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        Wrapper<OrdersEntity> queryWrapper = new EntityWrapper<OrdersEntity>()
            .eq("goods_order_uuid_number", orders.getGoodsOrderUuidNumber())
            .eq("yonghu_id", orders.getYonghuId())
            .eq("goods_id", orders.getGoodsId())
            .eq("buy_number", orders.getBuyNumber())
            .eq("price", orders.getPrice())
            .eq("discountprice", orders.getDiscountprice())
            .eq("total", orders.getTotal())
            .eq("discounttotal", orders.getDiscounttotal())
            .eq("order_types", orders.getOrderTypes())
            .eq("address_id", orders.getAddressId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        OrdersEntity ordersEntity = ordersService.selectOne(queryWrapper);
        if(ordersEntity==null){
            orders.setInsertTime(new Date());
            ordersService.insert(orders);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody OrdersEntity orders, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,orders:{}",this.getClass().getName(),orders.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            orders.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<OrdersEntity> queryWrapper = new EntityWrapper<OrdersEntity>()
            .notIn("id",orders.getId())
            .andNew()
            .eq("goods_order_uuid_number", orders.getGoodsOrderUuidNumber())
            .eq("yonghu_id", orders.getYonghuId())
            .eq("goods_id", orders.getGoodsId())
            .eq("buy_number", orders.getBuyNumber())
            .eq("price", orders.getPrice())
            .eq("discountprice", orders.getDiscountprice())
            .eq("total", orders.getTotal())
            .eq("discounttotal", orders.getDiscounttotal())
            .eq("order_types", orders.getOrderTypes())
            .eq("address_id", orders.getAddressId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        OrdersEntity ordersEntity = ordersService.selectOne(queryWrapper);
        if(ordersEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      orders.set
            //  }
            ordersService.updateById(orders);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ordersService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }







}

