package com.shpp.p2p.cs.kyelyseyeva.assignment2;

import acm.graphics.*;
import java.awt.*;
import com.shpp.cs.a.graphics.WindowProgram;

public class Assignment2Part2 extends WindowProgram {

    /* Constants controlling the size of the window. */
    public static final int APPLICATION_WIDTH = 300;
    public static final int APPLICATION_HEIGHT = 300;

    /* The radius of circles. */
    private static final double RADIUS = 50;

    /* The width and height of the rectangle. */
    private static final double REC_WIDTH = 200;
    private static final double REC_HEIGHT = 200;

    public void run() {
        /* Draw each construction. */
        addCircle(0, 0, RADIUS, Color.BLACK);
        addCircle( APPLICATION_WIDTH - RADIUS*2, APPLICATION_HEIGHT - RADIUS*2, RADIUS, Color.BLACK);
        addCircle(0, APPLICATION_HEIGHT - RADIUS*2, RADIUS, Color.BLACK);
        addCircle( APPLICATION_WIDTH - RADIUS*2, 0, RADIUS, Color.BLACK);
        addRec( APPLICATION_WIDTH/2-REC_WIDTH/2, APPLICATION_HEIGHT/2-REC_HEIGHT/2, REC_WIDTH, REC_HEIGHT, Color.white);
    }

    /*
     * Draws the circle.
     *
     * @param x The x coordinate of the center of the circle.
     * @param y The y coordinate of the center of the circle.
     * @param radius The radius of the circle.
     * @param color The color of the circle.
     */
    private void addCircle(double x, double y, double radius, Color color) {
        GOval circle = new GOval(x, y, 2 * radius, 2 * radius);
        circle.setColor(color);
        circle.setFilled(true);
        add(circle);
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


