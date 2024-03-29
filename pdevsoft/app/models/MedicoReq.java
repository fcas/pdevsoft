package models;

import play.db.jpa.Model;
import javax.persistence.*;
import play.data.validation.Email;

import java.util.*;

public class MedicoReq extends Model {
	
	public int CRMR;
	public String nome;
	public @Email String email; 
	public String telefone; 
	
	//getters and setters
	public int getCRMR() {
		return CRMR;
	}
	public void setCRMR(int cRMR) {
		CRMR = cRMR;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}