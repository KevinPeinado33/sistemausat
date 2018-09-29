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
import pe.edu.upeu.presup.dao.TipoDao;
import pe.edu.upeu.presup.entity.Tipo;
import pe.edu.upeu.presup.util.Conexion;

/**
 *
 * @author EMILY
 */
public class TipoDaoImp implements TipoDao{
private java.sql.CallableStatement cst;
    private ResultSet rs;
    private Connection cx;
    @Override
    public int create(Tipo t) {
         int x=0;
        try
        {
            cx= Conexion.getConexion();
            cst = cx.prepareCall("{call createTipo(?)}");
            cst.setInt(1, t.getIdTipo());
            cst.setString(2, t.getNoTipo());
            x = cst.executeUpdate();
            
        }catch(SQLException e)
        {
            System.out.println("ERROR"+e);
        }
        return x;
    }

    @Override
    public int update(Tipo y) {
        int x=0;
        try
        {
            cx= Conexion.getConexion();
            cst = cx.prepareCall("{call updateTupo(?,?)}");
            cst.setInt(1, y.getIdTipo());
            cst.setString(2, y.getNoTipo());
            x = cst.executeUpdate();
            
        }catch(SQLException e)
        {
            System.out.println("ERROR"+e);
        }
        return x;    }

    @Override
    public List<Map<String, Object>> liston(int id) {
List<Map<String, Object>> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call(listarUmu(?)}");
            cst.setInt(1, id);
            rs = cst.executeQuery();
            
            while(rs.next()){
                Map<String, Object> map = new HashMap<>();
                map.put("nom", rs.getString("nombres"));
                map.put("ape",  rs.getString("apellidos"));
                map.put("dn",  rs.getString("dni"));
                map.put("nucel",  rs.getString("num_celular"));
                map.put("dire",  rs.getString("direccion"));
                map.put("corr",  rs.getString("email"));
                map.put("nor",  rs.getString("nom_rol"));
                lista.add(map);
            }
        } catch (SQLException e) {
            System.out.println("ERROR: "+e);
        }
        return lista;    }

  
}
