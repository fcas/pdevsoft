package controllers;

import play.*;
import play.mvc.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.persistence.Id;

import models.*;
import daos.*;

public class Application extends Controller {
	
	public static DAOFactory factory;
	
	public static void index() {
		factory = DAOFactory.createDAOFactory(0);
		IDaoPaciente daoPaciente = factory.createDaoPaciente();
		IDaoExame daoExame = factory.createDaoExame();
		IDaoMedLab daoMedLab = factory.createDaoMedicoLaboratorio();
		IDaoMedReq daoMedReq = factory.createDaoMedicoRequisitante();
		
		ControllerPaciente cpaciente = new ControllerPaciente(daoPaciente);
		ControllerExame cexame = new ControllerExame(daoExame, daoPaciente, daoMedLab, daoMedReq);
		ControllerMedico cmedico = new ControllerMedico (daoMedLab, daoMedReq);
		//ControllerUsuario cusuario = new ControllerUsuario(factory.createDaoUsuario());
				
		render();
	}

	public static void main() {
		render();
	}
	
}