package com.entity.view;

import com.entity.GoodsEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 商品信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("goods")
public class GoodsView extends GoodsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 商品分类的值
		*/
		private String goodsValue;
		/**
		* 商品标签的值
		*/
		private String goodsBiaoqianValue;
		/**
		* 是否特卖的值
		*/
		private String goodsTemaiValue;



	public GoodsView() {

	}

	public GoodsView(GoodsEntity goodsEntity) {
		try {
			BeanUtils.copyProperties(this, goodsEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 商品分类的值
			*/
			public String getGoodsValue() {
				return goodsValue;
			}
			/**
			* 设置： 商品分类的值
			*/
			public void setGoodsValue(String goodsValue) {
				this.goodsValue = goodsValue;
			}
			/**
			* 获取： 商品标签的值
			*/
			public String getGoodsBiaoqianValue() {
				return goodsBiaoqianValue;
			}
			/**
			* 设置： 商品标签的值
			*/
			public void setGoodsBiaoqianValue(String goodsBiaoqianValue) {
				this.goodsBiaoqianValue = goodsBiaoqianValue;
			}
			/**
			* 获取： 是否特卖的值
			*/
			public String getGoodsTemaiValue() {
				return goodsTemaiValue;
			}
			/**
			* 设置： 是否特卖的值
			*/
			public void setGoodsTemaiValue(String goodsTemaiValue) {
				this.goodsTemaiValue = goodsTemaiValue;
			}













}
