package gameplay;

import gameassets.Constants;
import gameassets.Globals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                Globals.endGame();
            }
        });

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
    }
}
