package domain.interactor;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import data.response.PostDTO;
import domain.repository.IPostRepository;

public class ProvidePostsInteractor {
    static IPostRepository smth;
    static ArrayList<String[]> posts;

    public static ArrayList<String[]> getPosts(){
        @Nullable
        List<PostDTO> data = smth.loadPosts();
        if (data != null) {
            ArrayList<String[]> posts = new ArrayList<String[]>();
            for (PostDTO post : data) {
                posts.add(new String[]{post.title, post.body, Integer.toString(post.userId)});
            }
        }
        else {
           ArrayList<String[]> posts = new ArrayList<String[]>();
        }
        return posts;
    }
}
