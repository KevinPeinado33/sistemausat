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
public class DetallePrestamo {
    int id_detpres;
    int id_prestamo;
    int id_prod;
    String nom_prod;
    String  codigo;
    int estado;

    public DetallePrestamo() {
    }

    public DetallePrestamo(int id_prestamo, int id_prod) {
        this.id_prestamo = id_prestamo;
        this.id_prod = id_prod;
    }
    
    public DetallePrestamo(int id_prestamo, int id_prod, String nom_prod) {
        this.id_prestamo = id_prestamo;
        this.id_prod = id_prod;
        this.nom_prod = nom_prod;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public DetallePrestamo(int id_prod) {
        this.id_prod = id_prod;
    }

    public DetallePrestamo(String nom_prod) {
        this.nom_prod = nom_prod;
    }
    
    public String getNom_prod() {
        return nom_prod;
    }

    public void setNom_prod(String nom_prod) {
        this.nom_prod = nom_prod;
    }
    
    public int getId_detpres() {
        return id_detpres;
    }

    public void setId_detpres(int id_detpres) {
        this.id_detpres = id_detpres;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }
    
}
