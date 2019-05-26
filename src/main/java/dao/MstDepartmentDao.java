package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entity.MstDepartment;
import entity.pk.MstDepartmentPk;

public interface MstDepartmentDao extends 
		JpaRepository<MstDepartment, MstDepartmentPk>,
		MstDepartmentCustomDao{

	
}
