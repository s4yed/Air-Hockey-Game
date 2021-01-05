package gameobjects;

import gameassets.Constants;
import gameassets.Globals;
import gameassets.PlayAudio;
import gameobjects.Paddle.Paddle;

import javax.media.opengl.GL;
import java.awt.*;

public class Hockey extends Circle {
    public final float mass;    // The hockey's mass
    public float angle;         // The hockey's moving angle
    public float speed;         // The hockey's moving speed

    /**
     * Hockey class representing the game's hockey.
     *
     * @param radius    The hockey's actual radius
     * @param position  The hockey's position on the canvas
     * @param rgb       The hockey's color
     * @param isFilled  Is the hockey contained or outlined
     * @param lineWidth The hockey's line width if it is outlined
     */
    public Hockey(float radius, Point position, Color rgb, boolean isFilled, int lineWidth) {
        super(radius, position, rgb, isFilled, lineWidth);
        mass = radius * 0.6f;
        angle = 0;
        switch (Globals.gameLevel) {
            case EASY -> speed = Constants.SPEED;
            case HARD -> speed = Constants.SPEED + 200;
            default -> speed = Constants.SPEED + 100;
        }
    }

    @Override
    public void draw(GL gl) {
        super.draw(gl);
        Circle middle = new Circle(15, new Point(position.x, position.y), new Color(200, 50, 50), true, 0);
        middle.draw(gl);
        if (position.y > Constants.CANVAS_HEIGHT - 80) position.y = Constants.CANVAS_HEIGHT - 80;
        if (position.y < 80) position.y = 80;
        if (position.x > Constants.SCREEN_WIDTH - 80) position.x = Constants.SCREEN_WIDTH - 80;
        if (position.x < 80) position.x = 80;
    }

    /**
     * Check whether the hockey hits the 4 boundaries of the canvas.
     *
     * @param sound The hitting sound of the hockey
     */
    public void checkBounds(PlayAudio sound) {
        boolean isPocketHit = isPocketHit(Constants.SIDE.LEFT) || isPocketHit(Constants.SIDE.RIGHT);
        // right and left sides
        if (position.x + radius > Constants.SCREEN_WIDTH - 20 && !isPocketHit) {
            position.x = 2 * (Constants.SCREEN_WIDTH - radius - 20) - position.x;
            angle = -angle;
            sound.play(false);
        } else if (position.x - radius < 20 && !isPocketHit) {
            position.x = 2 * (radius + 20) - position.x;
            angle = -angle;
            sound.play(false);
        }
        // top and bottom sides
        if (position.y + radius > Constants.CANVAS_HEIGHT - 20 && !isPocketHit) {
            position.y = 2 * (Constants.CANVAS_HEIGHT - 20 - radius) - position.y;
            angle = (float) (Math.PI - angle);
            sound.play(false);
        } else if (position.y - radius < 20 && !isPocketHit) {
            position.y = 2 * (radius + 20) - position.y;
            angle = (float) (Math.PI - angle);
            sound.play(false);
        }
    }

    /**
     * A helper function to add 2 vectors.
     *
     * @param firstVec  The first vector's position
     * @param secondVec The second vector's position
     * @return The <code>(x,y)</code> position of the 2 added vectors
     */
    private Point addVectors(Point firstVec, Point secondVec) {
        double x = Math.sin(firstVec.x) * firstVec.y + Math.sin(secondVec.x) * secondVec.y;
        double y = Math.cos(firstVec.x) * firstVec.y + Math.cos(secondVec.x) * secondVec.y;

        double length = Math.hypot(x, y);
        double angle = Math.PI / 2 - Math.atan2(y, x);
        return new Point(angle, length);
    }

    /**
     * Check if the hockey collides with the paddles
     *
     * @param paddle The paddle that want to check to
     * @return <code>true</code> if the hockey hit the given paddle or <code>false</code> otherwise
     */
    public boolean isPaddleCollide(Paddle paddle) {
        float dx = position.x - paddle.position.x;
        float dy = position.y - paddle.position.y;

        float dist = position.dist(paddle.position);

        if (dist > radius + paddle.radius + 2) return false;

        // calculate the angle of the projection
        float tangent = (float) Math.atan2(dy, dx);
        float tempAngle = (float) (Math.PI / 2 + tangent);
        float totalMass = mass + paddle.mass;

        // the new vector after collision
        Point vecA = new Point(angle, speed * (mass - paddle.mass) / totalMass);
        Point vecB = new Point(tempAngle, 2 * paddle.speed * paddle.mass / totalMass);

        Point newVec = addVectors(vecA, vecB);
        angle = newVec.x;
        speed = newVec.y;

        if (speed > Constants.MAX_SPEED)
            speed = Constants.MAX_SPEED;

        // new vector for the player without changing the speed
        float tempSpeed = paddle.speed;
        vecA = new Point(paddle.angle, paddle.speed * (paddle.mass - mass) / totalMass);
        vecB = new Point(tempAngle + Math.PI, 2 * speed * mass / totalMass);
        newVec = addVectors(vecA, vecB);
        paddle.angle = newVec.x;
//        paddle.speed = tempSpeed;

        // If the paddle and the hockey collides then it must never overlap
        float overlap = 0.5f * (radius + paddle.radius - dist + 2);
        position.x += (float) (Math.sin(tempAngle) * overlap);
        position.y -= (float) (Math.cos(tempAngle) * overlap);

        paddle.position.x -= (float) (Math.sin(tempAngle) * overlap);
        paddle.position.y += (float) (Math.cos(tempAngle) * overlap);
        return true;
    }

    /**
     * Check whether the hockey hit one of the two goals
     *
     * @param side The side of the goal
     * @return <code>true</code> if the hockey hit the goal or <code>false</code> otherwise
     */
    public boolean isPocketHit(Constants.SIDE side) {
        boolean isLeftPocketHit = position.y < (Constants.CANVAS_HEIGHT / 2f) + radius + 30 &&
                position.y > (Constants.CANVAS_HEIGHT / 2f) - radius - 30 && position.x < radius + 30;
        boolean isRightPocketHit = position.y < (Constants.CANVAS_HEIGHT / 2f) + radius + 30 &&
                position.y > (Constants.CANVAS_HEIGHT / 2f) - radius - 30 && position.x > Constants.SCREEN_WIDTH - radius - 30;

        if (side == Constants.SIDE.LEFT) {
            if (isLeftPocketHit) position.x -= 20;
            return isLeftPocketHit;
        } else {
            if (isRightPocketHit) position.x += 20;
            return isRightPocketHit;
        }
    }

    /**
     * Updates the hockey's <code>(x,y)</code> position on the canvas depending on the main four directions.
     *
     * @param deltaTime The actual time spent based on the dropped frames. Helps with the smoothing of the movement
     */
    public void move(float deltaTime) {
        position.x += Math.sin(angle) * speed * deltaTime;
        position.y -= Math.cos(angle) * speed * deltaTime;
        speed *= 0.9998;
        if (speed < Constants.MIN_SPEED)
            speed = Constants.MIN_SPEED;
    }

    /**
     * Resetting the position of the hockey when hits one of th two goals.
     */
    public void reset() {
        position = new Point((Math.random() * Constants.SCREEN_WIDTH) / 2f, (Math.random() * Constants.CANVAS_HEIGHT) / 2f);
        angle = 1.5f;
    }
}
