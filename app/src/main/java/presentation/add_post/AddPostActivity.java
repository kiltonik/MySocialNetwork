package presentation.add_post;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import presentation.App;
import v.mysocialnetwork.R;

public final class AddPostActivity extends MvpAppCompatActivity implements AddPostView{

    @Inject
    @InjectPresenter
    AddPostPresenter presenter;

    @ProvidePresenter
    AddPostPresenter provideAddPostPresenter(){
        return presenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_post);
        ButterKnife.bind(this);
        App.getAppComponent().injectsAddPost(this);
        EditText title = findViewById(R.id.title);
        EditText author = findViewById(R.id.name);
        EditText body = findViewById(R.id.body);
        Button cancelButton = findViewById(R.id.cancel);
        cancelButton.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("post entered", false);
            finish();
        });
        Button savePostButton = findViewById(R.id.save_post);
        savePostButton.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("post", presenter.saveNewPost(title.getText().toString(),
                    body.getText().toString(),
                    author.getText().toString()));
            setResult(1, intent);
            finish();
        });
    }

}
