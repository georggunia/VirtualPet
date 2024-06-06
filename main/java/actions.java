/**
 * Enum of different actions and their corresponding attributeChanges
 * Everything is int
 */
public enum actions {
    play(2,2,2), eat(1,-2,1), sleep(-2,2,-2);
    private final int happinessChange, hungrinessChange, sleepinessChange;

    actions(int happinessChange, int hungrinessChange, int sleepinessChange) { //Konstrukcor
        this.happinessChange = happinessChange;
        this.hungrinessChange = hungrinessChange;
        this.sleepinessChange = sleepinessChange;
    }

    /**
     * @return return happinessChange;
     */
    public int getHappinessChange() {
        return happinessChange;
    }

    /**
     * @return  return hungrinessChange;
     */
    public int getHungrinessChange() {
        return hungrinessChange;
    }

    /**
     * @return return sleepinessChange;
     */
    public int getSleepinessChange() {
        return sleepinessChange;
    }
}
