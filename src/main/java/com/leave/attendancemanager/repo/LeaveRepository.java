package com.leave.attendancemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leave.attendancemanager.entity.LeaveMaster;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveMaster, Long>{
	
	@Modifying
    @Query(value="insert into LEAVE_MASTER (ECODE ,FROM_DT ,MGR_APPROVAL,TO_DT  )\r\n" + 
    		"values((select EMPLOYEE_MASTER.ECODE  from EMPLOYEE_MASTER where EMPLOYEE_MASTER.ECODE=?),?,'pending',?)", nativeQuery=true)
    public int applyLeave(String ecode,String from,String to);

    @Modifying
    @Query(value="Delete from LEAVE_MASTER where LEAVE_MASTER.ECODE=?", nativeQuery=true)
    public int deleteLeave(String ecode);
    
    @Modifying
    @Query(value="update LEAVE_MASTER \r\n" + 
    		"set LEAVE_MASTER.MGR_APPROVAL =?\r\n" + 
    		"where LEAVE_MASTER.ECODE =?" , nativeQuery=true)
    public int managerResponse(String mgrApproval,String ecode);
    
    }


