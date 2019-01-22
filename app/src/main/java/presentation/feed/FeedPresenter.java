package presentation.feed;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import java.util.List;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import data.response.PostDTO;
import domain.interactor.Interactor;


@InjectViewState
public class FeedPresenter extends MvpPresenter<FeedView> implements FeedPresenterCallback {

    private final Interactor interactor;

    @Inject
    FeedPresenter(Interactor interactor){
        this.interactor = interactor;
    }

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

