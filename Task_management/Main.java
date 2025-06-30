package Task_management;

import java.util.Scanner;

public class Main {
    public static void main(final String[] args) {
        System.out.println("**********WELCOME*********");
        final Scanner  sc=new Scanner(System.in);
        final Taskmanager task=new Taskmanager();
        boolean isrun=true;
        while(isrun){
            System.out.println("1.ADD TASK\n2.DISPLAY TASK\n3.View By Priority\n");
            System.out.println("Enter your Choice:");
            final int ch=sc.nextInt();
            sc.nextLine();
            
            switch (ch) {
                case 1:
                System.out.println("Adding the Task");
                task.addTask();
                break;
            
                case 2:
                System.out.println("Task viewing...");
                task.display();
                break;
                case 3:
                System.out.println("Viewing by Task Priority...");
                task.viewbypriority();
                break;

                case 0:
                isrun=false;
                break;

                default:
                    System.out.println("---------Invalid Options-------");
                    break;
            }
        }
        sc.close();   
    }
}
