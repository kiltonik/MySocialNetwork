package presentation.postComments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import data.response.CommentDTO;
import data.response.PostDTO;
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
        adapter = new CommentsAdapter(() -> {});
        recyclerView.setAdapter(adapter);
        PostForCommentsParcelable postForCommentsParcelable = getIntent().getParcelableExtra("post");
        PostDTO post = new PostDTO();
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
