package com.shpp.p2p.cs.kyelyseyeva.assignment3;

import acm.graphics.*;

import java.awt.*;

import com.shpp.cs.a.graphics.WindowProgram;

public class Assignment3Part6 extends WindowProgram {

    public void run() {
        GOval circle1 = addCircle(0, getHeight() - getWidth() / 8, getWidth() / 16, Color.yellow, Color.black);
        GOval circle2 = addCircle(getWidth() / 4, getHeight() - getWidth() / 8, getWidth() / 16, Color.white, Color.black);
        GOval circle3 = addCircle(getWidth() / 2, getHeight() - getWidth() / 8, getWidth() / 16, Color.white, Color.black);
        GOval circle4 = addCircle(getWidth() * 3 / 4, getHeight() - getWidth() / 6, getWidth() / 12, Color.white, Color.black);


        while (true) {
            //the first lap starts moving
            circle1.move(1, 0);

            //comes to the second lap and moves two laps
            //the second circle changes color
            if (circle1.getX() == getWidth() / 8) {
                circle2.setFillColor(Color.yellow);
                while (true) {
                    circle2.move(1, 0);
                    circle1.move(1, 0);
                    pause(20);
                    if (circle1.getX() == getWidth() / 4) break;
                }
            }

            //come to the third lap and moves three laps
            //the third circle changes color
            if (circle1.getX() == getWidth() / 4) {
                circle3.setFillColor(Color.yellow);
                while (true) {
                    circle3.move(1, 0);
                    circle2.move(1, 0);
                    circle1.move(1, 0);
                    pause(20);
                    if (circle1.getX() == getWidth() * 3 / 8) break;
                }
            }
            pause(20);

            //the fourth circle changes color
            //draws a face
            if (circle1.getX() == getWidth() * 3 / 8) {
                circle4.setFillColor(Color.yellow);

                //draws mouth
                GOval smile2 = addCircle(getWidth() * 3 / 4 + getWidth() / 12 - getWidth() / 30, getHeight() - getWidth() / 10, getWidth() / 30, Color.red, Color.black);
                GOval smile1 = addCircle(getWidth() * 3 / 4 + getWidth() / 12 - getWidth() / 30, getHeight() - getWidth() / 10, getWidth() / 30, Color.yellow, Color.yellow);

                //draws eyes
                GOval eye_white_1 = addCircle(getWidth() * 3 / 4 + getWidth() / 12 - getWidth() / 20, getHeight() - getWidth() / 7, getWidth() / 40, Color.white, Color.black);
                GOval eye_black_1 = addCircle(getWidth() * 3 / 4 + getWidth() / 12 - getWidth() / 20, getHeight() - getWidth() / 8, getWidth() / 70, Color.black, Color.black);
                GOval eye_white_2 = addCircle(getWidth() * 3 / 4 + getWidth() / 12, getHeight() - getWidth() / 7, getWidth() / 40, Color.white, Color.black);
                GOval eye_black_2 = addCircle(getWidth() * 3 / 4 + getWidth() / 12, getHeight() - getWidth() / 8, getWidth() / 70, Color.black, Color.black);

                //smiles
                while (true) {
                    smile1.move(0, -1);
                    pause(25);
                    if (smile1.getY() == getHeight() - getWidth() / 9) break;
                }

                //moving eyes
                while (true) {
                    eye_black_1.move(0.5, 0);
                    eye_black_2.move(0.5, 0);
                    pause(25);
                    if (eye_black_1.getX() == getWidth() * 3 / 4 + getWidth() / 12 - getWidth() / 35) break;
                }
                while (true) {
                    eye_black_1.move(-0.5, 0);
                    eye_black_2.move(-0.5, 0);
                    pause(25);
                    if (eye_black_1.getX() == getWidth() * 3 / 4 + getWidth() / 12 - getWidth() / 20) break;
                }

                break;
            }
        }
    }

    /*
     * Draws the circle.
     *
     * @param x The x coordinate of the center of the circle.
     * @param y The y coordinate of the center of the circle.
     * @param radius The radius of the circle.
     * @param color The color of the circle.
     */
    private GOval addCircle(double x, double y, double radius, Color colorFill, Color colorStroke) {
        GOval circle = new GOval(x, y, 2 * radius, 2 * radius);
        circle.setColor(colorStroke);
        circle.setFilled(true);
        circle.setFillColor(colorFill);
        add(circle);
        return circle;
    }
}
