/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.presup.entity;

/**
 *
 * @author Kevin Peinado
 */
public class Trabajador extends Usuario{

    private int idTrabajador;
    private String nomTrabajador;
    private String apelTrabajador;
    private String direccion;
    private String numCelular;
    private String numDni;
    private String email;

    public Trabajador() {
    }

    public Trabajador(int idTrabajador, String nomTrabajador, String apelTrabajador, String direccion, String numCelular, String numDni, String email, String user, String contrauser) {
        super(user, contrauser);
        this.idTrabajador = idTrabajador;
        this.nomTrabajador = nomTrabajador;
        this.apelTrabajador = apelTrabajador;
        this.direccion = direccion;
        this.numCelular = numCelular;
        this.numDni = numDni;
        this.email = email;
    }
    
    public Trabajador(String nomTrabajador, String apelTrabajador, String direccion, String numCelular, String numDni, String email,int idTrabajador) {
        
        this.nomTrabajador = nomTrabajador;
        this.apelTrabajador = apelTrabajador;
        this.direccion = direccion;
        this.numCelular = numCelular;
        this.numDni = numDni;
        this.email = email;
        this.idTrabajador = idTrabajador;
    }

    public Trabajador(String nomTrabajador, String apelTrabajador, String direccion, String numCelular, String numDni, String email) {
        this.nomTrabajador = nomTrabajador;
        this.apelTrabajador = apelTrabajador;
        this.direccion = direccion;
        this.numCelular = numCelular;
        this.numDni = numDni;
        this.email = email;
    }

    
    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getNomTrabajador() {
        return nomTrabajador;
    }

    public void setNomTrabajador(String nomTrabajador) {
        this.nomTrabajador = nomTrabajador;
    }

    public String getApelTrabajador() {
        return apelTrabajador;
    }

    public void setApelTrabajador(String apelTrabajador) {
        this.apelTrabajador = apelTrabajador;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumCelular() {
        return numCelular;
    }

    public void setNumCelular(String numCelular) {
        this.numCelular = numCelular;
    }

    public String getNumDni() {
        return numDni;
    }

    public void setNumDni(String numDni) {
        this.numDni = numDni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "idTrabajador=" + idTrabajador + ", nomTrabajador=" + nomTrabajador + ", apelTrabajador=" + apelTrabajador + ", direccion=" + direccion + ", numCelular=" + numCelular + ", numDni=" + numDni + ", email=" + email + '}';
    }
    

}
