package javaCode;
import javaCode.models.GameManager;
import java.awt.EventQueue;


public class Driver {


    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new GameManager();
        });
    }
}
