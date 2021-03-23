/**
 * 
 */
package com.libary.books.features.bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NonNull;

/**
 * @author kishoreselvaraju
 *
 */
@Entity
@Table(schema = "libary", name = "users")

public @Data class Users {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;

	
	@Column(name = "age")
	private Integer age;

	@Column(name = "email")
	private String email;

	@Column(name = "last_visit")
	private Timestamp lastVist;

	@Column(name = "updated_by")
	private Integer updatedBy;

	@Column(name = "updated_ts")
	private Timestamp updatedTs;

	@Column(name = "is_deleted")
	private Boolean isDeleted;

	@Column(name = "user_type")
	@NonNull
	private String userType;

	@Column(name = "book_count")
	private Integer bookCount;
	
	@Column(name = "user_name")
	@NonNull
	private String userName;
	@NonNull
	@Column(name = "password")
	private String password;
	
	public Users() {
		super();
	}

}
