package airhockeygame;

import gameassets.Globals;
import maingui.StartScreen;

import javax.swing.SwingUtilities;

public class AirHockeyGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Start the game
        SwingUtilities.invokeLater(() -> Globals.startScreen.setVisible(true));
        // Show current active threads
        System.err.println("Threads Running: " + Thread.activeCount());
    }
}
