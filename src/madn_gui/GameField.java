package madn_gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameField extends JPanel
{
	public GameField()
	{
		this.setLayout(new FlowLayout());
		this.add(new JButton("OMG"));
	}
}
