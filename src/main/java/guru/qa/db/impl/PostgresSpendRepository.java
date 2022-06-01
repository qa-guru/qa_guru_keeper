package guru.qa.db.impl;

import guru.qa.db.DataSourceProvider;
import guru.qa.db.SpendEntityRowMapper;
import guru.qa.db.SpendRepository;
import guru.qa.entity.AccountEntity;
import guru.qa.entity.SpendEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PostgresSpendRepository implements SpendRepository {

    private static final JdbcTemplate template =
            new JdbcTemplate(DataSourceProvider.INSTANCE.getDataSource());

    @Override
    public List<SpendEntity> getAllForAccount(AccountEntity account) {
        return template.query("SELECT * FROM spend WHERE account_id = ?",
                new SpendEntityRowMapper(),
                account.getId());
    }

    @Override
    public void addSpend(SpendEntity spend) {
        template.update("INSERT INTO spend (account_id , spend_category, spend, description) values (? , ?, ?, ?)",
                spend.getAccountId(),
                spend.getSpendCategory().toString(),
                spend.getSpend(),
                spend.getDescription()
        );
    }
}
