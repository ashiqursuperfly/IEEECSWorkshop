package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Movie /*implements Comparable<Movie>*/{

    private String name;
    private int releaseYear;
    private float rating;

    public Movie(String name, int releaseYear, float rating) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public static ArrayList<Movie> getDummyData() {
        Movie m1 = new Movie("JL Snyder Cut", 2021, 8.4f);
        Movie m2 = new Movie("Avengers Endgame", 2019, 8.4f);
        Movie m3 = new Movie("Joker", 2020, 8.6f);
        Movie m4 = new Movie("Sonic The Hedgehog", 2020, 7.6f);
        Movie m5 = new Movie("The Irishman", 2019, 8.3f);
        Movie m6 = new Movie("1917", 2019, 8.1f);

        ArrayList<Movie> moviesList = new ArrayList<>();
        moviesList.add(m1);
        moviesList.add(m2);
        moviesList.add(m3);
        moviesList.add(m4);
        moviesList.add(m5);
        moviesList.add(m6);
        return moviesList;
    }



    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", releaseYear=" + releaseYear +
                ", rating=" + rating +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public float getRating() {
        return rating;
    }

    /*
    @Override
    public int compareTo(Movie movie) {
        return Float.compare(movie.rating, rating);
    }
    */

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return releaseYear == movie.releaseYear && Objects.equals(name, movie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, releaseYear);
    }*/
}