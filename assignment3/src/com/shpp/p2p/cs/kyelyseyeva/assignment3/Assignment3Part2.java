package com.shpp.p2p.cs.kyelyseyeva.assignment3;
/*
* TO DO
*
* Take some positive integer and call it n
If n is even, then divide it by 2
If n is odd, then multiply by 3 and add 1
Continue this process until n is 1
* */
import com.shpp.cs.a.console.TextProgram;

public class Assignment3Part2 extends TextProgram {
    public void run() {
        gardenNumbers(readValue());
    }

    /*
     *Read the value from the user.
     *
     * return n The user's number.
     */
    private int readValue() {
        int n = 0;

        //if the user enters a negative  value or null, the question will be repeated
        do {
            n = readInt("Enter a number: ");
        } while (n <= 0);
        return n;
    }


    /*
     *Method for garden-numbers.
     *
     * @param n The initial number.
     */

    private void gardenNumbers(int n) {
        do {
            if (n % 2 == 0) {
                println(n + " is even so I take half: " + n / 2);
                n = n / 2;
            } else {
                println(n + " is odd so I make 3n + 1: " + (n * 3 + 1));
                n = n * 3 + 1;
            }
        } while (n != 1);

        println("The End.");
    }
}
