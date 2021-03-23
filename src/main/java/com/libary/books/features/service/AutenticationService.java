/**
 * 
 */
package com.libary.books.features.service;

import com.libary.books.features.to.request.AutenticationRequest;
import com.libary.books.features.to.response.AutenticationResponse;

/**
 * @author kishoreselvaraju
 *
 */

public interface AutenticationService {

	AutenticationResponse validateUsers(AutenticationRequest authReq) throws Exception;


}
