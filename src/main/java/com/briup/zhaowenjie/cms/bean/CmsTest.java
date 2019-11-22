package com.briup.zhaowenjie.cms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cms_Test")
public class CmsTest implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1152646010364597707L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "name", nullable = true, unique = true)
	private String name;
	@Column(name = "testString", nullable = true, unique = true)
	private String testString;

	public CmsTest() {
		// TODO Auto-generated constructor stub
	}

	public CmsTest(int id, String name, String testString) {
		this.id = id;
		this.name = name;
		this.testString = testString;
	}



}
