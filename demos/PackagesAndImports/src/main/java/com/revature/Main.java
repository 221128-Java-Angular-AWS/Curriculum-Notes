package com.revature;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.plummer.KylesClass;


public class Main {
    public static void main(String[] args) {
        KylesClass kc = new KylesClass();

        ObjectMapper mapper = new ObjectMapper();

        try {
            String JSON = mapper.writeValueAsString(kc);
            System.out.println(JSON);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }



}
