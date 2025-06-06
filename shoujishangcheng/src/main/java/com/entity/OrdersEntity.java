package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 订单
 *
 * @author 
 * @email
 */
@TableName("orders")
public class OrdersEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public OrdersEntity() {

	}

	public OrdersEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 订单编号
     */
    @TableField(value = "goods_order_uuid_number")

    private String goodsOrderUuidNumber;


    /**
     * 用户id
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 商品id
     */
    @TableField(value = "goods_id")

    private Integer goodsId;


    /**
     * 购买数量
     */
    @TableField(value = "buy_number")

    private Integer buyNumber;


    /**
     * 价格/积分
     */
    @TableField(value = "price")

    private Float price;


    /**
     * 折扣价格
     */
    @TableField(value = "discountprice")

    private Float discountprice;


    /**
     * 总价格/总积分
     */
    @TableField(value = "total")

    private Float total;


    /**
     * 折扣总价格
     */
    @TableField(value = "discounttotal")

    private Float discounttotal;


    /**
     * 订单状态
     */
    @TableField(value = "order_types")

    private Integer orderTypes;


    /**
     * 地址
     */
    @TableField(value = "address_id")

    private Integer addressId;


    /**
     * 物流公司
     */
    @TableField(value = "order_gongshi")

    private String orderGongshi;

    /**
     * 物流单号
     */
    @TableField(value = "order_number")

    private String orderNumber;

    public String getOrderGongshi() {
        return orderGongshi;
    }

    public void setOrderGongshi(String orderGongshi) {
        this.orderGongshi = orderGongshi;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：订单编号
	 */
    public String getGoodsOrderUuidNumber() {
        return goodsOrderUuidNumber;
    }


    /**
	 * 获取：订单编号
	 */

    public void setGoodsOrderUuidNumber(String goodsOrderUuidNumber) {
        this.goodsOrderUuidNumber = goodsOrderUuidNumber;
    }
    /**
	 * 设置：用户id
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户id
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：商品id
	 */
    public Integer getGoodsId() {
        return goodsId;
    }


    /**
	 * 获取：商品id
	 */

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
    /**
	 * 设置：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 获取：购买数量
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 设置：价格/积分
	 */
    public Float getPrice() {
        return price;
    }


    /**
	 * 获取：价格/积分
	 */

    public void setPrice(Float price) {
        this.price = price;
    }
    /**
	 * 设置：折扣价格
	 */
    public Float getDiscountprice() {
        return discountprice;
    }


    /**
	 * 获取：折扣价格
	 */

    public void setDiscountprice(Float discountprice) {
        this.discountprice = discountprice;
    }
    /**
	 * 设置：总价格/总积分
	 */
    public Float getTotal() {
        return total;
    }


    /**
	 * 获取：总价格/总积分
	 */

    public void setTotal(Float total) {
        this.total = total;
    }
    /**
	 * 设置：折扣总价格
	 */
    public Float getDiscounttotal() {
        return discounttotal;
    }


    /**
	 * 获取：折扣总价格
	 */

    public void setDiscounttotal(Float discounttotal) {
        this.discounttotal = discounttotal;
    }
    /**
	 * 设置：订单状态
	 */
    public Integer getOrderTypes() {
        return orderTypes;
    }


    /**
	 * 获取：订单状态
	 */

    public void setOrderTypes(Integer orderTypes) {
        this.orderTypes = orderTypes;
    }
    /**
	 * 设置：地址
	 */
    public Integer getAddressId() {
        return addressId;
    }


    /**
	 * 获取：地址
	 */

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "Orders{" +
            "id=" + id +
            ", insertTime=" + insertTime +
            ", goodsOrderUuidNumber=" + goodsOrderUuidNumber +
            ", yonghuId=" + yonghuId +
            ", goodsId=" + goodsId +
            ", buyNumber=" + buyNumber +
            ", price=" + price +
            ", discountprice=" + discountprice +
            ", total=" + total +
            ", discounttotal=" + discounttotal +
            ", orderTypes=" + orderTypes +
            ", addressId=" + addressId +
        "}";
    }
}
