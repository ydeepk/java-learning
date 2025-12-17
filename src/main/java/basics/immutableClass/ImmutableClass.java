package basics.immutableClass;

/**
 * An immutable class representing an animal with a maximum age and its animal class.
 *
 * The class is immutable because:
 * - The class is declared final to prevent subclassing.
 * - All fields are private and final, ensuring they can only be initialized once.
 * - There are no setter methods, and fields cannot be modified after object construction.
 */
public final class ImmutableClass {

    // Maximum age of the animal.
    private final int maxAge;

    // The classification of the animal (e.g., Mammal, Reptile).
    private final String animalClass;

    /**
     * Constructs an ImmutableClass object with the specified maxAge and animalClass.
     *
     * @param maxAge The maximum age of the animal. Must be a positive integer.
     * @param animalClass The class of the animal (e.g., Mammal, Reptile).
     */
    public ImmutableClass(int maxAge, String animalClass) {
        // Validate inputs to ensure integrity (optional based on use case)
        if (maxAge < 0) {
            throw new IllegalArgumentException("maxAge cannot be negative");
        }

        // Initialize the fields
        this.animalClass = animalClass;
        this.maxAge = maxAge;
    }

    /**
     * Gets the maximum age of the animal.
     *
     * @return The maximum age.
     */
    public int getMaxAge() {
        return maxAge;
    }

    /**
     * Gets the class of the animal.
     *
     * @return The animal class (e.g., Mammal, Reptile).
     */
    public String getAnimalClass() {
        return animalClass;
    }

}
