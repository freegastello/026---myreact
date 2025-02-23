package com.myreact.reacttest.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myreact.reacttest.dto.GsonRequestDTO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConverterGsonTest {
    @Test
    public void cloneThroughJsonTest() {
        GsonRequestDTO gsonRequestDTO = new GsonRequestDTO("1", "2");
        GsonRequestDTO cloneDTO = ConverterGson.cloneThroughJson(gsonRequestDTO);
        System.out.println("gsonRequestDTO = " + gsonRequestDTO);
        System.out.println("cloneDTO = "       + cloneDTO);
    }

    @Test
    public void converterJsonToObjectTest() {
        String stringJson = new Gson().toJson(createTestList());
        List<GsonRequestDTO> list = new ArrayList<>();
        List<GsonRequestDTO> cloneDTO = ConverterGson.converterJsonToObject(stringJson, list);

        assertEquals("11", cloneDTO.get(0).getId_product());
        assertEquals("44", cloneDTO.get(1).getQty_product());
    }

    @Test
    public void toJsonAndToObjectTest() {
        //Конвертирую в Json
        String stringJson = new Gson().toJson(createTestList());
        System.out.println("strJson = " + stringJson);//strJson = [{"id_product":"11","qty_product":"22"},{"id_product":"11","qty_product":"22"}]

        //Конвертирую обратно в объект
        List<GsonRequestDTO> listDTO2 = new Gson()
                .fromJson(stringJson, new TypeToken<List<GsonRequestDTO>>() {}.getType());

        assertEquals("11", listDTO2.get(0).getId_product());
        assertEquals("44", listDTO2.get(1).getQty_product());
    }

    private List<GsonRequestDTO> createTestList() {
        GsonRequestDTO dto1 = new GsonRequestDTO("11", "22");
        GsonRequestDTO dto2 = new GsonRequestDTO("33", "44");
        List<GsonRequestDTO> listDTO = new ArrayList<>();
        listDTO.add(dto1);
        listDTO.add(dto2);
        return listDTO;
    }
}
