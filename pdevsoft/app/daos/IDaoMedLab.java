package daos;
import models.*;
import java.util.List;

public interface IDaoMedLab {
	
	public void criarMedLab(MedicoLab medLab);
	public void apagarMedLab(MedicoLab medLab);
	public void editarMedLab(MedicoLab medLab);
	public List<MedicoLab> listarMedicosLab();
	public MedicoLab buscarMedicoLab(int CRML);

}
