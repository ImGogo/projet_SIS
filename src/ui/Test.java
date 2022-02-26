package ui;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
//from w ww. ja v a  2  s  .com
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Test {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setUndecorated(true);
    frame.setBackground(new Color(0, 0, 0, 0));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(new ShadowPane());

    JPanel panel = new JPanel(new GridBagLayout());
    panel.add(new JLabel("Look ma, no hands"));

    frame.add(panel);
    frame.pack();
    frame.setVisible(true);
  }
}