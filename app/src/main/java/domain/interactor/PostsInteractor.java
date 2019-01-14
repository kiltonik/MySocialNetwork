package domain.interactor;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import data.repository.PostRepository;
import data.response.PostDTO;
import presentation.feed.FeedPresenter;
import presentation.feed.FeedPresenterCallback;

public class PostsInteractor {
    static PostRepository smth = new PostRepository();

    public void getPosts(FeedPresenterCallback callback) {
        smth.loadPosts(callback);
    }
    
}
