package maingui;

import gameassets.Constants;
import gameassets.Globals;
import gameobjects.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WinnerScreen extends JFrame implements ScreenInitializer {

    private final Player player;

    public WinnerScreen(Player player) {
        this.player = player;
        initComponents();
    }

    @Override
    public void initComponents() {
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 600, 350);
        panel.setBackground(new Color(160, 230, 240));
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel cup = new JLabel("");
        cup.setBounds(30, 30, 256, 256);
        cup.setIcon(new ImageIcon(Constants.IMAGE_DIR + "winner.png"));
        panel.add(cup);

        JLabel winnerName = new JLabel(player.name + " is the Winner");
//        lblText2.setVerticalAlignment(SwingConstants.TOP);
        winnerName.setFont(mainFont(30, Font.PLAIN));
        winnerName.setHorizontalAlignment(SwingConstants.CENTER);
        winnerName.setBounds(300, 130, 250, 100);
        winnerName.setForeground(Constants.DARK);
        panel.add(winnerName);

        JLabel winnerLogo = new JLabel("Winner!");
        winnerLogo.setHorizontalAlignment(SwingConstants.CENTER);
        winnerLogo.setFont(mainFont(55, Font.PLAIN));
        winnerLogo.setBounds(270, 0, 300, 200);
        winnerLogo.setForeground(Constants.DARK);
        panel.add(winnerLogo);

        getContentPane().setLayout(null);
        setTitle("Game Winner");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(600, 350);
        ImageIcon icon = new ImageIcon(Constants.IMAGE_DIR + "air-hockey.png");
        setIconImage(icon.getImage());
        getContentPane().add(panel);
    }
}
