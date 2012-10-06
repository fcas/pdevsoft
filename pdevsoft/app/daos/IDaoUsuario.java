package daos;

import java.sql.SQLException;
import models.*;

public interface IDaoUsuario {

	public void conectar();

	public void doCreateUser(Usuarios usuarios);

	public void createUser();

	public void Erro();

}
