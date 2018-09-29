/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.presup.dao;

import java.util.List;
import java.util.Map;
import pe.edu.upeu.presup.controller.Devo;
import pe.edu.upeu.presup.entity.Devon;
import pe.edu.upeu.presup.entity.Prestamo;

/**
 *
 * @author EMILY
 */
public interface DevoDao {
    int create(Devon d);
    List<Map<String, Object>> listt();
}
