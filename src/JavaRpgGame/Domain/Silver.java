package JavaRpgGame.Domain;

public class Silver extends Character {
    private Boss boss;
    private int damage;

    public Silver(CharacterNames characterNames, CharacterClass characterClass) {
        super(characterNames, characterClass);
        life = 250;
        level = 30;
    }

    public Silver(CharacterNames characterNames, CharacterClass characterClass, int level, int life, int atack) {
        super(characterNames, characterClass, level, life, atack);
    }

    public String toString() {
        return super.toString();
    }

    @Override
    public void showAttacks() {
        System.out.println("\n ataque (1) - Punk Pistol Shoot" +
                "\nataque (2) - Mistical Encharpe" +
                "\nataque (3) - Demon crucife of Life");

    }
    @Override
    public void attack(int attack) {
        if (stunned) {
            System.out.println("Você foi stunnado");
            stunned = false;
            return;
        }
        damage = 0;
        {
            switch (attack) {
                case 1:
                    System.out.println("Você atacou o inimigo com Punk Pistol Shoot");
                    damage = 30;
                    break;
                case 2:
                    System.out.println("Você atacou com Mistical Scarf");
                    boss.setStunned(true);
                    damage = 20;
                    break;
                case 3:
                    System.out.println("Você usou Demon Crucife of life");
                    System.out.println("Adicionado 40 de vida a seu personagem");
                    life += 40;
                    damage = 10;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
            int losingLife = boss.getLife() - damage;
            boss.setLife(losingLife);
            System.out.println("\nBoss agora tem "+losingLife+" de vida");
        }
    }


    @Override
    public void characterDetails() {
        System.out.println("Silver, o pistoleiro implacável");
        System.out.println("\nNome: Silver" +
                "\n\nUm homem alto, Usa cartola laranja com óculos redondos, vestido enferrujado, echarpe vermelho escuro e cabelo cacheado curto.");

        System.out.println("\nDETALHES DOS ATAQUES");
        System.out.println(
                "\n- Punk Pistol Shoot: causa dano direto ao inimigo." +
                        "\n- Mistical Encharpe: prende o inimigo e impede que ele ataque por uma rodada." +
                        "\n- Demon Crucife of life: cura alta a si mesmo usando um crucifixo demoníaco e drena 10 de vida do inimigo");
        System.out.println("\nNo deserto deste mundo sombrio, não há um pistoleiro tão letal quando Sir silver...");
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }
}



