package study.domainboardwriter;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.domainboard.Post;
import study.domainboard.PostRegisterCommand;
import study.domainboard.PostService;
import study.domainmember.Account;
import study.domainmember.AccountService;
import study.domainmember.AccoutQueryByName;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardWriteService {
    private final BoardWriterRepository boardWriterRepository;
    private final AccountService accountService;
    private final PostService postService;

    public List<PostResult> writedPosts(final String memberName) {
        return boardWriterRepository.findAllByAccountName(memberName).stream()
                .flatMap(boardWriter -> boardWriter.getPosts().stream())
                .map(post -> PostResult.to(post, memberName))
                .toList();
    }

    @Transactional
    public void write(final PostByMemberCommand postCommand) {
        final Post post = postService.addPost(new PostRegisterCommand(postCommand.title(), postCommand.content()));
        final Account account = accountService.getMember(new AccoutQueryByName(postCommand.requestMemberName()));
        boardWriterRepository.save(new BoardWriter(account, List.of(post)));
    }
}
