class StudentReport {
    String Name, RollNumber;
    double M1, M2, M3;
    char Grade() {
        double Avg = (M1+M2+M3)/3;

        if(Avg>=80) return 'A';
        else if(Avg>=70) return 'B';
        else if(Avg>=60) return 'C';
        else return 'D';
    }

    void Display() {
        System.out.println("Student Name: " + Name);
        System.out.println("Student RollNumber: " + RollNumber);
        System.out.println("Student Marks:");
        System.out.println("Mark1: " + M1);
        System.out.println("Mark2: " + M2);
        System.out.println("Mark3: " + M3);
        System.out.println("Grade " + Grade());

    }

    public static void main(String[] args) {
        StudentReport S1 = new StudentReport();
        S1.Name="Thamarai"; S1.RollNumber="ECE001"; S1.M1=80; S1.M2=70; S1.M3=75;

        StudentReport S2 = new StudentReport();
        S2.Name="Kannan"; S2.RollNumber="CSC002"; S2.M1=60; S2.M2=65; S2.M3=50;

        S1.Display(); S2.Display();
    }
}