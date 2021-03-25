package movie_app.util.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RatingsItem implements Serializable {

	@SerializedName("Source")
	private String source;

	@SerializedName("Value")
	private String value;

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}

	public void setValue(String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}

	@Override
 	public String toString(){
		return source + " - " + value;
	}
}