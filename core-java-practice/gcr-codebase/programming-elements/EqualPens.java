class EqualPens {
    public static void main(String[] args) {
        int Pens = 14;// total number of pens
        int Students = 3;// total number of students
        int pensPerStudent = Pens / Students;// calculation of pens per students
        int remainingPens = Pens % Students;// calculation of remaining pens
        System.out.println("The pens per student is "+ pensPerStudent + " and the remaining pens not distributed is " + remainingPens);
        }
}
