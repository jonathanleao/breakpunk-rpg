package JavaRpgGame.Test;

import JavaRpgGame.Domain.*;
import JavaRpgGame.Domain.Character;
import JavaRpgGame.Services.ShowCharacterDetails;
import JavaRpgGame.Services.ShowDialogue;
import JavaRpgGame.Services.StartGame;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RpgCharactersMain {
    static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Character player = null;

        Silver silver = new Silver(CharacterNames.SILVER, CharacterClass.SHOTTER);
        Ollie ollie = new Ollie(CharacterNames.OLLIE, CharacterClass.ENGINNER);
        Serj serj = new Serj(CharacterNames.SERJ, CharacterClass.LONGDISTANCE);

        //Chefão do game

        final Boss boss = new Boss(CharacterNames.BOSS, CharacterClass.TANK);

        silver.setBoss(boss);
        serj.setBoss(boss);
        ollie.setBoss(boss);

        System.out.println("===================================================");
        System.out.println("SEJA BEM VINDO A BREAKPUNK");
        System.out.println("===================================================");
        // Selecionar personagem
        do {
            System.out.println("Qual personagem deseja escolher?");
            System.out.println("\n1- Silver" +
                    "\n2 - Ollie" +
                    "\n3 - Serj");

            System.out.println("\nEscolha (1),(2),(3)");
            try {
                int select = scanner.nextInt();
                switch (select) {
                    case 1:
                        player = silver;
                        break;
                    case 2:
                        player = ollie;
                        break;

                    case 3:
                        player = serj;
                        break;

                    default:
                        System.out.println("Esse personagem não existe, tente novamente...");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("digite apenas números!!!");
                scanner.nextLine();
            }
        } while (player == null);

        //Setando player como inimigo do boss
        boss.setCharacter(player);
        //Mostrando as informações do persoagem
        System.out.println("Informações do seu personagem");
        System.out.println(player);
        System.out.println("------------------------------------");

        ShowCharacterDetails showCharacterDetails = new ShowCharacterDetails();
        do {
            try {
                System.out.println("\nDeseja ver as informações do seu personagem? (sim/não)");
                char information = scanner.next().charAt(0);
                showCharacterDetails.showInformation(player, information);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        //Iniciando o a aventura
        System.out.println("==============================================================================================");
        StartGame startGame = new StartGame();
        do {
            try {
                System.out.println("\nDesejar iniciar sua aventura jovem guerreiro?");
                char start = scanner.next().charAt(0);
                startGame.startAdventure(start);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);


        //Sistema de dialogo com o chefe
        do {
            try {
                System.out.println("\nHoras antes do fim...");
                System.out.println("\nDeseja pular o dialogo? (sim/não)");
                char startFinalBattle = scanner.next().charAt(0);
                ShowDialogue showDialogue = new ShowDialogue();
                showDialogue.showDialogue(player, startFinalBattle);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        //informações do Boss
        System.out.println("==============================================================================================================");
        System.out.println("Detalhes do BOSS");
        boss.characterDetails();
        System.out.println("-----------------------------------------------------------------------------------");

        //iniciando combate do jogo com sistema de vida e stunning
        int atack;
        String name = player.getCharacterNames().getName();
        do {
            try {
                //loop de ataque do personagem e do boss
                System.out.println("\nTurno de " + name);
                System.out.println("\nCom qual golpe você deseja atacar?");
                player.showAttacks();
                atack = scanner.nextInt();
                player.attack(atack);
                if (boss.getLife() <= 0) {
                    player.setLevel(100);
                    System.out.println("\nVocê derrotou o tirano, libertou seus amigos" + " \ne sua glória será lembrada para todo o sempre");
                    System.out.println("\nFim de jogo...");
                    System.out.println("Você derrotou o Boss e upou para o nível: " + player.getLevel());
                    System.out.println(player);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas Números!!!");
                System.out.println("Turno perdido");
                scanner.nextLine();
            }

            System.out.println("-------------------------------------------------------------------------");
            System.out.println("\nTurno do Boss");
            System.out.println("Ataques do boss");
            boss.showAttacks();
            //randomizador dos ataques do boss
            int bossAttacks = random.nextInt(4) + 1;
            System.out.println("----------------------------------------------------------------------------");
            boss.attack(bossAttacks);
            if (player.getLife() <= 0) {
                player.setLevel(0);
                System.out.println("\nBoss destruiu você, e sua missão falhou, seus amigos foram condenados" + "\nnagora, você  irá morrer, e morrerá pensando o quanto fracassou...");
                System.out.println("\nfim de jogo");
                System.out.println("Boss te destrui e após sua morte, seu level caiu para: " + player.getLevel());
                System.out.println(player);
                break;
            }
        } while (boss.getLife() > 0 && player.getLife() > 0);
        System.out.println("\n");
    }

}
