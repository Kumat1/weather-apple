package TugasJson;

import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWeather extends JFrame {
    private JPanel panelMain,panelDalam;
    private BorderLayout layoutMain;
    private GridBagLayout layoutDalam;
    private GridBagConstraints constraints;
    private Font font,fontLabel,fontButton;
    private JTextField field1;
    private JButton buttonOk;
    private JLabel judul,label;
    private String city;


    public MainWeather(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        ActionListener actionButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                city = field1.getText();

                new Weather(city);
                MainWeather.this.setVisible(false);
            }
        };

        panelMain = (JPanel) this.getContentPane();

        layoutMain = new BorderLayout(2,1);
        panelMain.setLayout(layoutMain);

        panelDalam = new JPanel();
        layoutDalam = new GridBagLayout();
        panelDalam.setLayout(layoutDalam);
        constraints = new GridBagConstraints();

        font = new Font("Arial",Font.BOLD,40);
        fontLabel = new Font("Arial",Font.PLAIN,20);
        fontButton = new Font("Arial",Font.BOLD,20);

        judul = new JLabel("Ramalan Cuaca");
        judul.setFont(font);
        judul.setHorizontalAlignment(SwingConstants.CENTER);
        judul.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        constraints.weightx = 0;
        constraints.weighty=1;

        constraints.gridwidth = 1;
        constraints.gridheight =1;
        constraints.gridy=1;
        constraints.gridx=0;

        label = new JLabel("Kota : ");
        label.setFont(fontLabel);
        label.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panelDalam.add(label,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight =1;
        constraints.gridy=1;
        constraints.gridx=1;

        field1 = new JTextField("",10);
        field1.setFont(fontLabel);
        panelDalam.add(field1,constraints);

        constraints.gridwidth = 10;
        constraints.gridheight =1;
        constraints.gridy=2;
        constraints.gridx=0;

        buttonOk = new JButton("Ok");
        buttonOk.addActionListener(actionButton);
        buttonOk.setFont(fontButton);
        buttonOk.setForeground(Color.white);
        buttonOk.setBackground(Color.getHSBColor(0.54f,0.7f,0.7f));
        buttonOk.setPreferredSize(new Dimension(250,40));
        buttonOk.setContentAreaFilled(false);
        buttonOk.setOpaque(true);
        panelDalam.add(buttonOk,constraints);

        panelMain.add(judul,BorderLayout.NORTH);
        panelMain.add(panelDalam,BorderLayout.CENTER);

        this.setTitle("Ramalan Cuaca");
        this.setSize(400,250);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MainWeather();
    }
}
