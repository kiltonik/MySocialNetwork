package presentation.postComments;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.List;

import javax.inject.Inject;

import data.response.CommentDTO;
import data.response.PostDTO;
import domain.interactor.Interactor;

@InjectViewState
public class PostCommentsPresenter extends MvpPresenter<PostCommentsView> implements PostCommentsPresenterCallback{

    private final Interactor interactor;


//    @Override
//    protected void onFirstViewAttach(){
//        interactor.getComments(this);
//    }

    @Inject
    PostCommentsPresenter(Interactor interactor){
        this.interactor = interactor;
    }

    public void provideComments(PostDTO post){
        interactor.getComments(this, post.id);
    }

    @Override
    public void callingPresenterBackOnSuccess(List<CommentDTO> data) {
        getViewState().showComments(data);
    }

    @Override
    public void callingPresenterBackOnFailure() {

    }
}
