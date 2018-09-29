/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.presup.dao;

import java.util.List;
import pe.edu.upeu.presup.entity.Documento;
import pe.edu.upeu.presup.entity.Prestamo;
import pe.edu.upeu.presup.entity.Producto;
import pe.edu.upeu.presup.entity.Reserva;


/**
 *
 * @author HP
 */
public interface PrestamoDao {
    int create(Prestamo p);
    int update(Prestamo p);
    List<Prestamo> readAll();
    boolean search(String p);
    Prestamo read(int key);
    List<Documento> readDocument();
    Producto detalle(int key);
    Prestamo Reserva(int key);
    List<Producto> DetReserva(int key);
    int updateReserva(Reserva id);
  }
