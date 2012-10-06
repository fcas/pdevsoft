package daos;

import java.util.List;
import models.*;

public interface IDaoExame {
	public void criarExame(Exame exame);
	public void apagarExame(Exame exame);
	public void editarExame(Exame exame);
	public Exame buscarExame_ID(int ID);
	public Exame buscarExame_DataPrometida(String dataEntrega);
	public Exame buscarExame_Situacao (String Situacao);
	public List<Exame> buscarUltimosExames();
	public List<Exame> listarExames();
//	public List<Exame> buscarExamesEntregues();
//	public List<Exame> buscarExamesNaoEntregues ();
}