/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.presup.dao;

import java.util.List;
import java.util.Map;
import pe.edu.upeu.presup.entity.Tipo;

/**
 *
 * @author EMILY
 */
public interface TipoDao {
    int create(Tipo t);
    int update(Tipo y);
    List<Map<String,Object>> liston(int id);
}
