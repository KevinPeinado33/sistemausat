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
public class Escuela extends Facultad{
    
    private int idEscuela;
    private String nomEscuela;

    public Escuela() {
    }

    public Escuela(String nomEscuela, int idFacultad, String nomFacultad) {
        super(idFacultad, nomFacultad);
        this.nomEscuela = nomEscuela;
    }
    
    public Escuela(int idEscuela, String nomEscuela, int idFacultad, String nomFacultad) {
        super(idFacultad, nomFacultad);
        this.idEscuela = idEscuela;
        this.nomEscuela = nomEscuela;
    }

    public int getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(int idEscuela) {
        this.idEscuela = idEscuela;
    }

    public String getNomEscuela() {
        return nomEscuela;
    }

    public void setNomEscuela(String nomEscuela) {
        this.nomEscuela = nomEscuela;
    }

    @Override
    public String toString() {
        return super.toString() + "Escuela{" + "idEscuela=" + idEscuela + ", nomEscuela=" + nomEscuela + '}';
    }
       
}
