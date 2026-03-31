package JavaRpgGame.Domain;

public class Ollie extends Character {
    private Boss boss;
    private int damage;

    public Ollie(CharacterNames characterNames, CharacterClass characterClass) {
        super(characterNames, characterClass);
        life = 200;
        level = 15;
    }

    public Ollie(CharacterNames characterNames, CharacterClass characterClass, int level, int life, int atack) {
        super(characterNames, characterClass, level, life, atack);
    }

    @Override
    public void showAttacks() {
        System.out.println("\ntaque (1) - Mechanical Bees  " +
                "\nataque (2) - iron Shield" +
                "\nataque (3) - Ultra Hammer");
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
                    System.out.println("Você atacou o inimigo com Mechanical bees");
                    damage = 30;
                    break;
                case 2:
                    System.out.println("Você usou com Iron Shield");
                    life += 30;
                    break;
                case 3:
                    System.out.println("Você atacou com Titan hammer");
                    damage = 40;
                    break;
                case 0:
                    System.out.println("Ollie não ataca");
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
        System.out.println("Ollie, o engenheiro genial dos céus");
        System.out.println("\nNome: Ollie" +
                "\n\nUm jovem construtor de dirigíveis, usa um pequeno chapéu estilo Chaplin, roupas laranja com tons de roxo, faixas roxas nos pulsos e um pano amarrado na cintura.");

        System.out.println("\nDETALHES DOS ATAQUES");
        System.out.println(
                "\n- Mechanical Bee: cria uma abelha mecânica que causa dano contínuo ao inimigo." +
                        "\n- Iron Shield: cria um escudo que aumenta sua vida." +
                        "\n- Titan Hammer: golpeia o chão com seu martelo causando dano em todos os inimigos.");
        System.out.println("\nCom engrenagens e genialidade, Ollie transforma sucata em poder absoluto...");

    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }
}


