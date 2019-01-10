package presentation.feed;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import v.mysocialnetwork.R;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {

    List<String[]> data;

    public FeedAdapter(List<String[]> data){
        this.data = data;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.post, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedAdapter.ViewHolder viewHolder, int i) {
        String[] s = data.get(i);
        viewHolder.title.setText(s[0]);
        viewHolder.post.setText(s[1]);
        viewHolder.author.setText(s[2]);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView post;
        TextView author;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            post = itemView.findViewById(R.id.post_content);
            author = itemView.findViewById(R.id.author);
        }
    }
}
