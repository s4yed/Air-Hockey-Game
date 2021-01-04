package gameplay;

import gameassets.Constants;
import gameassets.Globals;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlayListener implements KeyListener {
    GamePlayListener() {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_PAUSE) {
            try {
                Globals.pauseGame();
                Constants.MAIN_MUSIC.stop();
                Object[] options = {"Resume", "Main Menu"};
                int n = JOptionPane.showOptionDialog(Globals.gamePlay, "Do you want to resume the game?", "",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                if (n == JOptionPane.YES_OPTION) Globals.resumeGame();
                else if (n == JOptionPane.NO_OPTION) Globals.endGame();
                else Globals.endGame();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
