package com.entity.model;

import com.entity.FangwuchuzuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 房屋出租
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-03-06 09:50:15
 */
public class FangwuchuzuModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 房屋封面
	 */
	
	private String fangwufengmian;
		
	/**
	 * 房屋类型
	 */
	
	private String fangwuleixing;
		
	/**
	 * 月租金
	 */
	
	private Integer yuezujin;
		
	/**
	 * 房屋地址
	 */
	
	private String fangwudizhi;
		
	/**
	 * 房屋面积
	 */
	
	private String fangwumianji;
		
	/**
	 * 使用权
	 */
	
	private String shiyongquan;
		
	/**
	 * 租赁状态
	 */
	
	private String zulinzhuangtai;
		
	/**
	 * 户主
	 */
	
	private String huzhu;
		
	/**
	 * 联系方式
	 */
	
	private String lianxifangshi;
		
	/**
	 * 房屋详情
	 */
	
	private String fangwuxiangqing;
		
	/**
	 * 公司账号
	 */
	
	private String gongsizhanghao;
		
	/**
	 * 公司名称
	 */
	
	private String gongsimingcheng;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
	/**
	 * 设置：房屋封面
	 */
	 
	public void setFangwufengmian(String fangwufengmian) {
		this.fangwufengmian = fangwufengmian;
	}
	
	/**
	 * 获取：房屋封面
	 */
	public String getFangwufengmian() {
		return fangwufengmian;
	}
				
	
	/**
	 * 设置：房屋类型
	 */
	 
	public void setFangwuleixing(String fangwuleixing) {
		this.fangwuleixing = fangwuleixing;
	}
	
	/**
	 * 获取：房屋类型
	 */
	public String getFangwuleixing() {
		return fangwuleixing;
	}
				
	
	/**
	 * 设置：月租金
	 */
	 
	public void setYuezujin(Integer yuezujin) {
		this.yuezujin = yuezujin;
	}
	
	/**
	 * 获取：月租金
	 */
	public Integer getYuezujin() {
		return yuezujin;
	}
				
	
	/**
	 * 设置：房屋地址
	 */
	 
	public void setFangwudizhi(String fangwudizhi) {
		this.fangwudizhi = fangwudizhi;
	}
	
	/**
	 * 获取：房屋地址
	 */
	public String getFangwudizhi() {
		return fangwudizhi;
	}
				
	
	/**
	 * 设置：房屋面积
	 */
	 
	public void setFangwumianji(String fangwumianji) {
		this.fangwumianji = fangwumianji;
	}
	
	/**
	 * 获取：房屋面积
	 */
	public String getFangwumianji() {
		return fangwumianji;
	}
				
	
	/**
	 * 设置：使用权
	 */
	 
	public void setShiyongquan(String shiyongquan) {
		this.shiyongquan = shiyongquan;
	}
	
	/**
	 * 获取：使用权
	 */
	public String getShiyongquan() {
		return shiyongquan;
	}
				
	
	/**
	 * 设置：租赁状态
	 */
	 
	public void setZulinzhuangtai(String zulinzhuangtai) {
		this.zulinzhuangtai = zulinzhuangtai;
	}
	
	/**
	 * 获取：租赁状态
	 */
	public String getZulinzhuangtai() {
		return zulinzhuangtai;
	}
				
	
	/**
	 * 设置：户主
	 */
	 
	public void setHuzhu(String huzhu) {
		this.huzhu = huzhu;
	}
	
	/**
	 * 获取：户主
	 */
	public String getHuzhu() {
		return huzhu;
	}
				
	
	/**
	 * 设置：联系方式
	 */
	 
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
				
	
	/**
	 * 设置：房屋详情
	 */
	 
	public void setFangwuxiangqing(String fangwuxiangqing) {
		this.fangwuxiangqing = fangwuxiangqing;
	}
	
	/**
	 * 获取：房屋详情
	 */
	public String getFangwuxiangqing() {
		return fangwuxiangqing;
	}
				
	
	/**
	 * 设置：公司账号
	 */
	 
	public void setGongsizhanghao(String gongsizhanghao) {
		this.gongsizhanghao = gongsizhanghao;
	}
	
	/**
	 * 获取：公司账号
	 */
	public String getGongsizhanghao() {
		return gongsizhanghao;
	}
				
	
	/**
	 * 设置：公司名称
	 */
	 
	public void setGongsimingcheng(String gongsimingcheng) {
		this.gongsimingcheng = gongsimingcheng;
	}
	
	/**
	 * 获取：公司名称
	 */
	public String getGongsimingcheng() {
		return gongsimingcheng;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
