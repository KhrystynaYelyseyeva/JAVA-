package com.shpp.p2p.cs.kyelyseyeva.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part3 extends KarelTheRobot {

    public void run() throws Exception {
        fillRow();
        pickUpBeepersAtEdgesOfRow();
        findMiddle();
        putMiddle();
    }


    //------METHODS--------

    /*method for turning around*/
    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    /*method for putting the beepers in the row*/
    private void fillRow() throws Exception {
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

    /*method.
    1)return to the middle of the row
    2)selects the extremes beeper in a row
    3)moves to beepers line*/
    private void pickUpBeepersAtEdgesOfRow() throws Exception {
        turnAround();
        pickBeeper();
        move();

        while (frontIsClear()) {
            move();
        }

        turnAround();
        pickBeeper();
        move();
    }

    /*method picking up the extreme beepers*/
    private void findMiddle() throws Exception {
        while (beepersPresent()) {
            move();
            if (noBeepersPresent()) {
                turnAround();
                move();
                pickBeeper();
                move();
            }
        }
    }

    /*method for putting the beeper in the middle of the row*/
    private void putMiddle() throws Exception {
        turnAround();
        move();
        putBeeper();
    }
}

