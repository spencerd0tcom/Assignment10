import javax.swing.*;
public class WarGUIDriver 
{

	public static void main(String[] args) 
	{
		JFrame frame = new WarGUI();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1500, 800);
		frame.validate();
		frame.setVisible(true);

	}

}
