package com.gymnation;

import javax.swing.*;
import java.awt.*;

public class Background extends JPanel {
    private Image backgroundImage;

    public Background(String imagePath) {
        try {
            backgroundImage = new ImageIcon(getClass().getClassLoader().getResource(imagePath)).getImage();
        } catch (Exception e) {
            System.err.println("Could not load image: " + imagePath);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}


