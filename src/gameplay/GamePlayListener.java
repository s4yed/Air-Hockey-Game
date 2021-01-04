package gameplay;

import gameassets.Constants;
import gameassets.Globals;

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
                Globals.timer.counter.setText("PAUSE");
                Globals.pauseGame();
                Constants.MAIN_MUSIC.stop();
                new maingui.PauseScreen().setVisible(true);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
