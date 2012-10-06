package daos;

import models.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IDaoExame {
	private static void conectar();

	public static void doCreateExame(Exame exame);

	public static void createExame();

	public static void createExame();

	public static void doEditExame(Exame exame);

	public static void editExame();

	public static void showExame();

	public static void showExame_DataPrometida(String date);

	public static void showExame_Situacao(String situacao);

	public static void showExame_ID(int ID);

	public static void buscarExameID();

	public static void buscarExameSituacao();

	public static void buscarexameDataEntrega();

	public static void showUltimosExames();

	public static void showExamesEntregues();

	public static void showExamesNaoEntregues();

	public static void Erro();
	// public void criarExame(Exame exame);
	// public void deletarExame(Exame exame);
	// public void editarExame(Exame exame);
	// public Exame buscarExameID(int ID);
	// public List<Exame> buscarExame_DataEntrega(String dataEntrega);
	// public List<Exame> buscarExame_Situacao (String Situacao);
	// public List<Exame> buscarUltimosExames ();
	// public List<Exame> buscarExamesEntregues ();
	// public List<Exame> buscarExamesNaoEntregues ();

}