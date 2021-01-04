package maingui;

import gameassets.Constants;
import gameassets.PlayAudio;

import java.awt.*;
import java.io.File;

public interface ScreenInitializer {
    PlayAudio buttonSound = new PlayAudio("buttonPressed2.wav");

    void initComponents();

    default Font mainFont(float size, int type) {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File(Constants.ASSETS_DIR + "fonts\\chinese rocks rg.ttf")).deriveFont(size);
            font.deriveFont(type);
            return font.deriveFont(type);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return new Font("Arial", Font.PLAIN, (int) size);
    }
}
