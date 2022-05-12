package guru.qa.db;

import guru.qa.entity.AccountEntity;
import guru.qa.entity.SpendEntity;

import java.util.List;

public interface SpendRepository {
    List<SpendEntity> getAll();
}
