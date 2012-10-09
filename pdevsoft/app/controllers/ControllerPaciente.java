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
 
public class ControllerPaciente extends Controller { 
    public static IDaoPaciente daoPaciente; 
     
    public ControllerPaciente(IDaoPaciente daoPaciente) { 
        this.daoPaciente = daoPaciente; 
    } 
     
    public static void criarPaciente(Paciente paciente) { //fazer verificacao
    	//da DATA DE NASCIMENTO
         
        if (paciente.ID != 0) { 
            if (daoPaciente.buscarPaciente(paciente.ID) == null) { 
                daoPaciente.criarPaciente(paciente); 
                showPaciente(); 
            } else { 
                Erro(); 
            }     
        } else { 
            Erro(); 
        } 
    } 
 
    public static void apagarPaciente(String ID) { 
         
        if (Integer.parseInt(ID) != 0) { 
            if ((daoPaciente.buscarPaciente(Integer.parseInt(ID)) != null) && 
            		(!daoPaciente.verificarID(Integer.parseInt(ID)))) { 
                daoPaciente.apagarPaciente(Integer.parseInt(ID)); 
                render(); 
            } else { 
                Erro(); 
            }     
        } else { 
            Erro(); 
        } 
    } 
 
    public static void editarPaciente(Paciente paciente) { 
        if (paciente.ID != 0) { 
            if (daoPaciente.buscarPaciente(paciente.ID) != null) { 
                daoPaciente.editarPaciente(paciente); 
                showPaciente(); 
            } else { 
                Erro(); 
            }     
        } else { 
            Erro(); 
        } 
    } 
 
    public static void buscarPaciente(String ID) { 
        Paciente paciente = daoPaciente.buscarPaciente(Integer.parseInt(ID)); 
        if (paciente != null) {
        	render(paciente); 
        } else {
        	Erro();
        }    
    } 
 
    public static void buscarPacienteCPF(String CPF) { 
        Paciente paciente = daoPaciente.buscarPacienteCPF(CPF); 
        if (paciente != null) {
        	render(paciente); 
        } else {
        	Erro();
        }
    } 
 
    public static void buscarPacienteRG(String RG) { 
        Paciente paciente = daoPaciente.buscarPacienteRG(RG);
        if (paciente != null) {
        	render(paciente); 
        } else {
        	Erro();
        }
    } 
     
    public static void showPaciente() { 
        render(); 
    } 
     
    public static void showBuscarPacienteCPF() { 
        render(); 
    } 
     
    public static void showBuscarPacienteRG() { 
        render(); 
    } 
    
    public static void showBuscarPaciente() { 
        render(); 
    } 
     
    public static void showCriarPaciente() { 
        render(); 
    } 
     
    public static void showEditarPaciente() { 
        render(); 
    } 
    
    public static void showApagarPaciente() { 
        render(); 
    } 
     
    public static void Erro() { 
        render();
    }	
}    