package pe.edu.upeu.presup.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pe.edu.upeu.presup.entity.Usuario;

public interface UsuarioDao {

    int create(Usuario usu);

    HashMap<String, Object> validar(String x, String y);

    List<Usuario> listarNomUsuario();

    int CambiarEstadoUsuario(Usuario u);

    int updateUsuario(Usuario u);
    
    List<Map<String, Object>> validarUsu(String usuario);
    
    int insertIntentos(int cantidad, int idusuario);
    
    int desactivarUsuario(String estado, int idtrabajador);
}
