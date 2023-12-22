package com.trader.applicationData;

import com.trader.utils.TraderUtils;

import java.util.Map;

public class LoginData  {
    private static TraderUtils base = new TraderUtils();
    public String emailID;
    public String password;

    @SuppressWarnings(value = "unchecked")
    public LoginData(String key){

        Map<Object, Object> login = base.jsonReader(base.filePaths().get("Login"));

        Map<String, String> valid = (Map<String, String>) login.get(key);

        emailID = valid.get("emailId");
        password = valid.get("password");
    }

}
