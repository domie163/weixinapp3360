package com.entity.vo;

import com.entity.AddressEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 地址
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("address")
public class AddressVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户id
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 联系人
     */

    @TableField(value = "address_name")
    private String addressName;


    /**
     * 地址
     */

    @TableField(value = "address_dizhi")
    private String addressDizhi;


    /**
     * 电话
     */

    @TableField(value = "address_phone")
    private String addressPhone;


    /**
     * 是否默认地址
     */

    @TableField(value = "isdefault_types")
    private Integer isdefaultTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
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
	 * 设置：联系人
	 */
    public String getAddressName() {
        return addressName;
    }


    /**
	 * 获取：联系人
	 */

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }
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
    /**
	 * 设置：电话
	 */
    public String getAddressPhone() {
        return addressPhone;
    }


    /**
	 * 获取：电话
	 */

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone;
    }
    /**
	 * 设置：是否默认地址
	 */
    public Integer getIsdefaultTypes() {
        return isdefaultTypes;
    }


    /**
	 * 获取：是否默认地址
	 */

    public void setIsdefaultTypes(Integer isdefaultTypes) {
        this.isdefaultTypes = isdefaultTypes;
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

}
