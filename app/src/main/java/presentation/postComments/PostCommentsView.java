package presentation.postComments;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import data.response.CommentDTO;

public interface PostCommentsView extends MvpView{
    void showComments(List<CommentDTO> comments);
}
