package kata.pkg6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import static java.util.stream.Collectors.joining;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import javax.xml.bind.PropertyException;


public class Kata6 {

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://api.dictionaryapi.dev/api/v2/entries/en/engineer");
        String json = readAllBytes(url);
        Gson gson = new Gson();
        
        JsonObject object = gson.fromJson(json, JsonArray.class).get(0).getAsJsonObject();
        Word word = gson.fromJson(object, Word.class);
        
        JAXBContext context = JAXBContext.newInstance(Word.class);
    Marshaller m = context.createMarshaller();
    try {
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    } catch (PropertyException e) {
        e.printStackTrace();
    }
    m.marshal(word, System.out);
    }

    private static String readAllBytes(URL url) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return reader.lines().collect(joining());
        }
    }
    
}
