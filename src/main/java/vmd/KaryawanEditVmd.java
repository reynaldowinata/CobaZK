package vmd;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Include;

import service.MstKaryawanService;
import dto.MstKaryawanDto;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class KaryawanEditVmd {
	
	@WireVariable
	private MstKaryawanService mstKaryawanSvc;
	
	private MstKaryawanDto mstKaryawanDto = new MstKaryawanDto();

	@Init
	public void load(){
		mstKaryawanDto = (MstKaryawanDto) Sessions.getCurrent().getAttribute("objKaryawan");
	}
	
	@Command(value="save")
	public void save(){
		MstKaryawanDto mstKaryawanFindOne = new MstKaryawanDto();
		mstKaryawanFindOne = mstKaryawanSvc.findOne(mstKaryawanDto);
		
		if(mstKaryawanFindOne != null && mstKaryawanFindOne.getId() != null){
			mstKaryawanSvc.update(mstKaryawanDto);
			Clients.showNotification("Data berhasil diupdate", Clients.NOTIFICATION_TYPE_INFO, null, null, 1500);
			Include inc = (Include) Executions.getCurrent().getDesktop().getPage("index").getFellow("mainInclude");
			inc.setSrc("/master/karyawan/karyawan.zul");
		}
		else{
			mstKaryawanSvc.save(mstKaryawanDto);
			Clients.showNotification("Data berhasil disimpan", Clients.NOTIFICATION_TYPE_INFO, null, null, 1500);
			Include inc = (Include) Executions.getCurrent().getDesktop().getPage("index").getFellow("mainInclude");
			inc.setSrc("/master/karyawan/karyawan.zul");
		}
	}
	
	@Command(value="back")
	public void back(){
		Include inc = (Include) Executions.getCurrent().getDesktop().getPage("index").getFellow("mainInclude");
		inc.setSrc("/master/karyawan/karyawan.zul");
	}
	
	/* ----- Setter Getter ----- */
	
	public MstKaryawanDto getMstKaryawanDto() {
		return mstKaryawanDto;
	}

	public void setMstKaryawanDto(MstKaryawanDto mstKaryawanDto) {
		this.mstKaryawanDto = mstKaryawanDto;
	}
	
}
