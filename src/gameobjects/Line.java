package gameobjects;

import gameassets.Constants;

import javax.media.opengl.GL;
import java.awt.Color;

public class Line extends GameObject {
    private final Point start, end;

    /**
     * Line class for drawing lined on the canvas.
     *
     * @param start: The starting point (x, y) of the line.
     * @param end:   The end point (x', y') of the line.
     */
    public Line(Point start, Point end, Point position, Color rgb, boolean isFilled, int lineWidth) {
        super(position, new Point(Constants.SPEED, Constants.SPEED), rgb, isFilled, lineWidth);
        this.start = start;
        this.end = end;
    }

    @Override
    public void draw(GL gl) {
        gl.glLineWidth(super.lineWidth);
        gl.glColor3ub((byte) super.rgb.getRed(), (byte) super.rgb.getGreen(), (byte) super.rgb.getBlue());
        gl.glBegin(GL.GL_LINES);
        gl.glVertex2f(start.x + super.position.x, start.y + super.position.y);
        gl.glVertex2f(end.x + super.position.x, end.y + super.position.y);
        gl.glEnd();
    }
}
