/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.presup.entity;


/**
 *
 * @author  EMILY
 */
public class Producto {
    private int idPro;
    private int idP;
    private String nom;
    private String cod;
    private int est;
    private int iTip;
    private String nomTip;
    private int stock;
    private int dispo;

    public int getDispo() {
        return dispo;
    }

    public void setDispo(int dispo) {
        this.dispo = dispo;
    }
    

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public Producto() {
    }

    public Producto(int idPro, int idP, String nom, String cod, int est, int iTip, String nomTip, int stock) {
        this.idPro = idPro;
        this.idP = idP;
        this.nom = nom;
        this.cod = cod;
        this.est = est;
        this.iTip = iTip;
        this.nomTip = nomTip;
        this.stock = stock;
    }

    public Producto(int idP, String nom, String cod, int est, int iTip) {
        this.idP = idP;
        this.nom = nom;
        this.cod = cod;
        this.est = est;
        this.iTip = iTip;
    }

    public Producto(String nom, String cod, int est, int iTip) {
        this.nom = nom;
        this.cod = cod;
        this.est = est;
        this.iTip = iTip;
    }

    public Producto(int iTip, String nomTip) {
        this.iTip = iTip;
        this.nomTip = nomTip;
    }
    

    
    public Producto(String nomTip) {
        this.nomTip = nomTip;
    }

    public Producto(int idP, int est) {
        this.idP = idP;
        this.est = est;
    }
   
    

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
    public String getNomTip() {
        return nomTip;
    }

    public void setNomTip(String nomTip) {
        this.nomTip = nomTip;
    }
    
    
    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public int getEst() {
        return est;
    }

    public void setEst(int est) {
        this.est = est;
    }

    public int getiTip() {
        return iTip;
    }

    public void setiTip(int iTip) {
        this.iTip = iTip;
    }
    
    
    
    
    
    
}
