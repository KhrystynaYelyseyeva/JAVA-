package com.shpp.p2p.cs.kyelyseyeva.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part1 extends KarelTheRobot {

    public void run() throws Exception {
        moveToTheNewspaper();
        pickingUpTheNewspaper();
        returnToTheStart();
    }

    //------METHODS--------
    /*method just for turning right*/
    private void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    /*method for turning back*/
    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    /*method for going 4 steps*/
    private void goesStraight() throws Exception {
        for (int i = 0; i < 4; i++) {
            move();
        }
    }

    /*method moving to the newspaper*/
    private void moveToTheNewspaper() throws Exception {
        /* goes on straight, which leads to the door and the newspaper */
        turnRight();
        move();
        turnLeft();

        /*goes straight */
        goesStraight();
    }

    /*method picking up a newspaper and turns 180*/
    private void pickingUpTheNewspaper() throws Exception {
        pickBeeper();
        turnAround();
    }

    /*method returning to the start point*/
    private void returnToTheStart() throws Exception {
        /*goes straight back*/
        goesStraight();

        /* gets into the start*/
        turnRight();
        move();
    }
}

