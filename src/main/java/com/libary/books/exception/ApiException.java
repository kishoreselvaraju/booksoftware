/**
 * 
 */
package com.libary.books.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

/**
 * @author kishoreselvaraju
 *
 */
public @Data class ApiException {
private  String message;
private  Throwable throwable;
private HttpStatus httpstatus;
public ApiException(String message, Throwable throwable, HttpStatus httpstatus) {
	super();
	this.message = message;
	this.throwable = throwable;
	this.httpstatus = httpstatus;
}


}
