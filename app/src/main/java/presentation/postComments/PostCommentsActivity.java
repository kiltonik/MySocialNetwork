package presentation.postComments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.List;

import javax.inject.Inject;

import data.response.CommentDTO;
import data.response.PostDTO;
import presentation.App;
import v.mysocialnetwork.R;

public final class PostCommentsActivity extends MvpAppCompatActivity implements PostCommentsView {

    @Inject
    @InjectPresenter
    PostCommentsPresenter presenter;

    @ProvidePresenter
    PostCommentsPresenter providePostCommentPresenter(){
        return presenter;
    }

    private RecyclerView recyclerView;
    private CommentsAdapter adapter;
    private PostDTO post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_comments);
        App.getAppComponent().injectsPostComments(this);
        recyclerView = findViewById(R.id.comment_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CommentsAdapter(() -> {});
        recyclerView.setAdapter(adapter);
        PostForCommentsParcelable postForCommentsParcelable = getIntent().getParcelableExtra("post");
        post = postForCommentsParcelable.getPostFromParcleable();
        TextView title = findViewById(R.id.title_comments);
        TextView body = findViewById(R.id.post_content_comments);
        TextView author = findViewById(R.id.author_comments);
        title.setText(post.title);
        body.setText(post.body);
        author.setText(String.valueOf(post.userId));
        presenter.provideComments(post);

    }

    @Override
    public void showComments(List<CommentDTO> data){
        adapter.setItems(data);
    }

}
