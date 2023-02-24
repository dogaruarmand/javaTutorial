package exercises.finance.intern;

public class Bank {
    private String name;
    private int vault;

    public Bank() {
    }

    public Bank(String name) {
        this.name = name;
    }

    public int getVault() {
        return vault;
    }

    public void setVault(int vault) {
        this.vault = vault;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                '}';
    }
}
