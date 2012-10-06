package daos;

import models.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IDaoMedLab {

	public void conectar();

	public void showMedlab();

	public void doCreateMedlab(MedicoLab medicolab);

	public void createMedlab();

	public void Erro();

	// public void criarMedLab(MedicoLab medLab);
	// public void deletarMedLab(MedicoLab medLab);
	// public void editarMedLab(MedicoLab medLab);
	// public List<MedicoLab> listarMedicosLab();
	// public List<MedicoLab> buscarMedicoLab(int CRM);

}
