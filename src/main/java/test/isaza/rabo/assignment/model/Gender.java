package test.isaza.rabo.assignment.model;

/**
 * Possible genders.
 */
public enum Gender {
    MALE("male"),
    FEMALE("female");

    private String value;

    Gender(String value) {
        this.value = value;
    }

    /**
     * Creates an instance of gender from a String.
     * @param gender as a String
     * @return the corresponding gender
     * @throws IllegalArgumentException if the gender label is invalid
     */
    public static Gender parse(String gender) {
        return valueOf(gender.toUpperCase());
    }

    @Override
    public String toString() {
        return value;
    }
}
