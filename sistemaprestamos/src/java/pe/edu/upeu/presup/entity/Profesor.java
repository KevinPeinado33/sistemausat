
package pe.edu.upeu.presup.entity;

/**
 *
 * @author Kevin Peinado
 */
public class Profesor extends Trabajador{
    
    private int idProfesor;
    private int estado;
    private String grado;
    private String codProfesor;
    private int idEscuela;
    private String nomApe;

    public Profesor() {
    }

    public Profesor(int idProfesor, int estado, String grado, String codProfesor, int idEscuela, int idTrabajador, String nomTrabajador, String apelTrabajador, String direccion, String numCelular, String numDni, String email) {
       
        this.idProfesor = idProfesor;
        this.estado = estado;
        this.grado = grado;
        this.codProfesor = codProfesor;
        this.idEscuela = idEscuela;
    }

    public Profesor(int estado, String grado, String codProfesor, int idEscuela, String nomTrabajador, String apelTrabajador, String direccion, String numCelular, String numDni, String email) {
        super(nomTrabajador, apelTrabajador, direccion, numCelular, numDni, email);
        this.estado = estado;
        this.grado = grado;
        this.codProfesor = codProfesor;
        this.idEscuela = idEscuela;
    }

    public Profesor(int idProfesor, String codProfesor, int idEscuela ,String nomTrabajador, String apelTrabajador, String direccion, String numCelular, String numDni, String email) {
        super(nomTrabajador, apelTrabajador, direccion, numCelular, numDni, email);
        this.idProfesor = idProfesor;
        this.codProfesor = codProfesor;
        this.idEscuela = idEscuela;
    }

  
    
    
    
    public String getNomApe() {
        return nomApe;
    }

    public void setNomApe(String nomApe) {
        this.nomApe = nomApe;
    }
   
    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getCodProfesor() {
        return codProfesor;
    }

    public void setCodProfesor(String codProfesor) {
        this.codProfesor = codProfesor;
    }

    public int getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(int idEscuela) {
        this.idEscuela = idEscuela;
    }

    @Override
    public String toString() {
        return super.toString() + "Profesor{" + "idProfesor=" + idProfesor + ", estado=" + estado + ", grado=" + grado + ", codProfesor=" + codProfesor + ", idEscuela=" + idEscuela + '}';
    }
    
}
