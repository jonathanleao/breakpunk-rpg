package JavaRpgGame.Services;

import JavaRpgGame.Domain.Character;

public class ShowCharacterDetails {
    public void showInformation(Character character, char information) {
            switch (information) {
                case 's':
                case 'S':
                    character.characterDetails();
                    break;
                case 'n':
                case 'N':
                    System.out.println("No escuro andas então...");
                    break;
                default:
                    throw new IllegalArgumentException("não pode usar números ou palavras diferentes!");
            }

    }
}
