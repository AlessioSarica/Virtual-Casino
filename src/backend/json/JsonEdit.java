package backend.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

import backend.auth.Autenticazione;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

/**
 * This service use to manipulate a JSON File with custom class method
 */
public class JsonEdit {

    /**
     * This static method gets user information
     * passing a mail identified user
     * to get information and this information used in another component to authenticate a read for other information
     * @param email passed an user email tu identify search data
     * @return String of full name
     */
    public static String getUser(String email){
        JSONArray json = reader();
        StringBuilder user = new StringBuilder();
        assert json != null;
        for (Object o : json) {
            JSONObject obj = (JSONObject) o;
            if(obj.get("email").equals(email)){
                user.append(obj.get("nome"));
                user.append(" ");
                user.append(obj.get("cognome"));
            }
        }
        return user.toString();
    }

    /**
     * This method writes credit of user passing the full name of the user to wire
     * @param nome String of name
     * @param cognome String of surname
     * @param saldo String of credit to write
     * @return a {@code true} if ok or {@code false} if not ok is write method it's ok
     */
    public static boolean writeSaldo(String nome, String cognome, double saldo) {
        JSONArray json = reader();
        assert json != null;
        for (Object o : json) {
            JSONObject obj = (JSONObject) o;
            if (obj.get("nome").equals(nome) && obj.get("cognome").equals(cognome)) {
                obj.put("saldo", saldo);
            }
        }
        return writer(json);
    }

    /**
     * This static method use to red credit of user passing an identification of user to search
     * @param nome of user
     * @param cognome of user
     * @return double of read credit
     */
    public static double readSaldo(String nome, String cognome) {
        JSONArray json = reader();
        assert json != null;
        for (Object o : json) {
            JSONObject obj = (JSONObject) o;
            if (obj.get("nome").equals(nome) && obj.get("cognome").equals(cognome)) {
                return Double.parseDouble(obj.get("saldo").toString());
            }
        }
        return 0;
    }


    /**
     * This static method read a JSON File and return data
     * @return a JSON Object
     */
    private static JSONArray reader() {
        try {
            Object obj = new JSONParser().parse(new FileReader(String.valueOf(Autenticazione.class.getClassLoader().getResource("Database.json"))));
            return (JSONArray) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * This static method writes to JSON FIle data passed
     * @param json data Object
     * @return a true or false if ok or not ok
     */
    private static boolean writer(JSONArray json) {
        // Scrive il file json
        try {
            PrintWriter pw = new PrintWriter(String.valueOf(Autenticazione.class.getClassLoader().getResource("Database.json")));
            pw.write(json.toJSONString());

            pw.flush();
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
