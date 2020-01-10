package com.leave.attendancemanager.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.leave.attendancemanager.entity.EmployeeMaster;
import com.leave.attendancemanager.entity.IEmpLeaveMap;
import com.leave.attendancemanager.pojo.AddEmployeeReqVO;
import com.leave.attendancemanager.pojo.ApplyLeaveReqVo;
import com.leave.attendancemanager.pojo.ApproveLeaveReqVO;
import com.leave.attendancemanager.pojo.DeleteLeaveReqVo;
import com.leave.attendancemanager.pojo.SuccessResponseVO;
import com.leave.attendancemanager.pojo.UserNotFoundException;
import com.leave.attendancemanager.repo.EmployeeRepository;
import com.leave.attendancemanager.repo.LeaveRepository;


@RestController

public class AttendanceMgrController {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private LeaveRepository leaveRepository;
	@GetMapping("/allEmployees")
	public List<EmployeeMaster> retrieveAllEmployees()
	{
		return  employeeRepository.getAllEmployees();
	}
	@GetMapping("/history")

	public List<IEmpLeaveMap> retrieveLeaveHistory() {
		return employeeRepository.getLeaves();
	}
	@GetMapping("/{ename}")
	public IEmpLeaveMap retrieveEmployeeLeaveHistory(@PathVariable String ename ) {
		if(employeeRepository.getLeaveOfEmployee(ename)==null) {
			throw new UserNotFoundException("ename:-" +ename);	
		}
		return employeeRepository.getLeaveOfEmployee(ename);
	}
	@Transactional(propagation =Propagation.REQUIRED)
	@PostMapping("/applyLeave")
	public SuccessResponseVO addLeave(@RequestBody ApplyLeaveReqVo request ) {
		SuccessResponseVO response = new SuccessResponseVO();
		int rowsAffected =  leaveRepository.applyLeave(request.getEcode(),request.getFrom(),request.to);

		if(rowsAffected > 0) {
			response.setResponseMsg("Leave Applied");
			response.setResponseCode("200");
		}else {
			response.setResponseMsg("Unable to apply for leave");
			response.setResponseCode("500");
		}
		return response;
	}
	@Transactional(propagation =Propagation.REQUIRED)
	@PostMapping("/AddEmployee")
	public SuccessResponseVO addNewEmployee(@RequestBody AddEmployeeReqVO request) {
		SuccessResponseVO response =new SuccessResponseVO();
		try {
			int rowsAffected = employeeRepository.addEmployee(request.getEcode(),request.getEname(),request.getEmail(),request.getMobileNo());
			if(rowsAffected >0) {
				response.setResponseMsg("Added Employee");
				response.setResponseCode("200");
			}else {
				response.setResponseMsg("Unable to Add Employee");
				response.setResponseCode("500");
			}
		}catch(Exception e) {
			
		}
		return response;
	}
	@Transactional(propagation =Propagation.REQUIRED)
	@DeleteMapping("/deleteLeave")
	public SuccessResponseVO deleteEmploeeLeave(@RequestBody DeleteLeaveReqVo request) {
		SuccessResponseVO response=new SuccessResponseVO();
		int  rowsAffected= leaveRepository.deleteLeave(request.getEcode());
		if(rowsAffected >0) {
			response.setResponseMsg("Deleted Leave");
			response.setResponseCode("200");

		}
		else 
		{
			response.setResponseMsg("Unable To Delete Leave");
			response.setResponseCode("500");
		}
		return response;
	}
	@Transactional(propagation =Propagation.REQUIRED)
	@PostMapping("/approveLeaves")
	public SuccessResponseVO retrieveAllLeaves(@RequestBody ApproveLeaveReqVO request) {
		SuccessResponseVO response=new SuccessResponseVO();
		int leaveApproved = leaveRepository.managerResponse(request.getMgrApproval(),request.getEcode());
		if(leaveApproved >0) {
			response.setResponseMsg("Response Successfull");
			response.setResponseCode("200");
		}
		return response;
	}

}









