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
import pe.edu.upeu.presup.dao.DevolucionDao;
import pe.edu.upeu.presup.entity.Prestamo;
import pe.edu.upeu.presup.entity.Producto;
import pe.edu.upeu.presup.entity.Tipo;
import pe.edu.upeu.presup.util.Conexion;

/**
 *
 * @author EMILY
 */
public class DevolucionDaoImp implements DevolucionDao {

    private java.sql.CallableStatement cst;
    private ResultSet rs;
    private Connection cx;
    
    @Override
    public int update(Prestamo p) {
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call updateDisPro(?,?)}");
            cst.setInt(1, p.getIdproducto());
            cst.setInt(2, p.getIdprestamo());
            x = cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
        return x;
    }


    @Override
    public List<Map<String, Object>> listarDevolucion() {
        List<Map<String, Object>> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call(listarDetallePrestamo()}");
            rs = cst.executeQuery();
            while(rs.next()){
                Map<String, Object> map = new HashMap<>();
                map.put("nom", rs.getString("nombres"));
                map.put("ape",  rs.getString("apellidos"));
                map.put("codi",  rs.getString("codigo"));
                map.put("fep",  rs.getString("fe_prestamo"));
                map.put("fed",  rs.getString("fe_devolucion"));
                map.put("est",  rs.getString("estado"));
                map.put("no",  rs.getString("nombre"));
                map.put("idprestamo",  rs.getString("idprestamo"));
                map.put("nom_Tip",  rs.getString("nom_tipo"));
                map.put("horap",  rs.getString("hora_prestamo"));
                map.put("horad",  rs.getString("hora_devolucion"));


                lista.add(map);
            }
        } catch (SQLException e) {
            System.out.println("ERROR: "+e);
        }
        return lista;
    }

    @Override
    public List<Producto> ListarProductosByFecha(String fe, String nom, String ape) {
        List<Producto> prod=new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call PROBAR(?,?,?)}");
            cst.setString(1, fe);
            cst.setString(2, nom);
            cst.setString(3, ape);
            
            rs = cst.executeQuery();
            while(rs.next()){
                Producto p = new Producto();
                p.setIdP(rs.getInt("idprestamo"));
                p.setNom(rs.getString("nombre"));
                p.setIdPro(rs.getInt("idproducto"));
                p.setDispo(rs.getInt("disposicion"));
                prod.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return prod;

    }
}

