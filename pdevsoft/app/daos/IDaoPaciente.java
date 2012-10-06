package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.*;

public interface IDaoPaciente {

	public void conectar();

	public void doCreatePaciente(Paciente paciente);

	public void createPaciente();

	public void doDeletePaciente(Paciente paciente);

	public void deletePaciente();

	public void doEditPaciente(Paciente paciente);

	public void editPaciente();

	public void showPaciente();

	public void Erro();

	public void showPaciente_RG(String RG);

	public void showPaciente_CPF(String CPF);

	public void showEmail_Paciente(int ID);

	public void buscarPacienteCPF();

	public void buscarPacienteRG();

	public void buscarEmailPaciente();

}
