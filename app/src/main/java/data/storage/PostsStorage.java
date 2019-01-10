package data.storage;

import java.util.List;

import data.Provider;
import data.response.PostDTO;

public class PostsStorage implements Provider{
    List<PostDTO> data;
    public void savePosts(List<PostDTO> new_data){
        data = new_data;
    }

    public List<PostDTO> getPostsFromBD(){
        return data;
    }

    public void addPostToBD(PostDTO post){
        data.add(post);
    }
}
