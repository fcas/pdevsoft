package daos;
import models.*;
import java.util.List;

public interface IDaoMedLab {
	
	public void criarMedicoLab(MedicoLab medLab);
	public void apagarMedicoLab(int CRML);
	public void editarMedicoLab(MedicoLab medLab);
	public List<MedicoLab> listarMedicosLab();
	public MedicoLab buscarMedicoLab(int CRML);

}
