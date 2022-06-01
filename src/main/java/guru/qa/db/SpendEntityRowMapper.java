package guru.qa.db;

import guru.qa.data.Category;
import guru.qa.entity.AccountEntity;
import guru.qa.entity.SpendEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpendEntityRowMapper implements RowMapper<SpendEntity> {
    @Override
    public SpendEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new SpendEntity()
                .setId(rs.getInt("id"))
                .setDescription(rs.getString("description"))
                .setAccountId(rs.getInt("account_id"))
                .setSpendCategory(Category.valueOf(rs.getString("spend_category")))
                .setSpend(rs.getInt("spend"));
    }
}
