package data.response;

import com.google.gson.annotations.SerializedName;

public class CommentDTO {
    @SerializedName("postId")
    public int postId;

    @SerializedName("id")
    public int id;

    @SerializedName("name")
    public String name;

    @SerializedName("email")
    public String email;

    @SerializedName("body")
    public String body;

}
