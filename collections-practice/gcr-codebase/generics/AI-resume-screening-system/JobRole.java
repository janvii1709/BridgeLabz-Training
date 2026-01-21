abstract class JobRole {
    private String name;
    private int experience; // years of experience

    public JobRole(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    // Abstract method to define skills required for each role
    public abstract void requiredSkills();
}
