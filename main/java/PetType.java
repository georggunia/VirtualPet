/**
 * This is the list of the different pets with their corresponding multipliers.
 * Each variable is of type double
 */
public enum PetType {
    DOG(2.0,2.0,2.0), CAT(1.0,3.0,2.0), BIRD(0.75,1.0,0.75), RABBIT(0.5,0.5,1.0);
    private final double happinessMultiplier, hungrinessMultiplier, sleepinessMultiplier; //Attributes
    

    PetType(double happinessMultiplier, double hungrinessMultiplier, double sleepinessMultiplier) { //Constructor
        this.happinessMultiplier = happinessMultiplier;
        this.hungrinessMultiplier = hungrinessMultiplier;
        this.sleepinessMultiplier = sleepinessMultiplier;
    }

    /**
     * returns HappinessMultiplier of type double.
     * @return return happinessMultiplier;
     */
    public double getHappinessMultiplier() {
        return happinessMultiplier;
    }


    /**
     * returns HungrinessMultiplier of type double
     * @return return hungrinessMultiplier;
     */
    public double getHungrinessMultiplier() {
        return hungrinessMultiplier;
    }

    /**
     * returns SleepinessMultiplier of type double
     * @return return sleepinessMultiplier;
     */
    public double getSleepinessMultiplier() {
        return sleepinessMultiplier;
    }
}