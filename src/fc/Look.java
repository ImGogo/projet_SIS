/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fc;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicScrollBarUI;
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
