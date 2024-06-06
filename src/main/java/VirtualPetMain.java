/**
 * This class is the main class for Virtual Pets
 */
public class VirtualPetMain {
    public static void main(String[] args) {
        //Initialize the pets
        Pet rosco = new Pet("Rosco", PetType.DOG);
        Pet morgana = new Pet("Morgana", PetType.CAT);
        Pet rabbit = new Pet("Rabbit of Caerbannog", PetType.RABBIT);

        //Animals are output with toString
        System.out.println("vv========================================= ================vv"); //BEGIN
        System.out.println(rosco);
        System.out.println(morgana);
        System.out.println(rabbit);

        //comparison with equals and with boolean expression
        Pet roscoClone = new Pet(rosco); //Creating a pet called roscoClone using Rosco's constructor
        System.out.println("\nComparison with equals method: "+roscoClone.equals(rosco)); //Comparison with .equals
        System.out.println("Comparison with boolean expression: "+(rosco == roscoClone)); //Comparison with boolean expression "=="

        //Creating a new pet and using the "eat" method
        Pet bunny = new Pet("SpringBonnie", PetType.RABBIT);
        System.out.println("\nBefore eating: " + bunny);
        bunny.eat(); //Execute food method
        System.out.println("After eating: " + bunny);

        //Initialize the PetOwner
        PetOwner jimmy = new PetOwner("Jimmy",rosco, rabbit);
        PetOwner timmy = new PetOwner("Timmy",morgana);

        //PetOwner are output with toString
        System.out.println("------------------------------------------- ----------------------");
        System.out.println(jimmy);
        System.out.println(timmy);

        //Initializing JimmyCLone with DeepCopyConstructor
        PetOwner jimmyClone = new PetOwner(jimmy);

        //trying out different boolean values
        System.out.println("------------------------------------------ ----------------------");
        System.out.println(jimmyClone.equals(jimmy)); //true because all attributes are equal
        System.out.println(jimmyClone == jimmy); //false because it only compares the name
        System.out.println(jimmyClone.getFirstPet().equals(jimmy.getFirstPet())); //true because the attributes are compared
        System.out.println(jimmyClone.getFirstPet()== jimmy.getFirstPet()); //false because the names are compared

        //10 iterations
        System.out.println("------------------------------------------- ----------------------");
        for (int i = 0; i < 10; i++) {
            jimmy.takeCareOfPets();
            timmy.takeCareOfPets();
            System.out.println("---Iteration "+i+"---");
            System.out.println(jimmy);
            System.out.println(timmy+"\n");
        }

        System.out.println("^^======================================== =================^^"); //END
    }
}