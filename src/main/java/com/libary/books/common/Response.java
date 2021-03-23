/**
 * 
 */
package com.libary.books.common;

import lombok.Data;

/**
 * @author kishoreselvaraju
 *
 */


public @Data class Response {

	private String responseCode;
	private String responseMessage;
	private String statusType;
}
