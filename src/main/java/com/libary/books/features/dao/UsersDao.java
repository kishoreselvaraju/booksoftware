/**
 * 
 */
package com.libary.books.features.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.libary.books.features.bean.Users;

/**
 * @author kishoreselvaraju
 *
 */
@Component
public interface UsersDao extends CrudRepository<Users, Integer> {
	@Query("select u from Users u where u.userName =:userName and u.password = :password ")
	Users getByCredentials(@Param("userName")String userName, @Param("password") String passCode);

	

	
}
