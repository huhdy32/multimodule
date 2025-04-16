package study.domainboard;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private final PostRepository postRepository;

    public Post addPost(final PostRegisterCommand postRegisterCommand) {
        final Post post = new Post(postRegisterCommand.title(), postRegisterCommand.content());
        postRepository.save(post);
        return post;
    }

    public void removePost(final Long id) {
        postRepository.deleteById(id);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
