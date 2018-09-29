/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package pe.edu.upeu.presup.entity;

/**
 *
 * @author EMILY
 */
public class Tipo {
    private int idTipo;
    private String noTipo;

    public Tipo() {
    }

    public Tipo(int idTipo, String noTipo) {
        this.idTipo = idTipo;
        this.noTipo = noTipo;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNoTipo() {
        return noTipo;
    }

    public void setNoTipo(String noTipo) {
        this.noTipo = noTipo;
    }

}