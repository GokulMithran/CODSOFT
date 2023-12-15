import java.util.Scanner;

//BankAccount class represents the userAccount
class BankAccount {
    private double bal;

    public BankAccount(double intialbal)
    {
        this.bal=intialbal;
    }
    public double getBal() {
        return bal;
    }

    public void deposit(double amount)
    {
        bal+=amount;
    }
    public boolean withdraw(double WithdrawAmount){
        if(WithdrawAmount>bal)
        {
            System.out.println("Insufficient Balance");
            return false;
        }
        bal-=WithdrawAmount;
        return true;

    }

}
//ATM class represents the ATM

class ATM{
    private final BankAccount userAccount;

    public ATM(BankAccount userAccount)
    {
        this.userAccount=userAccount;
    }
    public void displayMenu()
    {
        System.out.println("1.Withdraw");
        System.out.println("2.Deposit");
        System.out.println("3.Check Balance");
        System.out.println("4.Exit");
    }

    public void processTransaction()
    {
        Scanner sc=new Scanner(System.in);
        int choice;
        do{
            displayMenu();
            System.out.println("Enter your choice");
            choice =sc.nextInt();
            switch (choice) {
                case 1: {
                    System.out.print("Enter your Withdraw Amount:₹");
                    double WithdrawAmount = sc.nextDouble();
                    if (WithdrawAmount > 0) {
                        if (userAccount.withdraw(WithdrawAmount)) {
                            System.out.println("Withdraw Successful.Remaining Balance:" + userAccount.getBal());
                        }

                    }
                    else
                    {
                        System.out.println("Invalid Withdraw amount");
                    }
                    break;
                }

                case 2: {
                    System.out.print("Enter your Deposit Amount:₹");
                    double depositAmount = sc.nextDouble();
                        if (depositAmount > 0)
                        {
                            userAccount.deposit(depositAmount);
                            System.out.println("Deposit Successful.New Balance:" + userAccount.getBal());
                        }
                        else
                        {
                            System.out.println("Invalid Deposit amount");
                        }

                    break;

                }

                case 3:
                {
                    System.out.println("Current Balance:₹"+userAccount.getBal());
                    break;
                }

                case 4:
                {
                    System.out.println("Exiciting.Thank You!!!");
                    break;
                }

                default:
                {
                    System.out.println("Invalid Choice!!!");
                }



            }
        }while(choice!=4);
    }

}
public class Main {
    public static void main(String[] args) {
// Creating a user bank Account with initial amount 1000
        BankAccount userAccount =new BankAccount(1000);

//Creating ATM instance connected to user bank Account
        ATM atm=new ATM(userAccount);

//Processing Transaction through the ATM
        atm.processTransaction();
    }
}