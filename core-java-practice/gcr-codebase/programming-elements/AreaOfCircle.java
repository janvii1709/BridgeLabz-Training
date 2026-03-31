import java.util.Scanner;
class AreaOfCircle {
  public static void main(String [] args){
    //write a prgrm to calculate the area of a circle
    Scanner sc=new Scanner(System.in);
    //take radius value as input
    int radius=sc.nextInt();
    //take pi as input
    double PI=3.14;
    //calculate the area
    double area=PI*radius*radius;
    System.out.println("area of the circle is :" +area);

  }
}