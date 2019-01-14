package domain.repository;



import java.util.List;

import data.response.PostDTO;
import presentation.feed.FeedPresenterCallback;

public interface IPostRepository {
    void loadPosts(FeedPresenterCallback callback);
//    void saveNewPost(PostDTO post);

    
}
