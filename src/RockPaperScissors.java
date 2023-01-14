import java.util.Scanner;
import java.util.Random;


public class RockPaperScissors {
                                //0       1          2
    static String[] choices = {"paper","scissors","rock"};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        sc.close();
        //Guard clause to prevent invalid input
        if (!checkchoicevalidity(choice)){
            System.out.println(choice +" invalid");
            return;
        } 
        int cpu = CPUchoice();
        System.out.println("cpu picks " + choices[cpu]);
        System.out.println("user picked " + choice);
        System.out.println("you " + determineWinner(choiceToInt(choice), cpu));
    }
    
    //Determines validity of input
    public static Boolean checkchoicevalidity(String input){
        //Loops over array; makes sure choice matches array choices
        for(String choice : choices){    
            if(choice.equals(input)){
                return true;
            } 
        }
        return false;
    }

    //Determines cpus choice
    public static int CPUchoice(){
        Random gen = new Random();
        int choice = gen.nextInt(3);
        return choice;
    }
    
    //Determines winner by assigning values to each outcome
    public static String determineWinner(int user, int cpu){
        int result = user - cpu;
        if(result == -1 || result == 2){
            return "lose";
        } else if(result == 0) {
            return "tie";
        } else if(result == 1 || result == -2){
            return "win";

        }
            return "";
        }
    
    //Converts users choice to int for determining outcome
    public static int choiceToInt(String choice){
        switch(choice){
            case "rock":
            return 2;
            
            case "scissors":
            return 1;

            case "paper":
            return 0;

            default: 
            return -1;
        }
        
        }
    }
    