package gameobjects;

public class Point {
    public float x, y;

    /**
     * Point class that simulating a (x, y) point on the canvas.
     *
     * @param x: The first x-coordinate.
     * @param y: The second y-coordinate.
     */
    public Point(float x, float y) {
        super();
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public Point(double x, double y) {
        this.x = (float) x;
        this.y = (float) y;
    }

    /**
     * A function that calculate the distance between two points
     *
     * @param p: The target point.
     * @return The actual distance between two points.
     */
    public float dist(Point p) {
        float d = (float) Math.hypot(this.x - p.x, this.y - p.y);
        return d != 0 ? d : 1;
    }

//    @Override
//    public void draw(GL gl) {
//        gl.glBegin(GL.GL_POINTS);
////        gl.glColor3ub((byte) super.rgb.getRed(), (byte) super.rgb.getGreen(), (byte) super.rgb.getBlue());
////        gl.glPointSize(super.lineWidth);
//        gl.glVertex2f(this.x, this.y);
//        gl.glEnd();
//    }
}
