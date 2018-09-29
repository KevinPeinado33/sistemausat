package pe.edu.upeu.presup.test;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pe.edu.upeu.presup.dao.DevoDao;
import pe.edu.upeu.presup.dao.DevolucionDao;
import pe.edu.upeu.presup.dao.PrestamoDao;
import pe.edu.upeu.presup.dao.PrestamoDetalleDao;
import pe.edu.upeu.presup.dao.ProductoDao;
import pe.edu.upeu.presup.dao.ProfesorDao;
import pe.edu.upeu.presup.dao.TipoDao;
import pe.edu.upeu.presup.dao.UsuarioDao;
import pe.edu.upeu.presup.daoimp.DetallePrestamoDaoImp;
import pe.edu.upeu.presup.daoimp.DevoDaoImp;
import pe.edu.upeu.presup.daoimp.DevolucionDaoImp;
import pe.edu.upeu.presup.daoimp.PrestamoDaoImp;
import pe.edu.upeu.presup.daoimp.ProductoDaoImp;
import pe.edu.upeu.presup.daoimp.ProfesorDaoImp;
import pe.edu.upeu.presup.daoimp.TipoDaoImp;
import pe.edu.upeu.presup.daoimp.UsuarioDaoImp;
import pe.edu.upeu.presup.entity.Devon;
import pe.edu.upeu.presup.entity.Prestamo;
import pe.edu.upeu.presup.entity.Producto;
import pe.edu.upeu.presup.entity.Profesor;
import pe.edu.upeu.presup.entity.Tipo;
import pe.edu.upeu.presup.entity.Usuario;
import static pe.edu.upeu.presup.test.Test.conexion;
import pe.edu.upeu.presup.util.Conexion;

/**
 *
 * @author Kevin Peinado
 */
public class Test {

    static ProductoDao ko = new ProductoDaoImp();
    static Gson g = new Gson();
    static DevolucionDao kop = new DevolucionDaoImp();
    static DevoDao uni = new DevoDaoImp();
    static TipoDao i = new TipoDaoImp();
    static DevoDao po = new DevoDaoImp();
    static UsuarioDao us = new UsuarioDaoImp();
    static ProfesorDao pr = new ProfesorDaoImp();
    static PrestamoDao psr = new PrestamoDaoImp();
    static PrestamoDetalleDao dp = new DetallePrestamoDaoImp();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //hio();
        conexion();
        //conexion();
        //create();
        //listar();
        //delete();
        //update();
        //update();
        // validar();
        //create();
        //listar();
        //delete();
        //update();
        //ate();
        //validar();
        //read();
        //jip();
        //nop();
        // jio();
        //create();
        //pro();
        //lost();
       // nop(4);
        //lista(5);
    }

    static void listar() {
        System.out.println(g.toJson(po.listt()));
    }

    static void conexion() {
        if (Conexion.getConexion() != null) {
            System.out.println("Conexion Correcta Pero eso no quiere decir dejas de ser un fracasado :v ");
        } else {
            System.out.println("Conexion Incorrecta Iguales eres un fracaso :v");
        }
    }

    static void create() {
        Devon p = new Devon("vcv", 2);
        if (po.create(p) > 0) {
            System.out.println("c:");
        } else {
            System.out.println(":c");
        }
    }

    static void hio() {
        Prestamo lop = new Prestamo(3, 2);
        System.out.println(psr.update(lop));

    }

    static void delete() {
        g.toJson(ko.deleate(7));

    }

    static void ate() {
        Prestamo huma = new Prestamo(2, 0, 2);
        System.out.println(g.toJson(kop.update(huma)));

    }

    static void validar() {
        HashMap<String, Object> data = new HashMap<>();
        data = us.validar("marco", "0106");
        System.out.println(data);
        System.out.println(data.size());

    }

    static void read() {
        System.out.println(g.toJson(ko.read(1)));
    }

    static void nop(int id) {
        List<Map<String, Object>> lista = new ArrayList<>(id);
        //lista = i.liston();
        System.out.println(g.toJson(i.liston(id)));
        //System.out.println(lista.size());
    }

    static void jip() {
        System.out.println(g.toJson(ko.ko()));
    }

    static void pro() {

        System.out.println(pr.prestamosIdProfesor(1));

    }

    static void lost() {
        Tipo ijoijo = new Tipo(9, "lost");
        System.out.println(i.update(ijoijo));
    }
    static void lista(int id){
        System.out.println(g.toJson(pr.prestamosIdProfesor(id)));
    }

}
