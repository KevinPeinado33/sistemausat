/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.presup.dao;

import java.util.List;
import java.util.Map;
import pe.edu.upeu.presup.entity.Prestamo;
import pe.edu.upeu.presup.entity.Producto;
import pe.edu.upeu.presup.entity.Tipo;

/**
 *
 * @author EMILY
 */
public interface DevolucionDao {
    int update(Prestamo p);
    List<Producto> ListarProductosByFecha(String fe,String nom,String ape);
    List<Map<String, Object>> listarDevolucion();

}
