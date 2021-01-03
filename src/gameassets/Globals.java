package gameassets;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;
import gameobjects.Paddle.Paddle;
import gameobjects.Player;
import gameobjects.Point;
import gameplay.GamePlay;

import javax.media.opengl.GLCanvas;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Globals {
    public static Constants.LEVELS gameLevel = Constants.LEVELS.MEDIUM;
    public static Player firstPlayer = new Player("");
    public static Player secondPlayer = new Player("AI");
    public static Paddle[] paddles;
    public static SocketClient AI = new SocketClient(64092);
    public static GameTimer timer;
    public static Animator animator;
    public static GLCanvas glCanvas;
    private static GamePlay gamePlay;

    public static void startGame() {
        paddles = new Paddle[]{
                new Paddle(40, new Point(Constants.SCREEN_WIDTH - 70, Constants.CANVAS_HEIGHT / 2f), Constants.DARK, true, 0),
                new Paddle(40, new Point(70, Constants.CANVAS_HEIGHT / 2f), Constants.DARK, true, 0)
        };
        timer = new GameTimer(1000);
        animator = new FPSAnimator(Constants.FBS);
        glCanvas = new GLCanvas();
        gamePlay = GamePlay.getInstance();
        animator.add(glCanvas);
        animator.start();
        timer.start();
        glCanvas.requestFocus();
    }

    public static ArrayList<String[]> readPlayersData() {
        ArrayList<String[]> allPlayersData = new ArrayList<>();
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(Constants.ASSETS_DIR + "PlayersData.csv"));
            String row = csvReader.readLine();
            while (row != null) {
                row = csvReader.readLine();
                allPlayersData.add(row.split(","));
            }
            csvReader.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
}
        return allPlayersData;
                }

    public static void endGame() {
        try {
            timer.stop();
            animator.stop();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        gamePlay.dispose();
        gamePlay.removeInstance();
        firstPlayer.setPlayerData();
        secondPlayer.setPlayerData();
        firstPlayer.initPlayerData();
        secondPlayer.initPlayerData();
    }
}
