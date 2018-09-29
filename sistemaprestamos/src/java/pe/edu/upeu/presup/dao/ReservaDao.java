/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.presup.dao;

import java.util.List;
import java.util.Map;
import pe.edu.upeu.presup.entity.DetalleReserva;
import pe.edu.upeu.presup.entity.Reserva;

/**
 *
 * @author Kevin Peinado
 */
public interface ReservaDao {

    int guardarReserva(Reserva r);

    int guardarDetalleReserva(DetalleReserva dr);

    List<Map<String, Object>> validarProfesorByCodigo(String codigo);

    List<Map<String, Object>> listarProductosReserva();

    List<Map<String, Object>> selecionarProdById(int idProducto);

    List<Map<String, Object>> listarInfromeRegistro();

    int eliminarDetalleReserva(int key);

    int eliminarReserva(int key);

    int actualizarReserva(Reserva r);

    int actulizarDetallReserva(DetalleReserva dr);

    List<Map<String, Object>> listarReservaById(int idreserva);

    List<Map<String, Object>> buscarProdReservaById(int key);

}
