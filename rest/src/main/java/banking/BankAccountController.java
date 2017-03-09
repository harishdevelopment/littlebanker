package banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BankAccountController {

    private final BankAccountRepository bankAccountRepository;

    @Autowired
    BankAccountController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @RequestMapping(value = "/account/{accountNumber}", method = RequestMethod.GET)
    ResponseEntity<BankAccount> getAccountBalance(@PathVariable("accountNumber") Long accountNumber){
        this.validateBankAccount(accountNumber);
        Optional<BankAccount> bankAccount = this.bankAccountRepository.findByAccountNumber(accountNumber);
        return new ResponseEntity<>(bankAccount.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/account/", method = RequestMethod.POST)
    ResponseEntity<?> createBankAccount(@RequestBody BankAccount bankAccount){
        this.bankAccountRepository.save(bankAccount);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    private void validateBankAccount(Long accountNumber){
        this.bankAccountRepository.findByAccountNumber(accountNumber).orElseThrow(
                () -> new BankAccountNotFoundException(accountNumber)
        );
    }
}
