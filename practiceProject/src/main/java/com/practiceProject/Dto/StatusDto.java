package com.practiceProject.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.ToString;

@JsonInclude(Include.NON_NULL)
public class StatusDto {
private String token;
private String message;
private String code;
private int role;
public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}

public int getRole() {
	return role;
}
public void setRole(int role) {
	this.role = role;
}
@Override
public String toString() {
	return "StatusDto [token=" + token + ", message=" + message + ", code=" + code + ", role=" + role + "]";
}



}
