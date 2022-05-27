package zoofx.model;

public enum Section {
    WAY(new Build[]{new Build("Allée de terre", 10),
                    new Build("Allée de gravier", 15),
                    new Build("Allée en bois", 20),
                    new Build("Allée en pavés", 25),
                    new Build("Allée principale", 30),
                    new Build("Route", 20)}),
    ANIMALS(new Build[]{new Build("Enclos poules", 2000),
                        new Build("Enclos vaches", 5000),
                        new Build("Enclos cochons", 6000),
                        new Build("Enclos chevaux", 7000),
                        new Build("Enclos loups", 10000),
                        new Build("Enclos crocodiles", 15000),
                        new Build("Enclos pandas", 25000),
                        new Build("Enclos penguins", 25000),
                        new Build("Enclos singes", 20000),
                        new Build("Enclos giraffe", 30000),
                        new Build("Enclos éléphants", 40000)}),
    BUILD(new Build[]{new Build("Boutique de souvenirs", 15000),
                      new Build("Restaurant", 20000),
                      new Build("Hôtel", 30000),
                      new Build("Bar", 15000)}),
    FLASH(new Build[]{new Build("Éolienne", 3000),
                      new Build("Panneaux solaire", 4000)}),
    WATER(new Build[]{new Build("Pompe", 7000),
                      new Build("Station d'épuration", 8000)}),
    TREE(new Build[]{new Build("Arbre", 200),
                     new Build("Banc", 100),
                     new Build("Poubelle", 20),
                     new Build("Lampadaire", 10)});

    private Build[] builds;

    public Build[] getBuilds() {
        return builds;
    }

    private Section(Build[] builds) {
        this.builds = builds;
    }

    @Override
    public String toString() {
        if (this == WAY) {
            return "Section chemin";
        } else if (this == ANIMALS) {
            return "Section enclot";
        } else if (this == BUILD) {
            return "Section magasin";
        } else if (this == FLASH) {
            return "Section alimentation électrique";
        } else if (this == WATER) {
            return "Section alimentation hydraulique";
        } else if (this == TREE) {
            return "Section décoration";
        }
        return super.toString();
    }
}
