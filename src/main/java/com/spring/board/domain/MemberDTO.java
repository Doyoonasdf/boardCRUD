package com.spring.board.domain;

import java.util.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

public class MemberDTO {
	
    private String id;            // 회원 아이디
    private String pwd;           // 비밀번호
    private String name;          // 이름
    private String phoneNumber;   // 전화번호
    private String email;         // 이메일
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date birthDate;       // 생년월일
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date createdAt;  // 생성일
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date updatedAt;  // 수정일
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}