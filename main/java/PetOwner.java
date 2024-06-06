/**
 * in dieser Klasse wird der Owner und die einzelnen Funktionen definiert
 */
public class PetOwner {
    private final String name;
    private final Pet firstPet;
    private final Pet secondPet;

    /**
     * Constructor for the PetOwner.
     * @param name name of the owner
     * @param firstPet the first animal
     * @param secondPet the second animal
     */
    public PetOwner(String name, Pet firstPet, Pet secondPet) {
        if (name == null || name.length() == 0)
            throw new IllegalArgumentException("Name cannot be null or empty");
        if (firstPet == null)
            throw new IllegalArgumentException("Pet1 Must not be null");

        this.name = name;
        this.firstPet = firstPet;
        this.secondPet = secondPet;
    }

    /**
     * Constructor for the PetOwner WITHOUT a second animal.
     * @param name name of the owner
     * @param firstPet the first animal (in this case there is only one)
     */
    public PetOwner(String name, Pet firstPet) {
        this(name, firstPet, null);
    }

    /**
     * Copy constructor that works through deep copy.
     * You don't directly copy the first/(second) pet from the other, but you create a new pet
     * The new pet uses its own copy constructor to then copy the other pet
     * @param other other PetOwner
     */
    public PetOwner(PetOwner other) {
        if (other == null) {
            throw new IllegalArgumentException("Anderer Owner Darf nicht null sein!");
        }
        this.name = other.name;
        this.firstPet = new Pet(other.firstPet);
        this.secondPet = other.secondPet != null ? new Pet(other.secondPet) : null; //wenn other.secondpet = null, dann das hier auch
    }

    //Getter (setters make no sense since all variables are final)
    /**
     * @return return den Namen
     */
    public String getName() {
        return name;
    }

   /**
     * @return return the first pet
     */
    public Pet getFirstPet() {
        return firstPet;
    }

    /**
     * @return return the second pet
     */
    public Pet getSecondPet() {
        return secondPet;
    }

   //Methods
    /**
     * checks whether two actual instances are identical.
     * @param other other instance
     * @return true if identical, false if not
     */
    @Override
    public boolean equals(Object other) {
        if (other == null) //if null always false
            return false;
        if (getClass() != other.getClass()) //Compare classes
            return false;

        PetOwner otherPetOwner = (PetOwner) other; //cast

        //Compare attributes
        if (!name.equals(otherPetOwner.getName())) { //Compare name
            return false;
        }
        if (!firstPet.equals(otherPetOwner.firstPet)) { //Compare first pet
            return false;
        }
        if (secondPet == null) { //If secondpet is null:
            return otherPetOwner.secondPet == null; //return the result whether the other secondPet is also null
        } else return secondPet.equals(otherPetOwner.secondPet); //Otherwise(!=null) compare both SecondPets
    }

    /**
     * @return Prints the PetOwner and his pets
     */
    @Override
    public String toString() {
        return String.format("%s\n-\t%s\n-\t%s", name, firstPet.toString(), secondPet != null ? secondPet.toString() : "none");
    }

    /**
     * takes care of an animal. Must be called each time.
     */
    public void takeCareOfPet(Pet pet) {
        if (pet.getHungriness() >= pet.getSleepiness() && pet.getHungriness() >= pet.getSadness()) {
            pet.eat(); //eat when hunger is greatest
        } else if (pet.getSleepiness() >= pet.getHungriness() && pet.getSleepiness() >= pet.getSadness()) {
            pet.sleep(); //sleep when sleepiness is greatest
        } else {
            pet.play(); //Play if the above two do not apply
        }
    }

    /**
     * Takes care of BOTH animals
     */
    public void takeCareOfPets() {
        takeCareOfPet(firstPet);

        if (secondPet != null) {
            takeCareOfPet(secondPet);
        }
    }

}