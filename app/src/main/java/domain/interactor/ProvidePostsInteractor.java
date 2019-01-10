package domain.interactor;

import java.util.ArrayList;
import java.util.List;

import data.response.PostDTO;
import domain.repository.IPostRepository;

public class ProvidePostsInteractor {
    static IPostRepository smth;
    static ArrayList<String[]> posts;

    public static ArrayList<String[]> getPosts(){
        List<PostDTO> data = smth.loadPosts();
        for (PostDTO  post: data){
            posts.add(new String[]{post.title, post.body, Integer.toString(post.userId)});
        }
        return posts;
    }
}
