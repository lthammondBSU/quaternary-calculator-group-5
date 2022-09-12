package quaternarycalculator.bsu.edu.frontend.digitdisplay;

import javax.swing.*;
import java.awt.*;

public class DigitDisplay extends JPanel {
    private JTextField display;


    public DigitDisplay(){
        this.display = new JTextField(16);
        display.setFont(new Font("Serif",Font.BOLD,40));
        this.add(this.display);
    }

    public void updateDisplayContent(String s){
        String cur = this.display.getText();
        this.display.setText(cur+s);
    }

    public void clear(){
        this.display.setText("");
    }
}
