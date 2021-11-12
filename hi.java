/**
 *Write a program to check whether a triangle is valid or invalid. If the triangle is valid,
check whether a triangle is Equilateral, Isosceles or Scalene.
 */
import java.util.Scanner;
public class hi {
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        int a,b,c;
        System.out.print("enter length of first side");
        a=scanner.nextInt();
        System.out.print("enter length of second side");
        b=scanner.nextInt();
        System.out.print("enter length of third side");
        c=scanner.nextInt();

       int max=0;
       int min1=1;
       int min2=1;
        if(a> b&& a>c){
            max=a;
            min1=b;
            min2=c;
        }
        else if (b>a && b>c)
            max=b;
        else if (c>a && c>b)
            max=c;   
            
        if(min1+min2>max){
            if(a==b&&b==c)
            System.out.print(" Equilateral triangle");
        else if(a==b||b==c||c==a)
            System.out.print(" Isosceles triangle");
        else 
            System.out.print("Scalene triangle");
        
        }
        else
            System.out.print("Invalid triangle");   }
}       
