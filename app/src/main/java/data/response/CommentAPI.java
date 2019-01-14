package data.response;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CommentAPI {
    @GET("/comments")
    Call<List<CommentDTO>> comments(@Query("postId") int postId);
}
