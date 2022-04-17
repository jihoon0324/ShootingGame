import javax.swing.*;
import java.awt.*;
public class ShootingGame  extends JFrame{
	private Image bufferImage;
	private Graphics screenGraph;
	// imageIcon class  call image
	private Image mainScreen = new ImageIcon("res/main_screen.png").getImage();
	
	public ShootingGame() {
		// title bar
		setTitle("Shooting Game");
		// make  frames  "x" button if false
		//  Not make frames "x" button if true
		setUndecorated(true);
		setSize(Main.Screen_width,  Main.Screen_hight);
		// size change
		setResizable(false);
		// display center 
		setLocationRelativeTo(null);
		// when close the program , process closed  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		
		
	}
	public void paint(Graphics g) {
		
		bufferImage =createImage(Main.Screen_width,  Main.Screen_hight);
		screenGraph = bufferImage.getGraphics();
		
	}
	
	public void screenDraw(Graphics g) {
		
	}
	
	
}
