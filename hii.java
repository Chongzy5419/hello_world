/*
Write a program to generate two cards randomly and display the bigger card between 
them. The cards contain of two characteristic, color (Red, Blue, Green and Yellow) 
and value (1-10). The rules to identify the bigger card as below:
*/

import java.util.Random;
public class hii {
        public static void main(String[] args) {
            Random random=new Random();
            int c1, c2;
            int C1, C2;
            String cc1,cc2;
            
            C1=random.nextInt(10)+1;
            C2=random.nextInt(10)+1;

            c1=random.nextInt(4);
            c2=random.nextInt(4);

            cc1=color(c1);
            cc2=color(c2);

            System.out.println("Card 1:"+C1+", "+cc1);
            System.out.println("Card 2:"+C2+", "+cc2);

            if(C1==C2){
                if(c1>c2)
                    System.out.print("Card 1 is bigger");
                else if(c2>c1)
                    System.out.print("Card 2 is bigger");
                else
                    System.out.print("2 Cards are indentical");

            } 
            else if (C1==1)
                System.out.print("Card 1 is bigger");
            else if (C2==1)
                System.out.print("Card 2 is bigger"); 
            else if(C1>C2)
                System.out.print("Card 1 is bigger");
            else if(C2>C1)
                System.out.print("Card 2 is bigger");         
        }
        public static String color(int x) {
            String y="null";
            if(x==0)
            y="Red";
            if(x==1)
            y="Blue";
            if(x==2)
            y="Green";
            if(x==3)
            y="Yellow";
            return y;
        }
    }
