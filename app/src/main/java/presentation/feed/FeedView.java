package presentation.feed;


import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.ArrayList;
import java.util.List;

import data.response.PostDTO;

public interface FeedView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showPosts(List<PostDTO> data);
}

