package gameobjects.Paddle;

import gameassets.Constants;
import gameobjects.Circle;
import gameobjects.Point;

import javax.media.opengl.GL;
import java.awt.*;

public class Paddle extends Circle {
    public final float mass;    // The paddle's mass
    public float angle;         // The paddle's moving angle
    public float speed;         // The paddle's moving speed

    /**
     * Paddle class representing a game's left and right paddles.
     *
     * @param size      The size of the paddle
     * @param position  The paddle's position in the canvas
     * @param rgb       The paddle's color
     * @param isFilled  Is the paddle contained or outlined
     * @param lineWidth The paddle's line width if it is outlined
     */
    public Paddle(float size, gameobjects.Point position, Color rgb, boolean isFilled, int lineWidth) {
        super(size, position, rgb, isFilled, lineWidth);
        mass = radius * 0.9f;
        angle = 0;
        speed = Constants.SPEED - 50;
    }

    @Override
    public void draw(GL gl) {
        super.draw(gl);
        Circle middle = new Circle(20, new Point(this.position.x, this.position.y), new Color(50, 50, 50), true, 0);
        middle.draw(gl);
    }

    /**
     * Check whether the paddle hits the vertical boundaries of the canvas.
     */
    public void checkVerticalBounds() {
        if (this.position.y - this.radius <= 30)
            this.position.y = this.radius + 30;
        else if (this.position.y + this.radius > Constants.CANVAS_HEIGHT - 30)
            this.position.y = Constants.CANVAS_HEIGHT - this.radius - 30;
    }

    /**
     * Check whether the paddle hits the left boundary.
     */
    public void checkLeftBoundary() {
        // left boundary
        if (this.position.x - this.radius <= 30)
            this.position.x = this.radius + 30;
        else if (this.position.x + this.radius > Constants.SCREEN_WIDTH / 2f)
            this.position.x = (Constants.SCREEN_WIDTH / 2f) - this.radius;
    }

    /**
     * Check whether the paddle hits the right boundary.
     */
    public void checkRightBoundary() {
        // right boundary
        if (this.position.x + this.radius > Constants.SCREEN_WIDTH - 30)
            this.position.x = Constants.SCREEN_WIDTH - this.radius - 30;
        else if (this.position.x - this.radius < Constants.SCREEN_WIDTH / 2f)
            this.position.x = (Constants.SCREEN_WIDTH / 2f) + this.radius;
    }

    /**
     * Updates the paddle's position on the canvas depending on the main four directions.
     *
     * @param up        1 if it moves up <code>position.y</code> changes upwards, 0 otherwise
     * @param down      1 if it moves down <code>position.y</code> changes downwards, 0 otherwise
     * @param left      1 if it moves left <code>position.x</code> changes leftwards, 0 otherwise
     * @param right     1 if it moves right <code>position.x</code> changes rightwards, 0 otherwise
     * @param deltaTime The actual time spent based on the dropped frames. Helps with the smoothing of the movement
     */
    public void move(int up, int down, int left, int right, float deltaTime) {
        float dx = this.position.x, dy = this.position.y;
        this.position.x += (right - left) * speed;
        this.position.y += (up - down) * speed;
        dx = this.position.x - dx;
        dy = this.position.y - dy;
        this.angle = (float) Math.atan2(dy, dx);
    }
}
