package presentation.add_post;

import android.os.Parcelable;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import org.parceler.Parcels;

import data.response.PostDTO;
import domain.interactor.PostsInteractor;

@InjectViewState
public class AddPostPresenter extends MvpPresenter<AddPostView> {
    PostsInteractor interactor = new PostsInteractor();
    public Parcelable saveNewPost(String title, String body, String author){
        PostDTO post = new PostDTO();
        post.title = title;
        post.body = body;
        post.userId = Integer.valueOf(author);
        PostParcelable postParcelable = new PostParcelable(post);
        return postParcelable;
    }
}
