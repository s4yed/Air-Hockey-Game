package gameobjects.Paddle;

import gameassets.Constants;
import gameobjects.Point;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PaddleListener implements MouseMotionListener, KeyListener {
    private final Paddle paddle1, paddle2;
    private final float deltaTime;

    public PaddleListener(Paddle paddle1, Paddle paddle2, float deltaTime) {
        this.paddle1 = paddle1;
        this.paddle2 = paddle2;
        this.deltaTime = deltaTime;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Handling key strokes for the right player
        if (e.getKeyCode() == KeyEvent.VK_UP)
            paddle1.move(1, 0, 0, 0, deltaTime);
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            paddle1.move(0, 1, 0, 0, deltaTime);
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            paddle1.move(0, 0, 0, 1, deltaTime);
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            paddle1.move(0, 0, 1, 0, deltaTime);

        // Handling key strokes for the left player
        if (e.getKeyCode() == KeyEvent.VK_W)
            paddle2.move(1, 0, 0, 0, deltaTime);
        if (e.getKeyCode() == KeyEvent.VK_S)
            paddle2.move(0, 1, 0, 0, deltaTime);
        if (e.getKeyCode() == KeyEvent.VK_D)
            paddle2.move(0, 0, 0, 1, deltaTime);
        if (e.getKeyCode() == KeyEvent.VK_A)
            paddle2.move(0, 0, 1, 0, deltaTime);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point p = new Point(e.getX(), e.getY());
        paddle2.position.x = p.x;
        paddle2.position.y = Constants.CANVAS_HEIGHT - p.y;
    }
}
