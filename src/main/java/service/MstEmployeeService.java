package service;

import java.util.List;

import dto.MstEmployeeDto;

public interface MstEmployeeService {
	
	public void save(MstEmployeeDto mstKaryawanDto);
	public List<MstEmployeeDto> findAll();
	public void delete(MstEmployeeDto mstKaryawanDto);
	public MstEmployeeDto findOne(MstEmployeeDto mstKaryawanDto);
	public void update(MstEmployeeDto mstKaryawanDto);

}
