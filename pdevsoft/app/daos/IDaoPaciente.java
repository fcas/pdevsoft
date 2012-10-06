package daos;

import models.*;
import java.util.*;

public interface IDaoPaciente {
	public void criarPaciente(Paciente paciente);
	public void apagarPaciente(Paciente paciente);
	public void editarPaciente(Paciente paciente);
	public Paciente buscarPaciente(int ID);
	public Paciente buscarPacienteRG(String RG);
	public Paciente buscarPacienteCPF(String CPF);
}
