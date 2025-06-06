package com.entity.model;

import com.entity.GoodsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 商品信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GoodsModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 商品名称
     */
    private String goodsName;


    /**
     * 商品分类
     */
    private Integer goodsTypes;


    /**
     * 商品标签
     */
    private Integer goodsBiaoqianTypes;


    /**
     * 图片
     */
    private String goodsPhoto;


    /**
     * 品牌
     */
    private String goodsPinpai;


    /**
     * 规格
     */
    private String goodsGuige;


    /**
     * 现价
     */
    private Double goodsNewMoney;


    /**
     * 最近点击时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date goodsClickTime;


    /**
     * 点击次数
     */
    private Integer goodsClickNumber;


    /**
     * 商品详情
     */
    private String goodsContent;


    /**
     * 是否特卖
     */
    private Integer goodsTemaiTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
	 * 获取：商品名称
	 */
    public String getGoodsName() {
        return goodsName;
    }


    /**
	 * 设置：商品名称
	 */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    /**
	 * 获取：商品分类
	 */
    public Integer getGoodsTypes() {
        return goodsTypes;
    }


    /**
	 * 设置：商品分类
	 */
    public void setGoodsTypes(Integer goodsTypes) {
        this.goodsTypes = goodsTypes;
    }
    /**
	 * 获取：商品标签
	 */
    public Integer getGoodsBiaoqianTypes() {
        return goodsBiaoqianTypes;
    }


    /**
	 * 设置：商品标签
	 */
    public void setGoodsBiaoqianTypes(Integer goodsBiaoqianTypes) {
        this.goodsBiaoqianTypes = goodsBiaoqianTypes;
    }
    /**
	 * 获取：图片
	 */
    public String getGoodsPhoto() {
        return goodsPhoto;
    }


    /**
	 * 设置：图片
	 */
    public void setGoodsPhoto(String goodsPhoto) {
        this.goodsPhoto = goodsPhoto;
    }
    /**
	 * 获取：品牌
	 */
    public String getGoodsPinpai() {
        return goodsPinpai;
    }


    /**
	 * 设置：品牌
	 */
    public void setGoodsPinpai(String goodsPinpai) {
        this.goodsPinpai = goodsPinpai;
    }
    /**
	 * 获取：规格
	 */
    public String getGoodsGuige() {
        return goodsGuige;
    }


    /**
	 * 设置：规格
	 */
    public void setGoodsGuige(String goodsGuige) {
        this.goodsGuige = goodsGuige;
    }
    /**
	 * 获取：现价
	 */
    public Double getGoodsNewMoney() {
        return goodsNewMoney;
    }


    /**
	 * 设置：现价
	 */
    public void setGoodsNewMoney(Double goodsNewMoney) {
        this.goodsNewMoney = goodsNewMoney;
    }
    /**
	 * 获取：最近点击时间
	 */
    public Date getGoodsClickTime() {
        return goodsClickTime;
    }


    /**
	 * 设置：最近点击时间
	 */
    public void setGoodsClickTime(Date goodsClickTime) {
        this.goodsClickTime = goodsClickTime;
    }
    /**
	 * 获取：点击次数
	 */
    public Integer getGoodsClickNumber() {
        return goodsClickNumber;
    }


    /**
	 * 设置：点击次数
	 */
    public void setGoodsClickNumber(Integer goodsClickNumber) {
        this.goodsClickNumber = goodsClickNumber;
    }
    /**
	 * 获取：商品详情
	 */
    public String getGoodsContent() {
        return goodsContent;
    }


    /**
	 * 设置：商品详情
	 */
    public void setGoodsContent(String goodsContent) {
        this.goodsContent = goodsContent;
    }
    /**
	 * 获取：是否特卖
	 */
    public Integer getGoodsTemaiTypes() {
        return goodsTemaiTypes;
    }


    /**
	 * 设置：是否特卖
	 */
    public void setGoodsTemaiTypes(Integer goodsTemaiTypes) {
        this.goodsTemaiTypes = goodsTemaiTypes;
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

    }
