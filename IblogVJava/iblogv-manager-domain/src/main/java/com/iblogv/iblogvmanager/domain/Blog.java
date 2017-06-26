package com.iblogv.iblogvmanager.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Blog {

	private String blogId;
	
	private String blogContent;
	
	private List<Comment> comments;
	
	private String userId;
}
