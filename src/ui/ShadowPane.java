/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.sun.awt.AWTUtilities;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author Go
 */
public class ShadowPane extends JPanel {

  public ShadowPane() {
    setLayout(new BorderLayout());
//    setOpaque(false);
    setBackground(Color.BLACK);
    setBorder(new EmptyBorder(0, 0, 15, 15));
    this.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
    
  }

//  @Override
//  public Dimension getPreferredSize() {
//    return new Dimension(200, 200);
//  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();
    g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
    g2d.fillRect(10, 10, getWidth(), getHeight());
    g2d.dispose();
  }
}
