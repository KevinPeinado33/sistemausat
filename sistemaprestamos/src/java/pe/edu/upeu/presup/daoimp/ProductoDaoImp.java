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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pe.edu.upeu.presup.dao.ProductoDao;
import pe.edu.upeu.presup.entity.Producto;
import pe.edu.upeu.presup.util.Conexion;

/**
 *
 * @author HP
 */
public class ProductoDaoImp implements ProductoDao {

    private java.sql.CallableStatement cst;
    private ResultSet rs;
    private Connection cx;

    @Override
    public int create(Producto p) {
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call createProducto(?,?,?,?)}");
            cst.setString(1, p.getNom());
            cst.setString(2, p.getCod());
            cst.setInt(3, p.getEst());
            cst.setInt(4, p.getiTip());
            x = cst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ERROR" + e);
        }
        return x;
    }

    @Override
    public int deleate(int key) {
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call deleteProducto(?)}");
            cst.setInt(1, key);
            x = cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
        return x;
    }

    @Override
    public int update(Producto p) {
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call updateProducto(?,?)}");
            cst.setInt(1, p.getIdP());
            cst.setInt(2, p.getEst());
            x = cst.executeUpdate();
            System.out.println(x);
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
        return x;
    }

    @Override
    public Producto read(int key) {
        Producto p = new Producto();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call searchId(?)}");
            cst.setInt(1, key);
            rs = cst.executeQuery();
            while (rs.next()) {

                p.setIdP(rs.getInt("idproducto"));
                p.setNom(rs.getString("nombre"));
                p.setCod(rs.getString("codigo"));
                p.setEst(rs.getInt("estado"));
                p.setiTip(rs.getInt("idtipo"));
            }
        } catch (SQLException e) {
            System.out.println("ERROR:" + e);
        }
        //call searchId(4);
        return p;
    }

    @Override
    public List<Producto> readAll() {
        List<Producto> datos = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call listarProducto()}");
            rs = cst.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdP(rs.getInt("idproducto"));
                p.setNom(rs.getString("nombre"));
                p.setCod(rs.getString("codigo"));
                p.setEst(rs.getInt("estado"));
                p.setiTip(rs.getInt("idtipo"));
                p.setNomTip(rs.getString("nom_tipo"));
                p.setStock(rs.getInt("stock"));
                datos.add(p);
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
        return datos;
    }

    @Override
    public int crea(Producto p) {
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call createTipo(?)}");
            cst.setString(1, p.getNomTip());
            x = cst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ERROR" + e);
        }
        return x;
    }

    @Override
    public List<Producto> ko() {
        List<Producto> fui = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call bueno()}");
            rs = cst.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                
                p.setNomTip(rs.getString("nom_tipo"));
                p.setiTip(rs.getInt("idtipo"));
                fui.add(p);
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
        return fui;
    }

    @Override
    public List<Map<String, Object>> liko() {
        List<Map<String, Object>> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call listarTipo()}");
            rs = cst.executeQuery();
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("no", rs.getString("nom_tipo"));
                map.put("st", rs.getString("stock"));
                map.put("loco", rs.getString("idtipo"));
                lista.add(map);
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
        return lista;
    }

    @Override
    public List<Map<String, Object>> buscarTipoById(int idtipo) {
        List<Map<String, Object>> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call buscarTipoById(?)}");
            cst.setInt(1, idtipo);
            rs = cst.executeQuery();
            while(rs.next()){
                Map<String, Object> map = new HashMap<>();
                map.put("idt", rs.getInt("idtipo"));
                map.put("nom", rs.getString("nom_tipo"));
                lista.add(map);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return lista;
    }

}
