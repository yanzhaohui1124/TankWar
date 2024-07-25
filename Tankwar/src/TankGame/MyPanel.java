package TankGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ClassName: MyPanel
 * Description:画图工作
 * Author: yzh
 * Create 2024/7/24 15:45
 * Version: 1.0
 */
public class MyPanel extends JPanel implements KeyListener,Runnable {
    private Hero hero = null;

    private CopyOnWriteArrayList<Enemy> enemies = new CopyOnWriteArrayList<>();
    private int enemySize=3;

    public MyPanel() {
    }

    public MyPanel(Hero hero) {
        this.hero = hero;
        for(int i=0;i<enemySize;i++){
            Enemy enemy = new Enemy((100 * (i + 1)), 0);
            enemy.setDirection(2);
            enemies.add(enemy);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //填充一个黑色矩形来当作背景板，黑色是默认颜色
        g.fillRect(0, 0, 1000, 750);
        this.drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 0);

        //将每一个子弹都打印出来
        for(int i=0;i<hero.shotNum;i++){
            g.fill3DRect(hero.list.get(i).getX(),hero.list.get(i).getY(),1,1,false);
        }
        //将敌人显示出来
        for(int i = 0; i<enemySize;i++){
            this.drawTank(enemies.get(i).getX(),enemies.get(i).getY(),g,enemies.get(i).getDirection(),1);
        }
    }

    /*
     * x,y代表坐标
     * g代表画笔
     * direction是坦克的方向
     * type是坦克的类型
     * */
    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        switch (type) {
            //我方坦克
            case 0:
                g.setColor(Color.cyan);
                break;
            //敌方坦克
            case 1:
                g.setColor(Color.yellow);
                break;
            default:
                System.out.println("请使用正确的坦克类型");
        }
        switch (direction) {

            case 0://表示向上
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1: //表示向右
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2: //表示向下
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3: //表示向左
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            default:
                System.out.println("请选择正确的方向");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //监听键盘按下
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            hero.setDirection(0);
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hero.setDirection(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hero.setDirection(3);
            hero.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hero.setDirection(1);
            hero.moveRight();
        }

        if(e.getKeyCode()==KeyEvent.VK_J){
            hero.tankShot();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    //要不断刷新，才能配合shot中的sleep刷新
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }
}
