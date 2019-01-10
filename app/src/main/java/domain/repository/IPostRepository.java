package domain.repository;

import java.util.List;

import data.response.PostDTO;

public interface IPostRepository {
    List<PostDTO> loadPosts();
}
