package com.shpp.p2p.cs.kyelyseyeva.assignment3;
/*
* TO DO
*
* Exaltation to degree
* */
import com.shpp.cs.a.console.TextProgram;

public class Assignment3Part3 extends TextProgram {
    public void run() {
        raiseToPower(3, 3);
    }

    /*
     * Elevates to a degree.
     *
     * @param base The number that is sublime.
     * @param exponent The degree of base.
     *
     * return the base in the exponent
     */
    private double raiseToPower(double base, int exponent) {

        //first step for exponent from spaces (-1;0) and (0;1)
        if (exponent != 0 && exponent > -1.0 && exponent < 1.0) base = 1 / base;

        double result = base;
        //for the positive exponent
        if (exponent > 0) {
            for (int i = 0; i < exponent - 1; i++) {
                result *= base;
            }
        }
        //for the negative exponent
        else if (exponent < 0) {
            for (int i = 0; i < (-exponent) - 1; i++) {
                result *= base;
            }
            result = 1 / result;
        }
        //when exponent==0
        else {
            result = 1.0;
        }

        println(result);
        return result;
    }
}
