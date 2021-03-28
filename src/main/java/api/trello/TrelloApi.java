package api.trello;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * This class is for getting quests from trello
 */
public class TrelloApi {

   Properties properties = new Properties();

   {
      try {
         properties.load(new FileInputStream("src/main/resources/config.properties"));
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   private final String TRELLO_URL = properties.getProperty("trello_url");
   private final String BOARDS_URL = properties.getProperty("trello_boards_url");
   private final String KEY = properties.getProperty("trello_key");
   private final String TOKEN = properties.getProperty("trello_token");

   /**
    * @param url
    * @return Response or null
    * @throws IOException
    */
   private Response getApiResponse(String url) throws IOException
   {
      OkHttpClient client = new OkHttpClient().newBuilder()
              .build();
      Request request = new Request.Builder()
              .url(url + "key=" + KEY + "&token=" + TOKEN)
              .method("GET", null)
              .build();
      Response response = client.newCall(request).execute();

      if(response.isSuccessful()) {
         return response;
      } else {
         return null;
      }
   }

   /**
    * @return Board[]
    */
   private Board[] getBoardsArray()
   {
      Board[] boardsArray = {};
      try{
         Response response = getApiResponse(TRELLO_URL + BOARDS_URL);
         Gson gson = new Gson();
         boardsArray = gson.fromJson(response.body().string(),Board[].class);
      } catch (IOException e) {
         e.getStackTrace();
      }
      return boardsArray;
   }

   /**
    * @return TrelloMap (String, Card[])
    */
   public Map<String, Card[]> getTrelloMap () {
      Map<String, Card[]> trelloMap = new HashMap<>();
      try {
         for (Board board : getBoardsArray()) {
            String cardUrl = String.format("lists/%s/cards?", board.getId());
            Response response = getApiResponse(TRELLO_URL + cardUrl);
            Gson gson = new Gson();
            Card[] cards = gson.fromJson(response.body().string(), Card[].class);
            if (cards != null) {
               trelloMap.put(board.getName(), cards);
            }
         }
      } catch (IOException e) {
         Logger.getLogger("Error in getTrelloMap");
      }
      return trelloMap;
   }

}
