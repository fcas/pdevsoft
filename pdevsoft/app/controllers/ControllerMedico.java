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
	
	public ControllerMedico(IDaoMedLab daoMedLab, IDaoMedReq daoMedReq) {
		this.daoMedLab = daoMedLab;
		this.daoMedReq = daoMedReq;
	}
	
	public static void criarMedicoLab (MedicoLab medLab) {
		
		if (medLab.CRML != 0) {
			if (daoMedLab.buscarMedicoLab(medLab.CRML) == null) {
				daoMedLab.criarMedicoLab(medLab);
				showMedico();
			} else {
				Erro();
			}	
		} else {
			Erro();
		}
	}

	public static void apagarMedicoLab (String CRML) {
		if (Integer.parseInt(CRML) != 0) {
			
			if ((daoMedLab.buscarMedicoLab(Integer.parseInt(CRML)) != null) && 
					(!daoMedLab.verificarCRM(Integer.parseInt(CRML)))) {
					daoMedLab.apagarMedicoLab(Integer.parseInt(CRML));
					render();	
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
				daoMedLab.editarMedicoLab(medLab);
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
				daoMedReq.criarMedicoReq(medReq);
				showMedico();
			} else {
				Erro();
			}	
		} else {
			Erro();
		}
	}

	public static void apagarMedicoReq (String CRMR) {
		if (Integer.parseInt(CRMR) != 0) {
			
			if ((daoMedReq.buscarMedicoReq(Integer.parseInt(CRMR)) != null) && 
					(!daoMedReq.verificarCRM(Integer.parseInt(CRMR)))) {
				daoMedReq.apagarMedicoReq(Integer.parseInt(CRMR));
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
				daoMedReq.editarMedicoReq(medReq);
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
