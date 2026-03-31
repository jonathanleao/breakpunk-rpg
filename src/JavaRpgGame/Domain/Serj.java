package JavaRpgGame.Domain;

public class Serj extends Character {
    private Boss boss;
    private int damage;
    private boolean rocketArmStunned = false;

    public Serj(CharacterNames characterNames, CharacterClass characterClass) {
        super(characterNames, characterClass);
        life = 320;
        level = 30;
    }

    public Serj(CharacterNames characterNames, CharacterClass characterClass, int level, int life, int atack) {
        super(characterNames, characterClass, level, life, atack);
    }

    @Override
    public void showAttacks() {
        System.out.println("\ntaque (1) - Plasma Cannon  " +
                "\nataque (2) - Rocket Arm" +
                "\nataque (3) - Iron Feast");
    }

    @Override
    public void attack(int attack) {
        if (stunned) {
            System.out.println("Serj foi stunnado e seu ataque não deu dano");
            stunned = false;
            return;
        }
        if (rocketArmStunned){
            System.out.println("Serj usou Rocket Arm e não joga por uma rodada");
            rocketArmStunned= false;
            return;
        }

        damage = 0;
        {
            switch (attack) {
                case 1:
                    System.out.println("Você atacou o inimigo com Plasma Cannon");
                    damage = 50;
                    break;
                case 2:
                    System.out.println("Você atacou com Rocket Arm");
                    rocketArmStunned = true;
                    damage = 50;
                    break;
                case 3:
                    System.out.println("Você usou Iron Feast");
                    life += 60;
                    break;
                default:
                    System.out.println("Opção inválida, perdeu seu turno");
                    break;
            }
            int losingLife = boss.getLife() - damage;
            boss.setLife(losingLife);
            System.out.println("\nBoss agora tem "+losingLife+" de vida");

        }
    }


@Override
public void characterDetails() {
    System.out.println("Serj, o veterano de aço e plasma");
    System.out.println("\nNome: Serj" +
            "\n\nUm homem experiente com barba de Papai Noel, dentes de ouro e um braço robótico enferrujado com engrenagens expostas.");

    System.out.println("\nDETALHES DOS ATAQUES");
    System.out.println(
            "\n- Plasma Cannon: dispara um raio de plasma devastador com seu braço mecânico." +
                    "\n- Rocket Arm: lança seu próprio braço causando dano contínuo, e ao usar ele fica 1 rodada sem atacar." +
                    "\n- Iron Feast: devora um frango inteiro e recupera muita vida.");
    System.out.println("\nMesmo quebrado pelo tempo, Serj continua sendo uma máquina de guerra imparável...");

}

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }
}
