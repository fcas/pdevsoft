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

public class ControllerMedico extends Controller {
	public static IDaoMedLab daoMedLab;
	public static IDaoMedReq daoMedReq;
	/*Em EDITAR a gente teria que fazer uma coisa verificando
	 * as mesmas coisas que se verifica em CRIAR, só que nesse caso
	 * verificar que o ID/CRM não foi alterado. As outras coisas podem ser alteradas
	 desde que mantenha a consistencia de chave estrangeira (no caso de Exame).
	 */
	
	/*Falta o método buscarMedPacienteID, após criá-lo, alterar nos htmls
	 */
	
	public ControllerMedico(IDaoMedLab daoMedLab, IDaoMedReq daoMedReq) {
		this.daoMedLab = daoMedLab;
		this.daoMedReq = daoMedReq;
	}
	
	public static void criarMedicoLab (MedicoLab medLab) {
		
		if (medLab.CRML != 0) {
		
			if (daoMedLab.buscarMedicoLab(medLab.CRML) == null) {
				daoMedLab.criarMedLab(medLab);
				showMedico();
			} else {
				Erro();
			}	
		} else {
			Erro();
		}
	}

	public static void apagarMedicoLab (MedicoLab medLab) {
		if (medLab.CRML != 0) {
			
			if (daoMedLab.buscarMedicoLab(medLab.CRML) != null) {
				daoMedLab.apagarMedLab(medLab);
				showMedico();
			} else {
				Erro();
			}	
		} else {
			Erro();
		}
	}

	public static void editarMedicoLab (MedicoLab medLab) { 
		if (medLab.CRML != 0) {
			
			if (daoMedLab.buscarMedicoLab(medLab.CRML) != null) {
				daoMedLab.editarMedLab(medLab);
				showMedico();
			} else {
				Erro();
			}	
		} else {
			Erro();
		}
	}

	public static void listarMedicosLab() {
		List<MedicoLab> listaMedLab = daoMedLab.listarMedicosLab();
		if (listaMedLab != null) {
			render(listaMedLab);
		} else {
			Erro();
		}
	}
	
	public static void buscarMedicoLab(String CRML) {
		MedicoLab medLab = daoMedLab.buscarMedicoLab(Integer.parseInt(CRML));
		if (medLab != null) {
			render(medLab);
		} else {
			Erro();
		}
	}
	
	public static void criarMedicoReq (MedicoReq medReq) {

		if (medReq.CRMR != 0) {
		
			if (daoMedReq.buscarMedicoReq(medReq.CRMR) == null) {
				daoMedReq.criarMedReq(medReq);
				showMedico();
			} else {
				Erro();
			}	
		} else {
			Erro();
		}
	}

	public static void apagarMedicoReq (MedicoReq medReq) {
		if (medReq.CRMR != 0) {
			
			if (daoMedReq.buscarMedicoReq(medReq.CRMR) != null) {
				daoMedReq.apagarMedReq(medReq);
				showMedico();
			} else {
				Erro();
			}	
		} else {
			Erro();
		}
	}

	public static void editarMedicoReq (MedicoReq medReq) { 
		if (medReq.CRMR != 0) {
			
			if (daoMedReq.buscarMedicoReq(medReq.CRMR) != null) {
				daoMedReq.editarMedReq(medReq);
				showMedico();
			} else {
				Erro();
			}	
		} else {
			Erro();
		}
	}

	public static void listarMedicosReq() {
		List<MedicoReq> listaMedReq = daoMedReq.listarMedicosReq();
		if (listaMedReq != null) {
			render(listaMedReq);
		} else {
			Erro();
		}
	}
	
	public static void buscarMedicoReq(String CRMR) {
		//System.out.println("CRMR A SER BUSCADO = " + CRMR);
		MedicoReq medReq = daoMedReq.buscarMedicoReq(Integer.parseInt(CRMR));
		if (medReq != null) {
			render(medReq);
		} else {
			Erro();
		}
	}
	
	public static void showMedico() {
		render();
	}
	
	public static void showCriarMedicoLab() {
		render();
	}
	
	public static void showCriarMedicoReq() {
		render();
	}
	
	public static void showApagarMedicoLab() {
		render();
	}
	
	public static void showApagarMedicoReq() {
		render();
	}
	
	public static void showEditarMedicoLab() {
		render();
	}
	
	public static void showEditarMedicoReq() {
		render();
	}
	
	public static void showBuscarMedicoLab() {
		render();
	}
	
	public static void showBuscarMedicoReq() {
		render();
	}
	
	public static void Erro() {
		render();
	}

}
