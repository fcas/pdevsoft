package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IDaoPaciente {

	private static void conectar();

	public static void doCreatePaciente(Paciente paciente);

	public static void createPaciente();

	public static void doDeletePaciente(Paciente paciente);

	public static void deletePaciente();

	public static void doEditPaciente(Paciente paciente);

	public static void editPaciente();

	public static void showPaciente();

	public static void Erro();

	public static void showPaciente_RG(String RG);

	public static void showPaciente_CPF(String CPF);

	public static void showEmail_Paciente(int ID);

	public static void buscarPacienteCPF();

	public static void buscarPacienteRG();

	public static void buscarEmailPaciente();

}
