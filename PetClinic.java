import java.util.Scanner;

class Pet {
    private String species;
    private String name;

    public Pet(String species, String name) {
        this.species = species.toLowerCase();
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }
}

public class PetClinic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an array of 10 pets
        Pet[] pets = new Pet[10];
        pets[0] = new Pet("dog", "Pluto");
        pets[1] = new Pet("cat", "Whiskers");
        pets[2] = new Pet("dog", "Jack");
        pets[3] = new Pet("rabbit", "Fluffy");
        pets[4] = new Pet("duck", "Donald");
        pets[5] = new Pet("dog", "Milou");
        pets[6] = new Pet("turtle", "Leonardo");
        pets[7] = new Pet("cat", "Garfield");
        pets[8] = new Pet("rabbit", "Bunny");
        pets[9] = new Pet("duck", "Daffy");

        // Ask user for pet type
        System.out.print("Give type: ");
        String type = scanner.nextLine().toLowerCase();

        // Find and display pets of this type
        int count = 0;
        System.out.println("Pets of type " + type + ":");
        for (Pet pet : pets) {
            if (pet.getSpecies().equals(type)) {
                System.out.println("- " + pet.getName());
                count++;
            }
        }

        // Display total count
        System.out.println("Total animals of " + type + " type: " + count);
        scanner.close();
    }
}

