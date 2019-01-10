package data.response;

import com.google.gson.annotations.SerializedName;

public class PostDTO{
    @SerializedName("user_id")
    public int userId;

    @SerializedName("id")
    public int id;

    @SerializedName("title")
    public String title;

    @SerializedName("body")
    public String body;
}
