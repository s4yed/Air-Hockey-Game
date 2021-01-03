package gameobjects;

import gameassets.Constants;

import javax.media.opengl.GL;
import java.awt.Color;

public class Circle extends GameObject {
    public final float radius;
    private static final double THREE_SIXTY = Math.PI * 2;
    private static final double ONE_DEGREE = Math.PI / 180;

    /**
     * Circle class for drawing circles on the canvas.
     *
     * @param radius The radius of the drawn circle.
     */
    public Circle(float radius, Point position, Color rgb, boolean isFilled, int lineWidth) {
        super(position, new Point(Constants.SPEED, Constants.SPEED), rgb, isFilled, lineWidth);
        this.radius = radius;
    }

    @Override
    public void draw(GL gl) {
//        gl.glLineWidth(super.lineWidth);
        if (super.isFilled) gl.glBegin(GL.GL_POLYGON);
        else gl.glBegin(GL.GL_LINE_LOOP);
        gl.glColor4ub((byte) rgb.getRed(), (byte) rgb.getGreen(), (byte) rgb.getBlue(), (byte) rgb.getAlpha());
        for (float a = 0; a <= THREE_SIXTY; a += ONE_DEGREE) {
            double x = radius * (Math.cos(a)) + super.position.x;
            double y = radius * (Math.sin(a)) + super.position.y;
            gl.glVertex2d(x, y);
        }
        gl.glEnd();
    }
}
