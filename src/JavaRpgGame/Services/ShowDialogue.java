package JavaRpgGame.Services;

import JavaRpgGame.Domain.Character;

import java.util.Scanner;

public class ShowDialogue {
    Scanner scanner = new Scanner(System.in);

    public  void showDialogue(Character character, char startFinalBattle) {
        String name = character.getCharacterNames().getName();
        switch (startFinalBattle) {
            case 'n':
            case 'N': {
                System.out.println(
                        "\nO céu da Cidade Prateada está coberto por uma névoa avermelhada, e o som metálico dos dirigíveis ecoa pelo horizonte..." +
                                "\nO deserto enferrujado se estende diante de você, com cactos corroídos e carcaças de máquinas abandonadas pelo tempo." +
                                "\nAo longe, uma nave se aproxima lentamente, flutuando acima do solo como um presságio de morte..." +
                                "\nDe dentro de um aquário conectado à máquina, uma figura grotesca observa você..." +
                                "\nBoss..." +
                                "\nSeu cérebro exposto pulsa enquanto cabos e tubos alimentam sua nave com energia sombria." +
                                "\n\nSeus olhos se fixam em você, frios... calculistas..." +

                                "\n— Então... mais um herói tentando brincar de salvador? — diz Boss com um tom distorcido." +
                                "\n\n— Muitos vieram antes de você... todos falharam." +

                                "\nO vento quente sopra forte, levantando areia e ferrugem ao seu redor." +
                                "\n\nSeus aliados se posicionam ao seu lado, prontos para a batalha." +

                                "\n— Devolva a garota, Boss! — a voz ecoa firme no campo de batalha." +

                                "\nBoss solta uma risada baixa, mecânica..." +
                                "\n\n— Se você quer o que é meu... então lute por isso." +

                                "\nboss então lança um de seus venenos paralisadores e impossibilita" +
                                "\n\nos aliados de " + name + ", o deixando sozinho em combate" +

                                "\nA nave vibra intensamente, seus canhões começam a carregar energia." +
                                "\n\nO chão treme enquanto o calor aumenta ao redor." +

                                "\n— Vamos ver se você é digno... de sobreviver." +

                                "\nO combate final começa..." +

                                "\nPrepare-se para lutar.");
                break;
            }
            case 's':
            case 'S': {
                System.out.println("\nEntão o tirano disse - vou ser rápido, sou um homem bom, e quero lhe poupar de ver a sua família ");
                System.out.println("Morrer.........");
                break;
            }

        }
    }

}
