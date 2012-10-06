package daos;

import java.util.List;
import models.*;

public interface IDaoMedReq {
	
	public void criarMedReq(MedicoReq medReq);
	public void apagarMedReq(MedicoReq medReq);
	public void editarMedReq(MedicoReq medReq);
	public List<MedicoReq> listarMedicosReq();
	public MedicoReq buscarMedicoReq(int CRMR);
}
