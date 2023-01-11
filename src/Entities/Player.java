package Entities;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;
import java.security.Key;

public class Player extends entity {

    GamePanel gp;
    KeyHandler key;

    public Player(GamePanel gp, KeyHandler key) {
        this.gp = gp;
        this.key = key;
        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
    }

    public void update() {
        if (key.upPressed == true) {
            y -= speed;
        } else if (key.downPressed == true) {
            y += speed;
        } else if (key.leftPressed == true) {
            x -= speed;
        } else if (key.rightPressed == true) {
            x += speed;
        }
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    }
}

