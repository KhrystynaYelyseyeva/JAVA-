package com.shpp.p2p.cs.kyelyseyeva.assignment4;

import acm.graphics.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

public class Assignment4 extends WindowProgram {
    /**
     * Width and height of application window in pixels
     */
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;

    /**
     * Dimensions of game board (usually the same)
     */
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;

    /**
     * Dimensions of the paddle
     */
    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_HEIGHT = 10;

    /**
     * Offset of the paddle up from the bottom
     */
    private static final int PADDLE_Y_OFFSET = 30;

    /**
     * Number of bricks per row
     */
    private static final int NBRICKS_PER_ROW = 10;

    /**
     * Number of rows of bricks
     */
    private static final int NBRICK_ROWS = 10;

    /**
     * Separation between bricks
     */
    private static final int BRICK_SEP = 4;

    /**
     * Width of a brick
     */
    private static final int BRICK_WIDTH =
            (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

    /**
     * Height of a brick
     */
    private static final int BRICK_HEIGHT = 8;

    /**
     * Radius of the ball in pixels
     */
    private static final int BALL_RADIUS = 10;

    /**
     * Offset of the top brick row from the top
     */
    private static final int BRICK_Y_OFFSET = 70;

    /**
     * Number of turns
     */
    private static final int NTURNS = 3;

    //variables for paddle
    private GObject paddle = addRect(WIDTH / 2d - PADDLE_WIDTH / 2d, HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT / 2d,
            PADDLE_WIDTH, PADDLE_HEIGHT, Color.black);

    //variables for speed
    double vx, vy;

    //bricks will be embedded in this array
    ArrayList<GRect> br = new ArrayList<GRect>();

    //counter for bricks.
    // will decrease
    int brCount=NBRICK_ROWS * NBRICKS_PER_ROW;


//----------------------------------------------------------------------------------

    public void run() {

        buildWall();
        addMouseListeners();
        playGame(addRocket());

    }


//----------------------------------------------------------------------------------


    /**
     * Write Message.
     *
     * @param message The text of message for user.
     * @param x The x coordinate of the upper-left corner of the GLabel.
     * @param color The message's color.
     */
    private void writeMessage(String message, double x, Color color) {
        GLabel p = new GLabel(message, x, 450.0);
        p.setFont("Adobe Haiti Std-50");
        p.setColor(color);
        add(p);
    }

    /*
     * Object's behavior during collisions.
     *
     * @param rocket The object.
     */
    private void getCollidingObject(GObject rocket) {
        //if the rocket hits the object(paddle or bricks) at the one of the 4 rocket's points.
        if (getElementAt(rocket.getX(), rocket.getY()) != null ||
                getElementAt(rocket.getX() + 2 * BALL_RADIUS, rocket.getY()) != null ||
                getElementAt(rocket.getX(), rocket.getY() + 2 * BALL_RADIUS) != null ||
                getElementAt(rocket.getX() + 2 * BALL_RADIUS, rocket.getY() + 2 * BALL_RADIUS) != null
        ) {
            //the rocket changes direction
            vy = -vy;
        //if the rocket hits a brick.
        // additional condition.
        for (int i = 0; i < br.size(); i++) {
            if (getElementAt(rocket.getX(), rocket.getY()) == br.get(i) ||
                    getElementAt(rocket.getX() + 2 * BALL_RADIUS, rocket.getY()) == br.get(i) ||
                    getElementAt(rocket.getX(), rocket.getY() + 2 * BALL_RADIUS) == br.get(i) ||
                    getElementAt(rocket.getX() + 2 * BALL_RADIUS, rocket.getY() + 2 * BALL_RADIUS) == br.get(i)
            ) {
                //removal of bricks.
                remove(br.get(i));
                //decreases the counter for bricks.
                brCount--;
            }
        }
    }

}

    /*
     * Implementation of the game.
     *
     * @param rocket The object.
     */
    private void playGame(GObject rocket) {
        //random number generation for the rocket trajectory
        RandomGenerator rgen = new RandomGenerator();
        vx = rgen.nextDouble(1.0, 3.0);
        vy = 1.0;
        if (rgen.nextBoolean(0.5)) vx = -vx;

        //rocket movement.
        // limitation of 3 lives.
        int chance = 0;
        while (chance < NTURNS) {
            rocket.move(vx, vy);
            pause(10);

            getCollidingObject(rocket);

            //rocket reflected off the walls (except the bottom)
            if (rocket.getX() + BALL_RADIUS*2 > WIDTH || rocket.getX() + BALL_RADIUS < 0) vx = -vx;
            if (rocket.getY() < 0) vy = -vy;

            //termination of the game.
            //if there are no bricks.
            if (brCount == 0) {
                writeMessage("You win!", WIDTH / 5d, Color.orange);
                break;
            }

            //condition of loss of life.
            //rocket launch at the bottom of the wall.
            if (rocket.getY() >= HEIGHT) {
                chance++;
                rocket.setLocation(WIDTH / 2d, HEIGHT / 2d);
                waitForClick();
            }
        }
        //termination of the game.
        //if there are no lives.
        if (brCount != 0) {
            writeMessage("Game over", WIDTH / 6d, Color.red);
        }
    }

    /* The mouse's last position. */
    private double lastX = 0;

    /**
     * Repositions the move object to the mouse's location when the mouse
     * is moved.
     */
    public void mouseMoved(MouseEvent mouseEvent) {
        double lastX = mouseEvent.getX();
        /* The condition which checks whether paddle is touching the right border of the window */
        if (lastX > (APPLICATION_WIDTH - PADDLE_WIDTH)) {
            lastX = APPLICATION_WIDTH - PADDLE_WIDTH / 2d;
        }
        /* The condition which checks whether paddle is touching the left border of the window */
        if (lastX < (PADDLE_WIDTH)) {
            lastX = PADDLE_WIDTH / 2d;
        }
        paddle.setLocation(lastX - PADDLE_WIDTH / 2d, getHeight() - PADDLE_Y_OFFSET);
    }
    /**
    * draws a rectangular object
    *
    * @param x The x coordinate of the upper-left corner of the GRect
    * @param y The y coordinate of the upper-left corner of the GRect
    * @param w The width of the object
    * @param h The Hight of the object
    * @param color The color of the object
    */

    private GRect addRect(double x, double y, int w, int h, Color color) {
        GRect rect = new GRect(x, y, w, h);
        rect.setFilled(true);
        rect.setColor(color);
        add(rect);
        return rect;
    }

    //draws a rocket
    private GOval addRocket() {
        GOval rocket = new GOval(WIDTH / 2d, HEIGHT / 2d, BALL_RADIUS*2,
                BALL_RADIUS*2);
        rocket.setFilled(true);
        rocket.setFillColor(Color.black);
        add(rocket);
        return rocket;
    }

    //draws bricks
    private void buildWall() {
        for (int r = 0; r < NBRICK_ROWS; r++) {
            for (int c = 0; c < NBRICKS_PER_ROW; c++) {
                if (r == 0 || r == 1)
                    br.add(addRect(c * (BRICK_WIDTH + BRICK_SEP), BRICK_Y_OFFSET + r * (BRICK_HEIGHT + BRICK_SEP), BRICK_WIDTH, BRICK_HEIGHT, Color.red));
                if (r == 2 || r == 3)
                    br.add(addRect(c * (BRICK_WIDTH + BRICK_SEP), BRICK_Y_OFFSET + r * (BRICK_HEIGHT + BRICK_SEP), BRICK_WIDTH, BRICK_HEIGHT, Color.orange));
                if (r == 4 || r == 5)
                    br.add(addRect(c * (BRICK_WIDTH + BRICK_SEP), BRICK_Y_OFFSET + r * (BRICK_HEIGHT + BRICK_SEP), BRICK_WIDTH, BRICK_HEIGHT, Color.yellow));
                if (r == 6 || r == 7)
                    br.add(addRect(c * (BRICK_WIDTH + BRICK_SEP), BRICK_Y_OFFSET + r * (BRICK_HEIGHT + BRICK_SEP), BRICK_WIDTH, BRICK_HEIGHT, Color.green));
                if (r == 8 || r == 9)
                    br.add(addRect(c * (BRICK_WIDTH + BRICK_SEP), BRICK_Y_OFFSET + r * (BRICK_HEIGHT + BRICK_SEP), BRICK_WIDTH, BRICK_HEIGHT, Color.blue));

            }
        }
    }
}
