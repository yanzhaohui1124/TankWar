package DrawTest;

import javax.swing.*;
import java.awt.*;

/**
 * ClassName: DrawTest.Draw
 * Description:学习Draw
 * Author: yzh
 * Create 2024/7/24 14:42
 * Version: 1.0
 */
public class Draw extends JFrame {
    //首先定义一个画板
    private MyPanel mp=null;
    public static void main(String[] args) {
        new Draw();
        System.out.println("退出程序");
    }
    public Draw(){
        mp=new MyPanel();
        //将画板放到窗口之中
        this.add(mp);
        this.setSize(500,600);
        //设置点击叉自动退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置可以显示
        this.setVisible(true);
    }
}

class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        System.out.println("paint被调用了");
        //画出一个圆
        //g.drawOval(10,10,100,100);


        //填充一个矩形
        g.setColor(Color.BLACK);
        g.fillRect(300,400,100,100);

        //将图片放进去
        //这里要用MyPanel，逆天
        Image image = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bg.png"));
        g.drawImage(image, 10, 10, 175, 221, this);
    }
}
