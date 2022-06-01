package guru.qa.entity;

import guru.qa.data.Category;

public class SpendEntity {
    private int id;
    private int accountId;
    private Category spendCategory;
    private int spend;
    private String description;

    public int getId() {
        return id;
    }

    public SpendEntity setId(int id) {
        this.id = id;
        return this;
    }

    public int getAccountId() {
        return accountId;
    }

    public SpendEntity setAccountId(int accountId) {
        this.accountId = accountId;
        return this;
    }

    public Category getSpendCategory() {
        return spendCategory;
    }

    public SpendEntity setSpendCategory(Category spendCategory) {
        this.spendCategory = spendCategory;
        return this;
    }

    public int getSpend() {
        return spend;
    }

    public SpendEntity setSpend(int spend) {
        this.spend = spend;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SpendEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
