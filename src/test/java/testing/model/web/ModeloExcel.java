package testing.model.web;

public class ModeloExcel {
    private final String usuario;
    private final String password;


    public ModeloExcel(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }
}

