package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basic {

    public static void main(String[] args) {

        ArrayList<Movie> moviesList = Movie.getDummyData();
        // Collections.sort(moviesList);
        System.out.println(moviesList);
        Collections.shuffle(moviesList);


        if (moviesList.contains(new Movie("JL Snyder Cut", 2021, 8.4f))) {
            System.out.println("Movie Exist");
        }
        System.out.println(moviesList.indexOf(new Movie("JL Snyder Cut", 2021, 8.4f)));




    }
}
