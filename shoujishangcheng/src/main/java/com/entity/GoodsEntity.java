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
 * 商品信息
 *
 * @author 
 * @email
 */
@TableName("goods")
public class GoodsEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GoodsEntity() {

	}

	public GoodsEntity(T t) {
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
     * 商品名称
     */
    @TableField(value = "goods_name")

    private String goodsName;


    /**
     * 商品分类
     */
    @TableField(value = "goods_types")

    private Integer goodsTypes;


    /**
     * 商品标签
     */
    @TableField(value = "goods_biaoqian_types")

    private Integer goodsBiaoqianTypes;


    /**
     * 图片
     */
    @TableField(value = "goods_photo")

    private String goodsPhoto;


    /**
     * 品牌
     */
    @TableField(value = "goods_pinpai")

    private String goodsPinpai;


    /**
     * 规格
     */
    @TableField(value = "goods_guige")

    private String goodsGuige;


    /**
     * 现价
     */
    @TableField(value = "goods_new_money")

    private Double goodsNewMoney;


    /**
     * 最近点击时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "goods_click_time",fill = FieldFill.UPDATE)

    private Date goodsClickTime;


    /**
     * 点击次数
     */
    @TableField(value = "goods_click_number")

    private Integer goodsClickNumber;


    /**
     * 商品详情
     */
    @TableField(value = "goods_content")

    private String goodsContent;


    /**
     * 是否特卖
     */
    @TableField(value = "goods_temai_types")

    private Integer goodsTemaiTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 设置：商品名称
	 */
    public String getGoodsName() {
        return goodsName;
    }


    /**
	 * 获取：商品名称
	 */

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    /**
	 * 设置：商品分类
	 */
    public Integer getGoodsTypes() {
        return goodsTypes;
    }


    /**
	 * 获取：商品分类
	 */

    public void setGoodsTypes(Integer goodsTypes) {
        this.goodsTypes = goodsTypes;
    }
    /**
	 * 设置：商品标签
	 */
    public Integer getGoodsBiaoqianTypes() {
        return goodsBiaoqianTypes;
    }


    /**
	 * 获取：商品标签
	 */

    public void setGoodsBiaoqianTypes(Integer goodsBiaoqianTypes) {
        this.goodsBiaoqianTypes = goodsBiaoqianTypes;
    }
    /**
	 * 设置：图片
	 */
    public String getGoodsPhoto() {
        return goodsPhoto;
    }


    /**
	 * 获取：图片
	 */

    public void setGoodsPhoto(String goodsPhoto) {
        this.goodsPhoto = goodsPhoto;
    }
    /**
	 * 设置：品牌
	 */
    public String getGoodsPinpai() {
        return goodsPinpai;
    }


    /**
	 * 获取：品牌
	 */

    public void setGoodsPinpai(String goodsPinpai) {
        this.goodsPinpai = goodsPinpai;
    }
    /**
	 * 设置：规格
	 */
    public String getGoodsGuige() {
        return goodsGuige;
    }


    /**
	 * 获取：规格
	 */

    public void setGoodsGuige(String goodsGuige) {
        this.goodsGuige = goodsGuige;
    }
    /**
	 * 设置：现价
	 */
    public Double getGoodsNewMoney() {
        return goodsNewMoney;
    }


    /**
	 * 获取：现价
	 */

    public void setGoodsNewMoney(Double goodsNewMoney) {
        this.goodsNewMoney = goodsNewMoney;
    }
    /**
	 * 设置：最近点击时间
	 */
    public Date getGoodsClickTime() {
        return goodsClickTime;
    }


    /**
	 * 获取：最近点击时间
	 */

    public void setGoodsClickTime(Date goodsClickTime) {
        this.goodsClickTime = goodsClickTime;
    }
    /**
	 * 设置：点击次数
	 */
    public Integer getGoodsClickNumber() {
        return goodsClickNumber;
    }


    /**
	 * 获取：点击次数
	 */

    public void setGoodsClickNumber(Integer goodsClickNumber) {
        this.goodsClickNumber = goodsClickNumber;
    }
    /**
	 * 设置：商品详情
	 */
    public String getGoodsContent() {
        return goodsContent;
    }


    /**
	 * 获取：商品详情
	 */

    public void setGoodsContent(String goodsContent) {
        this.goodsContent = goodsContent;
    }
    /**
	 * 设置：是否特卖
	 */
    public Integer getGoodsTemaiTypes() {
        return goodsTemaiTypes;
    }


    /**
	 * 获取：是否特卖
	 */

    public void setGoodsTemaiTypes(Integer goodsTemaiTypes) {
        this.goodsTemaiTypes = goodsTemaiTypes;
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

    @Override
    public String toString() {
        return "Goods{" +
            "id=" + id +
            ", goodsName=" + goodsName +
            ", goodsTypes=" + goodsTypes +
            ", goodsBiaoqianTypes=" + goodsBiaoqianTypes +
            ", goodsPhoto=" + goodsPhoto +
            ", goodsPinpai=" + goodsPinpai +
            ", goodsGuige=" + goodsGuige +
            ", goodsNewMoney=" + goodsNewMoney +
            ", goodsClickTime=" + goodsClickTime +
            ", goodsClickNumber=" + goodsClickNumber +
            ", goodsContent=" + goodsContent +
            ", goodsTemaiTypes=" + goodsTemaiTypes +
            ", insertTime=" + insertTime +
        "}";
    }
}
