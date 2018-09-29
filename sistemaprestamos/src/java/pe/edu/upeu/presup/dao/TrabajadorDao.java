/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.presup.dao;
import java.util.List;
import pe.edu.upeu.presup.entity.Trabajador;
import pe.edu.upeu.presup.entity.Usuario;



/**
 *
 * @author EMILY
 */
public interface TrabajadorDao {
    int create(Trabajador tr);
    List<Trabajador> listarIdTrabajador();
    List<Trabajador>listarTrabajador();
    int updatePersona(Trabajador trab,Usuario usua);
    List<Trabajador>listarPersona(Integer id);
}
