class VolumeOfEarth{
    public static void main(String[] args) {
        double Radius = 6378.0; // Radius of earth in kilometers
        double volume = (4.0/3.0) * Math.PI * Math.pow(Radius,3);// volume calculation
        double volumeInCubicMiles = volume * 0.239;// conversion of volume to cubic miles ( 1 cubic km = 0.239 cubic miles)
        System.out.println("The volume of Earth in cubic kilometers is " + volume + " and cubic miles is " + volumeInCubicMiles);
    }
}