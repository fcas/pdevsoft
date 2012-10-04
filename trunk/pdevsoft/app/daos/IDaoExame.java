package daos;

public interface IDaoExame {
	public void criarExame(Exame exame)
	public void deletarExame(Exame exame)
	public void editarExame(Exame exame)
	public Exame buscarExameID(int ID)
	public List<Exame> buscarExame_DataEntrega(String dataEntrega)
	public List<Exame> buscarExame_Situacao (String Situacao)
	public List<Exame> buscarUltimosExames ()
	public List<Exame> buscarExamesEntregues ()
	public List<Exame> buscarExamesNaoEntregues ()
}