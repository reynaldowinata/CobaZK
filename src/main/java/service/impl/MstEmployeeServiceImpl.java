package service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.bytecode.buildtime.spi.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MstDepartmentDao;
import dao.MstEmployeeDao;
import dto.MstEmployeeDto;
import entity.MstEmployee;
import entity.pk.MstEmployeePk;
import service.MstEmployeeService;

@Service(value="mstEmployeeSvc")
@Transactional
public class MstEmployeeServiceImpl implements MstEmployeeService{

	@Autowired
	private MstEmployeeDao mstEmployeeDao;
	
	@Autowired
	private MstDepartmentDao mstDepartmentDao;
	
	@Override
	public void save(MstEmployeeDto mstKaryawanDto) {
		try {
			MstEmployee mstKaryawan = new MstEmployee();
			mstKaryawan.setCreatedDate(mstKaryawanDto.getCreatedDate());
			mstKaryawan.setCreatedUser(mstKaryawanDto.getCreatedUser());
			mstKaryawan.setDateOfBirth(mstKaryawanDto.getDateOfBirth());
			mstKaryawan.setDeleted(mstKaryawanDto.getDeleted());
			mstKaryawan.setDepartment(mstKaryawanDto.getDepartment());
			mstKaryawan.setEmployeeName(mstKaryawanDto.getEmployeeName());
			mstKaryawan.setUpdatedDate(mstKaryawanDto.getUpdatedDate());
			mstKaryawan.setUpdatedUser(mstKaryawanDto.getUpdatedUser());
			mstKaryawan.setGender(mstKaryawanDto.getGender());
			mstKaryawan.setId(mstKaryawanDto.getId());
			mstKaryawan.setBirthPlace(mstKaryawanDto.getBirthPlace());
			mstKaryawan.setAddress(mstKaryawanDto.getAddress());
			mstKaryawan.setCityCode(mstKaryawanDto.getCityCode());
			mstKaryawan.setPostalCode(mstKaryawanDto.getPostalCode());
			mstKaryawan.setProvinceCode(mstKaryawanDto.getProvinceCode());
			mstEmployeeDao.save(mstKaryawan);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MstEmployeeDto> findAll() {
		List<MstEmployeeDto> list = null;
		try {
			List<MstEmployee> res = mstEmployeeDao.findAll();
			if(res != null && !res.isEmpty() && res.size() > 0){
				list = new ArrayList<MstEmployeeDto>();
				
				for(MstEmployee karyawan : res){
					MstEmployeeDto dto = new MstEmployeeDto();
					dto.setCreatedDate(karyawan.getCreatedDate());
					dto.setCreatedUser(karyawan.getCreatedUser());
					dto.setDateOfBirth(karyawan.getDateOfBirth());
					dto.setDeleted(karyawan.getDeleted());
					dto.setDepartment(karyawan.getDepartment());
					dto.setGender(karyawan.getGender());
					dto.setId(karyawan.getId());
					dto.setEmployeeName(karyawan.getEmployeeName());
					dto.setUpdatedDate(karyawan.getUpdatedDate());
					dto.setUpdatedUser(karyawan.getUpdatedUser());
					dto.setBirthPlace(karyawan.getBirthPlace());
					dto.setAddress(karyawan.getAddress());
					dto.setCityCode(karyawan.getCityCode());
					dto.setPostalCode(karyawan.getPostalCode());
					dto.setProvinceCode(karyawan.getProvinceCode());

					list.add(dto);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			list = null;
		}
		return list;
	}

	@Override
	public void delete(MstEmployeeDto mstKaryawanDto) {
		try {
			MstEmployeePk karyPk = new MstEmployeePk();
			karyPk.setId(mstKaryawanDto.getId());
			
			MstEmployee karyawan = mstEmployeeDao.findOne(karyPk);
			if(karyawan != null && karyawan.getId() != null){
				karyawan.setDeleted(true);
				karyawan.setUpdatedDate(new Date());
				karyawan.setUpdatedUser("ADMIN");
				mstEmployeeDao.save(karyawan);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public MstEmployeeDto findOne(MstEmployeeDto mstKaryawanDto) {
		try {
			MstEmployeePk karyPk = new MstEmployeePk();
			karyPk.setId(mstKaryawanDto.getId());
			MstEmployeeDto dto = null;
			MstEmployee karyawan = mstEmployeeDao.findOne(karyPk);
			if(karyawan != null && karyawan.getId() != null){
				dto = new MstEmployeeDto();
				dto.setCreatedDate(karyawan.getCreatedDate());
				dto.setCreatedUser(karyawan.getCreatedUser());
				dto.setDateOfBirth(karyawan.getDateOfBirth());
				dto.setDeleted(karyawan.getDeleted());
				dto.setDepartment(karyawan.getDepartment());
				dto.setGender(karyawan.getGender());
				dto.setId(karyawan.getId());
				dto.setEmployeeName(karyawan.getEmployeeName());
				dto.setUpdatedDate(karyawan.getUpdatedDate());
				dto.setUpdatedUser(karyawan.getUpdatedUser());
				dto.setBirthPlace(karyawan.getBirthPlace());
			}
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void update(MstEmployeeDto mstKaryawanDto) {
		try {
			MstEmployeePk karyPk = new MstEmployeePk();
			karyPk.setId(mstKaryawanDto.getId());
			
			MstEmployee karyawan = mstEmployeeDao.findOne(karyPk);
			if(karyawan != null && karyawan.getId() != null){
				karyawan.setDeleted(mstKaryawanDto.getDeleted());
				karyawan.setUpdatedDate(new Date());
				karyawan.setUpdatedUser("ADMIN");
				karyawan.setDateOfBirth(mstKaryawanDto.getDateOfBirth());
				karyawan.setDepartment(mstKaryawanDto.getDepartment());
				karyawan.setGender(mstKaryawanDto.getGender());
				karyawan.setEmployeeName(mstKaryawanDto.getEmployeeName());
				karyawan.setBirthPlace(mstKaryawanDto.getBirthPlace());
				karyawan.setAddress(mstKaryawanDto.getAddress());
				karyawan.setCityCode(mstKaryawanDto.getCityCode());
				karyawan.setPostalCode(mstKaryawanDto.getPostalCode());
				karyawan.setProvinceCode(mstKaryawanDto.getProvinceCode());

				mstEmployeeDao.save(karyawan);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
