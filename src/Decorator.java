/*
The Design Patterns Java Companion

Copyright (C) 1998, by James W. Cooper

IBM Thomas J. Watson Research Center

http://www.java2s.com/Code/Java/Design-Pattern/DecoratorpatterninJava.htm

*/
import java.awt.BorderLayout;

import javax.swing.*;

class Decorator extends JComponent {

	public Decorator(JComponent c) {

		super();
		setLayout(new BorderLayout());
		add("Center", c);
	}
	public JComponent getSwingComponent(JComponent c){
		if (c instanceof JButton) return c;
		return getSwingComponent((JComponent) c.getComponents()[0]);
	}
	

}