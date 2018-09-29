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
import pe.edu.upeu.presup.dao.TrabajadorDao;
import pe.edu.upeu.presup.entity.Escuela;
import pe.edu.upeu.presup.entity.Facultad;
import pe.edu.upeu.presup.entity.Profesor;
import pe.edu.upeu.presup.entity.Trabajador;
import pe.edu.upeu.presup.entity.Usuario;
import pe.edu.upeu.presup.util.Conexion;

/**
 *
 * @author Kevin Peinado
 */
public class TrabajadorDaoImp implements TrabajadorDao {

    private java.sql.CallableStatement cst;
    private ResultSet rs;
    private Connection cx;

    @Override
    public int create(Trabajador tr) {
        int id = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call crearTrabajador(?,?,?,?,?,?,?)}");
            cst.setString(1, tr.getNomTrabajador());
            cst.setString(2, tr.getApelTrabajador());
            cst.setString(3, tr.getDireccion());
            cst.setString(4, tr.getNumCelular());
            cst.setString(5, tr.getNumDni());
            cst.setString(6, tr.getEmail()); 
            cst.registerOutParameter(7,java.sql.Types.INTEGER);
            cst.executeUpdate();
            id=cst.getInt(7);
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return id;  }

    @Override
    public List<Trabajador> listarIdTrabajador() {
        List<Trabajador> lis=new ArrayList<>();
        try{
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call listarIdTrabajador()}");
            rs = cst.executeQuery();
            while(rs.next()){
                Trabajador t = new Trabajador();
                t.setIdTrabajador(rs.getInt("idtrabajador"));
                lis.add(t);
            }
        }catch(SQLException e){
            System.out.println("ERROR:"+e);
        }
        return lis;

    }

    @Override
    public List<Trabajador> listarTrabajador() {
       List<Trabajador> lista=new ArrayList<>();
        try{
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call listarTrabajador()}");
            rs = cst.executeQuery();
            while(rs.next()){
                Trabajador tra = new Trabajador();
                tra.setIdTrabajador(rs.getInt("idtrabajador"));
                tra.setNomTrabajador(rs.getString("nombres"));
                tra.setApelTrabajador(rs.getString("apellidos"));
                tra.setDireccion(rs.getString("direccion"));
                tra.setNumCelular(rs.getString("num_celular"));
                tra.setNumDni(rs.getString("dni"));
                tra.setEmail(rs.getString("email"));
                lista.add(tra);
            }
        }catch(SQLException e){
            System.out.println("ERROR:"+e);
        }
        return lista;
    }

    @Override
    public int updatePersona(Trabajador trab, Usuario usua) {
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call updatePersona(?,?,?,?,?,?,?,?,?)}");
            cst.setString(1,trab.getNomTrabajador());
            cst.setString(2,trab.getApelTrabajador());
            cst.setString(3,trab.getDireccion());
            cst.setString(4,trab.getNumCelular());
            cst.setString(5,trab.getNumDni());
            cst.setString(6,trab.getEmail());
            cst.setInt(7,trab.getIdTrabajador());
            cst.setString(8,usua.getUser());
            cst.setString(9,usua.getContrauser());
            x = cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
        return x;   
    }

    @Override
    public List<Trabajador> listarPersona(Integer id) {
       List<Trabajador> lis=new ArrayList<>();
        try{
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call listarPersona(?)}");
            cst.setInt(1,id);
            rs = cst.executeQuery();
            while(rs.next()){
                
                Trabajador tr = new Trabajador();
                tr.setNomTrabajador(rs.getString("nombres"));
                tr.setApelTrabajador(rs.getString("apellidos"));
                tr.setDireccion(rs.getString("direccion"));
                tr.setNumCelular(rs.getString("num_celular"));
                tr.setNumDni(rs.getString("dni"));
                tr.setEmail(rs.getString("email"));
                tr.setUser(rs.getString("usuario"));
                tr.setContrauser(rs.getString("contrasenia"));
                lis.add(tr);
            }
        }catch(SQLException e){
            System.out.println("ERROR:"+e);
        }
        return lis;
        
    }



}
