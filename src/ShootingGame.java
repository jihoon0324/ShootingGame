import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

public class ShootingGame extends JFrame {
	private Image bufferImage;
	private Graphics screenGraph;
	// imageIcon class call image
	private Image mainScreen = new ImageIcon("res/main_screen.png").getImage();
	// press Enter call loading image
	private Image loadingScreen = new ImageIcon("res/loading_screen.png").getImage();
	private Image gameScreen = new ImageIcon("res/game_screen.png").getImage();

	private boolean isMainScreen, isLoadingScreen, isGameScreen;

	public ShootingGame() {
		// title bar
		setTitle("Shooting Game");
		// make frames "x" button if false
		// Not make frames "x" button if true
		setUndecorated(true);
		setSize(Main.Screen_width, Main.Screen_hight);
		// size change
		setResizable(false);
		// display center
		setLocationRelativeTo(null);
		// when close the program , process closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);

		init();

	}

	// 초기화 해줄 메소드
	private void init() {
		isMainScreen = true;
		isLoadingScreen = false;
		isGameScreen = false;
		addKeyListener(new keyListner());
	}

	// for change screen loading
	private void gameStart() {
		isMainScreen =false;
		isLoadingScreen=true;
		
		Timer loadingTimer = new Timer();
		TimerTask loadingTask =new TimerTask() {
			@Override
			public void run() {
				isLoadingScreen= false;
				isGameScreen=true;
			}
		};
		// after loading 3 second than change to game screen
		loadingTimer.schedule(loadingTask, 3000);
		
	}

	// make buffer image , 화면의 깜빡임을 최소화 하는 용도
	public void paint(Graphics g) {

		bufferImage = createImage(Main.Screen_width, Main.Screen_hight);
		screenGraph = bufferImage.getGraphics();
		screenDraw(screenGraph);
		// bufferImage: 불러올이미지, 그림이 그려질 x 좌표 , 그림이 그려질 y 좌표, observer:불러오는 이미지가 큰경우 메소드는
		// 실행이 끝났지만 이미지가 로딩중일때 정상적으로 다 로딩되었다는것을 알리기 위한 용도
		// g.drawImage(bufferImage,x,y.observer)
		g.drawImage(bufferImage, 0, 0, null);

	}

	public void screenDraw(Graphics g) {
		if (isMainScreen) {
			g.drawImage(mainScreen, 0, 0, null);
		}
		if (isLoadingScreen) {
			g.drawImage(loadingScreen, 0, 0, null);
		}
		if (isGameScreen) {
			g.drawImage(gameScreen, 0, 0, null);
		}

		this.repaint();
	}

	// keyListner
	class keyListner extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			// close when press "esc"
			case KeyEvent.VK_ESCAPE:
				System.exit(0);
				break;
			case KeyEvent.VK_ENTER:
				if(isMainScreen) {
					gameStart();
				}
				break;
			}
		}

	}

}
