package presentation.feed;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.List;

import data.response.PostDTO;
import domain.interactor.PostsInteractor;



@InjectViewState
public class FeedPresenter extends MvpPresenter<FeedView> implements FeedPresenterCallback {

    PostsInteractor interactor = new PostsInteractor();


    @Override
    protected void onFirstViewAttach() {
        interactor.getPosts(this);
        Log.d("onFirstViewAttach","complete");
    }

    public void providePosts(){
        interactor.getPosts(this);
    }

    @Override
    public void callingPresenterBackOnSuccess(List<PostDTO> data) {
        Log.d("presenter","callback on success");
        getViewState().showPosts(data);
        Log.d("presenter","new posts were shown");
    }

    @Override
    public void callingPresenterBackOnFailure() {
        Log.d("presenter","callback on failure");
    }
}

