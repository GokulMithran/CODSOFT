import java.util.*;

public class Main {
    public static void main(String[] args) {
        int guess,count=1,score=10;
        Scanner sc =new Scanner(System.in);
        Random ran =new Random();
        System.out.println("Enter -1 to Exit");
      int r=ran.nextInt(1,100);// Generating Random Number between 1 to 10
       do {
            System.out.println("Enter a number:");
              guess=sc.nextInt(); //Getting input from User
            if (guess == r) {
                System.out.println("Guess is Correct");
                System.out.println("Score:"+score);
                break;
            } else if (guess > r) {
                System.out.println("Guess is Too High");
                score--;
            } else {
                System.out.println("Guess is Too Low");
                score--;
            }
            count++;
       } while(guess!=r && guess!=-1);
    System.out.println("Number of Attempts taken:"+count);

    }
}