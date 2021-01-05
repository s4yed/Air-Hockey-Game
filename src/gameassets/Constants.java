package gameassets;

import gameobjects.Point;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public interface Constants {
    int SCREEN_WIDTH = 1500;
    int SCREEN_HEIGHT = 900;
    int CANVAS_HEIGHT = SCREEN_HEIGHT - 100;
    int SPEED = 150;
    int FBS = 60;
    int MAX_SPEED = 1000;
    int MIN_SPEED = 100;
    int MAX_SCORE = 3;

    enum LEVELS {
        EASY, MEDIUM, HARD
    }

    enum SIDE {
        LEFT, RIGHT, TOP, BOTTOM
    }

    String ASSETS_DIR = System.getProperty("user.dir") + "\\assets\\";
    String SOUND_DIR = ASSETS_DIR + "sounds\\";
    String IMAGE_DIR = ASSETS_DIR + "images\\";
    Color DARK = new Color(64, 64, 64);
    Color LIGHT = new Color(243, 243, 243);
    Point ORIGIN = new Point(0, 0);
    PlayAudio MAIN_MUSIC = new PlayAudio("BG2.wav");
    PlayAudio[] HOCKEY_SOUND = new PlayAudio[]{new PlayAudio("bounce.wav"), new PlayAudio("hitPocket.wav")};
    Image GAME_ICON = new ImageIcon(Constants.IMAGE_DIR + "air-hockey.png").getImage();
    static Font DISPLAY_FONT() {
        Font display = null;
        try {
            display = Font.createFont(Font.TRUETYPE_FONT, new File(ASSETS_DIR + "fonts\\Digital Dismay.otf")).deriveFont(Font.PLAIN).deriveFont(80f);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return display;
    }
}
