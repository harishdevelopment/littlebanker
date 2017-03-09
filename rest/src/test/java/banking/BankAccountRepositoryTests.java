package banking;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LittleBankApplication.class)
@WebAppConfiguration
public class BankAccountRepositoryTests {



    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Test
    public void testFindByAccountNumber() throws Exception {
        BankAccount bankAccount = new BankAccount(100L);
        this.bankAccountRepository.save(bankAccount);
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
