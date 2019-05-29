package ui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameTest extends WindowAdapter {
	Frame f;
	Button b;

	public FrameTest() {
		makeUi();
	}

	public void makeUi() {
		f = new Frame();
		b = new Button("Click");
		f.add(b);
		f.setSize(300, 200);
		f.setVisible(true);
		f.addWindowListener(new Mywindow());
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				b.setBackground(Color.red);
			}
		});
	}

	class Mywindow extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			super.windowClosing(e);
			f.setVisible(false);
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new FrameTest();
	}
}
