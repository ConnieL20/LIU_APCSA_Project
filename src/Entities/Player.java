package Entities;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.Key;

public class Player extends entity {

    GamePanel gp;
    KeyHandler key;

    public Player(GamePanel gp, KeyHandler key) {
        this.gp = gp;
        this.key = key;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 5;
        direction = "down";
    }

    public void getPlayerImage(){
        try {
            up = ImageIO.read(getClass().getResourceAsStream("/player/Dumpling_up.png"));
            down = ImageIO.read(getClass().getResourceAsStream("/player/Dumpling_down.png"));
            left = ImageIO.read(getClass().getResourceAsStream("/player/Dumpling_left.png"));
            right = ImageIO.read(getClass().getResourceAsStream("/player/Dumpling_right.png"));


        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update() {
        if (key.upPressed == true) {
            direction = "up";
            y -= speed;
        } else if (key.downPressed == true) {
            direction = "down";
            y += speed;
        } else if (key.leftPressed == true) {
            direction = "left";
            x -= speed;
        } else if (key.rightPressed == true) {
            direction = "right";
            x += speed;
        }
    }

    public void draw(Graphics2D g2){

        BufferedImage image = null;

        switch(direction) {
            case "up":
                image = up;
                break;
            case "down":
                image = down;
                break;
            case "left":
                image = left;
                break;
            case "right":
                image = right;
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}

