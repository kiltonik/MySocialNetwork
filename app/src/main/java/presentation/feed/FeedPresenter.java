package presentation.feed;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.Arrays;

import domain.interactor.ProvidePostsInteractor;

import static domain.interactor.ProvidePostsInteractor.getPosts;


@InjectViewState
public class FeedPresenter extends MvpPresenter<FeedView> {
    ArrayList<String[]> data = new ArrayList<>(Arrays.<String[]>asList(new String[]{"title 1", "post 1", "author 1"}));

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        Log.d("onFirstViewAttach","complete");
    }

    @Override
    public void attachView(FeedView view) {
        super.attachView(view);
    }

    @Override
    public void detachView(FeedView view) {
        super.detachView(view);
    }

    public ArrayList<String[]> providePosts(){
        return getPosts();
    }
}

