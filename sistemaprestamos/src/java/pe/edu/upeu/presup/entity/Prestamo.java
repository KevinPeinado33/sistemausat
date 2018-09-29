/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.presup.entity;

/**
 *
 * @author nicob
 */
public class Prestamo {
    int idprestamo;
    int estado;
    String fe_prestamo;
    String nom_alumno;
    String fe_devolucion;
    String hora_pre;
    String hora_devo;
    String aula;
    int id_profe;
    int id_documento;
    int id_user;
    String nom_profe;
    int idproducto;
    String nom_user;

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public Prestamo(int idprestamo) {
        this.idprestamo = idprestamo;
    }

    public Prestamo(int idprestamo, int idproducto) {
        this.idprestamo = idprestamo;
        this.idproducto = idproducto;
    }

  

    public Prestamo() {
    }

    public Prestamo(String nom_alumno, String fe_devolucion,String hora_devo, String aula, int id_profe, int id_documento, int id_user) {
        
        this.nom_alumno = nom_alumno;
        this.fe_devolucion = fe_devolucion;
        this.hora_devo = hora_devo;
        this.aula = aula;
        this.id_profe = id_profe;
        this.id_documento = id_documento;
        this.id_user = id_user;
    }

    

    public Prestamo(int idprestamo, int estado, int idproducto) {
        this.idprestamo = idprestamo;
        this.estado = estado;
        this.idproducto = idproducto;
    }

    public String getNom_user() {
        return nom_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }
    
    public String getNom_profe() {
        return nom_profe;
    }

    public void setNom_profe(String nom_profe) {
        this.nom_profe = nom_profe;
    }
    
    public String getHora_pre() {
        return hora_pre;
    }

    public void setHora_pre(String hora_pre) {
        this.hora_pre = hora_pre;
    }

    public String getHora_devo() {
        return hora_devo;
    }

    public void setHora_devo(String hora_devo) {
        this.hora_devo = hora_devo;
    }

    public int getId_profe() {
        return id_profe;
    }

    public void setId_profe(int id_profe) {
        this.id_profe = id_profe;
    }

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    public int getIdprestamo() {
        return idprestamo;
    }

    public void setIdprestamo(int idprestamo) {
        this.idprestamo = idprestamo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getFe_prestamo() {
        return fe_prestamo;
    }

    public void setFe_prestamo(String fe_prestamo) {
        this.fe_prestamo = fe_prestamo;
    }

    public String getNom_alumno() {
        return nom_alumno;
    }

    public void setNom_alumno(String nom_alumno) {
        this.nom_alumno = nom_alumno;
    }

    public String getFe_devolucion() {
        return fe_devolucion;
    }

    public void setFe_devolucion(String fe_devolucion) {
        this.fe_devolucion = fe_devolucion;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public void update(Prestamo p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}