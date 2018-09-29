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
import pe.edu.upeu.presup.controller.Devo;
import pe.edu.upeu.presup.entity.Devon;
import pe.edu.upeu.presup.dao.DevoDao;
import pe.edu.upeu.presup.util.Conexion;

/**
 *
 * @author EMILY
 */
public class DevoDaoImp implements DevoDao{
    private java.sql.CallableStatement cst;
    private ResultSet rs;
    private Connection cx;

    @Override
    public int create(Devon d) {
        int x=0;
        try
        {
            cx= Conexion.getConexion();
            cst = cx.prepareCall("{call createDevolucion(?,?)}");
            cst.setString(1, d.getDet());
            cst.setInt(2, d.getIdPro());
            x = cst.executeUpdate();
            
        }catch(SQLException e)
        {
            System.out.println("ERROR"+e);
        }
        return x;    }

    @Override
    public List<Map<String, Object>> listt() {
       List<Map<String, Object>> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call listarDetalleDevolucion()}");
            rs = cst.executeQuery();
            while(rs.next()){
                Map<String, Object> map = new HashMap<>();
                map.put("detal", rs.getString("detalle"));
                map.put("nom",  rs.getString("nombre"));
                map.put("cod",  rs.getString("codigo"));

                lista.add(map);
            }
        } catch (SQLException e) {
            System.out.println("ERROR: "+e);
        }
        return lista;  }

   
    
}
