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
@Override
public String toString() {
	return "StatusDto [token=" + token + ", message=" + message + ", code=" + code + "]";
}
//public StatusDto(String token, String message, String code) {
//	super();
//	this.token = token;
//	this.message = message;
//	this.code = code;
//}


}
