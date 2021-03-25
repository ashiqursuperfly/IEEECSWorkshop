package movie_app.util;

import movie_app.util.models.MovieData;
import movie_app.util.models.SearchApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("?apikey=c601d685")
    Call<SearchApiResponse> getSearchResults(@Query("s") String searchQuery);

    @GET("?apikey=c601d685")
    Call<MovieData> getMovieDetails(@Query("i") String imdbID);


}

