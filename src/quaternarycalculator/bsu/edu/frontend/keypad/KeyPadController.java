package quaternarycalculator.bsu.edu.frontend.keypad;

import quaternarycalculator.bsu.edu.frontend.QuaternaryCalculator;
import quaternarycalculator.bsu.edu.frontend.keypad.buttons.KeyPadButton;
import java.awt.*;

public class KeyPadController {
    private final QuaternaryCalculator mainFrame;
    private final KeyPad keyPad;
    public KeyPadController(QuaternaryCalculator mainFrame){
        this.mainFrame = mainFrame;
        this.keyPad = new KeyPad();
    }

    public void initialize(){
        this.mainFrame.getContentPane().setBackground(Color.DARK_GRAY);

        this.mainFrame.add(this.keyPad);
        this.setNumberButtonEvent();
        this.setOperatorButtonEvent();
    }

    private void setNumberButtonEvent(){
        for (KeyPadButton btn : this.keyPad.getNumberButtons()){
            btn.addActionListener(e -> mainFrame.numberButtonPressed(btn.getSymbol()));
        }
    }

    public void setOperatorButtonEvent(){
        for (KeyPadButton btn : this.keyPad.getOperatorButtons()){
            btn.addActionListener(e -> mainFrame.operatorButtonPressed(btn.getSymbol()));
        }
    }
}
