class VolumeOfEarth{
    public static void main(String[] args) {
        double radius = 6378.0; // in Km
        double volume = (4.0/3.0) * Math.PI * Math.pow(radius,3);
        double volumeInCubicMiles = volume * 0.239;
        System.out.println("The volume of Earth in cubic kilometers is " + volume + " and cubic miles is " + volumeInCubicMiles);
    }
}