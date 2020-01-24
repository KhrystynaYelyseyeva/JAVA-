package com.shpp.p2p.cs.kyelyseyeva.assignment2;

import acm.graphics.*;

import java.awt.*;

import com.shpp.cs.a.graphics.WindowProgram;

public class Assignment2Part6 extends WindowProgram {
    /* The number of circles. */
    private static final int NUM_CIRCLES = 6;

    /* The radius of circles. */
    private static final double RADIUS = 50;

    public void run() {
        drawWorm();
    }

    /* method for drawing worm. */
    private void drawWorm() {
        for (int i = 0; i < NUM_CIRCLES; i++) {
        if (i % 2 != 0) addCircle(i * RADIUS*6/5, 0, RADIUS, Color.green,Color.red);
        else addCircle(i * RADIUS*6/5, RADIUS, RADIUS, Color.green,Color.red);
    }}

    /*
     * Draws the circle.
     *
     * @param x The x coordinate of the center of the circle.
     * @param y The y coordinate of the center of the circle.
     * @param radius The radius of the circle.
     * @param color The color of the circle.
     */
    private void addCircle(double x, double y, double radius, Color colorFill,Color colorStroke) {
        GOval circle = new GOval(x, y, 2 * radius, 2 * radius);
        circle.setColor(colorStroke);
        circle.setFilled(true);
        circle.setFillColor(colorFill);
        add(circle);
    }
}
