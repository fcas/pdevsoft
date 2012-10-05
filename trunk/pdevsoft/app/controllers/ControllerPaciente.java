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
//fazer as verificacoes!!!
public class ControllerPaciente extends Controller {
	IDaoPaciente daoPaciente;
	
	public ControllerPaciente(IDaoPaciente daoPaciente) {
		this.daoPaciente = daoPaciente;
	}
	
	public static void doCreatePaciente(Paciente paciente) {
		daoPaciente.doCreatePaciente(paciente);
	}

	public static void doDeletePaciente(Paciente paciente) {
		daoPaciente.doDeletePaciente(paciente);
	}

	public static void doEditPaciente(Paciente paciente) {
		daoPaciente.doEditPaciente(paciente);
	}

	public static void showPaciente(Paciente paciente) {//verificar
		daoPaciente.showPaciente(paciente);
	}

	public static void Erro() {
		
	}

	public static void showPaciente_RG(String RG) {
		
	}

	public static void showPaciente_CPF(String CPF) {
		
	}

	public static void showEmail_Paciente(int ID) {

	}

	public static void buscarPacienteCPF() {
	
	}

	public static void buscarPacienteRG() {
		
	}

	public static void buscarEmailPaciente() {
	}	

}
