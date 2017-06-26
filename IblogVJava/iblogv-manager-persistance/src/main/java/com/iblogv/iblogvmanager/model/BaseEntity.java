package com.iblogv.iblogvmanager.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

/**
 * 
 * @author Amit Pandey
 *
 */

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable{

	private static final long serialVersionUID = 5405324632670970536L;

    @Column(name = "created_date", updatable=false)
    @CreatedDate
    private Date createdDate;

    @Column(name = "last_updated_date")
    @LastModifiedDate
    private Date lastUpdateDate;

}