package daos;

import models.*;
import java.util.*;

public interface IDaoPaciente {
	public void criarPaciente(Paciente paciente);
	public void apagarPaciente(int ID);
	public void editarPaciente(Paciente paciente);
	public boolean verificarID(int ID);
	public Paciente buscarPaciente(int ID);
	public Paciente buscarPacienteRG(String RG);
	public Paciente buscarPacienteCPF(String CPF);
}
