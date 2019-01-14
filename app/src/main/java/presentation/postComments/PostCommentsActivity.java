package presentation.postComments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import data.response.CommentDTO;
import presentation.add_post.PostForCommentsParcelable;
import v.mysocialnetwork.R;

public final class PostCommentsActivity extends MvpAppCompatActivity implements PostCommentsView {

    @InjectPresenter
    PostCommentsPresenter presenter;

    private RecyclerView recyclerView;
    private CommentsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_comments);
        recyclerView = findViewById(R.id.comment_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CommentsAdapter();
        recyclerView.setAdapter(adapter);
        PostForCommentsParcelable postForCommentsParcelable = getIntent().getParcelableExtra("post");
        presenter.provideComments(postForCommentsParcelable.getPostFromParcleable());

    }

    @Override
    public void showComments(List<CommentDTO> data){
        adapter.setItems(data);
    }

}
