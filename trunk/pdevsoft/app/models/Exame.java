package models;

import play.db.jpa.Model;
import javax.persistence.*;

import java.util.*;

public class Exame extends Model {

	public int ID; 
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getDatarec() {
		return datarec;
	}
	public void setDatarec(String datarec) {
		this.datarec = datarec;
	}
	public String getDataentrega() {
		return dataentrega;
	}
	public void setDataentrega(String dataentrega) {
		this.dataentrega = dataentrega;
	}
	
	public int getID_paciente() {
		return ID_paciente;
	}
	public void setID_paciente(int iD_paciente) {
		ID_paciente = iD_paciente;
	}
	public int getID_laudo() {
		return ID_laudo;
	}
	public void setID_laudo(int iD_laudo) {
		ID_laudo = iD_laudo;
	}
	public int getCRMR() {
		return CRMR;
	}
	public void setCRMR(int cRMR) {
		CRMR = cRMR;
	}
	public String observacoes;
	public String situacao;    
	public String datarec;  
	public String dataentrega;  
	public int ID_material;  
	public int ID_paciente = new Paciente().ID;
	public int ID_laudo = new Laudo().ID;   
	public int CRMR = new MedicoReq().CRMR;
	public int CRML = new MedicoLab().CRML;
	public String Analise_macro;
	public String getAnalise_macro() {
		return Analise_macro;
	}
	public void setAnalise_macro(String analise_macro) {
		Analise_macro = analise_macro;
	}
	public String getAnalise_micro() {
		return Analise_micro;
	}
	public void setAnalise_micro(String analise_micro) {
		Analise_micro = analise_micro;
	}
	public String getResultado() {
		return Resultado;
	}
	public void setResultado(String resultado) {
		Resultado = resultado;
	}
	public void setID_material(int iD_material) {
		ID_material = iD_material;
	}
	public String Analise_micro;
	public String Resultado;
	public int getCRML() {
		return CRML;
	}
	public void setCRML(int cRML) {
		CRML = cRML;
	}
	
}
