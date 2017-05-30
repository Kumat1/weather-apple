package TugasJson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeatherTampilan extends JFrame {
    private String city,cloud,pressure;
    private Long humidity,visibility ;
    private Double temp;
    private JPanel panelMain,panelDalam;
    private BorderLayout layoutMain;
    private GridBagLayout layoutDalam;
    private GridBagConstraints constraints;
    private JLabel labelCity, labelCloud,labelTemp,labelHumidity,labelVisibility,labelPressure;
    private Font fontCity,fontTemp,fontCloud;
    private JButton button;

    public WeatherTampilan(String n,String c,String p,Double t,Long h,Long v){
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

        this.city = n;
        this.cloud = c;
        this.pressure = p;
        this.temp = t;
        this.humidity = h;
        this.visibility = v;

        panelMain = (JPanel) this.getContentPane();
        layoutMain = new BorderLayout();
        panelMain.setLayout(layoutMain);

        panelDalam = new JPanel();
        layoutDalam = new GridBagLayout();
        panelDalam.setLayout(layoutDalam);

        fontCity = new Font("Times New Roman",Font.ITALIC + Font.BOLD,52);
        fontTemp = new Font("Times New Roman", Font.PLAIN,80);
        fontCloud = new Font("Times New Roman", Font.PLAIN,40);

        labelCity = new JLabel(city);
        labelCity.setFont(fontCity);
        labelCity.setHorizontalAlignment(SwingConstants.CENTER);
        labelCity.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
        panelMain.add(labelCity,BorderLayout.NORTH);

        constraints = new GridBagConstraints();

        constraints.weightx = 1;
        constraints.weighty=1;

        constraints.gridwidth = 1;
        constraints.gridheight =1;
        constraints.gridy=2;
        constraints.gridx=1;

        labelTemp = new JLabel(String.valueOf(temp+" F"));
        labelTemp.setFont(fontTemp);
        labelTemp.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panelDalam.add(labelTemp,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight =1;
        constraints.gridy=3;
        constraints.gridx=4;

        labelCloud = new JLabel(cloud);
        labelCloud.setFont(fontCloud);
        panelDalam.add(labelCloud,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight =1;
        constraints.gridy=4;
        constraints.gridx=4;

        labelPressure= new JLabel("Pressure "+String.valueOf(pressure));
        labelPressure.setFont(fontCloud);
        panelDalam.add(labelPressure,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight =1;
        constraints.gridy=5;
        constraints.gridx=4;

        labelHumidity = new JLabel("Humidity "+String.valueOf(humidity)+"%");
        labelHumidity.setFont(fontCloud);
        panelDalam.add(labelHumidity,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight =1;
        constraints.gridy=6;
        constraints.gridx=4;

        labelVisibility = new JLabel("Visibility "+String.valueOf(visibility));
        labelVisibility.setFont(fontCloud);
        panelDalam.add(labelVisibility,constraints);

        constraints.gridwidth = 4;
        constraints.gridheight =1;
        constraints.gridy=7;
        constraints.gridx=5;

        button = new JButton("Kembali");
        button.setMargin(new Insets(10,10,10,10));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainWeather();
                WeatherTampilan.this.setVisible(false);
            }
        });
        panelDalam.add(button,constraints);

        panelMain.add(panelDalam,BorderLayout.CENTER);

        this.setVisible(true);
        this.setSize(580,450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
