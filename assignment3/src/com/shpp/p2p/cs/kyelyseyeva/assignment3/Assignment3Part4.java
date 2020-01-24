package com.shpp.p2p.cs.kyelyseyeva.assignment3;
/*
* TO DO
*
* pyramid of bricks
* */
import acm.graphics.*;

import java.awt.*;

import com.shpp.cs.a.graphics.WindowProgram;

public class Assignment3Part4 extends WindowProgram {

    /* The size of the brick. */
    private static final int BRICK_HEIGHT = 50;
    private static final int BRICK_WIDTH = 100;
    /* The number of bricks. */
    private static final int BRICKS_IN_BASE = 5;

    public void run() {
        for (int y = BRICKS_IN_BASE, yy = 0; y > 0; y--, yy++) {
            for (int x = 0; x < y; x++) {
                addRec(x * BRICK_WIDTH + yy * BRICK_WIDTH / 2 + getWidth() / 2 - BRICK_WIDTH * BRICKS_IN_BASE / 2,
                        getHeight() - (yy + 1) * BRICK_HEIGHT,
                        BRICK_WIDTH, BRICK_HEIGHT,
                        Color.yellow, Color.black);
            }
        }
    }

    /*
     * Draws the rectangle.
     *
     * @param x The x coordinate of the upper-left corner of the rectangle.
     * @param y The y coordinate of the upper-left corner of the rectangle.
     */
    private void addRec(double x, double y, double width, double height, Color colorFill, Color colorStroke) {
        GRect rect = new GRect(x, y, width, height);
        rect.setColor(colorStroke);
        rect.setFilled(true);
        rect.setFillColor(colorFill);
        add(rect);
    }
}
