package Maze_Game;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Dimention: ");
        int n=sc.nextInt();
        char[][] matrix =new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]='0';
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Enter the Adventurer location:");
        int arow=sc.nextInt();
        int acol=sc.nextInt();
        matrix[arow][acol]='A';
        System.out.println("Enter the Destination location:");
        int drow=sc.nextInt();
        int dcol=sc.nextInt();
        matrix[drow][dcol]='D';

        int res=findshortpath(arow,acol,drow,dcol);
        System.out.println("The Shortest path is :"+res);



    }

    private static int findshortpath(int stx, int sty, int lsx, int lsy) {
        return Math.max(Math.abs(lsx-stx),Math.abs(lsy-sty));
    }
}
