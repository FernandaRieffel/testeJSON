import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

/**
 * Created by 201420240 on 22/04/2015.
 */
public class MinMaxSensorData {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://200.132.36.179/solar_api/v1/GetSensorRealtimeData.cgi?Scope=Device&DeviceId=0&DataCollection=MinMaxSensorData");
        InputStream is = url.openStream();
        JsonReader rdr = Json.createReader(is);
        JsonObject obj = rdr.readObject();
        JsonObject body = obj.getJsonObject("Body");
        JsonObject data = body.getJsonObject("Data");

        for (Map.Entry<String, JsonValue> result : data.entrySet()) {
            JsonObject value = (JsonObject) result.getValue();
            if(value.getBoolean("SensorActive") == true) {
                boolean valor = value.getBoolean("SensorActive");
                System.out.println(result.getKey() + ": " + valor);
            }
            else if(value.getJsonObject("Day") != null){

            }
            /*double valor = value.getInt("Value");
            String unidade = value.getString("Unit");
            System.out.println(result.getKey() + ": " + valor + " " + unidade);*/
        }
    }
}