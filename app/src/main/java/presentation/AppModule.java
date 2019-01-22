package presentation;


import dagger.Module;
import dagger.Provides;
import data.repository.CommentsRepository;
import data.repository.PostRepository;
import data.response.CommentAPI;
import data.response.PostApi;
import data.response.PostDTO;
import domain.interactor.Interactor;
import presentation.add_post.PostParcelable;
import presentation.feed.FeedPresenter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Provides
    public PostApi postAPI(Retrofit retrofit){
        return retrofit.create(PostApi.class);
    }

    @Provides
    public CommentAPI commentAPI(Retrofit retrofit){
        return retrofit.create(CommentAPI.class);
    }

    @Provides
    public Retrofit retrofit(GsonConverterFactory gsonConverterFactory){
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    @Provides
    public GsonConverterFactory gsonConverterFactory(){
        return GsonConverterFactory.create();
    }

    @Provides
    public PostDTO post(){
        return new PostDTO();
    }

    @Provides
    public PostParcelable postParcelable(){
        return new PostParcelable(new PostDTO());
    }
}
