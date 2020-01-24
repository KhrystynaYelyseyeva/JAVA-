package com.shpp.p2p.cs.kyelyseyeva.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part2 extends KarelTheRobot {

    public void run() throws Exception {
        createRowsOfPebbles();
    }


    //------METHODS--------

    /*method for creating rows of pebbles*/
 private void createRowsOfPebbles() throws Exception {
     /*puts beepers everywhere except the last row*/
     while (frontIsClear()) {
         fillOneRow();
         returnToStart();
         movToNewRow();
     }

     /*puts the beepers in the last row*/
     fillOneRow();
 }

    /*method for moving to a new row*/
    private void movToNewRow() throws Exception {
        turnLeft();
        move();
        move();
        move();
        move();
    }

    /*method for turning back*/
    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    /*method for putting the beepers in the row*/
    private void fillOneRow() throws Exception {
        turnLeft();

        /*puts the beepers in the boxes  to the end of the row except the last one and checks the fill*/
        while (frontIsClear())
            if (noBeepersPresent()) {
                putBeeper();
                move();
            } else {
                move();
            }

        /*puts the beeper in the last box  in the row and checks the fill*/
        if (noBeepersPresent()) {
            putBeeper();
        }
    }

    /*method for returning to the beginning of the row*/
    private void returnToStart() throws Exception {
        turnAround();
        while (frontIsClear()) {
            move();
        }
    }
}
