package com.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:/config/admin.properties")
public class Admin {
    /**
     * uuid
     */
    @Value("${admin.uuid}")
    private String uuid;

    /**
     * 名称
     */
    @Value("${admin.name}")
    private String name;

    /**
     * qq
     */
    @Value("${admin.qq}")
    private String qq;

    /**
     * 电话
     */
    @Value("${admin.phone}")
    private String phone;

    /**
     * age
     */
    @Value("${admin.age}")
    private int age;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getQq() {
	return qq;
    }

    public void setQq(String qq) {
	this.qq = qq;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public String getUuid() {
	return uuid;
    }

    public void setUuid(String uuid) {
	this.uuid = uuid;
    }

    public int getAge() {
	return age;
    }

    public void setAge(int age) {
	this.age = age;
    }
}
