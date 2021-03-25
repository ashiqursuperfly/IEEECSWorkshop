package movie_app.util.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.io.Serializable;

public class MovieData implements Serializable {

	@SerializedName("Title")
	private String title;

	@SerializedName("Genre")
	private String genre;

	@SerializedName("Director")
	private String director;

	@SerializedName("Writer")
	private String writer;

	@SerializedName("Actors")
	private String actors;

	@SerializedName("Plot")
	private String plot;

	@SerializedName("Ratings")
	private List<RatingsItem> ratings;

	private String responseStatus;

	public String getTitle() {
		return title;
	}

	public String getGenre() {
		return genre;
	}

	public String getDirector() {
		return director;
	}

	public String getWriter() {
		return writer;
	}

	public String getActors() {
		return actors;
	}

	public String getPlot() {
		return plot;
	}

	public List<RatingsItem> getRatings() {
		return ratings;
	}

	@Override
	public String toString() {

		StringBuilder sb =  new StringBuilder(title + "\n" + "-" + plot + "\n");

		for (RatingsItem r :
				ratings) {
			sb.append("-").append(r).append('\n');
		}

		if (actors != null) sb.append("Actors: ").append(actors);

		return sb.toString();

	}
}