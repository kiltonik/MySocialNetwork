package data.repository;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import data.response.CommentAPI;
import data.response.CommentDTO;
import domain.repository.ICommentsRepository;
import presentation.postComments.PostCommentsPresenterCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CommentsRepository implements ICommentsRepository{

    private final CommentAPI commentAPI;

    @Inject
    CommentsRepository(CommentAPI commentAPI){
        this.commentAPI = commentAPI;
    }

    @Override
    public void loadComments(PostCommentsPresenterCallback callback, int postId) {
        final String URL = "https://jsonplaceholder.typicode.com";
        Log.d("comment repository","works");

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        CommentAPI commentAPI = retrofit.create(CommentAPI.class);

        Call<List<CommentDTO>> call = commentAPI.comments(postId);

        call.enqueue(new Callback<List<CommentDTO>>() {
            @Override
            public void onResponse(Call<List<CommentDTO>> call, Response<List<CommentDTO>> response) {
                callback.callingPresenterBackOnSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<CommentDTO>> call, Throwable t) {

            }
        });

    }
}
