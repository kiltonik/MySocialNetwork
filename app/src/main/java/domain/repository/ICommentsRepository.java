package domain.repository;

import presentation.postComments.PostCommentsPresenterCallback;

public interface ICommentsRepository {
    void loadComments(PostCommentsPresenterCallback callback, int postId);
}
