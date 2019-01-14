package presentation.postComments;

import java.util.List;

import data.response.CommentDTO;

public interface PostCommentsPresenterCallback {
    void callingPresenterBackOnSuccess(List<CommentDTO> e);
    void callingPresenterBackOnFailure();
}
