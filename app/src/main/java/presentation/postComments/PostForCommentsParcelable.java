package presentation.postComments;

import android.os.Parcel;
import android.os.Parcelable;

import data.response.PostDTO;

public class PostForCommentsParcelable implements Parcelable {

    private PostDTO post;

    public static final Creator<PostForCommentsParcelable> CREATOR = new Creator<PostForCommentsParcelable>() {
        @Override
        public PostForCommentsParcelable createFromParcel(Parcel source) {
            String title = source.readString();
            String body = source.readString();
            String author = source.readString();
            String postId = source.readString();
            PostDTO post = new PostDTO();
            post.id = Integer.valueOf(postId);
            post.userId = Integer.valueOf(author);
            post.body = body;
            post.title = title;
            return new PostForCommentsParcelable(post);
        }

        @Override
        public PostForCommentsParcelable[] newArray(int size) {
            return new PostForCommentsParcelable[0];
        }
    };

    public PostForCommentsParcelable(PostDTO post){
        this.post = post;
    }

    public PostDTO getPostFromParcleable(){
        return post;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(post.title);
        dest.writeString(post.body);
        dest.writeString(String.valueOf(post.userId));
        dest.writeString(String.valueOf(post.id));
    }
}
