import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.math.*;

public class PACT {
    public static void main(String[] args) {
        JFrame window = new SimpleExampleGUI();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Simple GUI");
        window.setSize(800, 600);
        window.setVisible(true);
    }
}

class SimpleExampleGUI extends JFrame {
    private JButton m_Btn = new JButton("Click me!");
    
    SimpleExampleGUI() {
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(m_Btn);
        
        this.setContentPane(content);
        this.pack();

        m_Btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // ...
            }
        });
    }
}