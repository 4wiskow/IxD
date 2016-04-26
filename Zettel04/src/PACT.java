import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.math.*;
import java.util.ArrayList;

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
        buildMenu();
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

    private void buildMenu() {
        JMenuBar menuBar;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;

        menuBar = new JMenuBar();

        ArrayList <JMenu> menus = new ArrayList();
        menus.add(new JMenu("File"));
        menus.add(new JMenu("Datenbank"));
        menus.add(new JMenu("Fenster"));
        menus.add(new JMenu("Hilfe"));
        menus.forEach((menu) -> menuBar.add(menu));

        setJMenuBar(menuBar);
    }
}
