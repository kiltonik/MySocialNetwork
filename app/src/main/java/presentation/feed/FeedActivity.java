package presentation.feed;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import data.response.PostDTO;
import presentation.add_post.AddPostActivity;
import butterknife.ButterKnife;
import presentation.add_post.PostParcelable;
import presentation.postComments.PostCommentsActivity;
import presentation.postComments.PostForCommentsParcelable;
import v.mysocialnetwork.R;

public final class FeedActivity extends MvpAppCompatActivity implements FeedView{

    @InjectPresenter
    FeedPresenter presenter;

    private FeedAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        ButterKnife.bind(this);
        recyclerView = findViewById(R.id.feed_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FeedAdapter((v, position) -> {
            Intent intent = new Intent(this, PostCommentsActivity.class);
            intent.putExtra("post", new PostForCommentsParcelable(adapter.getData().get(position)));
            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void showPosts(List<PostDTO> data){
        Log.d("showPosts","called");
        adapter.setItems(data);
//        adapter.notifyDataSetChanged();
        Log.d("showPosts","complete");
        Button button = findViewById(R.id.add_new_post);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddPostActivity.class);
            startActivityForResult(intent, 1);
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent result){
        super.onActivityResult(requestCode, resultCode, result);
        switch (requestCode){
            case (1):{
                if (resultCode == 1){
                    PostParcelable postParcelable = result.getExtras().getParcelable("post");
                    adapter.addNewPost(postParcelable.getPostFromParcleable());
                }
            }
        }
    }

}
