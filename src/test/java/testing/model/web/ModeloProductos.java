package testing.model.web;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModeloProductos {
    private String producto1;
    private String producto2;
    private String producto3;

    public static List<ModeloProductos> setData(DataTable table) {
        List<ModeloProductos> data = new ArrayList<>();
        List<Map<String, String>> mapList = table.asMaps();
        for (Map<String, String> map : mapList) {
            data.add(new ObjectMapper().convertValue(map, ModeloProductos.class));
        }
        return data;

    }

    public String getProducto1() {
        return producto1;
    }

    public void setProducto1(String producto1) {
        this.producto1 = producto1;
    }

    public String getProducto2() {
        return producto2;
    }

    public void setProducto2(String producto2) {
        this.producto2 = producto2;
    }

    public String getProducto3() {
        return producto3;
    }

    public void setProducto3(String producto3) {
        this.producto3 = producto3;
    }
}
