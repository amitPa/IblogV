package com.iblogv.iblogvmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "iblogv_user")
@EqualsAndHashCode(callSuper = false)
public class UserEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7172860469681262545L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iblogv_user_id_pk", unique = true, nullable = false)
	private String id;
	
	@Column(name = "iblogv_user_id", unique = true, nullable = false)
	private String userId;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
}
