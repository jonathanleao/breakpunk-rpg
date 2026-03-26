package JavaRpgGame.Domain;

import java.util.Random;

public class Boss extends Character {
    private Character character;
    private int damage;

    public Boss(CharacterNames characterNames, CharacterClass characterClass) {
        super(characterNames, characterClass);
        life = 450;
        level = 35;
    }

    public Boss(CharacterNames characterNames, CharacterClass characterClass, int level, int life, int atack) {
        super(characterNames, characterClass, level, life, atack);
    }

    @Override
    public void showAttacks() {
        System.out.println("\n(1)-Death Laser" +
                "\n(2)-Ground impact" +
                "\n(3)-Hellfire Burn");
    }

    @Override
    public void attack (int attack) {
        if (stunned){
            System.out.println("O Mistical encharpe empediu o boss de atacar nessa rodada");
            stunned = false;
            return;
        }
        damage = 0;
        switch (attack){
            case 1:
                System.out.println("O boss atacou com Death Laser");
                damage = 30;
                break;
            case 2:
                System.out.println("O boss atacou com ground impact");
                character.setStunned(true);
                damage = 40;
                break;
            case 3:
                System.out.println("O boss atacou com Hellfire Burn");
                damage = 40;
                break;
            case 4:
                System.out.println("boss zomba da sua fraqueza e não ataca");
                break;
        }
        int losingLife = character.getLife() - damage;
        character.setLife(losingLife);
        System.out.println(character.getCharacterNames().getName()+ " agora tem "+losingLife+" de vida");

    }

    @Override
    public void characterDetails() {
        System.out.println("Boss, o tirano da Cidade Prateada");
        System.out.println("\nNome: Boss" +
                "\n\nUma mente cruel: uma cabeça com cérebro exposto dentro de um aquário, conectada a uma nave mortal que domina os céus.");

        System.out.println("\nDETALHES DOS ATAQUES");
        System.out.println(
                "\n- Death Laser: dispara um laser que retira 30 da vida do alvo." +
                        "\n- Ground Impact: atinge o chão causando dano extremo e impedindo você de atacar nessa rodada." +
                        "\n- Hellfire Burn: incendeia os inimigos causando alto dano contínuo.");
        System.out.println("\n\n\nNas sombras da Cidade Prateada, ninguém escapa do olhar — e do poder — de Boss...");
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public boolean isStunned() {
        return stunned;
    }

    public void setStunned(boolean stunned) {
        this.stunned = stunned;
    }
}
