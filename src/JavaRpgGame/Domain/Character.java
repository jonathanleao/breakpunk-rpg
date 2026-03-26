package JavaRpgGame.Domain;

public abstract class Character {
    protected CharacterNames characterNames;
    protected CharacterClass characterClass;
    protected int level;
    protected int life;
    protected int attack;
    protected boolean stunned = false;

    public Character(CharacterNames characterNames, CharacterClass characterClass) {
        this.characterNames = characterNames;
        this.characterClass = characterClass;
    }

    public Character(CharacterNames characterNames, CharacterClass characterClass, int level, int life, int attack) {
        this.characterNames = characterNames;
        this.characterClass = characterClass;
        this.level = level;
        this.life = life;
        this.attack = attack;
    }

    @Override
    // character stats
    public String toString() {
        return "\nSTATS"
                + "\nname: " + characterNames.getName()
                + "\nClass: " + characterClass.getName()
                + "\nLevel: " + this.level
                + "\nlife: " + this.life;
    }

    public abstract void showAttacks();

    public abstract void attack(int atack);



    public abstract void characterDetails();


    public CharacterNames getCharacterNames() {
        return characterNames;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public boolean isStunned() {
        return stunned;
    }

    public void setStunned(boolean stunned) {
        this.stunned = stunned;
    }
}
