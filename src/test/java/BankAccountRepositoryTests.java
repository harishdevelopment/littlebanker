import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import banking.BankAccount;
import banking.BankAccountRepository;
import banking.LittleBankApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        BankAccount bankAccount1 = new BankAccount(100L);
        entityManager.persist(bankAccount1);

        BankAccount findByAccountNumber = bankAccountRepository.findByAccountNumber(1L);
        assertEquals(bankAccount1.getBankBalance(), findByAccountNumber.getBankBalance());
        System.out.println("findByAccountNumber.getBankBalance()" + findByAccountNumber.getBankBalance());

    }
}
