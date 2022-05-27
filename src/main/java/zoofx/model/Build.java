package zoofx.model;

public class Build {

    private final String name;

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    private final int cost;

    public Build(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }


}
