/**
 * 
 */
package com.libary.books.features.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.libary.books.common.Response;
import com.libary.books.features.service.AutenticationService;
import com.libary.books.features.to.request.AutenticationRequest;
import com.libary.books.features.to.response.AutenticationResponse;
import com.libary.books.util.DataUtil;

/**
 * @author kishoreselvaraju
 *
 */
@RestController
public class AutenticationController {

	@Autowired (required = true)
	AutenticationService authService;
	
	@Autowired 
	HttpServletRequest httpreq;
	

	@RequestMapping(value = "/authication",method = RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	public AutenticationResponse getEntry(@RequestBody AutenticationRequest authReq,
			HttpServletResponse response) throws Exception{
		AutenticationResponse res = new AutenticationResponse();
		res = authService.validateUsers(authReq);
		res.setResponseCode("200");
		res.setStatusType("Success");
		res.setResponseMessage("You are logged in");
		return res;

	}
	
	@RequestMapping(value = "/getsession",method = RequestMethod.GET)
	@ResponseBody
	public AutenticationResponse getSession() throws Exception{
		AutenticationResponse res = new AutenticationResponse();
		String role = DataUtil.getRoleFromSession(httpreq);
		if(role == null) {
			throw new Exception("Sorry ! You dont have access");
			}
		res.setRole(role);
		res.setResponseCode("200");
		res.setStatusType("Success");
		res.setResponseMessage("You are logged in");
		return res;

	}
	
	@RequestMapping(value = "/logout",method = RequestMethod.GET)
	@ResponseBody
	public Response logout() throws Exception{
		Response res = new Response(); 
		String role = DataUtil.getRoleFromSession(httpreq);
		if(role != null) {
		DataUtil.removeRoleFromSession(httpreq);
			}
		res.setResponseCode("200");
		res.setStatusType("Success");
		res.setResponseCode("Successfully logged out");
		
		return res;

	}
}
