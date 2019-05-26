package service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MstDepartmentDao;
import dao.MstKaryawanDao;
import dto.MstKaryawanDto;
import entity.MstKaryawan;
import service.MstKaryawanService;

@Service(value="mstKaryawanSvc")
@Transactional
public class MstKaryawanServiceImpl implements MstKaryawanService{

	@Autowired
	private MstKaryawanDao mstKaryawanDao;
	
	@Autowired
	private MstDepartmentDao mstDepartmentDao;
	
	@Override
	public void save(MstKaryawanDto mstKaryawanDto) {
		try {
			MstKaryawan mstKaryawan = new MstKaryawan();
			mstKaryawan.setCreatedDate(mstKaryawanDto.getCreatedDate());
			mstKaryawan.setCreatedUser(mstKaryawanDto.getCreatedUser());
			mstKaryawan.setDateOfBirth(mstKaryawanDto.getDateOfBirth());
			mstKaryawan.setDeleted(mstKaryawanDto.getDeleted());
			mstKaryawan.setDepartment(mstKaryawanDto.getDepartment());
			mstKaryawan.setNamaKaryawan(mstKaryawanDto.getNamaKaryawan());
			mstKaryawan.setUpdatedDate(mstKaryawanDto.getUpdatedDate());
			mstKaryawan.setUpdatedUser(mstKaryawanDto.getUpdatedUser());
			mstKaryawan.setGender(mstKaryawanDto.getGender());
			
			mstKaryawanDao.save(mstKaryawan);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MstKaryawanDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
