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
public class Devon {
    private int iddevo;
    private String det;
    private int iddetapre;
    private int idPro;

    public Devon(int iddevo, String det, int iddetapre, int idPro) {
        this.iddevo = iddevo;
        this.det = det;
        this.iddetapre = iddetapre;
        this.idPro = idPro;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }
    

    public Devon() {
    }

    public Devon(int iddevo, String det, int iddetapre) {
        this.iddevo = iddevo;
        this.det = det;
        this.iddetapre = iddetapre;
    }

    public Devon(String det, int idPro) {
        this.det = det;
        this.idPro = idPro;
    }

    public int getIddevo() {
        return iddevo;
    }

    public void setIddevo(int iddevo) {
        this.iddevo = iddevo;
    }

    public String getDet() {
        return det;
    }

    public void setDet(String det) {
        this.det = det;
    }

    public int getIddetapre() {
        return iddetapre;
    }

    public void setIddetapre(int iddetapre) {
        this.iddetapre = iddetapre;
    }


    
    
    
}
