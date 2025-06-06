package com.entity.model;

import com.entity.OrdersEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class OrdersModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 订单编号
     */
    private String goodsOrderUuidNumber;


    /**
     * 用户id
     */
    private Integer yonghuId;


    /**
     * 商品id
     */
    private Integer goodsId;


    /**
     * 购买数量
     */
    private Integer buyNumber;


    /**
     * 价格/积分
     */
    private Float price;


    /**
     * 折扣价格
     */
    private Float discountprice;


    /**
     * 总价格/总积分
     */
    private Float total;


    /**
     * 折扣总价格
     */
    private Float discounttotal;


    /**
     * 订单状态
     */
    private Integer orderTypes;


    /**
     * 地址
     */
    private Integer addressId;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：订单编号
	 */
    public String getGoodsOrderUuidNumber() {
        return goodsOrderUuidNumber;
    }


    /**
	 * 设置：订单编号
	 */
    public void setGoodsOrderUuidNumber(String goodsOrderUuidNumber) {
        this.goodsOrderUuidNumber = goodsOrderUuidNumber;
    }
    /**
	 * 获取：用户id
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户id
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：商品id
	 */
    public Integer getGoodsId() {
        return goodsId;
    }


    /**
	 * 设置：商品id
	 */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
    /**
	 * 获取：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 设置：购买数量
	 */
    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 获取：价格/积分
	 */
    public Float getPrice() {
        return price;
    }


    /**
	 * 设置：价格/积分
	 */
    public void setPrice(Float price) {
        this.price = price;
    }
    /**
	 * 获取：折扣价格
	 */
    public Float getDiscountprice() {
        return discountprice;
    }


    /**
	 * 设置：折扣价格
	 */
    public void setDiscountprice(Float discountprice) {
        this.discountprice = discountprice;
    }
    /**
	 * 获取：总价格/总积分
	 */
    public Float getTotal() {
        return total;
    }


    /**
	 * 设置：总价格/总积分
	 */
    public void setTotal(Float total) {
        this.total = total;
    }
    /**
	 * 获取：折扣总价格
	 */
    public Float getDiscounttotal() {
        return discounttotal;
    }


    /**
	 * 设置：折扣总价格
	 */
    public void setDiscounttotal(Float discounttotal) {
        this.discounttotal = discounttotal;
    }
    /**
	 * 获取：订单状态
	 */
    public Integer getOrderTypes() {
        return orderTypes;
    }


    /**
	 * 设置：订单状态
	 */
    public void setOrderTypes(Integer orderTypes) {
        this.orderTypes = orderTypes;
    }
    /**
	 * 获取：地址
	 */
    public Integer getAddressId() {
        return addressId;
    }


    /**
	 * 设置：地址
	 */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    }
