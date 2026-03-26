package JavaRpgGame.Domain;

public enum CharacterNames {
    SILVER("Silver"),OLLIE("Ollie"),SERJ("Serj"),BOSS("Boss");

    public String name;

    CharacterNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
