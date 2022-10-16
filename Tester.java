package gameoflife;

import java.util.Scanner;
public class Tester {
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        String s;
        GameOfLifeEngine game = new GameOfLifeEngine();
        
        game.initialize2();
        
        do
        {
            System.out.print(game);
            game.next();
            s = sc.nextLine();
        }
        while (s.equals(""));
    }
}