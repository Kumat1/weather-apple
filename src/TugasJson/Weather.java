package TugasJson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.*;
import java.net.*;

public class Weather extends JFrame {
    private String city,name,cloud,pressure;
    private Long humidity,visibility;
    private Double temp ;
    private URL url;
    private InputStream is;
    private BufferedReader br;
    private Object obj;
    private JSONObject jsonObject,jsonWeather;

    public Weather(String c){
        this.city = c;
        JSONParser parser = new JSONParser();
        String baseUrl = "http://api.openweathermap.org/data/2.5/weather?q=";
        String key = "b7ba0b30cc4aee57ba67dd21c5f04eb9";

        try {
            url = new URL(baseUrl+city+"&appid="+key);

            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            obj  = parser.parse(br);
            jsonObject = (JSONObject) obj;

            name = (String) jsonObject.get("name");

            JSONArray weathers = (JSONArray) jsonObject.get("weather");
            for(Object weather : weathers){
                jsonWeather = (JSONObject) weather;
                cloud = (String) jsonWeather.get("description");
            }

            JSONObject mains = (JSONObject) jsonObject.get("main");
            pressure = (String) String.valueOf(mains.get("pressure"));
            temp = (Double) mains.get("temp");
            temp = Math.ceil((1.8 * (temp- 273)) +32);
            humidity = (Long) mains.get("humidity");

            visibility = (Long) jsonObject.get("visibility");

            new WeatherTampilan(name,cloud,pressure,temp,humidity,visibility);

            br.close();
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(this,"Tidak ada koneksi Internet","Peringatan",2);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this,"Gagal memproses data","Peringatan",2);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,"Kota yang Anda masukkan Salah","Peringatan",2);
        }
    }
}
