package presentation.add_post;

import android.os.Parcelable;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import data.response.PostDTO;
import domain.interactor.Interactor;

@InjectViewState
public class AddPostPresenter extends MvpPresenter<AddPostView> {

    private final Interactor interactor;

    private final PostDTO post;

    private final PostParcelable postParcelable;

    @Inject
    AddPostPresenter(Interactor interactor, PostDTO post, PostParcelable postParcelable){
        this.interactor = interactor;
        this.postParcelable = postParcelable;
        this.post = post;
    }

    public Parcelable saveNewPost(String title, String body, String author){
        post.title = title;
        post.body = body;
        post.userId = Integer.valueOf(author);
        return postParcelable;
    }
}
