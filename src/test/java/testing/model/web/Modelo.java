package testing.model.web;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import testing.model.LoginModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Modelo {
    private String username;
    private String password;
    private String resultado;

    public static List<Modelo> setData(DataTable table) {
        List<Modelo> data = new ArrayList<>();
        List<Map<String, String>> mapList = table.asMaps();
        for (Map<String, String> map : mapList) {
            data.add(new ObjectMapper().convertValue(map, Modelo.class));
        }
        return data;

    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}

