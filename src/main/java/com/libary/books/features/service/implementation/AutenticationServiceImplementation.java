/**
 * 
 */
package com.libary.books.features.service.implementation;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.libary.books.features.bean.Users;
import com.libary.books.features.dao.UsersDao;
import com.libary.books.features.service.AutenticationService;
import com.libary.books.features.to.request.AutenticationRequest;
import com.libary.books.features.to.response.AutenticationResponse;

/**
 * @author kishoreselvaraju
 *
 */
@Service
public class AutenticationServiceImplementation implements AutenticationService {
	@Autowired
	private UsersDao userDao;
	
	@Autowired
	private HttpServletRequest httpReq;

	@Override
	@Transactional
	public AutenticationResponse validateUsers(AutenticationRequest authReq) throws Exception {
		AutenticationResponse res = new AutenticationResponse();
		if ((authReq.getUserName() != null) && (authReq.getPassCode() != null)) {
			Users u =userDao.getByCredentials(authReq.getUserName(), authReq.getPassCode());
			if (u != null) {
				if (u.getUserType() != null) {
					HttpSession s = httpReq.getSession();
					s.setAttribute("AccessToken", u.getUserType());
					res.setLogged(true);
				}
			} else {
				throw new SecurityException("Sorry ! You dont have access for this ");
			}
		} else {
			throw new IOException("Please enter the correct Value");
		}

		return res;
	}

}
