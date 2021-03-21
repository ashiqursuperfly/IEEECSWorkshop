package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class HashDs {

    public static void main(String[] args) {

        ArrayList<Movie> moviesList = Movie.getDummyData();

        Map<Integer, ArrayList<Movie>> releaseYearToMovie = new HashMap<>();

        for (Movie movie : moviesList) {
            ArrayList<Movie> moviesInyear = releaseYearToMovie.get(movie.getReleaseYear());
            if (moviesInyear == null) moviesInyear = new ArrayList<>();
            moviesInyear.add(movie);
            releaseYearToMovie.put(movie.getReleaseYear(), moviesInyear);
        }

        System.out.println(releaseYearToMovie.get(2019));


        String [] randomPollResults = new String[]{
                "JL Snyder Cut,9",
                "JL Snyder Cut,9.5",
                "Joker,9",
                "The Irishman,10",
                "Joker,8.5",
                "JL Snyder Cut,9",
                "JL Snyder Cut,9.5",
                "Joker,9",
                "The Irishman,10",
                "Joker,8.5",
                "JL Snyder Cut,9.3",
                "JL Snyder Cut,9.2",
                "Joker,8.9",
                "The Irishman,8",
                "Joker,8.5"
        };

        /* TODO: find the final ratings of the movies after the poll */

    }

}
