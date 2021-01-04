package gameplay;

import gameassets.Constants;
import gameassets.Globals;
//import gameassets.TextureReader;
import gameobjects.Hockey;
import gameobjects.Paddle.PaddleListener;
import gameobjects.Point;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import java.awt.*;
import java.time.Duration;
import java.time.LocalTime;

public class MainGame implements GLEventListener {
    private final float WIDTH = Constants.SCREEN_WIDTH, HEIGHT = Constants.CANVAS_HEIGHT;
    private LocalTime startTime;
    private long elapsedSeconds;
    private int elapsedNanos;
    private int frames = Constants.FBS;
    private Hockey hockey;

//    private TextureReader.Texture texture;
    private final int[] textureIndex = new int[1];


    public MainGame() {
        // Generate Data for AI
//        try {
//            File data = new File(Constants.ASSETS_DIR + "DataToTrain1.csv");
//            out = new PrintWriter(new BufferedWriter(new FileWriter(data)));
//            out.println("x,y,speed,Player.x,Player.y");
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
    }

    private void gameAI() {
        Globals.paddles[0].position = Globals.AI.interact(hockey.position, hockey.speed);
    }

    @Override
    public void init(GLAutoDrawable gld) {
        startTime = LocalTime.now();
        GL gl = gld.getGL();
        initPlayers();
        PaddleListener paddleListener = new PaddleListener(getDeltaTime());
        Globals.glCanvas.addKeyListener(paddleListener);
        Globals.glCanvas.addMouseMotionListener(paddleListener);


        //Let's use a different color than black
        gl.glClearColor(0.95f, 0.95f, 0.95f, 1);
//        gl.glEnable(GL.GL_TEXTURE_2D);  // Enable Texture Mapping
//        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
//        gl.glGenTextures(1, textureIndex, 0);
//
//        try {
//            texture = TextureReader.readTexture(Constants.IMAGE_DIR + "Board.jpg", true);
//            gl.glBindTexture(GL.GL_TEXTURE_2D, textureIndex[0]);
//
////                mipmapsFromPNG(gl, new GLU(), texture[i]);
//            new GLU().gluBuild2DMipmaps(
//                    GL.GL_TEXTURE_2D,
//                    GL.GL_RGBA, // Internal Texel Format,
//                    texture.getWidth(), texture.getHeight(),
//                    GL.GL_RGBA, // External format from image,
//                    GL.GL_UNSIGNED_BYTE,
//                    texture.getPixels() // Imagedata
//            );
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }


        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glViewport(0, 0, (int) WIDTH, (int) HEIGHT);
        gl.glLoadIdentity();
        //gluOrtho2D's arguments represent
        //left, right, bottom, top
        gl.glOrtho(0, WIDTH, 0, HEIGHT, -1, 1);
    }

    @Override
    public void display(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        Drawer.drawMainBoard(gl);
//        Drawer.drawBackground(gl, textureIndex);
        Drawer.drawPlayers(gl);
        Drawer.drawHockey(gl, hockey, getDeltaTime());

        // Start AI
        if(Globals.isSingleMode)
            gameAI();

        // Generate AI data
//        out.println(hockey.position.x + "," + hockey.position.y + "," + hockey.speed + "," + paddle1.position.x + "," + paddle1.position.y);

    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    @Override
    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

    }

    private void initPlayers() {
        // Initialize game objects
        hockey = new Hockey(30, new Point(WIDTH / 2, HEIGHT / 2), new Color(250, 50, 30), true, 0);
    }

    public float getDeltaTime() {
        Duration timeSinceStart = Duration.between(startTime, LocalTime.now());
        int deltaTime = timeSinceStart.minusSeconds(elapsedSeconds).getNano() - elapsedNanos;
        if (timeSinceStart.getSeconds() > elapsedSeconds) {
            System.out.println("Frames: " + frames);
            frames = 0;
            elapsedSeconds = timeSinceStart.getSeconds();
        } else {
            frames++;
        }
        elapsedNanos = elapsedNanos + deltaTime;
        return deltaTime < 0 ? 0 : deltaTime / 100000000f;
    }
}