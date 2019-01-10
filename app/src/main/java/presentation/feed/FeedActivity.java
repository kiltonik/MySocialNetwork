package presentation.feed;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import presentation.add_post.AddPostActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;
import v.mysocialnetwork.R;

public final class FeedActivity extends MvpAppCompatActivity implements FeedView{

    @InjectPresenter
    FeedPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        ButterKnife.bind(this);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FeedAdapter adapter = new FeedAdapter(presenter.providePosts());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        Log.d("showPosts","complete");
        presenter.onFirstViewAttach();
    }

    @OnClick(R.id.add_new_post)
    public void addNewPost()
    {
        Log.d("addNewPost","start");
        Intent intent = new Intent(getApplicationContext(), AddPostActivity.class);
        startActivity(intent);
    }
}
