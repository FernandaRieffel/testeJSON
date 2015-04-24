import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

public class ScopeSystem {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://200.132.36.179/solar_api/v1/GetInverterRealtimeData.cgi?Scope=System");
        InputStream is = url.openStream();
        JsonReader rdr = Json.createReader(is);
        JsonObject obj = rdr.readObject();
        JsonObject body = obj.getJsonObject("Body");
        JsonObject data = body.getJsonObject("Data");

        for (Map.Entry<String, JsonValue> result : data.entrySet()) {
            JsonObject value = (JsonObject) result.getValue();
            String unidade = value.getString("Unit");
            double valor = value.getJsonObject("Values").getJsonNumber("1").doubleValue();
            System.out.println(result.getKey() + ": " + valor + " " + unidade);
        }
    }
}
