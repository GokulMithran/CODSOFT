import java.util.*;

class QuizQuestion{//Represents the encapsulation of Quiz Essential Components
    String question;
    List<String> options;
    int correctoption;
    public QuizQuestion(String question,List<String> options,int correctoption)
    {
        this.question=question;
        this.options=options;
        this.correctoption=correctoption;
    }
}
class Quizgame{ //Represents the Functions with timer for QuizQuestions

    List<QuizQuestion> quizQuestions;
    int quesnum=0;
    int userScore;

    Timer timer =new Timer();

    public Quizgame()
    {
        quizQuestions=new ArrayList<>();
        userScore=0;
    }

    public void addquestion(String question,List<String> options,int correctoption)
    {
     quizQuestions.add(new QuizQuestion(question,options,correctoption));
    }
    public void display()
    {

        if(quesnum<quizQuestions.size()) {
            QuizQuestion current = quizQuestions.get(quesnum);
            System.out.println(current.question);
            for (int i = 0; i < 4; i++) {
                System.out.println(i + 1 + ")" + current.options.get(i));
            }
            startTimer();
            userAnswer();
        }
        else
        {
                  endquiz();
        }

    }
    public void startTimer()
    {

        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up! Moving to the next question.");
                checkAnswer(-1);

            }
        };
        timer.schedule(task,15000);
    }

    public void userAnswer()
    {
        Scanner sc=new Scanner(System.in);
        int ans=sc.nextInt();
        checkAnswer(ans);

    }

    public void checkAnswer(int ans)
    {
        Timer stopTimer=new Timer();
        QuizQuestion current=quizQuestions.get(quesnum);
        if(ans==current.correctoption)
        {
            System.out.println("Correct!");
            userScore++;

        }
        else
        {
            System.out.println("Wrong.The Correct Answer is:"+current.correctoption);
        }
        quesnum++;
        stopTimer.cancel();
        display();
    }

    public void endquiz()
    {
        System.out.println("---------Quiz Completed!-------");
        System.out.println("Total Socre is: "+userScore+" out of "+quizQuestions.size());
        timer.cancel();

    }
}

public class Main {
    public static void main(String[] args) {
  Quizgame quiz=new Quizgame();

         //The user add the quizQuestions
        quiz.addquestion("What is the size of Integer?",
                List.of("2", "4", "1", "8"), 2);
        quiz.addquestion("What is the capital of India?",
                List.of("Kolkata", "Mumbai", "Chennai", "Delhi"), 4);
        quiz.display();
    }
}