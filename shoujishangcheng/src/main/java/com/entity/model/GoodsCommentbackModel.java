package com.entity.model;

import com.entity.GoodsCommentbackEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 商品评论
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GoodsCommentbackModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 评论商品
     */
    private Integer goodsId;


    /**
     * 评论人
     */
    private Integer yonghuId;


    /**
     * 评论时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 评论内容
     */
    private String goodsCommentbackContent;


    /**
     * 回复内容
     */
    private String goodsReplyContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


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
	 * 获取：评论商品
	 */
    public Integer getGoodsId() {
        return goodsId;
    }


    /**
	 * 设置：评论商品
	 */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
    /**
	 * 获取：评论人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：评论人
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：评论时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：评论时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：评论内容
	 */
    public String getGoodsCommentbackContent() {
        return goodsCommentbackContent;
    }


    /**
	 * 设置：评论内容
	 */
    public void setGoodsCommentbackContent(String goodsCommentbackContent) {
        this.goodsCommentbackContent = goodsCommentbackContent;
    }
    /**
	 * 获取：回复内容
	 */
    public String getGoodsReplyContent() {
        return goodsReplyContent;
    }


    /**
	 * 设置：回复内容
	 */
    public void setGoodsReplyContent(String goodsReplyContent) {
        this.goodsReplyContent = goodsReplyContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
