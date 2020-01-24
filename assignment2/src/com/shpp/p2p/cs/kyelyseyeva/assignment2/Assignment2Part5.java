package com.shpp.p2p.cs.kyelyseyeva.assignment2;

import acm.graphics.*;

import java.awt.*;

import com.shpp.cs.a.graphics.WindowProgram;

public class Assignment2Part5 extends WindowProgram {

    /* The middle width and middle height of window. */
    private final double MIDDLE_WIDTH = getWidth() / 2;
    private final double MIDDLE_HEIGHT = getHeight() / 2;

    /*The number of rows    and columns    in the    grid,respectively . */
    private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 6;

    /* The width and height of each box. */
    private static final double BOX_SIZE = 40;

    /* The horizontal and vertical spacing between the boxes. */
    private static final double BOX_SPACING = 10;

    /* The starting point. */
    private final double START_POINT_X = MIDDLE_WIDTH + NUM_COLS * BOX_SIZE / 2.0 + (NUM_COLS - 1) * BOX_SPACING / 2.0;
    private final double START_POINT_Y = MIDDLE_HEIGHT + NUM_ROWS * BOX_SIZE / 2.0 + (NUM_ROWS - 1) * BOX_SPACING / 2.0;


    public void run() {
        drawConstruction();
    }

    /* Draw each construction. */
    private void drawConstruction() {
        for (int r = 0; r < NUM_ROWS; r++) {
        for (int c = 0; c < NUM_COLS; c++) {
            addSquare(START_POINT_X + c * (BOX_SIZE + BOX_SPACING), START_POINT_Y + r * (BOX_SIZE + BOX_SPACING), BOX_SIZE, Color.black);
        }
    }}

    /*
     * Draws the square.
     *
     * @param x The x coordinate of the upper-left corner of the square.
     * @param y The y coordinate of the upper-left corner of the square.
     */
    private void addSquare(double x, double y, double width, Color color) {
        GRect rect = new GRect(x, y, width, width);
        rect.setFilled(true);
        rect.setColor(color);
        add(rect);
    }
}
