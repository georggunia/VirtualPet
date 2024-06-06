import static org.junit.Assert.*;
import org.junit.*;

public class PetOwnerTest{

  private Pet pet1;
  private Pet pet2;
  private PetOwner owner;

  @Before
  public void init(){
    pet1 = new Pet("pet1", PetType.DOG);
    pet2 = new Pet("pet2", PetType.BIRD);
    owner = new PetOwner("owner", pet1, pet2);
  }

  @Test
  public void testInitConstructor(){


    assertEquals("name must be set", "owner", owner.getName());
    assertSame("first pet must be set", pet1, owner.getFirstPet());
    assertSame("second pet must be set", pet2, owner.getSecondPet());

    owner = new PetOwner("owner", pet1);
    assertEquals("name must be set", "owner", owner.getName());
    assertSame("first pet must be set", pet1, owner.getFirstPet());
    assertNull("second pet must null", owner.getSecondPet());

    owner = new PetOwner("owner", pet1, null);
    assertNull("second pet must null", owner.getSecondPet());

    assertThrows("must throw IllegalArgumentException on null name",
        IllegalArgumentException.class,
        () -> new PetOwner(null, pet1, pet2));
    assertThrows("must throw IllegalArgumentException on empty name",
        IllegalArgumentException.class,
        () -> new PetOwner("", pet1, pet2));
    assertThrows("must throw IllegalArgumentException on null name",
        IllegalArgumentException.class,
        () -> new PetOwner(null, pet1));
    assertThrows("must throw IllegalArgumentException on empty name",
        IllegalArgumentException.class,
        () -> new PetOwner("", pet1));

    assertThrows("must throw IllegalArgumentException on null first pet",
        IllegalArgumentException.class,
        () -> new PetOwner("owner", null, pet2));
    assertThrows("must throw IllegalArgumentException on null first pet",
        IllegalArgumentException.class,
        () -> new PetOwner("owner", null));

  }

 @Test
  public void testCopyConstructor(){
    PetOwner clone = new PetOwner(owner);

    assertEquals("names of clones must be equals", 
        owner.getName(), clone.getName());
    assertNotSame("first pets of clones must not be identical (copy constructor must be deep!)", 
        owner.getFirstPet(), clone.getFirstPet());
    assertEquals("first pet of clones must be equal", 
        owner.getFirstPet(), clone.getFirstPet());
    assertNotSame("second pets of clones must not be identical (copy constructor must be deep!)", 
        owner.getSecondPet(), clone.getSecondPet());
    assertEquals("second pet of clones must be equal", 
        owner.getSecondPet(), clone.getSecondPet());

    assertThrows("copy constructor must throw IllegalArgumentException on null parameter",
        IllegalArgumentException.class,
        () -> new PetOwner(null));

  }

  @Test
  public void testTakeCareOfPets(){

    Pet pet1Clone = new Pet(pet1);
    Pet pet2Clone = new Pet(pet2);

    owner.takeCareOfPets();
    pet1Clone.play();
    assertEquals("owner must play with dog",
        pet1Clone, pet1);
    pet2Clone.play();
    assertEquals("owner must play with bird",
        pet2Clone, pet2);

    owner.takeCareOfPets();
    pet1Clone.eat();
    assertEquals("owner must feed dog",
        pet1Clone, pet1);
    pet2Clone.eat();
    assertEquals("owner must feed bird",
        pet2Clone, pet2);

    owner.takeCareOfPets();
    pet1Clone.sleep();
    assertEquals("owner must take dog to sleep",
        pet1Clone, pet1);
    pet2Clone.sleep();
    assertEquals("owner must take bird to sleep",
        pet2Clone, pet2);

    owner.takeCareOfPets();
    pet1Clone.eat();
    assertEquals("owner must feed dog",
        pet1Clone, pet1);


  }

   @Test
  public void testEquals(){
    assertTrue("equals must return true on identical objects",
        owner.equals(owner));

    assertFalse("equals must return false on null",
        owner.equals(null));

    assertFalse("equals must return false on different types",
        owner.equals("I'm a dog owner!"));

    assertFalse("equals must return false on different names",
        (new PetOwner("owner2", pet1, pet2).equals(owner)));

    assertFalse("equals must return false on different first pets",
        (new PetOwner("owner2", (new Pet("Birdy", PetType.BIRD)), pet2).equals(owner)));

    assertFalse("equals must return false on different second pets",
        (new PetOwner("owner2", pet1, (new Pet("Birdy", PetType.BIRD))).equals(owner)));

    assertFalse("equals must return false on different second pets",
        (new PetOwner("owner2", pet1, null)).equals(owner));

    assertTrue("equals must return true on equal owners with same pets",
        (new PetOwner("owner", pet1, pet2).equals(owner)));

    assertTrue("equals must return true on equal owners with same second pet and equal first pet",
        (new PetOwner("owner", new Pet("pet1", PetType.DOG), pet2).equals(owner)));

    assertTrue("equals must return true on equal owners with same first pet and equal second pet",
        (new PetOwner("owner", pet1, new Pet("pet2", PetType.BIRD)).equals(owner)));


  }

}

