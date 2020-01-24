package com.shpp.p2p.cs.kyelyseyeva.assignment2;

import acm.graphics.*;

import java.awt.*;

import com.shpp.cs.a.graphics.WindowProgram;

public class Assignment2Part4 extends WindowProgram {

    /* The width and height of the rectangle. */
    private static final double REC_WIDTH = 100;
    private static final double REC_HEIGHT = 200;

    public void run() {
        drawFlag();
        writeCountry();
    }


    //method for drawing flag.
    private void drawFlag() {

        addRec(getWidth() / 2 - REC_WIDTH * 1.5, getHeight() / 2 - REC_HEIGHT / 2, REC_WIDTH, REC_HEIGHT, Color.blue);
        addRec(getWidth() / 2 - REC_WIDTH * 0.5, getHeight() / 2 - REC_HEIGHT / 2, REC_WIDTH, REC_HEIGHT, Color.yellow);
        addRec(getWidth() / 2 + REC_WIDTH * 0.5, getHeight() / 2 - REC_HEIGHT / 2, REC_WIDTH, REC_HEIGHT, Color.red);
    }

    //method for writing country.
    private void writeCountry() {
    GLabel p = new GLabel("Flag of Romania", getWidth() / 2, getHeight() / 2.5 + REC_HEIGHT);
        p.setFont("Adobe Haiti Std-25");
    add(p);
}

    /*
     * Draws the rectangle.
     *
     * @param x The x coordinate of the upper-left corner of the rectangle.
     * @param y The y coordinate of the upper-left corner of the rectangle.
     */
    private void addRec(double x, double y, double width, double height, Color color) {
        GRect rect = new GRect(x, y, width, height);
        rect.setFilled(true);
        rect.setColor(color);
        add(rect);
    }
}
