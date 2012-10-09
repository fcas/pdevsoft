package daos;

import java.util.List;
import models.*;

public interface IDaoMedReq {
	
	public void criarMedicoReq(MedicoReq medReq);
	public void apagarMedicoReq(int CRMR);
	public void editarMedicoReq(MedicoReq medReq);
	public List<MedicoReq> listarMedicosReq();
	public MedicoReq buscarMedicoReq(int CRMR);
}
