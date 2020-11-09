package com.mg.configurationManager.entity;

import java.sql.Timestamp;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

	private Timestamp createdOn;
	private Timestamp updatedOn;
	private Timestamp createdBy;
	public Timestamp getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	public Timestamp getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}
	public Timestamp getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Timestamp createdBy) {
		this.createdBy = createdBy;
	}
	
	
}
