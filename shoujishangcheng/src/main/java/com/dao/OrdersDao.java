package com.dao;

import com.entity.OrdersEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.OrdersView;

/**
 * 订单 Dao 接口
 *
 * @author 
 */
public interface OrdersDao extends BaseMapper<OrdersEntity> {

   List<OrdersView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
