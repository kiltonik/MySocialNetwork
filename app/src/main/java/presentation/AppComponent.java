package presentation;

import android.content.Context;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import presentation.add_post.AddPostActivity;
import presentation.feed.FeedActivity;
import presentation.postComments.PostCommentsActivity;
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void injectsFeed(FeedActivity feedActivity);
    void injectsAddPost(AddPostActivity addPostActivity);
    void injectsPostComments(PostCommentsActivity postCommentsActivity);
    @Component.Builder
    interface Builder{
        AppComponent build();

        @BindsInstance
        Builder context(Context context);
    }
}
