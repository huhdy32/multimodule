package study.domainboardwriter;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

interface BoardWriterRepository extends JpaRepository<BoardWriter, Long> {
    @Query("SELECT bw FROM BoardWriter bw WHERE bw.account.name = :name")
    List<BoardWriter> findAllByAccountName(@Param("name") final String accountName);
}
