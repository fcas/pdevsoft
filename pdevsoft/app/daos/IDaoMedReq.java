package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IDaoMedReq {

	private static void conectar();

	public static void showMedreq();

	public static void showMedreq_Exame(int ID);

	public static void showMedico_Paciente(int ID);

	public static void doCreateMedreq(MedicoReq medicoreq);

	public static void createMedreq();

	public static void buscarMedPacienteID();

	public static void buscarMedicoReqExameId();

	public static void Erro();

}
