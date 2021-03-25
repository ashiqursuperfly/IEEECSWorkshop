package movie_app.util;

import movie_app.util.models.MovieData;
import movie_app.util.models.SearchApiResponse;
import movie_app.util.models.SearchItem;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieApp {



    public static void main(String[] args) {
        try {

            Scanner sc = new Scanner(System.in);

            while (true) {

                System.out.println("Search for a movie/series!");
                String query = sc.nextLine();

                ApiService apiService = ApiClient.getApiService();

                Response<SearchApiResponse> response = apiService.getSearchResults(query).execute();
                SearchApiResponse searchApiResponse = response.body();

                if (searchApiResponse == null) continue;

                System.out.println("Select a movie:");
                ArrayList<SearchItem> searchItems = searchApiResponse.getSearchItems();

                if (searchItems == null) continue;

                for (int i = 0, searchItemsSize = searchItems.size(); i < searchItemsSize; i++) {
                    SearchItem item = searchItems.get(i);
                    System.out.println(i + ":" + " " + item);
                }

                int selectedId = sc.nextInt();

                if (selectedId >= 0 && selectedId < searchItems.size()) {
                    Response<MovieData> movieDetailResponse = apiService.getMovieDetails(searchItems.get(selectedId).getImdbID()).execute();

                    System.out.println("\nDetails:");
                    System.out.println(movieDetailResponse.body());
                }

                sc.nextLine();
                System.out.println("\n");

            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
