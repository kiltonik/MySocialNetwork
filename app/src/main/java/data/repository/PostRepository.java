package data.repository;



import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;

import data.response.PostApi;
import data.response.PostDTO;
import domain.repository.IPostRepository;
import presentation.feed.FeedPresenterCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PostRepository implements IPostRepository{

    private static final String URL = "https://jsonplaceholder.typicode.com";

    @Nullable
    public void loadPosts(FeedPresenterCallback callback){
        Log.d("repository","works");

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            PostApi post_api = retrofit.create(PostApi.class);

            Call<List<PostDTO>> call = post_api.posts();

            call.enqueue(new Callback<List<PostDTO>>() {
                @Override
                public void onResponse(Call<List<PostDTO>> call, Response<List<PostDTO>> response) {
                    Log.d("repository", "data loaded");
                    callback.callingPresenterBackOnSuccess(response.body());
                }

                @Override
                public void onFailure(Call<List<PostDTO>> call, Throwable t) {
                    Log.d("repository", "data wasn't loaded");
                    callback.callingPresenterBackOnFailure();
                }
            });
        }


//    @Override
//    public void saveNewPost(PostDTO post) {
//        bd.saveOnePost(post);
//    }


}


