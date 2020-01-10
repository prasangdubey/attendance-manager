package com.leave.attendancemanager.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leave.attendancemanager.entity.EmployeeMaster;
import com.leave.attendancemanager.entity.IEmpLeaveMap;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeMaster ,Long>{
	@Query(value="SELECT * FROM EMPLOYEE_MASTER", nativeQuery=true )
	public List<EmployeeMaster> getAllEmployees();

	@Query(value="SELECT EMPLOYEE_MASTER.ENAME  , LEAVE_MASTER.FROM_DT , LEAVE_MASTER.TO_DT ,LEAVE_MASTER.MGR_APPROVAL \r\n" + 
			"FROM EMPLOYEE_MASTER \r\n" + 
			"RIGHT JOIN LEAVE_MASTER ON EMPLOYEE_MASTER.ECODE =LEAVE_MASTER.ECODE ", nativeQuery=true)
	public List<IEmpLeaveMap> getLeaves();
	@Query(value="SELECT EMPLOYEE_MASTER.ENAME  , LEAVE_MASTER.FROM_DT , LEAVE_MASTER.TO_DT ,LEAVE_MASTER.MGR_APPROVAL\r\n" + 
		"FROM EMPLOYEE_MASTER\r\n" + 
		"RIGHT JOIN LEAVE_MASTER ON EMPLOYEE_MASTER.ECODE =LEAVE_MASTER.ECODE\r\n" + 
		"WHERE EMPLOYEE_MASTER.ENAME =?" ,nativeQuery=true)
    public IEmpLeaveMap getLeaveOfEmployee(String ename);
    @Modifying
	@Query(value="insert into EMPLOYEE_MASTER (ECODE,ENAME,EMAIL,MOBILE_NO )\r\n" + 
			"values(?,?,?,?)", nativeQuery=true)
	public int addEmployee(String ecode,String ename,String email,String mobile_no);
	   
   }
  


