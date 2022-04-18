import java.awt.Image;
import java.awt.*;
import javax.swing.ImageIcon;

//player 움직임 구현
public class Game extends Thread {
	// 게임의 딜레이마다 증가 할 cnt를 선언해주고 이 cnt 가 이벤트 발생 주기를 컨트롤 하는 변수가 된다
	private int delay = 20;
	private long pretime;
	private int cnt;

	private Image player = new ImageIcon("res/player.png").getImage();

//player 변수
	private int playerX, playerY;
	private int playerWidth = player.getWidth(null);
	private int playerHeight = player.getHeight(null);
// play 가 한번 키를 입력했을때 이동할 거리 	
	private int playerSpeed = 10;
	private int playerHP = 30;

	private boolean up, down, left, right;

	@Override
	public void run() {
		cnt = 0;
		playerX = 0;
		playerY = (Main.Screen_hight - playerHeight) / 2;
		// cnt 를 앞서 설정한 delay 지날때마다 증가
		while (true) {
			pretime = System.currentTimeMillis();
			if (System.currentTimeMillis() - pretime < delay) {
				try {
					// 차이만큼 sleep
					Thread.sleep(delay - System.currentTimeMillis() + pretime);
					
					keyProcess();
					cnt++;
				} catch (InterruptedException e) {

				}
			}

		}
	}
	
	private void keyProcess() {
		// 화면에서 안나가는선 조정
		if(up && playerY -playerSpeed >0) playerY-=playerSpeed;
		if(down && playerY +playerHeight +playerSpeed <Main.Screen_hight) playerY+= playerSpeed;
		if(left && playerX -playerSpeed >0) playerX -= playerSpeed;
		if(right && playerX +playerWidth +playerSpeed <Main.Screen_width) playerX += playerSpeed;
		
	}
	
	
	public void gameDraw(Graphics g) {
		playerDraw(g);
	}
	
	public void playerDraw(Graphics g) {
		g.drawImage(player,playerX,playerY,null);
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public void setRight(boolean right) {
		this.right = right;
	}
	
	
	

}
