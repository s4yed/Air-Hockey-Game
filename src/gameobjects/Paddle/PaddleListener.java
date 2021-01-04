package gameobjects.Paddle;

import gameassets.Constants;
import gameassets.Globals;
import gameobjects.Point;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PaddleListener implements MouseMotionListener, KeyListener {
    private final float deltaTime;

    public PaddleListener(float deltaTime) {
        this.deltaTime = deltaTime;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Handling key strokes for the right player
        if (e.getKeyCode() == KeyEvent.VK_UP)
            Globals.paddles[0].move(1, 0, 0, 0, deltaTime);
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            Globals.paddles[0].move(0, 1, 0, 0, deltaTime);
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            Globals.paddles[0].move(0, 0, 0, 1, deltaTime);
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            Globals.paddles[0].move(0, 0, 1, 0, deltaTime);

        // Handling key strokes for the left player
        if (e.getKeyCode() == KeyEvent.VK_W)
            Globals.paddles[1].move(1, 0, 0, 0, deltaTime);
        if (e.getKeyCode() == KeyEvent.VK_S)
            Globals.paddles[1].move(0, 1, 0, 0, deltaTime);
        if (e.getKeyCode() == KeyEvent.VK_D)
            Globals.paddles[1].move(0, 0, 0, 1, deltaTime);
        if (e.getKeyCode() == KeyEvent.VK_A)
            Globals.paddles[1].move(0, 0, 1, 0, deltaTime);
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
        Globals.paddles[1].position.x = p.x;
        Globals.paddles[1].position.y = Constants.CANVAS_HEIGHT - p.y;
    }
}
