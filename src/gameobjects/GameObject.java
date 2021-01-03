package gameobjects;

import javax.media.opengl.GL;
import java.awt.Color;


public class GameObject implements Drawable {
    public Color rgb;
    public Point position;
    public Point velocity;
    public boolean isFilled;
    public int lineWidth;

    /**
     * A parent class of all the game objects used in this game.
     *
     * @param position  The position (x, y) of the object on the canvas.
     * @param velocity  The speed of the object.
     * @param rgb       The main color of the game object.
     * @param isFilled  Draw outlined or filled object.
     * @param lineWidth The line width of the outlined object.
     */
    GameObject(Point position, Point velocity, Color rgb, boolean isFilled, int lineWidth) {
        this.position = position;
        this.velocity = velocity;
        this.rgb = rgb;
        this.isFilled = isFilled;
        this.lineWidth = lineWidth;
    }

    @Override
    public void draw(GL gl) {
        gl.glLineWidth(lineWidth);
    }
}
