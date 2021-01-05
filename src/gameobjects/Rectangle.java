package gameobjects;

import gameassets.Constants;
import gameobjects.GameObject;
import gameobjects.Point;

import javax.media.opengl.GL;
import java.awt.Color;

public class Rectangle extends GameObject {
    public Point top, bottom;

    /**
     * Rectangle class for drawing rectangles on the canvas.
     *
     * @param top:    The top left/right point of the rectangle.
     * @param bottom: The bottom right/left point of the rectangle.
     */
    public Rectangle(Point top, Point bottom, Point position, Color rgb, boolean isFilled, int lineWidth) {
        super(position, new Point(Constants.SPEED, Constants.SPEED), rgb, isFilled, lineWidth);
        this.top = new Point(top);
        this.bottom = new Point(bottom);
    }

    @Override
    public void draw(GL gl) {
        gl.glLineWidth(super.lineWidth);
        if (super.isFilled) gl.glBegin(GL.GL_QUADS);
        else gl.glBegin(GL.GL_LINE_LOOP);
        gl.glColor3ub((byte) super.rgb.getRed(), (byte) super.rgb.getGreen(), (byte) super.rgb.getBlue());
        gl.glVertex2f(top.x + super.position.x, top.y + super.position.y);
        gl.glVertex2f(bottom.x + super.position.x, top.y + super.position.y);
        gl.glVertex2f(bottom.x + super.position.x, bottom.y + super.position.y);
        gl.glVertex2f(top.x + super.position.x, bottom.y + super.position.y);
        gl.glEnd();
    }
}
