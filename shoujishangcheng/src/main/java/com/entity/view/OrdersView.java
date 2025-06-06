package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableField;
import com.entity.OrdersEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 订单
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("orders")
public class OrdersView extends OrdersEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 订单状态的值
		*/
		private String orderValue;



		//级联表 address
			/**
			* 用户id
			*/
			private Integer yonghuId;
			/**
			* 地址
			*/
			private String addressName;
			/**
			* 电话
			*/
			private String addressPhone;
			/**
			* 是否默认地址
			*/
			private Integer isdefaultTypes;
				/**
				* 是否默认地址的值
				*/
				private String isdefaultValue;
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			/**
			* 创建时间
			*/
			private Date insertTime;

		//级联表 goods
			/**
			* 商品名称
			*/
			private String goodsName;
			/**
			* 商品分类
			*/
			private Integer goodsTypes;
				/**
				* 商品分类的值
				*/
				private String goodsValue;
			/**
			* 商品标签
			*/
			private Integer goodsBiaoqianTypes;
				/**
				* 商品标签的值
				*/
				private String goodsBiaoqianValue;
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
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			/**
			* 最近点击时间
			*/
			private Date goodsClickTime;
			/**
			* 点击次数
			*/
			private Integer goodsClickNumber;
			/**
			* 商品详情
			*/
			private String goodsContent;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 余额
			*/
			private Double newMoney;


	/**
	 * 地址
	 */
	private String addressDizhi;

	/**
	 * 设置：地址
	 */
	public String getAddressDizhi() {
		return addressDizhi;
	}


	/**
	 * 获取：地址
	 */

	public void setAddressDizhi(String addressDizhi) {
		this.addressDizhi = addressDizhi;
	}
	public OrdersView() {

	}

	public OrdersView(OrdersEntity ordersEntity) {
		try {
			BeanUtils.copyProperties(this, ordersEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 订单状态的值
			*/
			public String getOrderValue() {
				return orderValue;
			}
			/**
			* 设置： 订单状态的值
			*/
			public void setOrderValue(String orderValue) {
				this.orderValue = orderValue;
			}






				//级联表的get和set address
					/**
					* 获取： 用户id
					*/
					public Integer getYonghuId() {
						return yonghuId;
					}
					/**
					* 设置： 用户id
					*/
					public void setYonghuId(Integer yonghuId) {
						this.yonghuId = yonghuId;
					}
					/**
					* 获取： 地址
					*/
					public String getAddressName() {
						return addressName;
					}
					/**
					* 设置： 地址
					*/
					public void setAddressName(String addressName) {
						this.addressName = addressName;
					}
					/**
					* 获取： 电话
					*/
					public String getAddressPhone() {
						return addressPhone;
					}
					/**
					* 设置： 电话
					*/
					public void setAddressPhone(String addressPhone) {
						this.addressPhone = addressPhone;
					}
					/**
					* 获取： 是否默认地址
					*/
					public Integer getIsdefaultTypes() {
						return isdefaultTypes;
					}
					/**
					* 设置： 是否默认地址
					*/
					public void setIsdefaultTypes(Integer isdefaultTypes) {
						this.isdefaultTypes = isdefaultTypes;
					}


						/**
						* 获取： 是否默认地址的值
						*/
						public String getIsdefaultValue() {
							return isdefaultValue;
						}
						/**
						* 设置： 是否默认地址的值
						*/
						public void setIsdefaultValue(String isdefaultValue) {
							this.isdefaultValue = isdefaultValue;
						}















				//级联表的get和set goods
					/**
					* 获取： 商品名称
					*/
					public String getGoodsName() {
						return goodsName;
					}
					/**
					* 设置： 商品名称
					*/
					public void setGoodsName(String goodsName) {
						this.goodsName = goodsName;
					}
					/**
					* 获取： 商品分类
					*/
					public Integer getGoodsTypes() {
						return goodsTypes;
					}
					/**
					* 设置： 商品分类
					*/
					public void setGoodsTypes(Integer goodsTypes) {
						this.goodsTypes = goodsTypes;
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
					* 获取： 商品标签
					*/
					public Integer getGoodsBiaoqianTypes() {
						return goodsBiaoqianTypes;
					}
					/**
					* 设置： 商品标签
					*/
					public void setGoodsBiaoqianTypes(Integer goodsBiaoqianTypes) {
						this.goodsBiaoqianTypes = goodsBiaoqianTypes;
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
					* 获取： 图片
					*/
					public String getGoodsPhoto() {
						return goodsPhoto;
					}
					/**
					* 设置： 图片
					*/
					public void setGoodsPhoto(String goodsPhoto) {
						this.goodsPhoto = goodsPhoto;
					}
					/**
					* 获取： 品牌
					*/
					public String getGoodsPinpai() {
						return goodsPinpai;
					}
					/**
					* 设置： 品牌
					*/
					public void setGoodsPinpai(String goodsPinpai) {
						this.goodsPinpai = goodsPinpai;
					}
					/**
					* 获取： 规格
					*/
					public String getGoodsGuige() {
						return goodsGuige;
					}
					/**
					* 设置： 规格
					*/
					public void setGoodsGuige(String goodsGuige) {
						this.goodsGuige = goodsGuige;
					}
					/**
					* 获取： 现价
					*/
					public Double getGoodsNewMoney() {
						return goodsNewMoney;
					}
					/**
					* 设置： 现价
					*/
					public void setGoodsNewMoney(Double goodsNewMoney) {
						this.goodsNewMoney = goodsNewMoney;
					}
					/**
					* 获取： 最近点击时间
					*/
					public Date getGoodsClickTime() {
						return goodsClickTime;
					}
					/**
					* 设置： 最近点击时间
					*/
					public void setGoodsClickTime(Date goodsClickTime) {
						this.goodsClickTime = goodsClickTime;
					}
					/**
					* 获取： 点击次数
					*/
					public Integer getGoodsClickNumber() {
						return goodsClickNumber;
					}
					/**
					* 设置： 点击次数
					*/
					public void setGoodsClickNumber(Integer goodsClickNumber) {
						this.goodsClickNumber = goodsClickNumber;
					}
					/**
					* 获取： 商品详情
					*/
					public String getGoodsContent() {
						return goodsContent;
					}
					/**
					* 设置： 商品详情
					*/
					public void setGoodsContent(String goodsContent) {
						this.goodsContent = goodsContent;
					}
					/**
					* 获取： 创建时间
					*/
					public Date getInsertTime() {
						return insertTime;
					}
					/**
					* 设置： 创建时间
					*/
					public void setInsertTime(Date insertTime) {
						this.insertTime = insertTime;
					}



















				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}






}
