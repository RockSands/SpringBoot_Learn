package com.annotation.domain;

public enum EmployeeGanderEnum {
	GENDER_M("M"), GENDER_F("F");

	private String desc;

	EmployeeGanderEnum(String desc) {
		this.setDesc(desc);
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
