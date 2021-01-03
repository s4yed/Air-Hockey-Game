package gameobjects;

import javax.media.opengl.GL;


public interface Drawable {
    /**
     * Abstract method for drawing any object on the canvas.
     *
     * @param gl: The drawable object of the canvas.
     */
    void draw(GL gl);
}
