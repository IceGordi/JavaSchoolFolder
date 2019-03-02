import java.util.Scanner;
public class Act2{
  public static void main(String[] args){
    System.out.println("Enter the length of a box in feet:");
    Scanner scn = new Scanner(System.in);
    String uWrite = scn.nextLine();
    int feet = Integer.parseInt(uWrite);
    int inches = feet *12;
    System.out.println("It's "+ inches +" inches");
  }
}
