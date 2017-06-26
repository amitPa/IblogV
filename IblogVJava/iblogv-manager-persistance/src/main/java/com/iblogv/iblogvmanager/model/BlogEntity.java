package com.iblogv.iblogvmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "iblogv_blog")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BlogEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2728605287243087486L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "blog_id_pk", unique = true, nullable = false)
	private String id;
	
	@Column(name = "blog_id", unique = true, nullable = false)
	private String blogId;
	
	@Column(name = "post", nullable = false)
	@Lob
	private String blog;
	
	@ManyToOne(cascade = {}, fetch = FetchType.EAGER, optional = true, targetEntity = UserEntity.class)
	@JoinColumn(name = "author_id", referencedColumnName = "iblogv_user_id_pk")
	private UserEntity authorId;
	
	@Column(name = "comment", nullable = false)
	@Lob
	private String comment;
	
	@Column(name = "likes", nullable = false)
	@Lob
	private String likes;
	
	
	
}
