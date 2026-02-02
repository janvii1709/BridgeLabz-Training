class Dog extends Animal {
    private String dogSound;
    public Dog(String dogSound) {
        this.dogSound = dogSound;
    }
    @Override
    public void makeSound() {
        System.out.println("Dog says: " + dogSound);
    }
}
