package guru.qa.entity;

public class AccountEntity {
    private int id;
    private String name;
    private int value;

    public int getId() {
        return id;
    }

    public AccountEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AccountEntity setName(String name) {
        this.name = name;
        return this;
    }

    public int getValue() {
        return value;
    }

    public AccountEntity setValue(int value) {
        this.value = value;
        return this;
    }
}
