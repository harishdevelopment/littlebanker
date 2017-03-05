import static org.junit.Assert.assertEquals;

import banking.BankAccount;
import banking.BankAccountNotFoundException;
import banking.BankAccountRepository;
import banking.LittleBankApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LittleBankApplication.class)
@DataJpaTest
public class BankAccountRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Test
    public void testFindByAccountNumber() throws Exception {
        BankAccount bankAccount = new BankAccount(100L);
        entityManager.persist(bankAccount);
        Optional<BankAccount> findByAccountNumber = bankAccountRepository.findByAccountNumber(1L);
        assertEquals(bankAccount.getBankBalance(), findByAccountNumber.map(BankAccount::getBankBalance).get());
        System.out.println("findByAccountNumber.getBankBalance()" + findByAccountNumber.map(BankAccount::getBankBalance));
    }

    @Test(expected = BankAccountNotFoundException.class)
    public void validateBankAccount() throws Exception {
        this.bankAccountRepository.findByAccountNumber(2L).orElseThrow(
                () -> new BankAccountNotFoundException(1L)
        );
    }
}
