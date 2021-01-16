package com.app.colorTable;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class ColorTable implements TableCellRenderer{
	private static final TableCellRenderer RENDERER = new DefaultTableCellRenderer();
	

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,
			int column) {
		// TODO Auto-generated method stub
		Component c = RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		Color clr = null;
        if ((column >= 7)&&(column <= 9)) {
        	Object resultat = table.getModel().getValueAt(row, column);
    		Double aff = Double.parseDouble(resultat.toString());
    		
    		if((aff > 0)) 
    		{
       			 clr = Color.GREEN;
       			 
    			 
    		}else {
    			clr = Color.RED;
      			 
    		}
        }
         else {
        	 clr = Color.BLACK;
          }
        c.setForeground(clr);
        return c;
	}


}
