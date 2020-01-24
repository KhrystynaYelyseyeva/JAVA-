package com.shpp.p2p.cs.kyelyseyeva.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part4 extends KarelTheRobot {

    public void run() throws Exception {
        creatChessboard();
    }

    //------METHODS--------
    /*method for creating a chessboard*/
    private void creatChessboard() throws Exception {
        while (frontIsClear()) {
        fillTheRow();
        goToNewRow();
    }}

    /*method for turning around*/
    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    /*method for turning right*/
    private void turnRight() throws Exception {
        turnAround();
        turnLeft();
    }

    /*method for transition to a new row*/
    private void goToNewRow() throws Exception {
        if (facingEast()) {
            turnLeft();
            moveIfFrontIsClear();
            turnLeft();
        } else {
                turnRight();
                moveIfFrontIsClear();
            if (frontIsClear()) {     //checking for last line
                turnRight();
            }
        }
    }

    /*method moving one step with checking ability*/
    private void moveIfFrontIsClear() throws Exception {
        if (frontIsClear()) move();
    }

    /*method checking beeper present in the previous box*/
    private void checkingBeeperPresent() throws Exception {
        if (beepersPresent()) {
            moveIfFrontIsClear();
        } else {
            moveIfFrontIsClear();
            putBeeper();
        }
    }

    /*method for filling the row*/
    //puts one beeper through one box to the end
    //101010
    private void fillTheRow() throws Exception {
        //puts one beeper through one box to the end except the last box
        while (frontIsClear()) {
            putBeeper();
            moveIfFrontIsClear();
            moveIfFrontIsClear();
        }

        //puts beeper in the last box, if this need
        //checking the previous box for beeper
        turnAround();
        moveIfFrontIsClear();
        turnAround();
        checkingBeeperPresent();
    }
}
