package study.apiboard;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.domainboardwriter.BoardWriteService;
import study.domainboardwriter.PostByMemberCommand;
import study.domainboardwriter.PostResult;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class BoardWriteController {
    private final BoardWriteService boardWriteService;

    @PostMapping
    public void addPost(
            @RequestParam final String title,
            @RequestParam final String content,
            @RequestParam final String writer
    ) {
        boardWriteService.write(new PostByMemberCommand(title, content, writer));
    }

    @GetMapping
    public List<PostResult> getAll(
            @RequestParam final String writer
    ) {
        return boardWriteService.writedPosts(writer);
    }
}
