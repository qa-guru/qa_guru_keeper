package guru.qa.service;

import guru.qa.entity.AccountEntity;

public class Application {

    private AccountService accountService = new AccountService();
    private SpendService spendService = new SpendService();

    public void run() {
        AccountEntity accountEntity = accountService.login();
        accountService.showCurrentBalance(accountEntity);
        spendService.doSpend(accountEntity);
        accountService.showCurrentBalance(accountEntity);
        spendService.showAllSpends(accountEntity);
    }
}
