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

public class ControllerExame extends Controller {

	public static IDaoExame daoExame;
	public static IDaoPaciente daoPaciente;
	public static IDaoMedLab daoMedLab;
	public static IDaoMedReq daoMedReq;
	
	public ControllerExame(IDaoExame daoExame, IDaoPaciente daoPaciente, IDaoMedLab daoMedLab, IDaoMedReq daoMedReq) {//a interface é passada pelo construtor, só que nesse caso, vai ter que passar a de paciente e medico também
		//porque Exame tem as chaves estrangeiras deles, então é necessário pra fazer a verificação
		this.daoExame = daoExame;
		this.daoPaciente = daoPaciente;
		this.daoMedLab = daoMedLab;
		this.daoMedReq = daoMedReq;
	}
	
	public static void criarExame (Exame exame) {
	
		if (exame.ID != 0) { //testa se o ID é vazio
			//verificacao se o ID do exame não existe e os demais campos relacionados a outras entidades existem
			if ((daoExame.buscarExame_ID(exame.ID) == null) && (daoPaciente.buscarPaciente(exame.ID_paciente) != null) 
					&& (daoMedLab.buscarMedicoLab(exame.CRML) != null) && (daoMedReq.buscarMedicoReq(exame.CRMR) != null)) {
				daoExame.criarExame(exame);
				showExame();
			} else {
				Erro();
			}	
		} else {
			Erro();
		}
	}
	
	public static void editarExame (Exame exame) {

		if (exame.ID != 0) {
			if ((daoExame.buscarExame_ID(exame.ID) != null)) {	//o exame tem que existir para ser editado	
				daoExame.editarExame(exame);
				showExame();
			} else {
				Erro();
			}	
		} else {
			Erro();
		}
	}
	
	public static void apagarExame (Exame exame) {
		if (exame.ID != 0) {
			if ((daoExame.buscarExame_ID(exame.ID) != null)) {	//o exame tem que existir para ser apagado
				daoExame.apagarExame(exame);
				showExame();
			} else {
				Erro();
			}	
		} else {
			Erro();
		}
	}
	
	public static void buscarExame_DataPrometida(String data) {
		List<Exame> list_exame = daoExame.buscarExame_DataPrometida(data);
		if (list_exame != null) {
			render(list_exame);
		} else {
			Erro();
		}
	}
	
	public static void buscarExame_Situacao(String situacao) {
		List<Exame> list_exame = daoExame.buscarExame_Situacao(situacao);
		if (list_exame != null) {
			render(list_exame);
		} else {
			Erro();
		}
	}
	
	public static void buscarExame_ID(String ID) {
		Exame exame = daoExame.buscarExame_ID(Integer.parseInt(ID));
		if (exame != null) {
			render(exame);
		} else {
			Erro();
		}
	}
	
	public static void buscarUltimosExames() {
		List<Exame> list_exame = daoExame.buscarUltimosExames();
		if (list_exame != null) {
			render(list_exame);
		} else {
			Erro();
		}
	}
	
	public static void showExame() {
		render();
	}
	
	public static void showBuscarExame_ID() {
		render();
	}
	
//	public static void showExame_Entregues() {
//		render();
//	}
//	
//	public static void showExame_NaoEntregues() {
//		render();
//	}
	
	public static void showBuscarExame_Situacao() {
		render();
	}
	
	public static void showBuscarExame_DataPrometida() {
		render();
	}
	
	public static void showCriarExame() {
		render();
	}
	
	public static void showEditarExame(){
		render();
	}
	
	public static void Erro() {
		render();
	}
	
}