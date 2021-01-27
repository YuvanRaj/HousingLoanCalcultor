/*import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class TestingUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static List<String> getMovieTitles(String author) {
        String response;
        int page = 1;
        int totalPages = 2;
        List<String> titles = new ArrayList<>();

        while (page <= totalPages) {
            try {
                URL url = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=" + author + "&page=" + page);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                while ((response = reader.readLine()) != null) {
                    JsonObject jsonResponse = new Gson().fromJson(response, JsonObject.class);
                    totalPages = jsonResponse.get("total_pages").getAsInt();
                    JsonArray data = jsonResponse.getAsJsonArray("data");

                    for (JsonElement datum: data) {
                        String title = datum.getAsJsonObject().get("Title").getAsString();
                        titles.add(title);
                    }
                }
                reader.close();
                page++;

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        
        return titles;
    }

}
*/