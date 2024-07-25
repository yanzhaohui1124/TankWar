package TankGame;

import javax.swing.*;

/**
 * ClassName: TankGame01
 * Description:
 * Author: yzh
 * Create 2024/7/24 15:47
 * Version: 1.0
 */
public class TankGame01 extends JFrame {
    //画板
    MyPanel mp = null;

    public static void main(String[] args) {
        TankGame01 tankGame01 = new TankGame01();
    }

    public TankGame01() {
        mp = new MyPanel(new Hero(100, 100));
        //mp作为一个线程
        Thread thread = new Thread(mp);
        thread.start();
        //设置大小，可见，关闭状态
        this.add(mp);
        this.setSize(1000, 750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
