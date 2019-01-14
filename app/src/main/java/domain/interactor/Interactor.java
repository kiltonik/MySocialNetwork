package domain.interactor;

import data.repository.CommentsRepository;
import data.repository.PostRepository;
import presentation.feed.FeedPresenterCallback;
import presentation.postComments.PostCommentsPresenterCallback;

public class Interactor {
    static PostRepository postRepository = new PostRepository();
    static CommentsRepository commentsRepository = new CommentsRepository();

    public void getPosts(FeedPresenterCallback callback) {
        postRepository.loadPosts(callback);
    }

    public void getComments(PostCommentsPresenterCallback callback, int postId){
        commentsRepository.loadComments(callback, postId);
    }
}
