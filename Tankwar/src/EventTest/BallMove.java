package EventTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * ClassName: BallMove
 * Description:
 * Author: yzh
 * Create 2024/7/24 16:29
 * Version: 1.0
 */
public class BallMove extends JFrame{
    MyPanel mp = null;

    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }

    public BallMove(){
        mp = new MyPanel();

        this.add(mp);
        this.setSize(1000,750);
        //设置为监听事件
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel extends JPanel implements KeyListener{
    private int x = 100;
    private int y = 100;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x,y,20,20);
    }
    //字符输出时触发
    @Override
    public void keyTyped(KeyEvent e) {

    }
    //键盘被按下时触发
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_DOWN:
                y+=5;
                break;
            case KeyEvent.VK_UP:
                y-=5;
                break;
            case KeyEvent.VK_LEFT:
                x-=5;
                break;
            case KeyEvent.VK_RIGHT:
                x+=5;
                break;
            default:
                System.out.println("请按上下左右键");

        }
        this.repaint();
    }
    //按键松开时触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
