import java.util.Scanner;

/*Write a program to solve the quadratic equation. The program will request user to 
enter one line of input, ax2 + bx + c, where a, b and c is in between 1-9. The formula 
to solve the quadratic equation is as below:
*/
public class Hiii {
    public static void main(String[] args) {
    Scanner A=new Scanner(System.in);
    System.out.print("enter coeficient for x^2: ");
    int a=A.nextInt();
    System.out.print("enter coeficient for x: ");
    int b=A.nextInt();System.out.print("enter coeficient: ");
    int c=A.nextInt();

    double root=(b*b)-(4*a*c);

    double Root=Math.sqrt(root);

    double x1=(-b+Root)/(2*a);
    double x2=(-b-Root)/(2*a);

    if(root<0)
    System.out.print("This quadratic equation has 0 root(s).\n No solution");
    if(root==0)
        System.out.print("This quadratic equation has 1 root(s).\n x="+x1);
    if(root>0)
    System.out.print("This quadratic equation has 2 root(s).\nx= "+x1+"\nx= "+x2);

    
    }

}
