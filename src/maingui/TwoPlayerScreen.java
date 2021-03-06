package maingui;

import gameassets.Constants;
import gameassets.Globals;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class TwoPlayerScreen extends javax.swing.JFrame implements ScreenInitializer {

    private static TwoPlayerScreen twoPlayerScreen = null;

    /**
     * Creates new form TwoPlayers
     */
    private TwoPlayerScreen() {
        initComponents();
    }

    public static TwoPlayerScreen getInstance() {
        if (twoPlayerScreen == null) {
            twoPlayerScreen = new TwoPlayerScreen();
            twoPlayerScreen.setVisible(true);
        }
        return twoPlayerScreen;
    }

    public void removeInstance() {
        twoPlayerScreen = null;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        firstPlayerField = new javax.swing.JTextField();
        multiPlayerButton = new javax.swing.JButton();
        mediumLevel = new javax.swing.JLabel();
        player1Label = new javax.swing.JLabel();
        levelsSlider = new javax.swing.JSlider();
        levels = new javax.swing.JLabel();
        hardLevel = new javax.swing.JLabel();
        easyLevel = new javax.swing.JLabel();
        player2Label = new javax.swing.JLabel();
        secondPlayerField = new javax.swing.JTextField();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Two Players");
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(Constants.GAME_ICON);

        jPanel1.setBackground(Constants.DARK);
        jPanel1.setForeground(Constants.LIGHT);

        firstPlayerField.setBackground(Constants.LIGHT);
        firstPlayerField.setFont(mainFont(25, Font.PLAIN));
        firstPlayerField.setForeground(Constants.DARK);
        firstPlayerField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        firstPlayerField.setText("Name");
        firstPlayerField.setBorder(null);
        firstPlayerField.setPreferredSize(new java.awt.Dimension(300, 70));
        firstPlayerField.setSelectedTextColor(Constants.LIGHT);
        firstPlayerField.setSelectionColor(Constants.DARK);

        multiPlayerButton.setBackground(Constants.LIGHT);
        multiPlayerButton.setFont(mainFont(50, Font.BOLD));
        multiPlayerButton.setForeground(Constants.DARK);
        multiPlayerButton.setText("Start");
        multiPlayerButton.setToolTipText("");
        multiPlayerButton.setBorder(null);
        multiPlayerButton.setBorderPainted(false);
        multiPlayerButton.setFocusPainted(false);
        multiPlayerButton.setFocusable(false);
        multiPlayerButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        multiPlayerButton.setPreferredSize(new java.awt.Dimension(200, 70));
        multiPlayerButton.setRequestFocusEnabled(false);
        multiPlayerButton.addActionListener(this::multiPlayerButtonActionPerformed);

        mediumLevel.setBackground(Constants.DARK);
        mediumLevel.setFont(mainFont(20, Font.PLAIN));
        mediumLevel.setForeground(Constants.LIGHT);
        mediumLevel.setText("medium");
        mediumLevel.setFocusable(false);
        mediumLevel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mediumLevel.setRequestFocusEnabled(false);

        player1Label.setBackground(Constants.DARK);
        player1Label.setFont(mainFont(35, Font.BOLD));
        player1Label.setForeground(Constants.LIGHT);
        player1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player1Label.setText("1st PLayer Name");
        player1Label.setFocusable(false);
        player1Label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        player1Label.setRequestFocusEnabled(false);

        levelsSlider.setBackground(Constants.DARK);
        levelsSlider.setForeground(Constants.LIGHT);
        levelsSlider.setMaximum(3);
        levelsSlider.setMinimum(1);
        levelsSlider.setValue(2);
        levelsSlider.setFocusable(false);
        levelsSlider.addChangeListener(e -> levelStateChanged());

        levels.setBackground(Constants.DARK);
        levels.setFont(mainFont(35, Font.BOLD));
        levels.setForeground(Constants.LIGHT);
        levels.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        levels.setText("Level");
        levels.setFocusable(false);
        levels.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        levels.setRequestFocusEnabled(false);

        hardLevel.setBackground(Constants.DARK);
        hardLevel.setFont(mainFont(20, Font.PLAIN));
        hardLevel.setForeground(Constants.LIGHT);
        hardLevel.setText("hard");
        hardLevel.setFocusable(false);
        hardLevel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        hardLevel.setRequestFocusEnabled(false);

        easyLevel.setBackground(Constants.DARK);
        easyLevel.setFont(mainFont(20, Font.PLAIN));
        easyLevel.setForeground(Constants.LIGHT);
        easyLevel.setText("easy");
        easyLevel.setFocusable(false);
        easyLevel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        easyLevel.setRequestFocusEnabled(false);

        player2Label.setBackground(Constants.DARK);
        player2Label.setFont(mainFont(35, Font.BOLD));
        player2Label.setForeground(Constants.LIGHT);
        player2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player2Label.setText("2nd PLayer Name");
        player2Label.setFocusable(false);
        player2Label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        player2Label.setRequestFocusEnabled(false);

        secondPlayerField.setBackground(Constants.LIGHT);
        secondPlayerField.setFont(mainFont(25, Font.PLAIN)
        );
        secondPlayerField.setForeground(Constants.DARK);
        secondPlayerField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        secondPlayerField.setText("Name2");
        secondPlayerField.setBorder(null);
        secondPlayerField.setPreferredSize(new java.awt.Dimension(300, 70));
        secondPlayerField.setSelectedTextColor(Constants.LIGHT);
        secondPlayerField.setSelectionColor(Constants.DARK);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(128, 128, 128)
                                                .addComponent(firstPlayerField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(74, 74, 74)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(54, 54, 54)
                                                                .addComponent(secondPlayerField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(player2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(player1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(52, 82, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(levels, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(levelsSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(3, 3, 3)
                                                                .addComponent(easyLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(mediumLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(hardLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(113, 113, 113))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(multiPlayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(134, 134, 134))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(player1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(firstPlayerField, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(player2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(secondPlayerField, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(levels, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(levelsSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(easyLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(mediumLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(hardLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(multiPlayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void multiPlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Globals.firstPlayer.name = firstPlayerField.getText();
        Globals.secondPlayer.name = secondPlayerField.getText();
        buttonSound.play(false);
        if (!(Globals.firstPlayer.name.equals("") || Globals.secondPlayer.name.equals(""))) {
            this.dispose();
            Globals.isSingleMode = false;
            Globals.startGame();
        }
    }

    private void levelStateChanged() {
        switch (levelsSlider.getValue()) {
            case 1 -> Globals.gameLevel = Constants.LEVELS.EASY;
            case 3 -> Globals.gameLevel = Constants.LEVELS.HARD;
            default -> Globals.gameLevel = Constants.LEVELS.MEDIUM;
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider levelsSlider;
    private javax.swing.JLabel mediumLevel;
    private javax.swing.JLabel levels;
    private javax.swing.JLabel hardLevel;
    private javax.swing.JLabel easyLevel;
    private javax.swing.JButton multiPlayerButton;
    private javax.swing.JTextField firstPlayerField;
    private javax.swing.JTextField secondPlayerField;
    private javax.swing.JLabel player1Label;
    private javax.swing.JLabel player2Label;
    // End of variables declaration
}
