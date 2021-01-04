package gameassets;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;
import gameobjects.Paddle.Paddle;
import gameobjects.Player;
import gameobjects.Point;
import gameplay.GamePlay;
import maingui.StartScreen;

import javax.media.opengl.GLCanvas;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Globals {
    public static Constants.LEVELS gameLevel = Constants.LEVELS.MEDIUM;
    public static boolean isSingleMode = true;
    public static Player firstPlayer = new Player("");
    public static Player secondPlayer = new Player("AI");
    public static StartScreen startScreen = new StartScreen();
    public static SocketClient AI = new SocketClient(1337);
    public static Paddle[] paddles;
    public static GameTimer timer;
    public static Animator animator;
    public static GLCanvas glCanvas;
    public static GamePlay gamePlay;
    public static boolean isGameOpened;

    public static void startGame() {
        startScreen.setVisible(false);
        new Thread(() -> {
            isGameOpened = true;
            timer = new GameTimer(1000);
            paddles = new Paddle[]{
                    new Paddle(40, new Point(Constants.SCREEN_WIDTH - 70, Constants.CANVAS_HEIGHT / 2f), Constants.DARK, true, 0),
                    new Paddle(40, new Point(70, Constants.CANVAS_HEIGHT / 2f), Constants.DARK, true, 0)
            };
            animator = new FPSAnimator(Constants.FBS);
            glCanvas = new GLCanvas();
            gamePlay = new GamePlay();
            animator.add(glCanvas);
            resumeGame();
        }).start();
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
        isGameOpened = false;
        Constants.MAIN_MUSIC.resume();
        try {
            timer.stop();
            animator.stop();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        gamePlay.dispose();
        firstPlayer.setPlayerData();
        secondPlayer.setPlayerData();
        firstPlayer.initPlayerData();
        secondPlayer.initPlayerData();
        startScreen.setVisible(true);
    }

    public static void pauseGame() {
        Constants.MAIN_MUSIC.stop();
        timer.counter.setText("PAUSE");
        timer.stop();
        animator.stop();
    }

    public static void resumeGame() {
        Constants.MAIN_MUSIC.resume();
        timer.start();
        animator.start();
    }
}
