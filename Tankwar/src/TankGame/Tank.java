package TankGame;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ClassName: Tank
 * Description:Tank类，敌我双方坦克皆由此继承
 * Author: yzh
 * Create 2024/7/24 15:34
 * Version: 1.0
 */
public class Tank {
    //坦克的横纵坐标，这里的坦克大小都是一致的，可以进行改进
    private int x;
    private int y;

    private int direction;

    private int speed=2;
    //这里加一个链表就可以实现多个子弹
    CopyOnWriteArrayList<Shot> list = new CopyOnWriteArrayList<>();
    int shotNum=0;
    public Shot shot = null;
    public void tankShot(){
        switch (direction){
            case 0:
                shot=new Shot(x+20,y,0);
                break;
            case 1:
                shot=new Shot(x+60,y+20,1);
                break;
            case 2:
                shot=new Shot(x+20,y+60,2);
                break;
            case 3:
                shot=new Shot(x,y+20,3);
               break;
        }
        list.add(shot);
        shotNum++;
        new Thread(shot).start();
    }

    public void moveUp() {
        y -= speed;
    }

    public void moveDown() {
        y += speed;
    }

    public void moveLeft() {
        x -= speed;
    }

    public void moveRight() {
        x += speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
