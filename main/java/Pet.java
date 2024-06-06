/**
 * The pet and the individual functions are defined in this class
 */
public class Pet  {
    private final String name;
    private final PetType type;
    private int happiness;
    private int hungriness;
    private int sleepiness; 

    /**
     * Constructor for the pet.*
     * @param name name of Pet
     * @param type Type of Pet
     */
    public Pet(String name, PetType type) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("Name cant be null or empty ");
        }
        if (type == null) {
            throw new IllegalArgumentException("Type cant be null");
        }
        this.name = name;
        this.type = type;
        this.happiness = 5;
        this.hungriness = 3;
        this.sleepiness = 1;
    }

    /**
     * Copy constructor for Pet.
     * @param other other Pet
     */
    public Pet(Pet other) {
        if (other == null) {
            throw new IllegalArgumentException("Other pet cannot be null!");
        }
        this.name = other.name;
        this.type = other.type;
        this.happiness = other.happiness;
        this.hungriness = other.hungriness;
        this.sleepiness = other.sleepiness;
    }

    //getters
    /**
     * @return return the name of the pet
     */
    public String getName() {
        return name;
    }

    /**
     * @return return the type of the Pet
     */
    public PetType getType() {
        return type;
    }

    /**
     * @return return the Happinies of the Pet
     */
    public int getHappiness() {
        return happiness;
    }

    /**
     * @return return the Hungriness of the Pet
     */
    public int getHungriness() {
        return hungriness;
    }

    /**
     * @return return the Sleepines of the Pet
     */
    public int getSleepiness() {
        return sleepiness;
    }

    /**
     * @return return whether the animal is happy or not
     */
    public boolean isHappy() {
        return happiness > 7;
    }

    /**
     * @return return whether the animal is sad or not
     */
    public boolean isSad() {
        return happiness < 3;
    }

    /**
     * @return the sadness of the animal
     */
    public int getSadness() {
        return 10 - happiness;
    }

    //methods
    /**
     * Changes the happiness by one value.
     *
     * @param change is the value that is added to happiness
     * @return return new happiness
     */
    public int changeHappiness(int change) {
        happiness = happiness + change;

        if (happiness < 0) {
            happiness = 0;
        } else if (happiness > 10) {
            happiness = 10;
        }
        return happiness;
    }

    /**
     * Changes the Hungriness by one value.
     *
     * @param change is the value that is added to the hunger
     * @return return new Hungriness#
     */
    public int changeHungriness(int change) {
        hungriness = hungriness + change;

        if (hungriness < 0) {
            hungriness = 0;
        } else if (hungriness > 10) {
            hungriness = 10;
        }
        return hungriness;
    }

    /**
     * Changes the Sleepiness by a value.
     * @param change is the value added to sleepiness
     * @return return new Sleepiness
     */
    public int changeSleepiness(int change) {
        sleepiness = sleepiness + change;

        if (sleepiness < 0) {
            sleepiness = 0;
        } else if (sleepiness > 10) {
            sleepiness = 10;
        }
        return sleepiness;
    }

    private void applyAction(actions action) {
        changeHappiness((int) (Math.round (action.getHappinessChange()*type.getHappinessMultiplier())));
        changeSleepiness((int) (Math.round (action.getSleepinessChange()*type.getSleepinessMultiplier())));
        changeHungriness((int) (Math.round (action.getHungrinessChange()*type.getHungrinessMultiplier())));
    }

    public void play(){
        applyAction(actions.play);
    }

    public void eat(){
        applyAction(actions.eat);
    }

    public void sleep(){
        applyAction(actions.sleep);
    }

    /**
     * Checks two objects for equality.
     * First it checks whether the other object is null
     * then it is checked whether the classes are the same
     * The attributes are then compared
     * @param other other class
     * @return return true if the instances are equal
     */
    @Override
    public boolean equals(Object other) {
        if (other == null) //if null always false
            return false;
        if (getClass() != other.getClass()) //Compare classes
            return false;

        Pet otherPet = (Pet) other; //cast

        //Compare attributes
        if (!name.equals(otherPet.getName())){
            return false;
        }
        if (!type.equals(otherPet.getType())){
            return false;
        }
        if (happiness != otherPet.happiness){
            return false;
        }
        if (hungriness != otherPet.hungriness){
            return false;
        }
        if (sleepiness != otherPet.sleepiness){
            return false;
        }

        return true;
    }

    /**
     * @return return the Various Animals
     */
    @Override
    public String toString() {
        String emoji; //Emojis indicate the animal's mood
        if (isHappy()) {
            emoji = ":-)";
        } else if (isSad()) {
            emoji = ":-(";
        } else {
            emoji = ":-|";
        }
        return String.format("%s  %s (%s): Ha: %d, Hu %d, Sl %d", name, emoji, type, happiness, hungriness, sleepiness);
    }
}