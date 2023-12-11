import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int[] marks=new int[5];
        int total=0;
        float avg;
        for(int i=0;i<5;i++)
        {
           System.out.print("Enter the Mark of Subject"+(i+1)+":");
           marks[i]=sc.nextInt();
           total=total+marks[i];
        }
        avg=total/5;
        System.out.println("Total Mark:"+total);
        System.out.println("Average Percentage:"+avg);
        System.out.print("Grade:");
        if(avg>=90)
            System.out.println("O");
        else if(avg>=80 && avg<90)
            System.out.println("A+");
        else if(avg>70 && avg<80)
            System.out.println("A");
        else if(avg>60 && avg<70)
            System.out.println("B+");
        else if(avg>50 && avg<60)
            System.out.println("B");
        else
            System.out.println("C");


    }
}