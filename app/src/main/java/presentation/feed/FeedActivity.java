package presentation.feed;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import data.response.PostDTO;
import presentation.add_post.AddPostActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presentation.add_post.PostParcelable;
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
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FeedAdapter();
        recyclerView.setAdapter(adapter);
//        adapter = new FeedAdapter(presenter.providePosts());
//        recyclerView.setAdapter(adapter);

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
