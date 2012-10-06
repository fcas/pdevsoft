package daos;

import models.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IDaoExame {
	public void conectar();

	public void doCreateExame(Exame exame);

	public void createExame();

	public void createExame();

	public void doEditExame(Exame exame);

	public void editExame();

	public void showExame();

	public void showExame_DataPrometida(String date);

	public void showExame_Situacao(String situacao);

	public void showExame_ID(int ID);

	public void buscarExameID();

	public void buscarExameSituacao();

	public void buscarexameDataEntrega();

	public void showUltimosExames();

	public void showExamesEntregues();

	public void showExamesNaoEntregues();

	public void Erro();
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