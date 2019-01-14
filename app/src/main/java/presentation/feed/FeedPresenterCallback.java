package presentation.feed;

import java.util.List;

import data.response.PostDTO;

public interface FeedPresenterCallback {
    void callingPresenterBackOnSuccess(List<PostDTO> e);
    void callingPresenterBackOnFailure();
}
