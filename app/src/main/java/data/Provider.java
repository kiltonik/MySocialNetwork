package data;

import java.util.List;

import data.response.PostDTO;

public interface Provider {
    void savePosts(List<PostDTO> new_data);
    List<PostDTO> getPostsFromBD();
    void addPostToBD (PostDTO post);
}
