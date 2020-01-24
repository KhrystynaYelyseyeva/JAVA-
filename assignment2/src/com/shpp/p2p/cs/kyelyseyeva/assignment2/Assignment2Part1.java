package com.shpp.p2p.cs.kyelyseyeva.assignment2;

import com.shpp.cs.a.console.TextProgram;

public class Assignment2Part1 extends TextProgram {

    public void run() {

        //reads the values a,b,c from the user for the quadratic equation a*x*x + b*x + c = 0
        double a = readDouble("Please enter a: ");
        double b = readDouble("Please enter b: ");
        double c = readDouble("Please enter c: ");

        //calculates discriminant
        double d = b * b - 4 * a * c;

        //finds the roots of the equation
        if (d > 0) {
            double x1 = (-b + Math.sqrt(d)) / (2 * a);
            double x2 = (-b - Math.sqrt(d)) / (2 * a);
            println("There is two roots: " + x1 + " and " + x2);
        } else if (d == 0) {
            double x = -b / (2 * a);
            println("There is one root: " + x);
        } else {
            println("There are no real roots");
        }

    }

}

