package com.gl.studentmanagementlab6.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="roles")
public class Role {
	
	@Id
	@GeneratedValue
	@Column(name="roleId")
	private int roleId;
	
	@Column(name="roleName")
	private String roleName;
}
