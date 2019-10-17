import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import static java.awt.Color.black;
import static java.awt.Color.red;
import static java.awt.Color.yellow;
import static javax.swing.SwingConstants.LEFT;

/**
 * Created by Pero on 14.09.2019.
 */
public class GUI extends JFrame {

    private JButton button1;
    private JPanel panel1;

    public GUI() {

        //Set up Frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setTitle("Zelda Calculator");
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //Set up components
        JMenuBar menuBar = new JMenuBar();
        Border border = new LineBorder(black);
        menuBar.setBorder(border);
        JMenu menu = new JMenu("Menü");
        menuBar.add(menu);
        JMenuItem menuItem1 = new JMenuItem("create GUI");
        menuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI tempGUI = new GUI();
            }
        });
        JMenuItem menuItem2 = new JMenuItem("Beenden");
        menuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                closeApplication();
            }
        });
        menu.add(menuItem1);
        menu.add(menuItem2);

        JPanel container1 = new JPanel();
        container1.setSize(200, 200);
        container1.setBackground(red);
        container1.setVisible(true);

        JPanel container2 = new JPanel();
        container2.setSize(200, 200);
        container2.setBackground(yellow);
        container2.setLayout(new FlowLayout());
        container2.setVisible(true);

        JLabel label1 = new JLabel();
        label1.setText("bla");
        container2.add(label1);

        JLabel label2 = new JLabel();
        label2.setText("bla2");
        container2.add(label2);

        JTabbedPane tab1 = new JTabbedPane();
        tab1.add("Tab 1",container1);
        tab1.setTabPlacement(LEFT);

        JTabbedPane tab2 = new JTabbedPane();
        tab2.add("Tab2", container1);
        tab2.setTabPlacement(LEFT);

        //JScrollPane(component) for scroll bars

        Button button = new Button();
        button.setLabel("Click me!");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked!");
                //label.setText("bla");
            }
        });

        //add components
        setJMenuBar(menuBar);
        add(container1, BorderLayout.WEST);
        add(container2, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
        setVisible(true);


    }

    void closeApplication() {
        setVisible(false);
        dispose();
    }
}
