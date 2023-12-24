package com.trader.applicationData;

import com.trader.utils.TraderUtils;

import java.util.Map;

public class RegisterData {

    private static final TraderUtils base = new TraderUtils();

    public String firstName;
    public String lastName;
    public String emailID;
    public String password;

    @SuppressWarnings(value = "unchecked")
    public RegisterData(String key){

        Map<Object, Object> register = base.jsonReader(base.filePaths().get("Register"));

        Map<String, String> valid = (Map<String, String>) register.get(key);

//        firstName =

        emailID = valid.get("emailId");

        password = valid.get("password");
    }
}
