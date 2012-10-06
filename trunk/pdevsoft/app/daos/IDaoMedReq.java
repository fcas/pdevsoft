package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.*;

public interface IDaoMedReq {

	public void conectar();

	public void showMedreq();

	public void showMedreq_Exame(int ID);

	public void showMedico_Paciente(int ID);

	public void doCreateMedreq(MedicoReq medicoreq);

	public void createMedreq();

	public void buscarMedPacienteID();

	public void buscarMedicoReqExameId();

	public void Erro();

}
