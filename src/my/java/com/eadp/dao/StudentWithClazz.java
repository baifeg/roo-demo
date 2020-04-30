package com.eadp.dao;

import com.eadp.entity.Clazz;

public class StudentWithClazz {
	private String name;
	private String clazzName;
	private Clazz clazz;

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClazzName() {
		return clazzName;
	}

	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}

	@Override
	public String toString() {
		return "StudentWithClazz [name=" + name + ", clazzName=" + clazzName + ", clazz=" + clazz + "]";
	}
}
