package com.libary.books.features.to.response;

import com.libary.books.common.Response;

import lombok.Getter;
import lombok.Setter;

public  class AutenticationResponse extends Response {
	private @Getter @Setter Boolean logged;
	private @Getter @Setter String role;
	

}
