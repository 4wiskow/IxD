import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.math.*;
import java.text.NumberFormat;
import java.util.ArrayList;

public class PACT
{
    public static void main(String[] args)
    {
        JFrame window = new SimpleExampleGUI();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Simple GUI");
        window.setSize(800, 600);
        window.setVisible(true);
    }
}

class SimpleExampleGUI extends JFrame
{
    private JButton m_Btn = new JButton("Click me!");

    SimpleExampleGUI()
    {
        buildMenu();
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(m_Btn);

        this.setContentPane(content);
        this.pack();

        m_Btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                buildDialog();
            }
        });
    }
    
    /**
     * Baut das Dialogfenster zum Hinzufügen von Benutzern.
     */
    private void buildDialog()
    {
        //Dialogfenster
        JDialog nutzerHinzu = new JDialog();
        nutzerHinzu.setMinimumSize(new Dimension(300,300));
        nutzerHinzu.setTitle("Nutzer hinzufügen");

        // Create Lables
        JLabel name = new JLabel("Name:");
        JLabel id = new JLabel("ID:");
        JLabel adresse = new JLabel("Adresse:");
        JLabel geburt = new JLabel("Geburtsdatum:");
        JLabel aufnahme = new JLabel("Aufnahmedatum:");
        
        // Create Textfields
        JTextField nameFeld = new JTextField("Name");
        JTextField adressFeld = new JTextField("Adresse");
        JTextField geburtsFeld = new JTextField("Geburtsdatum");
        JTextField aufnahmeFeld = new JTextField("Aufnahmedatum");
        
        //Numberfield for IDs
        JFormattedTextField idFeld = new JFormattedTextField(NumberFormat.getNumberInstance());
        idFeld.setValue(new Integer(30));
        idFeld.setColumns(10);
        idFeld.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
                char ch = e.getKeyChar();
                
                if (ch < '0' || ch > '9') {
                    e.consume();
                }}}
                );

        // Optionpane inside the Dialog
        JOptionPane option = new JOptionPane(null);
        Object[] options = {"Abbrechen", "Aufnehmen"};
        // rename the buttons
        option.setOptions(options);
        
        // Panel inside the Optionpane to prevent Textfields being positioned under the buttons. Dunno if necessary.
        //JPanel panel = new JPanel();
        //option.add(panel, 0);
        nutzerHinzu.add(option);

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        
        //Set Constraints for Lables and corresponding Textfields and add them to the Panel
        c.gridx = 0;
        c.gridy = 0;
        c.fill = c.HORIZONTAL;
        layout.setConstraints(name, c);
        option.add(name, c);
        c.gridx = 1;
        c.gridy = 0;
        layout.setConstraints(nameFeld, c);
        option.add(nameFeld, c);
        
        c.gridx = 0;
        c.gridy = 1;
        layout.setConstraints(id, c);
        option.add(id, c);
        c.gridx = 1;
        c.gridy = 1;
        layout.setConstraints(idFeld, c);
        option.add(idFeld, c);

        
        c.gridx = 0;
        c.gridy = 2;
        layout.setConstraints(adresse, c);
        option.add(adresse, c);
        c.gridx = 1;
        c.gridy = 2;
        layout.setConstraints(adressFeld, c);
        option.add(adressFeld, c);

        
        c.gridx = 0;
        c.gridy = 3;
        layout.setConstraints(geburt, c);
        option.add(geburt, c);
        c.gridx = 1;
        c.gridy = 3;
        layout.setConstraints(geburtsFeld, c);
        option.add(geburtsFeld, c);

        
        c.gridx = 0;
        c.gridy = 4;
        layout.setConstraints(aufnahme, c);
        option.add(aufnahme, c);
        c.gridx = 1;
        c.gridy = 4;
        layout.setConstraints(aufnahmeFeld, c);
        option.add(aufnahmeFeld, c);

        // Pack and launch dialog.
        option.setLayout(layout);
        nutzerHinzu.pack();
        nutzerHinzu.setVisible(true);

    }

    private void buildMenu()
    {
        JMenuBar menuBar;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;

        menuBar = new JMenuBar();

        ArrayList<JMenu> menus = new ArrayList<JMenu>();
        menus.add(new JMenu("File"));
        menus.add(new JMenu("Datenbank"));
        menus.add(new JMenu("Fenster"));
        menus.add(new JMenu("Hilfe"));
        menus.forEach((menu) -> menuBar.add(menu));

        //menuBar.getMenu(1).add(new JMenuItem("Neuer Benutzer"));

        setJMenuBar(menuBar);
    }
}
