package pe.edu.upeu.presup.daoimp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pe.edu.upeu.presup.dao.UsuarioDao;
import pe.edu.upeu.presup.entity.Usuario;
import pe.edu.upeu.presup.util.Conexion;

public class UsuarioDaoImp implements UsuarioDao {

    private CallableStatement cst;
    private ResultSet rs;
    private Connection cx;

    @Override
    public HashMap<String, Object> validar(String x, String y) {
        HashMap<String, Object> map = new HashMap<>();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call validarUser(?,?)}");
            cst.setString(1, x);
            cst.setString(2, y);
            rs = cst.executeQuery();
            while (rs.next()) {
                map.put("idu", rs.getInt("idusuario"));
                map.put("user", rs.getString("usuario"));
                map.put("nom", rs.getString("nombres"));
                map.put("apell", rs.getString("apellidos"));
                map.put("rol", rs.getString("nom_rol"));
                map.put("irol", rs.getInt("idrol"));
                map.put("itra", rs.getInt("idtrabajador"));
            }
        } catch (SQLException e) {
            System.out.println("Gran errror en : " + e);
        }
        return map;
    }

    @Override
    public int create(Usuario usu) {
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call crearUsuario(?,?,?,?)}");
            cst.setString(1, usu.getUser());
            cst.setString(2, usu.getContrauser());
            cst.setInt(3, usu.getIdroluser());
            cst.setInt(4, usu.getIdtrabajuser());
            x = cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return x;
    }

    @Override
    public List<Usuario> listarNomUsuario() {
        List<Usuario> lis = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call listarNomUsuario()}");
            rs = cst.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setUser(rs.getString("usuario"));
                lis.add(u);
            }
        } catch (SQLException e) {
            System.out.println("ERROR:" + e);
        }
        return lis;

    }

    @Override
    public int CambiarEstadoUsuario(Usuario u) {
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call CambiarEstadoUsuario(?)}");
            cst.setInt(1, u.getIdtrabajuser());

            x = cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
        return x;
    }

    @Override
    public int updateUsuario(Usuario u) {
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call updateUsuario(?,?,?)}");
            cst.setInt(1, u.getIduser());
            cst.setString(2, u.getUser());
            cst.setString(3, u.getContrauser());
            x = cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
        return x;
    }

    @Override
    public List<Map<String, Object>> validarUsu(String usuario) {
        List<Map<String, Object>> data = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call validarUsu(?)}");
            cst.setString(1, usuario);
            rs = cst.executeQuery();
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("idtra", rs.getInt("idtrabajador"));
                map.put("nombres", rs.getString("nombres"));
                map.put("apellidos", rs.getString("apellidos"));
                map.put("usuario", rs.getString("usuario"));
                map.put("idusu", rs.getString("idusuario"));
                data.add(map);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return data;
    }

    @Override
    public int insertIntentos(int cantidad, int idusuario) {
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("call insertIntentos(?,?)");
            cst.setInt(1, cantidad);
            cst.setInt(2, idusuario);
            x = cst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return x;
    }

    @Override
    public int desactivarUsuario(String estado, int idtrabajador) {
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("call desactivarUsuario(?,?)");
            cst.setString(1, estado);
            cst.setInt(2, idtrabajador);
            x = cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return x;
    }
}
