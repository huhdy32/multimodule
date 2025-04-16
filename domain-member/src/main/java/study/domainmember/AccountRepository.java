package study.domainmember;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findAll();

    Account findByName(String name);
}
