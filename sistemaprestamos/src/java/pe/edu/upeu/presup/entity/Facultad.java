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
public class Facultad {
    
    private int idFacultad;
    private String nomFacultad;

    public Facultad() {
    }

    public Facultad(String nomFacultad) {
        this.nomFacultad = nomFacultad;
    }

    public Facultad(int idFacultad, String nomFacultad) {
        this.idFacultad = idFacultad;
        this.nomFacultad = nomFacultad;
    }

    public int getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(int idFacultad) {
        this.idFacultad = idFacultad;
    }

    public String getNomFacultad() {
        return nomFacultad;
    }

    public void setNomFacultad(String nomFacultad) {
        this.nomFacultad = nomFacultad;
    }

    @Override
    public String toString() {
        return "Facultad{" + "idFacultad=" + idFacultad + ", nomFacultad=" + nomFacultad + '}';
    }
    
    
}
