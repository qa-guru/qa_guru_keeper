package guru.qa.service;

import guru.qa.data.Category;
import guru.qa.db.AccountRepository;
import guru.qa.db.SpendRepository;
import guru.qa.db.impl.PostgresAccountRepository;
import guru.qa.db.impl.PostgresSpendRepository;
import guru.qa.entity.AccountEntity;
import guru.qa.entity.SpendEntity;

import javax.swing.*;
import java.util.Arrays;

public class SpendService {

    private SpendRepository spendRepository = new PostgresSpendRepository();
    private AccountRepository accountRepository = new PostgresAccountRepository();

    public void doSpend(AccountEntity account) {
        int index = JOptionPane.showOptionDialog(
                null,
                "Категория",
                "Выберите категорию траты",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                Arrays.stream(Category.values()).map(Category::getDescription).toArray(String[]::new),
                Category.BAR.getDescription()
        );

        Category selected = Category.values()[index];
        int spendValue = Integer.parseInt(
                JOptionPane.showInputDialog("Введите размер траты")
        );
        String desc = JOptionPane.showInputDialog("Введите описание траты");
        if (isSpendAcceptedForGivenUser(account, spendValue)) {
            SpendEntity spend = new SpendEntity()
                    .setSpend(spendValue)
                    .setSpendCategory(selected)
                    .setDescription(desc)
                    .setAccountId(account.getId());

            spendRepository.addSpend(spend);
            account.setValue(account.getValue() - spendValue);
            accountRepository.updateAccount(account);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Невозможжно совершить списание",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void showAllSpends(AccountEntity account) {
        Object[][] rows = spendRepository.getAllForAccount(account)
                .stream()
                .map(spend -> new Object[]{spend.getSpendCategory().getDescription(), spend.getSpend(), spend.getDescription()})
                .toArray(Object[][]::new);

        Object[] headers = {"Категория", "Размер траты", "Описание траты"};
        JTable table = new JTable(rows, headers);
        JOptionPane.showMessageDialog(null, new JScrollPane(table));
    }

    private boolean isSpendAcceptedForGivenUser(AccountEntity givenUser, int spend) {
        if (spend <= 0) {
            return false;
        }
        if (givenUser.getValue() < spend) {
            return false;
        }
        return true;
    }
}
