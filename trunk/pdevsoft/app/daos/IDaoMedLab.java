package daos;

import models.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IDaoMedLab {

	private static void conectar();

	public static void showMedlab();

	public static void doCreateMedlab(MedicoLab medicolab);

	public static void createMedlab();

	public static void Erro();

	// public void criarMedLab(MedicoLab medLab);
	// public void deletarMedLab(MedicoLab medLab);
	// public void editarMedLab(MedicoLab medLab);
	// public List<MedicoLab> listarMedicosLab();
	// public List<MedicoLab> buscarMedicoLab(int CRM);

}
