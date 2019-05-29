package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.MstEmployee;
import entity.pk.MstEmployeePk;

public interface MstEmployeeDao extends 
	JpaRepository<MstEmployee, MstEmployeePk>{

}
