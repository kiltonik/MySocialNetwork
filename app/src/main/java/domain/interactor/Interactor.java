package domain.interactor;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import data.repository.CommentsRepository;
import data.repository.PostRepository;
import presentation.feed.FeedPresenterCallback;
import presentation.postComments.PostCommentsPresenterCallback;


public class Interactor {

    PostRepository postRepository;

    CommentsRepository commentsRepository;

    @Inject
    Interactor(PostRepository postRepository, CommentsRepository commentsRepository){
        this.commentsRepository = commentsRepository;
        this.postRepository = postRepository;
    }

    public void getPosts(FeedPresenterCallback callback) {
        postRepository.loadPosts(callback);
    }

    public void getComments(PostCommentsPresenterCallback callback, int postId){
        commentsRepository.loadComments(callback, postId);
    }
}
