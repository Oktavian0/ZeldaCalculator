import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import static java.awt.Color.*;
import static javax.swing.SwingConstants.*;

/**
 * Created by Pero on 14.09.2019.
 */
public class GUI extends JFrame {

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

        Border labelBorder = BorderFactory.createLineBorder(black, 1);
        Border labelInnerBorder = BorderFactory.createEmptyBorder(2, 2, 2, 2);

        Dimension dim = new Dimension();
        dim.width = 65;

        JPanel container1 = new JPanel();
        container1.setPreferredSize(dim);
        container1.setBackground(red);
        container1.setVisible(true);

        JPanel container2 = new JPanel();
        container2.setSize(200, 200);
        container2.setBackground(yellow);
        container2.setLayout(new FlowLayout());
        container2.setVisible(true);

        JPanel container3 = new JPanel();
        container3.setSize(200, 200);
        container3.setLayout(new FlowLayout());
        container3.setVisible(true);

        JLabel label1 = new JLabel();
        label1.setText("bla");
        label1.setBorder(BorderFactory.createCompoundBorder(labelBorder, labelInnerBorder));
        container2.add(label1);

        JLabel label2 = new JLabel();
        label2.setText("bla2");
        label2.setBorder(BorderFactory.createCompoundBorder(labelBorder, labelInnerBorder));
        container2.add(label2);

        JTabbedPane tabbedPane = new JTabbedPane();
        //tabbedPane.setLayout(new FlowLayout());
        JPanel panel1 = new JPanel();
        panel1.setBackground(yellow);
        JPanel panel2 = new JPanel();
        panel2.setBackground(green);
        JPanel panel3 = new JPanel();
        panel3.setBackground(red);
        JLabel label1_1 = new JLabel("Label 1-1");
        JLabel label2_1 = new JLabel("Label 2-1");
        JLabel label3_1 = new JLabel("Label 3-1");
        panel1.add(label1_1);
        panel2.add(label2_1);
        panel3.add(label3_1);
        tabbedPane.addTab("Tab 1", panel1);
        tabbedPane.addTab("Tab 2", panel2);
        tabbedPane.addTab("Tab 3", panel3);
        container2.add(tabbedPane);


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
