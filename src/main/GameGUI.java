package main;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

public class GameGUI extends JFrame {
    private static final String filename = "scores.txt";
    private static int[][] board = new int[4][4];
    private static int currentScore = 0;
    private static String fontStyle = "Arial";
    private int highScore = updateHigh();
    private static boolean ai_not_running = true;
    public static int GOAL = 2048;

    public static Color NUMBER_COLOR = new Color(119, 110, 101);
    public static Color PANEL_BACKGROUND_COLOR = new Color(204, 192, 179);
    public static Color BORDER_COLOR = new Color(187, 173, 160);
    
    public GameGUI() {
        initComponents();
        updateText();
        mainGameFrame.setVisible(false);
        updateColors();
    }
    private void initComponents() {
        mainGameFrame = new JFrame();
        mainPanel = new JPanel();
        winLabel = new JLabel();
        menuPanel = new JPanel();
        tryAgainLabel = new JLabel();
        jPanel0_0 = new JPanel();
        jLbl0_0 = new JLabel();
        jPanel0_1 = new JPanel();
        jLbl0_1 = new JLabel();
        jPanel0_2 = new JPanel();
        jLbl0_2 = new JLabel();
        jPanel0_3 = new JPanel();
        jLbl0_3 = new JLabel();
        jPanel1_0 = new JPanel();
        jLbl1_0 = new JLabel();
        jPanel1_1 = new JPanel();
        jLbl1_1 = new JLabel();
        jPanel1_2 = new JPanel();
        jLbl1_2 = new JLabel();
        jPanel20 = new JPanel();
        jLbl1_3 = new JLabel();
        jPanel2_0 = new JPanel();
        jLbl2_0 = new JLabel();
        jPanel2_1 = new JPanel();
        jLbl2_1 = new JLabel();
        jPanel2_2 = new JPanel();
        jLbl2_2 = new JLabel();
        jPanel2_3 = new JPanel();
        jLbl2_3 = new JLabel();
        jPanel3_0 = new JPanel();
        jLbl3_0 = new JLabel();
        jPanel3_1 = new JPanel();
        jLbl3_1 = new JLabel();
        jPanel3_2 = new JPanel();
        jLbl3_2 = new JLabel();
        jPanel3_3 = new JPanel();
        jLbl3_3 = new JLabel();
        scorePanel = new JPanel();
        currentScoreLabel = new JLabel();
        scoreHeaderLabel = new JLabel();
        bestPanel = new JPanel();
        highScoreLabel = new JLabel();
        bestHighScoreLbl = new JLabel();
        AIButton = new JButton();

        mainGameFrame.setAlwaysOnTop(true);
        mainGameFrame.setMinimumSize(new Dimension(405, 523));
        mainGameFrame.setType(java.awt.Window.Type.POPUP);

        mainPanel.setBackground(new Color(255, 255, 51));

        winLabel.setBackground(new Color(255, 255, 255));
        winLabel.setFont(new Font(fontStyle, 1, 50));
        winLabel.setForeground(new Color(255, 255, 255));
        winLabel.setHorizontalAlignment(SwingConstants.CENTER);
        winLabel.setText("You win!");

        menuPanel.setBackground(new Color(143, 122, 102));

        tryAgainLabel.setFont(new Font(fontStyle, 0, 18));
        tryAgainLabel.setForeground(new Color(255, 255, 255));
        tryAgainLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tryAgainLabel.setText("Try again");
        tryAgainLabel.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				restart();
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        GroupLayout menuPanelLayout = new GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tryAgainLabel)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tryAgainLabel)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(winLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(155, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(menuPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(154, 154, 154))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(winLabel, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menuPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        GroupLayout mainGameFrameLayout = new GroupLayout(mainGameFrame.getContentPane());
        mainGameFrame.getContentPane().setLayout(mainGameFrameLayout);
        mainGameFrameLayout.setHorizontalGroup(
            mainGameFrameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainGameFrameLayout.setVerticalGroup(
            mainGameFrameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(GOAL + "");
        setBackground(new Color(255, 255, 255));
        setCursor(new Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(null);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                arrowKeyHandler(evt);
            }
        });

        jPanel0_0.setBackground(PANEL_BACKGROUND_COLOR);
        jPanel0_0.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 5));
        jPanel0_0.setToolTipText("");
        jPanel0_0.setFocusable(false);

        jLbl0_0.setFont(new Font(fontStyle, 1, 31)); // NOI18N
        jLbl0_0.setForeground(NUMBER_COLOR);
        jLbl0_0.setHorizontalAlignment(SwingConstants.CENTER);
        jLbl0_0.setText("" + board[0][0]);

        GroupLayout jPanel0_0Layout = new GroupLayout(jPanel0_0);
        jPanel0_0.setLayout(jPanel0_0Layout);
        jPanel0_0Layout.setHorizontalGroup(
            jPanel0_0Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel0_0Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl0_0, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel0_0Layout.setVerticalGroup(
            jPanel0_0Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel0_0Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl0_0, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel0_1.setBackground(PANEL_BACKGROUND_COLOR);
        jPanel0_1.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 5));
        jPanel0_1.setToolTipText("");
        jPanel0_1.setMaximumSize(null);

        jLbl0_1.setFont(new Font(fontStyle, 1, 31)); // NOI18N
        jLbl0_1.setForeground(NUMBER_COLOR);
        jLbl0_1.setHorizontalAlignment(SwingConstants.CENTER);
        jLbl0_1.setText("" + board[0][1]);

        GroupLayout jPanel0_1Layout = new GroupLayout(jPanel0_1);
        jPanel0_1.setLayout(jPanel0_1Layout);
        jPanel0_1Layout.setHorizontalGroup(
            jPanel0_1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel0_1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl0_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel0_1Layout.setVerticalGroup(
            jPanel0_1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel0_1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl0_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel0_2.setBackground(PANEL_BACKGROUND_COLOR);
        jPanel0_2.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 5));
        jPanel0_2.setToolTipText("");
        jPanel0_2.setMaximumSize(null);

        jLbl0_2.setFont(new Font(fontStyle, 1, 31)); // NOI18N
        jLbl0_2.setForeground(NUMBER_COLOR);
        jLbl0_2.setHorizontalAlignment(SwingConstants.CENTER);
        jLbl0_2.setText("" + board[0][2]);

        GroupLayout jPanel0_2Layout = new GroupLayout(jPanel0_2);
        jPanel0_2.setLayout(jPanel0_2Layout);
        jPanel0_2Layout.setHorizontalGroup(
            jPanel0_2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel0_2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl0_2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel0_2Layout.setVerticalGroup(
            jPanel0_2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel0_2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl0_2, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel0_3.setBackground(PANEL_BACKGROUND_COLOR);
        jPanel0_3.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 5));
        jPanel0_3.setToolTipText("");
        jPanel0_3.setMaximumSize(null);

        jLbl0_3.setFont(new Font(fontStyle, 1, 31));
        jLbl0_3.setForeground(NUMBER_COLOR);
        jLbl0_3.setHorizontalAlignment(SwingConstants.CENTER);
        jLbl0_3.setText("" + board[0][3]);

        GroupLayout jPanel0_3Layout = new GroupLayout(jPanel0_3);
        jPanel0_3.setLayout(jPanel0_3Layout);
        jPanel0_3Layout.setHorizontalGroup(
            jPanel0_3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel0_3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl0_3, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel0_3Layout.setVerticalGroup(
            jPanel0_3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel0_3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl0_3, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1_0.setBackground(PANEL_BACKGROUND_COLOR);
        jPanel1_0.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 5));
        jPanel1_0.setToolTipText("");
        jPanel1_0.setMaximumSize(null);

        jLbl1_0.setFont(new Font(fontStyle, 1, 31));
        jLbl1_0.setForeground(NUMBER_COLOR);
        jLbl1_0.setHorizontalAlignment(SwingConstants.CENTER);
        jLbl1_0.setText("" + board[1][0]);

        GroupLayout jPanel1_0Layout = new GroupLayout(jPanel1_0);
        jPanel1_0.setLayout(jPanel1_0Layout);
        jPanel1_0Layout.setHorizontalGroup(
            jPanel1_0Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1_0Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl1_0, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1_0Layout.setVerticalGroup(
            jPanel1_0Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1_0Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl1_0, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1_1.setBackground(PANEL_BACKGROUND_COLOR);
        jPanel1_1.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 5));
        jPanel1_1.setToolTipText("");
        jPanel1_1.setMaximumSize(null);

        jLbl1_1.setFont(new Font(fontStyle, 1, 31));
        jLbl1_1.setForeground(NUMBER_COLOR);
        jLbl1_1.setHorizontalAlignment(SwingConstants.CENTER);
        jLbl1_1.setText("" + board[1][1]);

        GroupLayout jPanel1_1Layout = new GroupLayout(jPanel1_1);
        jPanel1_1.setLayout(jPanel1_1Layout);
        jPanel1_1Layout.setHorizontalGroup(
            jPanel1_1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1_1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl1_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1_1Layout.setVerticalGroup(
            jPanel1_1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1_1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl1_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1_2.setBackground(PANEL_BACKGROUND_COLOR);
        jPanel1_2.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 5));
        jPanel1_2.setToolTipText("");
        jPanel1_2.setMaximumSize(null);

        jLbl1_2.setFont(new Font(fontStyle, 1, 31)); // NOI18N
        jLbl1_2.setForeground(NUMBER_COLOR);
        jLbl1_2.setHorizontalAlignment(SwingConstants.CENTER);
        jLbl1_2.setText("" + board[1][2]);

        GroupLayout jPanel1_2Layout = new GroupLayout(jPanel1_2);
        jPanel1_2.setLayout(jPanel1_2Layout);
        jPanel1_2Layout.setHorizontalGroup(
            jPanel1_2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1_2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl1_2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1_2Layout.setVerticalGroup(
            jPanel1_2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1_2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl1_2, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel20.setBackground(PANEL_BACKGROUND_COLOR);
        jPanel20.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 5));
        jPanel20.setToolTipText("");
        jPanel20.setMaximumSize(null);

        jLbl1_3.setFont(new Font(fontStyle, 1, 31)); // NOI18N
        jLbl1_3.setForeground(NUMBER_COLOR);
        jLbl1_3.setHorizontalAlignment(SwingConstants.CENTER);
        jLbl1_3.setText("" + board[1][3]);

        GroupLayout jPanel20Layout = new GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl1_3, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl1_3, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2_0.setBackground(PANEL_BACKGROUND_COLOR);
        jPanel2_0.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 5));
        jPanel2_0.setToolTipText("");
        jPanel2_0.setMaximumSize(null);

        jLbl2_0.setFont(new Font(fontStyle, 1, 31)); // NOI18N
        jLbl2_0.setForeground(NUMBER_COLOR);
        jLbl2_0.setHorizontalAlignment(SwingConstants.CENTER);
        jLbl2_0.setText("" + board[2][0]);

        GroupLayout jPanel2_0Layout = new GroupLayout(jPanel2_0);
        jPanel2_0.setLayout(jPanel2_0Layout);
        jPanel2_0Layout.setHorizontalGroup(
            jPanel2_0Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2_0Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl2_0, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2_0Layout.setVerticalGroup(
            jPanel2_0Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2_0Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl2_0, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2_1.setBackground(PANEL_BACKGROUND_COLOR);
        jPanel2_1.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 5));
        jPanel2_1.setToolTipText("");
        jPanel2_1.setMaximumSize(null);

        jLbl2_1.setFont(new Font(fontStyle, 1, 31)); // NOI18N
        jLbl2_1.setForeground(NUMBER_COLOR);
        jLbl2_1.setHorizontalAlignment(SwingConstants.CENTER);
        jLbl2_1.setText("" + board[2][1]);

        GroupLayout jPanel2_1Layout = new GroupLayout(jPanel2_1);
        jPanel2_1.setLayout(jPanel2_1Layout);
        jPanel2_1Layout.setHorizontalGroup(
            jPanel2_1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2_1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl2_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2_1Layout.setVerticalGroup(
            jPanel2_1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2_1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl2_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2_2.setBackground(PANEL_BACKGROUND_COLOR);
        jPanel2_2.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 5));
        jPanel2_2.setToolTipText("");
        jPanel2_2.setMaximumSize(null);

        jLbl2_2.setFont(new Font(fontStyle, 1, 31)); // NOI18N
        jLbl2_2.setForeground(NUMBER_COLOR);
        jLbl2_2.setHorizontalAlignment(SwingConstants.CENTER);
        jLbl2_2.setText("" + board[2][2]);

        GroupLayout jPanel2_2Layout = new GroupLayout(jPanel2_2);
        jPanel2_2.setLayout(jPanel2_2Layout);
        jPanel2_2Layout.setHorizontalGroup(
            jPanel2_2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2_2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl2_2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2_2Layout.setVerticalGroup(
            jPanel2_2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2_2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl2_2, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2_3.setBackground(PANEL_BACKGROUND_COLOR);
        jPanel2_3.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 5));
        jPanel2_3.setToolTipText("");
        jPanel2_3.setMaximumSize(null);

        jLbl2_3.setFont(new Font(fontStyle, 1, 31)); // NOI18N
        jLbl2_3.setForeground(NUMBER_COLOR);
        jLbl2_3.setHorizontalAlignment(SwingConstants.CENTER);
        jLbl2_3.setText("" + board[2][3]);

        GroupLayout jPanel2_3Layout = new GroupLayout(jPanel2_3);
        jPanel2_3.setLayout(jPanel2_3Layout);
        jPanel2_3Layout.setHorizontalGroup(
            jPanel2_3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2_3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl2_3, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2_3Layout.setVerticalGroup(
            jPanel2_3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2_3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl2_3, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3_0.setBackground(PANEL_BACKGROUND_COLOR);
        jPanel3_0.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 5));
        jPanel3_0.setToolTipText("");
        jPanel3_0.setMaximumSize(null);

        jLbl3_0.setFont(new Font(fontStyle, 1, 31)); // NOI18N
        jLbl3_0.setForeground(NUMBER_COLOR);
        jLbl3_0.setHorizontalAlignment(SwingConstants.CENTER);
        jLbl3_0.setText("" + board[3][0]);

        GroupLayout jPanel3_0Layout = new GroupLayout(jPanel3_0);
        jPanel3_0.setLayout(jPanel3_0Layout);
        jPanel3_0Layout.setHorizontalGroup(
            jPanel3_0Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3_0Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl3_0, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3_0Layout.setVerticalGroup(
            jPanel3_0Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3_0Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl3_0, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3_1.setBackground(PANEL_BACKGROUND_COLOR);
        jPanel3_1.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 5));
        jPanel3_1.setToolTipText("");
        jPanel3_1.setMaximumSize(null);

        jLbl3_1.setFont(new Font(fontStyle, 1, 31)); // NOI18N
        jLbl3_1.setForeground(NUMBER_COLOR);
        jLbl3_1.setHorizontalAlignment(SwingConstants.CENTER);
        jLbl3_1.setText("" + board[3][1]);

        GroupLayout jPanel3_1Layout = new GroupLayout(jPanel3_1);
        jPanel3_1.setLayout(jPanel3_1Layout);
        jPanel3_1Layout.setHorizontalGroup(
            jPanel3_1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3_1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl3_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3_1Layout.setVerticalGroup(
            jPanel3_1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3_1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl3_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3_2.setBackground(PANEL_BACKGROUND_COLOR);
        jPanel3_2.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 5));
        jPanel3_2.setToolTipText("");
        jPanel3_2.setMaximumSize(null);

        jLbl3_2.setFont(new Font(fontStyle, 1, 31)); // NOI18N
        jLbl3_2.setForeground(NUMBER_COLOR);
        jLbl3_2.setHorizontalAlignment(SwingConstants.CENTER);
        jLbl3_2.setText("" + board[3][2]);

        GroupLayout jPanel3_2Layout = new GroupLayout(jPanel3_2);
        jPanel3_2.setLayout(jPanel3_2Layout);
        jPanel3_2Layout.setHorizontalGroup(
            jPanel3_2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3_2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl3_2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3_2Layout.setVerticalGroup(
            jPanel3_2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3_2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl3_2, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3_3.setBackground(PANEL_BACKGROUND_COLOR);
        jPanel3_3.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 5));
        jPanel3_3.setToolTipText("");
        jPanel3_3.setMaximumSize(null);

        jLbl3_3.setFont(new Font(fontStyle, 1, 31)); // NOI18N
        jLbl3_3.setForeground(NUMBER_COLOR);
        jLbl3_3.setHorizontalAlignment(SwingConstants.CENTER);
        jLbl3_3.setText("" + board[3][3]);

        GroupLayout jPanel3_3Layout = new GroupLayout(jPanel3_3);
        jPanel3_3.setLayout(jPanel3_3Layout);
        jPanel3_3Layout.setHorizontalGroup(
            jPanel3_3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3_3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl3_3, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3_3Layout.setVerticalGroup(
            jPanel3_3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3_3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl3_3, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        scorePanel.setBackground(new Color(197, 173, 160));
        scorePanel.setBorder(new LineBorder(BORDER_COLOR, 5, true));
        scorePanel.setMaximumSize(new Dimension(120, 61));
        scorePanel.setMinimumSize(new Dimension(120, 61));
        scorePanel.setName(""); // NOI18N
        scorePanel.setPreferredSize(new Dimension(120, 61));

        currentScoreLabel.setFont(new Font(fontStyle, 1, 24)); // NOI18N
        currentScoreLabel.setForeground(new Color(255, 255, 255));
        currentScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        currentScoreLabel.setText("Score: " + currentScore);

        scoreHeaderLabel.setFont(new Font(fontStyle, 1, 14)); // NOI18N
        scoreHeaderLabel.setForeground(new Color(238, 228, 218));
        scoreHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreHeaderLabel.setText("SCORE");
        scoreHeaderLabel.setMaximumSize(new Dimension(50, 17));
        scoreHeaderLabel.setMinimumSize(new Dimension(50, 17));
        scoreHeaderLabel.setPreferredSize(new Dimension(50, 17));

        GroupLayout scorePanelLayout = new GroupLayout(scorePanel);
        scorePanel.setLayout(scorePanelLayout);
        scorePanelLayout.setHorizontalGroup(
            scorePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(currentScoreLabel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 110, Short.MAX_VALUE)
            .addComponent(scoreHeaderLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        scorePanelLayout.setVerticalGroup(
            scorePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(scorePanelLayout.createSequentialGroup()
                .addComponent(scoreHeaderLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(currentScoreLabel, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
        );

        bestPanel.setBackground(new Color(197, 173, 160));
        bestPanel.setBorder(new LineBorder(BORDER_COLOR, 5, true));
        bestPanel.setMaximumSize(new Dimension(120, 61));
        bestPanel.setMinimumSize(new Dimension(120, 61));
        bestPanel.setPreferredSize(new Dimension(120, 61));

        highScoreLabel.setFont(new Font(fontStyle, 1, 24)); // NOI18N
        highScoreLabel.setForeground(new Color(255, 255, 255));
        highScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        highScoreLabel.setText("Best: " + highScore);

        bestHighScoreLbl.setFont(new Font(fontStyle, 1, 14)); // NOI18N
        bestHighScoreLbl.setForeground(new Color(238, 228, 218));
        bestHighScoreLbl.setHorizontalAlignment(SwingConstants.CENTER);
        bestHighScoreLbl.setText("BEST");
        bestHighScoreLbl.setMaximumSize(new Dimension(37, 17));
        bestHighScoreLbl.setMinimumSize(new Dimension(37, 17));
        bestHighScoreLbl.setName(""); // NOI18N
        bestHighScoreLbl.setPreferredSize(new Dimension(37, 17));

        GroupLayout bestPanelLayout = new GroupLayout(bestPanel);
        bestPanel.setLayout(bestPanelLayout);
        bestPanelLayout.setHorizontalGroup(
            bestPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(highScoreLabel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(bestHighScoreLbl, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        bestPanelLayout.setVerticalGroup(
            bestPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, bestPanelLayout.createSequentialGroup()
                .addComponent(bestHighScoreLbl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(highScoreLabel, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        AIButton.setText("AI");
        AIButton.setFocusable(false);
        AIButton.setRequestFocusEnabled(false);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scorePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bestPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel2_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel2_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel1_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel1_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel0_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel3_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel3_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel3_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel0_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel0_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel0_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addGap(18, 18, 18)
                        .addComponent(AIButton)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(bestPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(scorePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(AIButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel0_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel0_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel0_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel0_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3_3, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        pack();
    }

    private void arrowKeyHandler(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_arrowKeyHandler
//        if (ai_not_running) ai();
        int id = evt.getKeyCode();
        updateBoard(id, true);
        if (currentScore > highScore) {
            highScore = currentScore;
        }
        updateText(); //Score changed, so text needs to be updated
        if (checkWin()) {
            mainGameFrame.setVisible(true);
        }
        if (checkLoss()) {
            winLabel.setText("Game over!");
            winLabel.setForeground(NUMBER_COLOR);
            mainPanel.setBackground(new Color(238, 228, 218));
            mainGameFrame.setVisible(true);
        }
        updateColors(); //If tiles changed numbers, we need to update the colors
    }
//    private void menuPanelMouseClicked(MouseEvent evt) {//GEN-FIRST:event_menuPanelMouseClicked
//        File f = new File(filename);
//        ArrayList<String[]> lines = new ArrayList<>();
//        if(f.exists() && !f.isDirectory()) { 
//            try {
//                Scanner input = new Scanner(new File(filename));
//                while (input.hasNextLine()) {
//                    lines.add(input.nextLine().split(": "));
//                }
//                for (String[] line: lines) {
//                    line[0] += ": ";
//                    line[2] = ": " + line[2];
//                }
//                String[] now = {nameTxtField.getText() + ": ", "" + currentScore, ": " + highestTile()};
//                lines.add(now);
//                Comparator<String[]> custom;
//                custom = new Comparator<String[]>() {
//                    @Override
//                    public int compare(String[] a1, String[] a2) {
//                        return Integer.parseInt(a2[1]) - Integer.parseInt(a1[1]);
//                    }
//                }
//                ;
//                Collections.sort(lines, custom);
//                input.close();
//            } catch (FileNotFoundException ex) {
//                ex.printStackTrace();
//            }
//        }
//        else {
//            String[] now = {nameTxtField.getText() + ": ", "" + currentScore, ": " + highestTile()};
//            lines.add(now);
//        }
//        PrintWriter writer = null;
//        try {
//            writer = new PrintWriter(filename, "UTF-8");
//            for (String[] s: lines) {
//                for (String s1: s) {
//                    writer.print(s1);
//                }
//                writer.println();
//            }
//        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
//            ex.printStackTrace();
//        } finally {
//            writer.close();
//        }
//        restart();
//        updateText();
//        updateColors();
//        nameTxtField.setText("Enter your name");
//        mainGameFrame.setVisible(false);
//        updateHigh();
//    }

    public static void printBoard(int[][] board) {
        for (int[] a: board) {
            for (int i : a)
                System.out.print(i + " ");
            System.out.println();
        }
    }
    private void updateBoard(int n, boolean real) {
    	int[][] before = copyBoard(board);
    	if (n == KeyEvent.VK_LEFT) {
            pushLeft();
            //check tiles with x > 0, from left to right to see if they collapse
            joinTiles(real);
            pushLeft();
            addNewTile(before);
        }
        else if (n == KeyEvent.VK_UP) {
            rotateCCW();
            updateBoard(KeyEvent.VK_LEFT, real);
            //Reverse effects
            rotateCW();
        }
        else if (n == KeyEvent.VK_RIGHT) {
            rotateCCW();
            rotateCCW();
            updateBoard(KeyEvent.VK_LEFT, real);
            //Reverse effects
            rotateCW();
            rotateCW();
        	
        }
        else if (n == KeyEvent.VK_DOWN) {
            rotateCW();
            updateBoard(KeyEvent.VK_LEFT, real);
            //Reverse effects
            rotateCCW();
        }
    }
    private void addNewTile(int[][] before){
    	if (!Arrays.deepEquals(before, board)) {
            ArrayList<int[]> a = new ArrayList<int[]>();
            //Gather all Empty Tiles left on the board
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (board[i][j] == 0) {
                        int[] coords = {i, j};
                        a.add(coords);
                    }
                }
            }
            //Shuffle arraylist around
            Collections.shuffle(a);
            int random = (int) (Math.random() * 10);
            if (random < 2) {
            	board[a.get(0)[0]][a.get(0)[1]] = 4;
            } else{
            	//Higher chance of getting a 2
            	board[a.get(0)[0]][a.get(0)[1]] = 2;
            }
        }
    }
    private void joinTiles(boolean real){
    	for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
            	//If two consecutive numbers found, add them together
                if (board[i][j-1] == board[i][j]) {
                    board[i][j-1] *= 2;
                    //If we are checking if the user could hypothetically move, then 
                    //this will not run
                    if (real) {
                        currentScore += board[i][j-1];
                    }
                    board[i][j] = 0; //temporarily leave a 0 which will go away when we push again
                }
            }
        }
    }
    private void pushLeft() {
        //move tiles with values as far left as possible
        for (int i = 0; i < 4; i++) {
            int[] row = new int[4];
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != 0) {
                    int curr = 0;
                    while(row[curr] != 0) {
                        curr++;
                    }
                    //Found, empty cell so moving it over
                    row[curr] = board[i][j];
                }
            }
            board[i] = row;
        }
    }
    private void rotateCW() {
        int[][] rotated = new int[4][4];
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                rotated[c][3-r] = board[r][c];
            }
        }
        board = rotated;
    }
    private void rotateCCW() {
        int[][] rotated = new int[4][4];
        for (int r = 0; r < 4; r++) {
        	for (int c = 0; c < 4; c++) {
        		rotated[3-c][r] = board[r][c];
        	}
        }
        board = rotated;
    }
    private static void restart() {
            currentScore = 0;
            board = new int[4][4];
            int[] pos1 = {(int) (Math.random() * 3), (int) (Math.random() * 3)};
            int value1 = ((int) (Math.random() * 2) + 1) * 2;
            int[] pos2 = {(int) (Math.random() * 3), (int) (Math.random() * 3)};
            while (pos1[0] == pos2[0] && pos1[1] == pos2[1]) {
                    int[] temp = {(int) (Math.random() * 3), (int) (Math.random() * 3)};
                    pos2 = temp;
            }
            int value2 = ((int) (Math.random() * 2) + 1) * 2;
            board[pos1[0]][pos1[1]] = value1;
            board[pos2[0]][pos2[1]] = value2;
    }
    private static int[][] copyBoard(int[][] board) {
        int[][] copy = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                copy[i][j] = board[i][j];
            }
        }
        return copy;
    }
    private void updateText() {
        jLbl0_0.setText(board[0][0] == 0 ? "": "" + board[0][0]);
        jLbl0_1.setText(board[0][1] == 0 ? "": "" + board[0][1]);
        jLbl0_2.setText(board[0][2] == 0 ? "": "" + board[0][2]);
        jLbl0_3.setText(board[0][3] == 0 ? "": "" + board[0][3]);
        jLbl1_0.setText(board[1][0] == 0 ? "": "" + board[1][0]);
        jLbl1_1.setText(board[1][1] == 0 ? "": "" + board[1][1]);
        jLbl1_2.setText(board[1][2] == 0 ? "": "" + board[1][2]);
        jLbl1_3.setText(board[1][3] == 0 ? "": "" + board[1][3]);
        jLbl2_0.setText(board[2][0] == 0 ? "": "" + board[2][0]);
        jLbl2_1.setText(board[2][1] == 0 ? "": "" + board[2][1]);
        jLbl2_2.setText(board[2][2] == 0 ? "": "" + board[2][2]);
        jLbl2_3.setText(board[2][3] == 0 ? "": "" + board[2][3]);
        jLbl3_0.setText(board[3][0] == 0 ? "": "" + board[3][0]);
        jLbl3_1.setText(board[3][1] == 0 ? "": "" + board[3][1]);
        jLbl3_2.setText(board[3][2] == 0 ? "": "" + board[3][2]);
        jLbl3_3.setText(board[3][3] == 0 ? "": "" + board[3][3]);
        currentScoreLabel.setText("" + currentScore);
        highScoreLabel.setText("" + highScore);
    }
    private void updateColors() {
        JPanel[] numberPanelContainers = {jPanel0_0, jPanel0_1, jPanel0_2, jPanel0_3, jPanel1_0, jPanel1_1, jPanel1_2, jPanel20, jPanel2_0, jPanel2_1, jPanel2_2, jPanel2_3, jPanel3_0, jPanel3_1, jPanel3_2, jPanel3_3};
        JLabel[] numbers = {jLbl0_0, jLbl0_1, jLbl0_2, jLbl0_3, jLbl1_0, jLbl1_1, jLbl1_2, jLbl1_3, jLbl2_0, jLbl2_1, jLbl2_2, jLbl2_3, jLbl3_0, jLbl3_1, jLbl3_2, jLbl3_3};
        for (int i = 0; i < numberPanelContainers.length; i++) {
            if (numbers[i].getText().equals("")) {
            	numberPanelContainers[i].setBackground(PANEL_BACKGROUND_COLOR);
            	numbers[i].setForeground(NUMBER_COLOR);
            }
            else if (numbers[i].getText().equals("2")) {
            	numberPanelContainers[i].setBackground(new Color(238, 228, 218));
            	numbers[i].setForeground(NUMBER_COLOR);
            }
            else if (numbers[i].getText().equals("4")) {
            	numberPanelContainers[i].setBackground(new Color(237, 224, 200));
            	numbers[i].setForeground(NUMBER_COLOR);
            }
            else if (numbers[i].getText().equals("8")){
            	numberPanelContainers[i].setBackground(new Color(242, 177, 121));
            	numbers[i].setForeground(new Color(255, 255, 255));
            }
            else if (numbers[i].getText().equals("16")){
            	numberPanelContainers[i].setBackground(new Color(245, 149, 99));
            	numbers[i].setForeground(new Color(255, 255, 255));
            }
            else if (numbers[i].getText().equals("32")){
            	numberPanelContainers[i].setBackground(new Color(246, 124, 95));
            	numbers[i].setForeground(new Color(255, 255, 255));
            }
            else if (numbers[i].getText().equals("64")){
            	numberPanelContainers[i].setBackground(new Color(246, 94, 59));
            	numbers[i].setForeground(new Color(255, 255, 255));
            }
            else if (numbers[i].getText().equals("128")){
            	numberPanelContainers[i].setBackground(new Color(237, 207, 114));
            	numbers[i].setForeground(new Color(255, 255, 255));
            }
            else if (numbers[i].getText().equals("256")){
            	numberPanelContainers[i].setBackground(new Color(237, 204, 97));
            	numbers[i].setForeground(new Color(255, 255, 255));
            }
            else if (numbers[i].getText().equals("512")){
            	numberPanelContainers[i].setBackground(new Color(237, 200, 80));
            }
            else if (numbers[i].getText().equals("1024")){
            	numberPanelContainers[i].setBackground(new Color(237, 197, 63));
            	numbers[i].setForeground(new Color(255, 255, 255));
            }
            else if (numbers[i].getText().equals("2048")){
            	numberPanelContainers[i].setBackground(new Color(237, 194, 46));
            	numbers[i].setForeground(new Color(255, 255, 255));
            }
            else {
            	numberPanelContainers[i].setBackground(new Color(0, 0, 0));
            	numbers[i].setForeground(new Color(255, 255, 255));
            }
        }
    }
    private boolean checkWin() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == GOAL) 
                	return true;
            }
        }
        return false;
    }
    private boolean checkLoss() {
    	//Make copy of board since we are going to change the real board
    	//This will be copied back to original board if a move was detected
        int[][] before = copyBoard(board);
        boolean leftChange = true;
        //Make 'real' false so we don't make any moves, only check if the push left
        //would change anything
        updateBoard(KeyEvent.VK_LEFT, false);
        if (Arrays.deepEquals(before, board)) 
        	leftChange = false;
        board = before;
        boolean upChange = true;
        updateBoard(KeyEvent.VK_UP, false);
        if (Arrays.deepEquals(before, board))
        	upChange = false;
        board = before;
        boolean rightChange = true;
        updateBoard(KeyEvent.VK_RIGHT, false);
        if (Arrays.deepEquals(before, board)) 
        	rightChange = false;
        board = before;
        boolean downChange = true;
        updateBoard(KeyEvent.VK_DOWN, false);
        if (Arrays.deepEquals(before, board)) 
        	downChange = false;
        board = before;
        return !(leftChange || upChange || rightChange || downChange);
//        if (leftChange || upChange || rightChange || downChange) return false;
//        return true;
    }
    private int highestTile() {
        int max = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] > max) 
                	max = board[i][j];
            }
        }
        return max;
    }
    private int updateHigh() {
        try {
            Scanner input = new Scanner(new File(filename));
            ArrayList<String[]> lines = new ArrayList<>();
            while (input.hasNextLine())
                lines.add(input.nextLine().split(": "));
            for (String[] a: lines) {
                if (Integer.parseInt(a[1]) > highScore) {
                    highScore = Integer.parseInt(a[1]);
                }
            }
            input.close();
        } catch (FileNotFoundException ex) {
            //return 0 if file doesn't exist; file will be created later
            return 0;
        }
        return highScore;
    }
//    private void ai() {
//        if (ai) {
//            ai_not_running = false;
//            new SwingWorker<Integer, Integer>() {
//                protected Integer doInBackground() {
//                    final AI ai = new AI();
//                    nameTxtField.setText(ai_name);
//                    if (ai_autoRestart) {
//                        int totalScore = 0;
//                        int totalWins = 0;
//                        int totalLosses = 0;
//                        int trialHighScore = 0;
//                        int trialLowScore = Integer.MAX_VALUE;
//                        int highTile = 0;
//                        ArrayList<Integer> tileFreq = new ArrayList<>();
//                        int trials = ai_trials;
//                        while (ai_autoRestart) {
//                            int id = ai.ai_move(copyBoard(board));
//                            updateBoard(id, true);
//                            publish(0);
//                            try {
//                                Thread.sleep(sleep_time);
//                            } catch(InterruptedException ex) {
//                                Thread.currentThread().interrupt();
//                            }
//                            //no high score stuff
//                            if (checkWin()) {
//                                totalWins++;
//                                totalScore += currentScore;
//                                if (currentScore > trialHighScore) trialHighScore = currentScore;
//                                if (currentScore < trialLowScore) trialLowScore = currentScore;
//                                if (highestTile() > highTile) highTile = highestTile();
//                                restart();
//                                updateText();
//                                updateColors();
//                                ai_trials--;
//                            }
//                            if (checkLoss()) {
//                                totalLosses++;
//                                totalScore += currentScore;
//                                if (currentScore > trialHighScore) trialHighScore = currentScore;
//                                if (currentScore < trialLowScore) trialLowScore = currentScore;
//                                if (highestTile() > highTile) highTile = highestTile();
//                                restart();
//                                updateText();
//                                updateColors();
//                                ai_trials--;
//                            }
//                            if (ai_trials == 0) ai_autoRestart = false;
//                            tileFreq.add(highTile);
//                            highTile = 0;
//                        }
//                        double averageScore = totalScore / trials;
//                        double winPercent = 100.0 * totalWins / (totalWins + totalLosses);
//                        int[] freqs = new int[11];
//                        freqs[0] = Collections.frequency(tileFreq, 2048);
//                        freqs[1] = Collections.frequency(tileFreq, 1024) + freqs[0];
//                        freqs[2] = Collections.frequency(tileFreq, 512) + freqs[1];
//                        freqs[3] = Collections.frequency(tileFreq, 256) + freqs[2];
//                        freqs[4] = Collections.frequency(tileFreq, 128) + freqs[3];
//                        freqs[5] = Collections.frequency(tileFreq, 64) + freqs[4];
//                        freqs[6] = Collections.frequency(tileFreq, 32) + freqs[5];
//                        freqs[7] = Collections.frequency(tileFreq, 16) + freqs[6];
//                        freqs[8] = Collections.frequency(tileFreq, 8) + freqs[7];
//                        freqs[9] = Collections.frequency(tileFreq, 4) + freqs[8];
//                        freqs[10] = Collections.frequency(tileFreq, 2) + freqs[9];
//                        System.out.println("AI: " + ai_name);
//                        System.out.println("# of trials: " + trials);
//                        System.out.println("average score = " + averageScore);
//                        System.out.println("win percent = " + winPercent + "%");
//                        System.out.println("high score = " + trialHighScore);
//                        System.out.println("low score = " + trialLowScore);
//                        System.out.println("Tile frequenceies: ");
//                        System.out.println("2048: " + freqs[0] * 100.0 / trials + "%");
//                        System.out.println("1024: " + freqs[1] * 100.0 / trials + "%");
//                        System.out.println("512: " + freqs[2] * 100.0 / trials + "%");                        
//                        System.out.println("256: " + freqs[3] * 100.0 / trials + "%");
//                        System.out.println("128: " + freqs[4] * 100.0 / trials + "%");
//                        System.out.println("64: " + freqs[5] * 100.0 / trials + "%");
//                        System.out.println("32: " + freqs[6] * 100.0 / trials + "%");
//                        System.out.println("16: " + freqs[7] * 100.0 / trials + "%");
//                        System.out.println("8: " + freqs[8] * 100.0 / trials + "%");
//                        System.out.println("4: " + freqs[9] * 100.0 / trials + "%");
//                        System.out.println("2: " + freqs[10] * 100.0 / trials + "%");
//                        ai_autoRestart = true;
//                        ai_not_running = true;
//                    }
//                    while (!checkWin() && !checkLoss() && !ai_autoRestart) {
//                        int id = ai.ai_move(copyBoard(board));
//                        updateBoard(id, true);
//                        publish(0);
//                        if (currentScore > highScore) {
//                            highScore = currentScore;
//                        }
//                        try {
//                            Thread.sleep(sleep_time);
//                        } catch(InterruptedException ex) {
//                            Thread.currentThread().interrupt();
//                        }
//                    }
//                    if (checkWin()) {
//                        mainGameFrame.setVisible(true);
//                    }
//                    if (checkLoss()) {
//                        winLabel.setText("Game over!");
//                        winLabel.setForeground(NUMBER_COLOR);
//                        mainPanel.setBackground(new Color(238, 228, 218));
//                        mainGameFrame.setVisible(true);
//                    }
//                    return 0;
//                }
//                protected void process(List<Integer> e) {
//                    updateText();
//                    updateColors();
//                }
//            }.execute();
//        }
//    }
    public static void main(String args[]) {
        restart();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameGUI().setVisible(true);
            }
        });
    }

    private JButton AIButton;
    private JFrame mainGameFrame;
    private JLabel jLbl0_0;
    private JLabel jLbl2_1;
    private JLabel jLbl2_2;
    private JLabel jLbl2_3;
    private JLabel jLbl3_0;
    private JLabel jLbl3_1;
    private JLabel jLbl3_2;
    private JLabel jLbl3_3;
    private JLabel currentScoreLabel;
    private JLabel highScoreLabel;
    private JLabel scoreHeaderLabel;
    private JLabel jLbl0_1;
    private JLabel bestHighScoreLbl;
    private JLabel winLabel;
    private JLabel tryAgainLabel;
    private JLabel jLbl0_2;
    private JLabel jLbl0_3;
    private JLabel jLbl1_0;
    private JLabel jLbl1_1;
    private JLabel jLbl1_2;
    private JLabel jLbl1_3;
    private JLabel jLbl2_0;
    private JPanel mainPanel;
    private JPanel jPanel0_3;
    private JPanel jPanel1_0;
    private JPanel jPanel1_1;
    private JPanel jPanel1_2;
    private JPanel menuPanel;
    private JPanel jPanel20;
    private JPanel scorePanel;
    private JPanel jPanel2_0;
    private JPanel jPanel2_1;
    private JPanel jPanel2_2;
    private JPanel jPanel2_3;
    private JPanel jPanel3_0;
    private JPanel jPanel3_1;
    private JPanel jPanel3_2;
    private JPanel jPanel3_3;
    private JPanel bestPanel;
    private JPanel jPanel0_0;
    private JPanel jPanel0_1;
    private JPanel jPanel0_2;
}