package com.shpp.p2p.cs.kyelyseyeva.assignment3;
/*
* TO DO
*
* St. Petersburg game
This is a hypothetical casino game with a simple ideology.

Two people play: lucky and sweaty.

The game ends when the first player earns $ 20 or more.

Sweaty puts $ 1 on the table and the lucky guy starts tossing a coin.

If an eagle is sweaty, it adds up to the amount on the table exactly the same amount.

If the lug - everything on the table, goes to the lucky guy.

If the lucky winner is less than $ 20, then the game is repeated.
* */
import com.shpp.cs.a.console.TextProgram;

public class Assignment3Part5 extends TextProgram {
    public void run() {
        //winnings counter
        int prize = 0;
        //step counter
        int step = 0;

        //St. Petersburg game
        while (prize < 20) {
            //sweaty puts 1$
            int bet = 1;

            //the coin is tossed
            //
            //false - eagle - sweaty contributes to the amount on the table the exact same amount.
            //true - lash - everything on the table goes to the lucky guy.
            while (RandomNumber() == false) {
                bet *= 2;
            }
            prize += bet;


            println("This game, you earned $" + bet + "\n" + "Your total is $" + prize);
            step++;
        }
        println("It took " + step + " games to earn $20");
    }

    /*
     * Search for a random boolean value.
     *
     * return true or false.
     */
    private boolean RandomNumber() {
        return Math.random() < 0.5;
    }

}
