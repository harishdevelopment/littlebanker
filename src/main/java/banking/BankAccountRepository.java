package banking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    BankAccount findByAccountNumber(Long accountNumber);

}
