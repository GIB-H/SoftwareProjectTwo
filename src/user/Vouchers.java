package user;

public class Vouchers{

    int cost;
    String name;

    public Vouchers(int cost, String name) {
        this.cost = cost;
        this.name = name;

    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
}

