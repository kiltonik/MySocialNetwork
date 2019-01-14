package presentation.postComments;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import data.response.CommentDTO;
import v.mysocialnetwork.R;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder>{

    private List<CommentDTO> data = new ArrayList<>();

    private CommentClickListener listener;

    @NonNull
    @Override
    public CommentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.comment, viewGroup, false);
        v.setOnClickListener(v1 -> listener.onCommentClicked());
        return new ViewHolder(v);
    }

    public CommentsAdapter(CommentClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsAdapter.ViewHolder viewHolder, int i) {
        CommentDTO comment = data.get(i);
        viewHolder.body.setText(comment.body);
        viewHolder.author.setText(comment.email);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setItems(List<CommentDTO> newData){
        data.addAll(newData);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView author;
        TextView body;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.comment_author);
            body = itemView.findViewById(R.id.comment_body);
        }
    }
}
