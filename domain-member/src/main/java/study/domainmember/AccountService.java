package study.domainmember;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    @Transactional
    public void createMember(AccountRegisterCommand member) {
        Account account = new Account(member.name());
        accountRepository.save(account);
    }

    @Transactional(readOnly = true)
    public List<Account> getMembers() {
        return accountRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Account getMember(AccoutQueryByName accoutQueryByName) {
        return accountRepository.findByName(accoutQueryByName.name());
    }
}
