/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.presup.dao;

import java.util.List;
import java.util.Map;
import pe.edu.upeu.presup.entity.Producto;

/**
 *
 * @author HP
 */
public interface ProductoDao {
    int create (Producto p);
    int deleate (int key);
    int update (Producto p);
    Producto read(int key);
    List <Producto> readAll();
    int crea (Producto p);
    List <Producto> ko();
    List<Map<String, Object>> liko();
    List<Map<String, Object>> buscarTipoById(int idtipo);
    
    
  }
