package gameplay;

import gameassets.Constants;
import gameassets.Globals;

import javax.swing.*;
import java.awt.*;

public class GamePlay extends JFrame {
    public GamePlay() {
        super("Air Hockey");
        initGameComponents();
    }

    /**
     * Initializes the gameplay window components.
     */
    private void initGameComponents() {
        // Dispose when the JFrame is closed
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JPanel gameTopScreen = new JPanel();
        gameTopScreen.setLayout(new GridLayout(1, 3));

        Globals.firstPlayer.score.setHorizontalAlignment(JLabel.LEFT);
        Globals.secondPlayer.score.setHorizontalAlignment(JLabel.RIGHT);

        // Top game screen
        gameTopScreen.setPreferredSize(new Dimension(Constants.SCREEN_WIDTH, 100));
        gameTopScreen.setBorder(BorderFactory.createEmptyBorder(10, 60, 0, 60));
        gameTopScreen.setBackground(Constants.DARK);
        gameTopScreen.add(Globals.firstPlayer.score);
        gameTopScreen.add(Globals.timer.counter);
        gameTopScreen.add(Globals.secondPlayer.score);

        // Add main game listeners
        Globals.glCanvas.addGLEventListener(new MainGame());
        Globals.glCanvas.addKeyListener(new GamePlayListener());
        Globals.glCanvas.requestFocus();

        //add the GLCanvas just like we would any Component
        getContentPane().add(Globals.glCanvas, BorderLayout.CENTER);
        getContentPane().add(gameTopScreen, BorderLayout.NORTH);

        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setResizable(false);
        //center the JFrame on the screen
        setLocationRelativeTo(null);
        //Show what we have done
        setFocusable(true);
        ImageIcon icon = new ImageIcon(Constants.IMAGE_DIR + "air-hockey.png");
        setIconImage(icon.getImage());
        setVisible(true);
        requestFocus();
    }
}
