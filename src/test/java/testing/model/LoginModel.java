package testing.model;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoginModel {

    private String user;
    private String pass;
    private String pais;

    public static List<LoginModel> setData(DataTable table) {
        List<LoginModel> data = new ArrayList<>();
        List<Map<String, String>> mapList = table.asMaps();
        for (Map<String, String> map : mapList) {
            data.add(new ObjectMapper().convertValue(map, LoginModel.class));
        }
        return data;

    }

    public String getUser() {
        return user;
    }

    public  String getPass() {
        return pass;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}


