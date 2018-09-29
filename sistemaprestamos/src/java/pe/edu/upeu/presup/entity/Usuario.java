package pe.edu.upeu.presup.entity;
public class Usuario {
    private int iduser;
    private String user;
    private String contrauser;
    private int estaduser;
    private int idroluser;
    private int idtrabajuser;

    public Usuario() {
    }

    public Usuario(int iduser, String user, String contrauser) {
        this.iduser = iduser;
        this.user = user;
        this.contrauser = contrauser;
    }

    public Usuario(String user, String contrauser, int idroluser, int idtrabajuser) {
        this.user = user;
        this.contrauser = contrauser;
        this.idroluser = idroluser;
        this.idtrabajuser = idtrabajuser;
    }

    public Usuario(int idtrabajuser) {
        this.idtrabajuser = idtrabajuser;
    }
    
    
    
    public Usuario(int iduser, String user, String contrauser, int estaduser, int idroluser, int idtrabajuser) {
        this.iduser = iduser;
        this.user = user;
        this.contrauser = contrauser;
        this.estaduser = estaduser;
        this.idroluser = idroluser;
        this.idtrabajuser = idtrabajuser;
    }

    public Usuario(String user, String contrauser) {
        this.user = user;
        this.contrauser = contrauser;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContrauser() {
        return contrauser;
    }

    public void setContrauser(String contrauser) {
        this.contrauser = contrauser;
    }

    public int getEstaduser() {
        return estaduser;
    }

    public void setEstaduser(int estaduser) {
        this.estaduser = estaduser;
    }

    public int getIdroluser() {
        return idroluser;
    }

    public void setIdroluser(int idroluser) {
        this.idroluser = idroluser;
    }

    public int getIdtrabajuser() {
        return idtrabajuser;
    }

    public void setIdtrabajuser(int idtrabajuser) {
        this.idtrabajuser = idtrabajuser;
    }
    
}
