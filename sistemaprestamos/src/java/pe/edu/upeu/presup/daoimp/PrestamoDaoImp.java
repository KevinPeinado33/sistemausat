/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.presup.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.presup.dao.PrestamoDao;
import pe.edu.upeu.presup.entity.Documento;
import pe.edu.upeu.presup.entity.Prestamo;
import pe.edu.upeu.presup.entity.Producto;
import pe.edu.upeu.presup.entity.Reserva;
import pe.edu.upeu.presup.util.Conexion;

/**
 *
 * @author HP
 */
public class PrestamoDaoImp implements PrestamoDao {

    private java.sql.CallableStatement cs;
    private ResultSet rs;
    private Connection cx;

    @Override
    public int create(Prestamo p) {
        int id = 0;
        try {
            cx = Conexion.getConexion();
            cs = cx.prepareCall("{call createPrestamo(?,?,?,?,?,?,?,?)}");
            cs.setString(1, p.getFe_prestamo());
            cs.setString(2, p.getHora_pre());
            cs.setString(1, p.getHora_devo());
            cs.setString(2, p.getNom_alumno());
            cs.setString(3, p.getFe_devolucion());
            cs.setString(4, p.getAula());
            cs.setInt(5, p.getId_profe());
            cs.setInt(6, p.getId_documento());
            cs.setInt(7, p.getId_user());
            cs.registerOutParameter(8, java.sql.Types.INTEGER);
            cs.executeUpdate();
            id = cs.getInt(8);
        } catch (SQLException e) {
            System.out.println("Error" + e);
        }
        return id;
    }

    @Override
    public int update(Prestamo p) {
         int x = 0;
        try {
            cx = Conexion.getConexion();
            cs = cx.prepareCall("{call updateDisPro(?,?)}");
            cs.setInt(1, p.getIdproducto());
            cs.setInt(2, p.getIdprestamo());
            x = cs.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
        return x;}

    @Override
    public List<Prestamo> readAll() {
        List<Prestamo> pre = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cs = cx.prepareCall("{call ListPrestamos}");
            rs = cs.executeQuery();
            while (rs.next()) {
                Prestamo p = new Prestamo();
                p.setIdprestamo(rs.getInt(1));
                p.setEstado(rs.getInt(2));
                p.setNom_alumno(rs.getString(4));
                p.setAula(rs.getString(6));
                p.setFe_prestamo(rs.getString(3));
                p.setFe_devolucion(rs.getString(5));
                p.setHora_pre(rs.getString(10));
                p.setHora_devo(rs.getString(11));
                p.setId_profe(rs.getInt(7));
                p.setId_documento(rs.getInt(8));
                p.setId_user(rs.getInt(9));
                p.setNom_user(rs.getString(12));
                p.setNom_profe(rs.getString(13));
                
                pre.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return pre;
    }

    @Override
    public boolean search(String p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Prestamo read(int key) {
        Prestamo p = new Prestamo();
        try {
            cx = Conexion.getConexion();
            cs = cx.prepareCall("{call SearchPrestamo(?)}");
            cs.setInt(1, key);
            rs = cs.executeQuery();
            while (rs.next()) {
                p.setIdprestamo(rs.getInt(1));
                p.setEstado(rs.getInt(2));
                p.setFe_prestamo(rs.getString(3));
                p.setNom_alumno(rs.getString(4));
                p.setFe_devolucion(rs.getString(5));
                p.setAula(rs.getString(6));
                p.setId_profe(rs.getInt(7));
                p.setId_documento(rs.getInt(8));
                p.setId_user(rs.getInt(9));

            }
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        return p;
    }

    @Override
    public List<Documento> readDocument() {
        List<Documento> doc = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cs = cx.prepareCall("{call ListDocumento}");

            rs = cs.executeQuery();
            while (rs.next()) {
                Documento d = new Documento();
                d.setId(rs.getInt(1));
                d.setNombre(rs.getString(2));
                doc.add(d);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return doc;
    }

    @Override
    public Producto detalle(int key) {
        Producto pl = new Producto();
        try {
            cx = Conexion.getConexion();
            cs = cx.prepareCall("{call AddProductoDetalle(?)}");
            cs.setInt(1, key);
            rs = cs.executeQuery();
            while (rs.next()) {
                pl.setIdP(rs.getInt(1));
                pl.setNom(rs.getString(2));
                pl.setEst(rs.getInt(3));
                pl.setNomTip(rs.getString(4));
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        return pl;
    }

    @Override
    public Prestamo Reserva(int key) {
        Prestamo pe = new Prestamo();
        try {
            cx = Conexion.getConexion();
            cs = cx.prepareCall("{call EspejoReserva(?)}");
            cs.setInt(1, key);
            rs = cs.executeQuery();
            while (rs.next()) {
                pe.setId_profe(rs.getInt("idprofesor"));
                pe.setFe_devolucion(rs.getString("fe_devolucion"));
                pe.setAula(rs.getString("aula"));
                pe.setFe_prestamo(rs.getString("fe_prestamo"));
                pe.setHora_devo(rs.getString("h_devolucion"));
                pe.setHora_pre(rs.getString("h_prestamo"));
                pe.setNom_profe(rs.getString("nombres"));
            }
        } catch (SQLException e) {
            System.out.println("Error espejo:" + e);
        }
        return pe;
    }

    @Override
    public List<Producto> DetReserva(int key) {
        List<Producto> p = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cs = cx.prepareCall("{call EspejoDetalleReserva(?)}");
            cs.setInt(1, key);
            rs = cs.executeQuery();
            while (rs.next()) {
                Producto pre = new Producto();
                pre.setIdP(rs.getInt(1));
                pre.setNom(rs.getString(2));
                pre.setEst(rs.getInt(3));
                pre.setNomTip(rs.getString(4));
                p.add(pre);
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        return p;
    }

    @Override
    public int updateReserva(Reserva id) {
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cs = cx.prepareCall("{call UpdateEstReserva(?)}");
            cs.setInt(1, id.getIdReserva());
            x = cs.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error estRes" + e);
        }
        return x;
    }

}
