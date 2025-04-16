package study.domainboardwriter;

import study.domainboard.Post;

public record PostResult(Long id,
                         String title,
                         String content,
                         String writer) {
    static PostResult to(final Post post, final String writer) {
        return new PostResult(post.getId(), post.getTitle(), post.getContent(), writer);
    }
}
