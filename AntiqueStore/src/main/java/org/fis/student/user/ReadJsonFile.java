package org.fis.student.user;

import org.fis.student.exception.WrongPasswordException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadJsonFile {
    private static String role;
    private static boolean found=false;
    public static void Read(String pass, String mail) throws WrongPasswordException, IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader=new FileReader("../AntiqueStore/src/main/resources/users.json");
        Object obj=jsonParser.parse(reader);
        JSONArray userList = (JSONArray)obj;
        for(Object user:userList) {
            JSONObject o = (JSONObject) user;
            if (o.get("passwordField").toString().equals(pass) && o.get("mailField").toString().equals(mail)) {
                found=true;
                role = o.get("roleField").toString();
                return;
            }
        }
        if(found==false)
            throw new WrongPasswordException();

    }
    public static String getRole(){
        return role;
    }
}
