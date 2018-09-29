/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.presup.daoimp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pe.edu.upeu.presup.dao.ReservaDao;
import pe.edu.upeu.presup.entity.DetalleReserva;
import pe.edu.upeu.presup.entity.Reserva;
import pe.edu.upeu.presup.util.Conexion;

/**
 *
 * @author Kevin Peinado
 */
public class ReservaDaoImp implements ReservaDao {

    private CallableStatement cst;
    private ResultSet rs;
    private Connection cx;

    @Override
    public List<Map<String, Object>> validarProfesorByCodigo(String codigo) {
        List<Map<String, Object>> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call validarProfesorByCodigo(?)}");
            cst.setString(1, codigo);
            rs = cst.executeQuery();
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("idTrabajador", rs.getInt("idtrabajador"));
                map.put("nombres", rs.getString("nombres"));
                map.put("apellidos", rs.getString("apellidos"));
                map.put("idProfesor", rs.getInt("idprofesor"));
                lista.add(map);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return lista;
    }

    @Override
    public List<Map<String, Object>> listarProductosReserva() {
        List<Map<String, Object>> datos = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call listarProductosReserva()}");
            rs = cst.executeQuery();
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("idProducto", rs.getInt("idproducto"));
                map.put("idTipo", rs.getInt("idtipo"));
                map.put("nomProd", rs.getString("nombre"));
                map.put("codigo", rs.getString("codigo"));
                map.put("nomTipo", rs.getString("nom_tipo"));
                map.put("stock", rs.getInt("stock"));
                map.put("estado", rs.getInt("estado"));
                datos.add(map);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return datos;
    }

    @Override
    public List<Map<String, Object>> selecionarProdById(int idProducto) {
        List<Map<String, Object>> data = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call selecionarProdById(?)}");
            cst.setInt(1, idProducto);
            rs = cst.executeQuery();
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("idproducto", rs.getInt("idproducto"));
                map.put("idtipo", rs.getInt("idtipo"));
                map.put("nomProducto", rs.getString("nombre"));
                map.put("codigo", rs.getString("codigo"));
                data.add(map);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return data;
    }

    @Override
    public int guardarReserva(Reserva r) {
        int id = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call registrarReserva(?,?,?,?,?,?,?,?,?)}");
            cst.setInt(1, r.getEstado());
            cst.setString(2, r.getFe_reserva());
            cst.setString(3, r.getFe_devolucion());
            cst.setString(4, r.getAula());
            cst.setInt(5, r.getIdProfesor());
            cst.setString(6, r.getFe_prestamo());
            cst.setString(7, r.getH_devolucion());
            cst.setString(8, r.getH_prestamo());
            cst.registerOutParameter(9, java.sql.Types.INTEGER);
            cst.executeUpdate();
            id = cst.getInt(9);
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return id;
    }

    @Override
    public int guardarDetalleReserva(DetalleReserva dr) {
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call registrarDetalleReserva(?,?)}");
            cst.setInt(1, dr.getIdReserva());
            cst.setInt(2, dr.getIdProducto());
            x = cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return x;
    }

    @Override
    public List<Map<String, Object>> listarInfromeRegistro() {
        List<Map<String, Object>> data = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call listarInfromeRegistro()}");
            rs = cst.executeQuery();
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("idReserva", rs.getInt("idreserva"));
                map.put("feReserva", rs.getDate("fe_reserva"));
                map.put("idprofesor", rs.getInt("idprofesor"));
                map.put("nomProfesor", rs.getString("nombres"));
                map.put("aplProfesor", rs.getString("apellidos"));
                map.put("dni", rs.getString("dni"));
                map.put("iddr", rs.getInt("iddetalle_reserva"));
                data.add(map);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return data;
    }

    @Override
    public int eliminarDetalleReserva(int key) {
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call eliminarDetalleReserva(?)}");
            cst.setInt(1, key);
            x = cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return x;
    }

    @Override
    public int eliminarReserva(int key) {
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call eliminarReserva(?)}");
            cst.setInt(1, key);
            x = cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return x;
    }

    @Override
    public int actualizarReserva(Reserva r) {
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call actualizarReserva(?,?,?,?,?,?)}");
            cst.setInt(1, r.getIdReserva());
            cst.setString(2, r.getAula());
            cst.setString(3, r.getFe_prestamo());
            cst.setString(4, r.getH_prestamo());
            cst.setString(5, r.getFe_devolucion());
            cst.setString(6, r.getH_devolucion());
            x = cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return x;
    }

    @Override
    public int actulizarDetallReserva(DetalleReserva dr) {
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call actualizarDetalleReserva(?,?)}");
            cst.setInt(1, dr.getIdDetalleReserva());
            cst.setInt(2, dr.getIdProducto());
            x = cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return x;
    }

    @Override
    public List<Map<String, Object>> listarReservaById(int idreserva) {
        List<Map<String, Object>> data = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call listarReservaById(?)}");
            cst.setInt(1, idreserva);
            rs = cst.executeQuery();
            while (rs.next()) {                
                Map<String, Object> map = new HashMap<>();
                map.put("idreserva", rs.getInt("idreserva"));
                map.put("fe_devolucion", rs.getString("fe_devolucion"));
                map.put("aula", rs.getString("aula"));
                map.put("fe_prestamo", rs.getString("fe_prestamo"));
                map.put("h_devolucion", rs.getTime("h_devolucion"));
                map.put("h_prestamo", rs.getTime("h_prestamo"));
                map.put("idprofesor", rs.getInt("idprofesor"));
                map.put("nombres", rs.getString("nombres"));
                map.put("apellidos", rs.getString("apellidos"));
                data.add(map);
            }
                    
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return data;
    }

    @Override
    public List<Map<String, Object>> buscarProdReservaById(int key) {
        List<Map<String, Object>> data = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call buscarProdReservaById(?)}");
            cst.setInt(1, key);
            rs = cst.executeQuery();
            while(rs.next()){
                Map<String, Object> map  = new HashMap<>();
                map.put("idreserva", rs.getInt("idreserva"));
                map.put("iddr", rs.getInt("iddetalle_reserva"));
                map.put("idproducto", rs.getInt("idproducto"));
                map.put("nomprod", rs.getString("nombre"));
                map.put("codprod", rs.getString("codigo"));
                data.add(map);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return data;
    }
}
