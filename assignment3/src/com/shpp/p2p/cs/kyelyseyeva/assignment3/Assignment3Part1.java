package com.shpp.p2p.cs.kyelyseyeva.assignment3;
/*
* TO DO
*
* the program asks the user for the number of minutes spent in the last seven days for the exercises,
* and accordingly reports the following:


* whether there was enough time to exercise for cardiovascular health, and if not, how many days of a proper life
* (with more than 30 minutes of exercise) would not be enough for the recommended schedule.

* whether there were enough exercises to reduce blood pressure and cholesterol and, if not, output:
* how many days the user did not reach for 40 minutes a day.
* */

import com.shpp.cs.a.console.TextProgram;

public class Assignment3Part1 extends TextProgram {
    /* Constants controlling the min time (in minutes) per one day for PI. */
    public static final int MINUTES_FOR_CARDIO = 30;
    public static final int MINUTES_FOR_PRESSURE = 40;

    /* Constants controlling the days per one week for PI. */
    public static final int DAYS_FOR_CARDIO = 5;
    public static final int DAYS_FOR_PRESSURE = 3;

    public void run() {
        //counters for active days
        int daysUsersCardio = 0;
        int daysUsersPressure = 0;

        for (int i = 1; i < 8; i++) {
            int activeTime = 0;
            //reads the values from the user about activity
            //if the user enters a negative  or too large value, the question will be repeated
            do {
                activeTime = readInt("How many minutes did you do on day " + i + "? ");
            } while (activeTime < 0 || activeTime > 1440);

            //if the activity is positive then increase the counter
            if (activeTime >= MINUTES_FOR_CARDIO) daysUsersCardio++;
            if (activeTime >= MINUTES_FOR_PRESSURE) daysUsersPressure++;
        }


        //output of recommendations
        if (daysUsersCardio >= DAYS_FOR_CARDIO) {
            println("Cardiovacular health:\n" +
                    "    Great job! You've done enough exercise for cardiovacular health.");
        } else {
            println("Cardiovacular health:\n" +
                    "You needed to train hard for at least " + (DAYS_FOR_CARDIO - daysUsersCardio) + " more day(s) a week!");
        }

        if (daysUsersPressure >= DAYS_FOR_PRESSURE) {
            println("Blood pressure:\n" +
                    "    Great job! You've done enough exercise to keep a low blood pressure.");
        } else {
            println("Blood pressure:\n" +
                    "You needed to train hard for at least " + (DAYS_FOR_PRESSURE - daysUsersPressure) + " more day(s) a week!");
        }
    }


}

