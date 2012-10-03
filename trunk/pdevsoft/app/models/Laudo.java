package models;

import play.db.jpa.Model;
import javax.persistence.*;

import java.util.*;

public class Laudo extends Model {
	
	public int ID;
	public String analise_macro;
	public String analise_micro;    
	public String resultado; 
	public String dataentrega;

	

	public int ID_paciente = new Paciente().ID;
	public int CRML = new MedicoLab().CRML;
	
}