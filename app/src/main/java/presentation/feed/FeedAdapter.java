package presentation.feed;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import data.response.PostDTO;
import v.mysocialnetwork.R;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {

    private List<PostDTO> data = new ArrayList<>();

    private FeedClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.post, viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(v);
        v.setOnClickListener(v1 -> listener.onItemClicked(v1, viewHolder.getAdapterPosition()));
        return viewHolder;
    }

    public FeedAdapter(FeedClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull FeedAdapter.ViewHolder viewHolder, int i) {
        PostDTO post = data.get(i);
        viewHolder.title.setText(post.title);
        viewHolder.author.setText(String.valueOf(post.userId));
        viewHolder.post.setText(post.body);

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

    public void setItems(List<PostDTO> newData){
        data.addAll(newData);
        notifyDataSetChanged();
    }

    public List<PostDTO> getData() {
        return data;
    }

    public void clearItems(){
        data.clear();
        notifyDataSetChanged();
    }

    public void addNewPost(PostDTO newData){
        data.add(0, newData);
        notifyDataSetChanged();
    }
}
