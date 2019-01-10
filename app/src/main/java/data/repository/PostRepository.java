package data.repository;



import android.support.annotation.Nullable;

import java.util.List;

import data.response.PostApi;
import data.response.PostDTO;
import data.storage.PostsStorage;
import domain.repository.IPostRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PostRepository implements IPostRepository{

    PostsStorage bd = new PostsStorage();
    private static final String URL = "https://jsonplaceholder.typicode.com";
    List<PostDTO> data;

    @Nullable
    public List<PostDTO> loadPosts(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostApi post_api = retrofit.create(PostApi.class);

        Call<List<PostDTO>> call = post_api.posts();

        call.enqueue(new Callback<List<PostDTO>>() {
            @Override
            public void onResponse(Call<List<PostDTO>> call, Response<List<PostDTO>> response) {
                data = response.body();
            }

            @Override
            public void onFailure(Call<List<PostDTO>> call, Throwable t) {

            }
        });
        return data;
    }
}


