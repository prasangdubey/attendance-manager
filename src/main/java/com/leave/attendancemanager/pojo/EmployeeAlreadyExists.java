package com.leave.attendancemanager.pojo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.IM_USED)
public class EmployeeAlreadyExists extends RuntimeException {

	public EmployeeAlreadyExists(String message) {
		super(message);

	}
	

}
