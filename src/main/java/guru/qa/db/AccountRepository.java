package guru.qa.db;

import guru.qa.entity.AccountEntity;

import java.util.List;

public interface AccountRepository {
    List<AccountEntity>  getAll();
    AccountEntity  getByName(String accountName);
    void addAccount(AccountEntity account);
}
