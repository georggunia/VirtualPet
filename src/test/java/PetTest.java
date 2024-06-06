import static org.junit.Assert.*;
import org.junit.*;



public class PetTest {

  private Pet pet;

  @Before
  public void init(){
    pet = new Pet("dog", PetType.DOG);
  }

  @Test
  public void testInitConstructor(){
    assertEquals("constructor must set name", "dog", pet.getName());
    assertEquals("constructor must set type", PetType.DOG, pet.getType());
    assertEquals("constructor must set initial happiness value to 5", 5, pet.getHappiness());
    assertEquals("constructor must set initial hungriness value to 3", 3, pet.getHungriness());
    assertEquals("constructor must set initial sleepiness value to 1", 1, pet.getSleepiness());

    assertThrows("must throw IllegalArgumentException on null name",
        IllegalArgumentException.class, () -> new Pet(null, PetType.DOG));
    assertThrows("must throw IllegalArgumentException on empty name",
        IllegalArgumentException.class,  () -> new Pet("", PetType.DOG));
    assertThrows("must throw IllegalArgumentException on null type",
        IllegalArgumentException.class, () -> new Pet("dog", null));
  }

  @Test
  public void testCopyConstructor(){
    pet.eat();
    pet.sleep();

    Pet clone = new Pet(pet);

    assertEquals("names of clones must be equal", pet.getName(), clone.getName());
    assertEquals("types of clones must be equal", pet.getType(), clone.getType());
    assertEquals("happiness value of clones must be equal", pet.getHappiness(), clone.getHappiness());
    assertEquals("sleepiness value of clones must be equal", pet.getSleepiness(), clone.getSleepiness());
    assertEquals("hungriness value of clones must be equal", pet.getHungriness(), clone.getHungriness());

    assertThrows("copy constructor must throw IllegalArgumentException on null parameter",
        IllegalArgumentException.class, () -> new Pet(null));

  }

  @Test
  public void testIsSadHappy(){
    assertFalse("new pet is not sad", pet.isSad());
    assertFalse("new pet is not happy", pet.isHappy());

    pet.changeHappiness(-10);

    assertTrue("pet with happinesss value of " + pet.getHappiness() + " is sad", pet.isSad());
    assertFalse("pet with happinesss value of " + pet.getHappiness() + " is not happy", pet.isHappy());

    pet.changeHappiness(+10);

    assertFalse("pet with happinesss value of " + pet.getHappiness() + " is not sad", pet.isSad());
    assertTrue("pet with happinesss value of " + pet.getHappiness() + " is happy", pet.isHappy());

  }

  @Test
  public void testGetSadness(){

    assertEquals("sadness of dog with happiness of 5 must be 5",
        5, pet.getSadness());

    pet.changeHappiness(+3);
    assertEquals("sadness of dog with happiness of 8 must be 2",
        2, pet.getSadness());

  }

  @Test
  public void testChangeHappiness(){
    pet.changeHappiness(-2);

    assertEquals("new value must be 5-2=3", 3, pet.getHappiness());

    pet.changeHappiness(-5);
    assertEquals("new value must be 0", 0, pet.getHappiness());

    pet.changeHappiness(+5);
    assertEquals("new value must be 5", 5, pet.getHappiness());

    pet.changeHappiness(+3);
    assertEquals("new value must be 8", 8, pet.getHappiness());

    pet.changeHappiness(+5);
    assertEquals("new value must be 10", 10, pet.getHappiness());

    pet.changeHappiness(-4);
    assertEquals("new value must be 6", 6, pet.getHappiness());

  }

  @Test
  public void testChangeSleepiness(){
    pet.changeSleepiness(-1);

    assertEquals("new value must be 1-1=0", 0, pet.getSleepiness());

    pet.changeSleepiness(-5);
    assertEquals("new value must be 0", 0, pet.getSleepiness());

    pet.changeSleepiness(+5);
    assertEquals("new value must be 5", 5, pet.getSleepiness());

    pet.changeSleepiness(+3);
    assertEquals("new value must be 8", 8, pet.getSleepiness());

    pet.changeSleepiness(+5);
    assertEquals("new value must be 10", 10, pet.getSleepiness());

    pet.changeSleepiness(-4);
    assertEquals("new value must be 6", 6, pet.getSleepiness());

  }

  @Test
  public void testChangeHungriness(){
    pet.changeHungriness(-2);

    assertEquals("new value must be 3-2=3", 1, pet.getHungriness());

    pet.changeHungriness(-5);
    assertEquals("new value must be 0", 0, pet.getHungriness());

    pet.changeHungriness(+5);
    assertEquals("new value must be 5", 5, pet.getHungriness());

    pet.changeHungriness(+3);
    assertEquals("new value must be 8", 8, pet.getHungriness());

    pet.changeHungriness(+5);
    assertEquals("new value must be 10", 10, pet.getHungriness());

    pet.changeHungriness(-4);
    assertEquals("new value must be 6", 6, pet.getHungriness());

  }

  @Test
  public void testPlay(){

    pet.play();

    assertEquals("happiness of dog after single round of play must be 9",
        9, pet.getHappiness());

    assertEquals("hungriness of dog after single round of play must be 7",
        7, pet.getHungriness());

    assertEquals("sleepiness of dog after single round of play must be 5",
        5, pet.getSleepiness());

    pet = new Pet("cat", PetType.CAT);
    pet.play();

    assertEquals("happiness of dog after single round of play must be 9",
        7, pet.getHappiness());

    assertEquals("hungriness of dog after single round of play must be 7",
        9, pet.getHungriness());

    assertEquals("sleepiness of dog after single round of play must be 5",
        5, pet.getSleepiness());



  }

  @Test
  public void testEat(){

    pet.eat();

    assertEquals("happiness of dog after single round of eat must be 9",
        7, pet.getHappiness());

    assertEquals("hungriness of dog after single round of eat must be 7",
        0, pet.getHungriness());

    assertEquals("sleepiness of dog after single round of eat must be 5",
        3, pet.getSleepiness());

    pet = new Pet("rabbit", PetType.RABBIT);
    pet.eat();

    assertEquals("happiness of dog after single round of eat must be 9",
        6, pet.getHappiness());

    assertEquals("hungriness of dog after single round of eat must be 7",
        2, pet.getHungriness());

    assertEquals("sleepiness of dog after single round of eat must be 5",
        2, pet.getSleepiness());

  }

  @Test
  public void testSleep(){

    pet.sleep();

    assertEquals("happiness of dog after single round of sleep must be 9",
        1, pet.getHappiness());

    assertEquals("hungriness of dog after single round of sleep must be 7",
        7, pet.getHungriness());

    assertEquals("sleepiness of dog after single round of sleep must be 5",
        0, pet.getSleepiness());

    pet = new Pet("bird", PetType.BIRD);
    pet.sleep();

    assertEquals("happiness of dog after single round of sleep must be 9",
        4, pet.getHappiness());

    assertEquals("hungriness of dog after single round of sleep must be 7",
        5, pet.getHungriness());

    assertEquals("sleepiness of dog after single round of sleep must be 5",
        0, pet.getSleepiness());

  }

  @Test
  public void testEquals(){

    assertTrue("equals must return true on identical objects",
        pet.equals(pet));

    assertFalse("equals must return false on null",
        pet.equals(null));

    assertFalse("equals must return false on different types",
        pet.equals("I'm a dog!"));

    assertFalse("equals must return false on different names",
        (new Pet("doggy", PetType.DOG).equals(pet)));

    assertFalse("equals must return false on different types",
        (new Pet("dog", PetType.CAT).equals(pet)));

    pet.changeHappiness(+2);

    assertFalse("equals must return false on different happiness values",
        (new Pet("dog", PetType.DOG).equals(pet)));

    pet.changeHappiness(-2);
    pet.changeSleepiness(+3);

    assertFalse("equals must return false on different sleepiness values",
        (new Pet("dog", PetType.DOG).equals(pet)));

    pet.changeSleepiness(-3);
    pet.changeHungriness(+1);

    assertFalse("equals must return false on different hungriness values",
        (new Pet("dog", PetType.DOG).equals(pet)));

    pet.changeHungriness(-1);

    assertTrue("equals must return true on equals pets",
        (new Pet("dog", PetType.DOG).equals(pet)));


  }



}
