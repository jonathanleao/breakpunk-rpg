package JavaRpgGame.Domain;

public enum CharacterClass {
    SHOTTER("Shooter"), ENGINNER("Engineer"),
    LONGDISTANCE("Long Distance Support"),TANK ("Tank Boss");

    public String name;

    CharacterClass(String name) {
        this.name= name;

    }

    public String getName() {
        return name;
    }
}
