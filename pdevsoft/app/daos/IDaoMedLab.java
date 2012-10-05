package daos;
import models.*;
import java.util.List;

public interface IDaoMedLab {
	
	public void criarMedLab(MedicoLab medLab);
	public void deletarMedLab(MedicoLab medLab);
	public void editarMedLab(MedicoLab medLab);
	public List<MedicoLab> listarMedicosLab();
	public List<MedicoLab> buscarMedicoLab(int CRM);

}
