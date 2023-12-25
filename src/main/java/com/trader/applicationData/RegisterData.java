package com.trader.applicationData;

import com.trader.utils.TraderUtils;

import java.util.Map;

public class RegisterData {

    private static final TraderUtils base = new TraderUtils();

    public String firstName;
    public String lastName;
    public String emailID;
    public String password;

    public String url;

    @SuppressWarnings(value = "unchecked")
    public RegisterData(String key){

        int count;
        String email;

        Map<Object, Object> register = base.jsonReader(base.filePaths().get("Register"));

        Map<String, String> data = (Map<String, String>) register.get(key);

        if (!data.get("lastName").equals(base.dateInWords())){

            data.put("lastName", base.dateInWords());

            if (!data.get("firstName").equals(base.month())){

                data.put("firstName", base.month());
            }

            data.put("count", "0");

            count = Integer.parseInt(data.get("count"));

            email = "harish." + base.month().toLowerCase() + base.day() + "+" + count + "@pibase.info";

            data.put("emailId", email);

            count++;

            data.put("count", String.valueOf(count));

            base.jsonPayloadWriter(register, base.filePaths().get("Register"));

        }else {

            count = Integer.parseInt(data.get("count"));

            email = "harish." + base.month().toLowerCase() + base.day() + "+" + count + "@pibase.info";

            count++;

            data.put("emailId", email);

            data.put("count", String.valueOf(count));

            base.jsonPayloadWriter(register, base.filePaths().get("Register"));
        }

        url = register.get("url").toString();

        firstName = data.get("firstName");

        lastName = data.get("lastName");

        emailID = data.get("emailId");

        password = data.get("password");
    }
}
