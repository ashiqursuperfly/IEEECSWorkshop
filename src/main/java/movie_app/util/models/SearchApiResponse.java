package movie_app.util.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.io.Serializable;

public class SearchApiResponse implements Serializable {

	@SerializedName("Search")
	private ArrayList<SearchItem> searchItems;
	private String totalResults;
	@SerializedName("Response")
	private String responseStatus;

	public ArrayList<SearchItem> getSearchItems() {
		return searchItems;
	}

	public String getTotalResults() {
		return totalResults;
	}

	public String getResponse() {
		return responseStatus;
	}

	@Override
 	public String toString(){
		return 
			"SearchApiResponse{" + 
			"search = '" + searchItems + '\'' +
			",totalResults = '" + totalResults + '\'' + 
			",response = '" + responseStatus + '\'' +
			"}";
		}
}