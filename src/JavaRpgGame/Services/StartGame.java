package JavaRpgGame.Services;

public class StartGame{

    public void startAdventure(char start){
        switch (start) {
            case 's':
            case 'S':
                System.out.println("Você e esse seu reinado de caos, acabam aqui...");
                System.out.println("\nIniciando Jogo...");
                break;
            case 'n':
            case 'N':
                System.out.println("A sua Falta de coragem, levou sua familia, e todos que você ama, a morte...");
                System.exit(0);
        }
    }
}
