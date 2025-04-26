package cse.school.codejam;

public class BankServiceImpl implements BankService {
    private final AccountRepository accountRepository;
    private final TransactionLogger transactionLogger;

    public BankServiceImpl(TransactionLogger transactionLogger, AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        this.transactionLogger = transactionLogger;
    }

    @Override
    public void createAccount(String accountNumber, String accountHolderName) {
        if (accountRepository.accountExists(accountNumber)) {
            throw new IllegalArgumentException("Account already exists.");
        }
        BankAccount account = new BankAccount(accountNumber, accountHolderName);
        accountRepository.addAccount(account);
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        BankAccount account = accountRepository.getAccount(accountNumber);
        account.deposit(amount);
        Transaction transaction = new Transaction()
                .setType(Transaction.TransactionType.DEPOSIT)
                .setToAccountNumber(accountNumber)
                .setAmount(amount);
        transactionLogger.logTransaction(accountNumber, transaction);
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        BankAccount account = accountRepository.getAccount(accountNumber);
        account.withdraw(amount);
        Transaction transaction = new Transaction()
                .setType(Transaction.TransactionType.WITHDRAW)
                .setFromAccountNumber(accountNumber)
                .setAmount(amount);
        transactionLogger.logTransaction(accountNumber, transaction);
    }

    @Override
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive.");
        }
        BankAccount fromAccount = accountRepository.getAccount(fromAccountNumber);
        BankAccount toAccount = accountRepository.getAccount(toAccountNumber);
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);

        Transaction fromTransaction = new Transaction()
                .setType(Transaction.TransactionType.TRANSFER)
                .setFromAccountNumber(fromAccountNumber)
                .setToAccountNumber(toAccountNumber)
                .setAmount(amount);

        Transaction toTransaction = new Transaction()
                .setType(Transaction.TransactionType.TRANSFER)
                .setFromAccountNumber(fromAccountNumber)
                .setToAccountNumber(toAccountNumber)
                .setAmount(amount);

        transactionLogger.logTransaction(fromAccountNumber, fromTransaction);
        transactionLogger.logTransaction(toAccountNumber, toTransaction);
    }

    @Override
    public String getAccountDetails(String accountNumber) {
        BankAccount account = accountRepository.getAccount(accountNumber);
        return account.getAccountDetails();
    }

    @Override
    public double getAccountBalance(String accountNumber) {
        BankAccount account = accountRepository.getAccount(accountNumber);
        return account.getBalance();
    }
}