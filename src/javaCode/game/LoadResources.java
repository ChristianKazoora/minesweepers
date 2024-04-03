package javaCode.game;

import javax.swing.*;
import java.awt.*;

public class LoadResources {

    public LoadResources(){
        //empty constructor
    }
    public Image[] Loader(){
        Image [] img = new Image[13];

        for (int i = 0; i <= 12; i++) {

            var path = "src/resources/" + i + ".png";
            img[i] = (new ImageIcon(path)).getImage();
        }
        return img;
    }
}
