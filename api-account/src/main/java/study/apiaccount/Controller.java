package study.apiaccount;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.domainmember.Account;
import study.domainmember.AccountRegisterCommand;
import study.domainmember.AccountService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Controller {

    private final AccountService accountService;

    @PostMapping("/members")
    public void addMember(@ModelAttribute AccountRegisterCommand command) {
        accountService.createMember(command);
    }

    @GetMapping("/members")
    public List<Account> getMembers() {
        return accountService.getMembers();
    }
}
