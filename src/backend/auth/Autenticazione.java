package backend.auth;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * This custom service allows authenticating user with JSON File
 */
public class Autenticazione {
    /**
     * This static method execute login verify to JSON File passing credential
     *
     * @param email    of user
     * @param password of user
     * @return true or false if login executes with no error
     */
    public static boolean login(String email, String password) {
        JSONArray json = reader();

        assert json != null;
        for (Object o : json) {
            JSONObject obj = (JSONObject) o;
            if (obj.get("email").equals(email) && obj.get("password").equals(password)) {
                return true;
            }
        }
        if (Objects.equals(password, "")) {
            for (Object o : json) {
                JSONObject obj = (JSONObject) o;
                if (obj.get("email").equals(email)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * This method allow to registration user-passing data to be written on JSON File and check if user already exists
     *
     * @param nome              of user
     * @param cognome           of user
     * @param email             of user
     * @param password          of user
     * @param intestatarioCarta of credit card
     * @param CVV               of credit card
     * @param scadenza          of credit card
     * @param numeroCarta       of credit card
     * @param saldo             of user
     * @return true or false its depend on if registration operation executed successfully
     */
    public static boolean register(String nome, String cognome, String email, String password, String intestatarioCarta, String CVV, String scadenza, String numeroCarta, double saldo) {
        // Controllo se gia esiste un utente con la stessa email
        if (!login(email, "")) {
            JSONArray json = reader() == null ? new JSONArray() : reader();

            // Aggiunta ad una mappa i dati della carta
            LinkedHashMap<String, String> map2 = new LinkedHashMap<>(4);
            map2.put("CVV", CVV);
            map2.put("scadenza", scadenza);
            map2.put("numeroCarta", numeroCarta);
            map2.put("intestatarioCarta", intestatarioCarta);

            // Aggiunta ad una mappa i dati base dell utente
            LinkedHashMap<String, Object> map = new LinkedHashMap<>(6);
            map.put("nome", nome);
            map.put("cognome", cognome);
            map.put("email", email);
            map.put("password", password);
            map.put("saldo", saldo);
            map.put("carta", map2);
            // Aggiunta ad una mappa i dati base dell utente e i dati della carta
            Objects.requireNonNull(json).add(map);
            // Scrive il file json
            return writer(json);
        } else {
            return false;
        }
    }

    /**
     * This static method read a JSON File to use to modify and delegate to a writer
     *
     * @return JSON Objects contain the read JSON
     */
    private static JSONArray reader() {
        try {
            Object obj = new JSONParser().parse(new FileReader("C:/Users/saric/IdeaProjects/Virtual-Casino/resources/Database.json"));
            return (JSONArray) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * This static method writes a JSON Object to a JSON File
     *
     * @param json passing a reference to JSON Objects modified
     * @return true or false of state of this command
     */
    private static boolean writer(JSONArray json) {
        // Scrive il file json
        try {
            PrintWriter pw = new PrintWriter("resources/Database.json");
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
