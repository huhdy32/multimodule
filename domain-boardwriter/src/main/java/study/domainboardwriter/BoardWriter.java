package study.domainboardwriter;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import study.domainboard.Post;
import study.domainmember.Account;

@Entity
@RequiredArgsConstructor
@Getter
public class BoardWriter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    @Cascade(value = {CascadeType.PERSIST})
    @BatchSize(size = 100)
    private List<Post> posts;

    public BoardWriter(Account account, List<Post> posts) {
        this.account = account;
        this.posts = posts;
    }
}