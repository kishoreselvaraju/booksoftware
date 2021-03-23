/**
 * 
 */
package com.libary.books.features.to.request;

import lombok.Data;

/**
 * @author kishoreselvaraju
 *
 */
public @Data class AutenticationRequest {
	private String userName;
	private String passCode;

}
