import java.awt.Image;

import javax.swing.ImageIcon;

//player 움직임 구현
public class Game extends Thread {
	// 게임의 딜레이마다 증가 할 cnt를 선언해주고 이 cnt 가 이벤트 발생 주기를 컨트롤 하는 변수가 된다
private int delay =20;
private long pretime;
private int cnt;

private Image player = new ImageIcon("res/player.png").getImage();

//player 변수
private int playerX,playerY;
private int playerwidth = player.getWidth(null);
private int playerheight = player.getHeight(null);
// play 가 한번 키를 입력했을때 이동할 거리 	
private int playSpeed =10;
private int playerHP =30;

private boolean up,down,left,right;

@Override
public void run() {
	cnt =0;
	playerX=0;
	playerY=(Main.Screen_hight -playerheight)/2;
	// cnt 를 앞서 설정한 delay 지날때마다 증가
	while(true) {
		pretime=System.currentTimeMillis();
		if(System.currentTimeMillis() - pretime <delay) {
			try {
				//  차이만큼 sleep
				Thread.sleep(delay - System.currentTimeMillis() +pretime);
				cnt++;
			}catch(InterruptedException e) {
				
			}
		}
		
		
	}
}



}
