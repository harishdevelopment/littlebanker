package banking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountNumber;

    private Long bankBalance;

    public BankAccount(Long bankBalance) {
        this.bankBalance = bankBalance;
        System.out.println("New Bank account created...");
    }

    protected BankAccount() {
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public Long getBankBalance() {
        return bankBalance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", bankBalance=" + bankBalance +
                '}';
    }
}
