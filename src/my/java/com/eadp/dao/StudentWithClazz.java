package com.eadp.dao;

public class StudentWithClazz {
	private String name;
	private String clazzName;

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
		return "StudentWithClazz [name=" + name + ", clazzName=" + clazzName + "]";
	}
}
