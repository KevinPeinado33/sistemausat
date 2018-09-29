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
public class DetalleReserva {
    
    private int idDetalleReserva;
    private int idReserva;
    private int idProducto;

    public DetalleReserva() {
    }

    public DetalleReserva(int idDetalleReserva, int idReserva, int idProducto) {
        this.idDetalleReserva = idDetalleReserva;
        this.idReserva = idReserva;
        this.idProducto = idProducto;
    }

    public DetalleReserva(int idReserva, int idProducto) {
        this.idReserva = idReserva;
        this.idProducto = idProducto;
    }
    

    public int getIdDetalleReserva() {
        return idDetalleReserva;
    }

    public void setIdDetalleReserva(int idDetalleReserva) {
        this.idDetalleReserva = idDetalleReserva;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public String toString() {
        return "DetalleReserva{" + "idDetalleReserva=" + idDetalleReserva + ", idReserva=" + idReserva + ", idProducto=" + idProducto + '}';
    }
    
    
}
