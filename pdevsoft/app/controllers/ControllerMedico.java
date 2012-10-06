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
	 Em nenhum dos controller eu implementei essa verificação, então FACAM ISSO!!
	 */
	
	public ControllerMedico(IDaoMedLab daoMedLab, IDaoMedReq daoMedReq) {
		this.daoMedLab = daoMedLab;
		this.daoMedReq = daoMedReq;
	}
	
	public static void criarMedicoLab (MedicoLab medLab) {
		
		if (medLab.CRML != 0) {
		
			if (daoMedLab.buscarMedicoLab(medLab.CRML) == null) {
				daoMedLab.criarMedLab(medLab);
				showMedLab();
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
				showMedLab();
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
				showMedLab();
			} else {
				Erro();
			}	
		} else {
			Erro();
		}
	}

	public static void listarMedicosLab() {
		List<MedicoLab> listaMedLab = new ArrayList<MedicoLab>();
		listaMedLab = daoMedLab.listarMedicosLab();
		render(listaMedLab);
	}
	
	public static void buscarMedicoLab(int CRML) {
		MedicoLab medLab = new MedicoLab();
		medLab = daoMedLab.buscarMedicoLab(CRML);
		render(medLab);
	}
	
	public static void criarMedicoReq (MedicoReq medReq) {

		if (medReq.CRMR != 0) {
		
			if (daoMedReq.buscarMedicoReq(medReq.CRMR) == null) {
				daoMedReq.criarMedReq(medReq);
				showMedReq();
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
				showMedReq();
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
				showMedReq();
			} else {
				Erro();
			}	
		} else {
			Erro();
		}
	}

	public static void listarMedicosReq() {
		List<MedicoReq> listaMedReq = new ArrayList<MedicoReq>();
		listaMedReq = daoMedReq.listarMedicosReq();
		render(listaMedReq);
	}
	
	public static void buscarMedicoReq(int CRMR) {
		MedicoReq medReq = new MedicoReq();
		medReq = daoMedReq.buscarMedicoReq(CRMR);
		render(medReq);
	}
	
	public static void showMedLab() {
		render();
	}
	
	public static void showMedReq() {
		render();
	}
	
	public static void Erro() {
		render();
	}

}
