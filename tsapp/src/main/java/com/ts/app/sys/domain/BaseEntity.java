package com.ts.app.sys.domain;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable{
	
	private static final long serialVersionUID = -925844541697060866L;

	/**
	 * 创建人ID
	 */
	private Integer createUserId;
	
	/**
	 * 创建时间
	 */
	private Date createDate;
	
	/**
	 * 更新者ID
	 */
	private Integer updateUserId;
	
	/**
	 * 更新时间
	 */
	private Date updateDate;
	/**
	 * 删除标记（0 正常，1 删除）
	 */
	private String deleteFlag;
	public Integer getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	
}
