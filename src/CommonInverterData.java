import javax.json.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

/**
 * Created by 201420240 on 16/04/2015.
 */
public class CommonInverterData {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://200.132.36.179/solar_api/v1/GetInverterRealtimeData.cgi?Scope=Device&DeviceId=1&DataCollection=CommonInverterData");
        InputStream is = url.openStream();
        JsonReader rdr = Json.createReader(is);
        JsonObject obj = rdr.readObject();
        JsonObject body = obj.getJsonObject("Body");
        JsonObject data = body.getJsonObject("Data");

        for (Map.Entry<String, JsonValue> result : data.entrySet()) {
            JsonObject value = (JsonObject) result.getValue();

            if(value.getJsonNumber("Value") != null){
                JsonNumber valor = value.getJsonNumber("Value");
                String unidade = value.getString("Unit");
                System.out.println(result.getKey() + ": " + valor + " " + unidade);
            }
        }
    }
}

