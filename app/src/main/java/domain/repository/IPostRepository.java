package domain.repository;

import java.util.List;

import data.response.PostDTO;

public interface IPostRepository {
    public List<PostDTO> loadPosts();
}
