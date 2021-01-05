package gameplay;

import gameassets.Constants;
import gameassets.Globals;
import gameobjects.*;
import maingui.WinnerScreen;
//import maingui.WinnerScreen;

import javax.media.opengl.GL;

public class Drawer {

    public static void drawMainBoard(GL gl) {
        // Draw the rectangular border
        gameobjects.Rectangle rect = new Rectangle(Constants.ORIGIN, new Point(Constants.SCREEN_WIDTH, Constants.CANVAS_HEIGHT),
                Constants.ORIGIN, Constants.DARK, false, 50);
        rect.draw(gl);

        // Draw the left pocket
        Line leftPocket = new Line(new Point(0, (Constants.CANVAS_HEIGHT / 2f) - 80), new Point(0, (Constants.CANVAS_HEIGHT / 2f) + 80),
                new Point(0, 0), Constants.LIGHT, false, 50);
        leftPocket.draw(gl);

        // Draw the right pocket
        Line rightPocket = new Line(new Point(Constants.SCREEN_WIDTH, (Constants.CANVAS_HEIGHT / 2f) - 80),
                new Point(Constants.SCREEN_WIDTH, (Constants.CANVAS_HEIGHT / 2f) + 80),
                new Point(0, 0), Constants.LIGHT, false, 50);
        rightPocket.draw(gl);

        // Draw the midlle line
        Line l1 = new Line(new Point(Constants.SCREEN_WIDTH / 2f, Constants.CANVAS_HEIGHT), new Point(Constants.SCREEN_WIDTH / 2f, 0),
                Constants.ORIGIN, Constants.DARK, true, 20);
        l1.draw(gl);

        // Draw the large midlle circle
        Circle crl1 = new Circle(150, new Point(Constants.SCREEN_WIDTH / 2f, Constants.CANVAS_HEIGHT / 2f), Constants.DARK, true, 20);
        crl1.draw(gl);

        // Draw the small midlle circle
        Circle crl2 = new Circle(20, new Point(Constants.SCREEN_WIDTH / 2f, Constants.CANVAS_HEIGHT / 2f), Constants.LIGHT, true, 0);
        crl2.draw(gl);

        Circle crl3 = new Circle(20, new Point(Constants.SCREEN_WIDTH / 4f, Constants.CANVAS_HEIGHT / 4f), Constants.DARK, true, 0);
        crl3.draw(gl);

        Circle crl4 = new Circle(20, new Point((3 * Constants.SCREEN_WIDTH) / 4f, (3 * Constants.CANVAS_HEIGHT) / 4f),
                Constants.DARK, true, 0);
        crl4.draw(gl);

        Circle crl5 = new Circle(20, new Point(Constants.SCREEN_WIDTH / 4f, (3 * Constants.CANVAS_HEIGHT) / 4f),
                Constants.DARK, true, 0);
        crl5.draw(gl);

        Circle crl6 = new Circle(20, new Point((3 * Constants.SCREEN_WIDTH) / 4f, Constants.CANVAS_HEIGHT / 4f),
                Constants.DARK, true, 0);
        crl6.draw(gl);
    }

    public static void drawHockey(GL gl, Hockey hockey, float deltaTime) {
        hockey.draw(gl);
        hockey.move(deltaTime);
        hockey.checkBounds(Constants.HOCKEY_SOUND[0]);
        if (hockey.isPaddleCollide(Globals.paddles[0])) Constants.HOCKEY_SOUND[0].play(false);
        if (hockey.isPaddleCollide(Globals.paddles[1])) Constants.HOCKEY_SOUND[0].play(false);
        if (hockey.isPocketHit(Constants.SIDE.LEFT)) {
            Constants.HOCKEY_SOUND[1].play(false);
            Globals.secondPlayer.incrementScore();
            if (Globals.secondPlayer.getScore() == Constants.MAX_SCORE) {
                new WinnerScreen(Globals.secondPlayer).setVisible(true);
                Globals.secondPlayer.winner = true;
                Globals.secondPlayer.duration = Globals.timer.getTimer();
                Globals.endGame();
            }
            hockey.reset();
        }
        if (hockey.isPocketHit(Constants.SIDE.RIGHT)) {
            Constants.HOCKEY_SOUND[1].play(false);
            assert Globals.firstPlayer != null;
            Globals.firstPlayer.incrementScore();
            if (Globals.firstPlayer.getScore() == Constants.MAX_SCORE) {
                new WinnerScreen(Globals.firstPlayer).setVisible(true);
                Globals.firstPlayer.winner = true;
                Globals.firstPlayer.duration = Globals.timer.getTimer();
                Globals.endGame();
            }
            hockey.reset();
        }
    }

    public static void drawPlayers(GL gl) {
        Globals.paddles[0].draw(gl);
        Globals.paddles[0].checkRightBoundary();
        Globals.paddles[0].checkVerticalBounds();
        Globals.paddles[1].draw(gl);
        Globals.paddles[1].checkLeftBoundary();
        Globals.paddles[1].checkVerticalBounds();
    }

    public static void drawBackground(GL gl, int[] textureIndex) {
        gl.glEnable(GL.GL_BLEND);    // Turn Blending On
        gl.glBindTexture(GL.GL_TEXTURE_2D, textureIndex[0]);

        gl.glBegin(GL.GL_QUADS);
        // Front Face
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex2f(-1, -1);
        gl.glTexCoord2f(1, 0.0f);
        gl.glVertex2f(Constants.SCREEN_WIDTH + 1, -1);
        gl.glTexCoord2f(1, 1);
        gl.glVertex2f(Constants.SCREEN_WIDTH + 1, Constants.CANVAS_HEIGHT + 1);
        gl.glTexCoord2f(0.0f, 1);
        gl.glVertex2f(-1, Constants.CANVAS_HEIGHT + 1);
        gl.glEnd();
        gl.glDisable(GL.GL_BLEND);
    }
}
