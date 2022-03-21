/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fc;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Go
 */
public class Look {
    
    public static final void setTableLook(JTable table){
        
        table.setBorder(null);
        DefaultTableCellRenderer head_render = new DefaultTableCellRenderer(); 
        
        head_render.setBackground(new Color(255,255,255));
        head_render.setForeground(new Color(31,58,105));
        table.getTableHeader().setDefaultRenderer(head_render);
        table.setFillsViewportHeight(true);
        table.setDefaultEditor(Object.class, null);
        
        table.setDefaultRenderer(Object.class, new TableCellRenderer(){
            private DefaultTableCellRenderer DEFAULT_RENDERER =  new DefaultTableCellRenderer();
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if(isSelected){
                    c.setBackground(new Color(31, 58, 105));
                }else{
                    if (row%2 == 0){
                        c.setBackground(Color.WHITE);
                    }
                    else {
                        c.setBackground(new Color(230, 230, 240));
                    }     
                }
                return c;
            }
        });
    }
    
    public static final void setComboBoxScrollBar(JComboBox comboBox) {
        comboBox.setUI(new BasicComboBoxUI() {
             @Override
             public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
                ListCellRenderer renderer = comboBox.getRenderer();
                Component c;
                Dimension d;
                c =
                    renderer.getListCellRendererComponent(
                        listBox, comboBox.getSelectedItem(), -1, false, false);
                c.setFont(comboBox.getFont());
                
                if (comboBox.isEnabled()) {
                  c.setForeground(comboBox.getForeground());
                  c.setBackground(comboBox.getBackground());
                } else {
                  c.setForeground(UIManager.getColor("ComboBox.disabledForeground"));
                  c.setBackground(UIManager.getColor("ComboBox.disabledBackground"));
                }
                d = c.getPreferredSize();
//                comboBox.setBorder( BorderFactory.createEmptyBorder(5,5,5,5));
                currentValuePane.paintComponent(g, c, comboBox, bounds.x, bounds.y, bounds.width, d.height);
              }
            @Override
            protected JButton createArrowButton() {
                JButton button = new javax.swing.plaf.basic.BasicArrowButton(
                        javax.swing.plaf.basic.BasicArrowButton.SOUTH,
                        new Color(255, 255, 255),
                        new Color(255, 255, 255),
                        new Color(31, 28, 105),
                        new Color(255, 255, 255));
                button.setName("ComboBox.arrowButton");
                button.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
                return button;
            }
            @Override
            protected ComboPopup createPopup() {
                return new BasicComboPopup(comboBox) {
                    @Override
                    protected JScrollPane createScroller() {
                        JScrollPane scroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                        scroller.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                            @Override
                            protected void configureScrollBarColors() {
                                this.thumbColor = new Color(31, 28, 105);
                                this.trackColor = new Color(255, 255, 255);
                                this.thumbDarkShadowColor = new Color(31, 28, 105);
                            }
                            @Override
                            protected JButton createDecreaseButton(int orientation) {
                                return createZeroButton();
                            }

                            @Override
                            protected JButton createIncreaseButton(int orientation) {
                                return createZeroButton();
                            }

                            @Override
                            public Dimension getPreferredSize(JComponent c) {
                                return new Dimension(10, super.getPreferredSize(c).height);
                            }

                            private JButton createZeroButton() {
                                return new JButton() {
                                    @Override
                                    public Dimension getMinimumSize() {
                                        return new Dimension(new Dimension(0, 0));
                                    }

                                    @Override
                                    public Dimension getPreferredSize() {
                                        return new Dimension(new Dimension(0, 0));
                                    }

                                    @Override
                                    public Dimension getMaximumSize() {
                                        return new Dimension(new Dimension(0, 0));
                                    }
                                };
                            }
                        });
                        return scroller;
                    }
                };
            }
        });
    }
    
    public static final void setScrollBar(JScrollPane s){
        s.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(31, 28, 105);
                this.trackColor = new Color(255, 255, 255);
                this.thumbDarkShadowColor = new Color(31, 28, 105);
            }
            @Override
        protected JButton createDecreaseButton(int orientation) {
            return createZeroButton();
        }

        @Override    
        protected JButton createIncreaseButton(int orientation) {
            return createZeroButton();
        }

        private JButton createZeroButton() {
            JButton jbutton = new JButton();
            jbutton.setPreferredSize(new Dimension(0, 0));
            jbutton.setMinimumSize(new Dimension(0, 0));
            jbutton.setMaximumSize(new Dimension(0, 0));
            return jbutton;
        }
        });
        
    }
    
    
}
