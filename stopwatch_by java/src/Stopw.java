import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Stopw  extends JFrame implements ActionListener
{

   
    JButton startButton=new JButton("Start"); 
    JButton resetButton=new JButton("Reset"); 
    JLabel timeLabel=new JLabel();
    Color C=new Color(59,89, 152);
    int el_time=0;
    int secound=0;
    int minute=0;
    int hour=0;
    boolean started=false;
    String secound_string= String.format("%02d",secound);
    String minute_string= String.format("%02d",minute);
    String hour_string= String.format("%02d",hour);

Timer timer=new Timer(1000,new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {
        el_time=el_time+1000;
        hour= (el_time/3600000);
        minute = (el_time/60000) % 60;
        secound = (el_time/1000) % 60;
        secound_string = String.format("%02d", secound);
        minute_string = String.format("%02d", minute);
        hour_string = String.format("%02d", hour);
        timeLabel.setText(hour_string+":"+minute_string+":"+secound_string);
    }
}
);

    Stopw()
    {

        timeLabel.setText("00:00:00");
        timeLabel.setBounds(100,100,200,100);
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setBackground(C);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        
        startButton.setBounds(100,200,100,50);
        startButton.setFont(new Font("Ink Free",Font.PLAIN,20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        
        resetButton.setBounds(200,200,100,50);
        resetButton.setFont(new Font("Ink Free",Font.PLAIN,20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

add(timeLabel);
add(startButton);
add(resetButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(420,420);
       setLocation(420,200);
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       setTitle("Stopwatch");
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
if(e.getSource()==startButton)
{
    started=true;
    startButton.setText("Stop");
start();
}
else
{
    started=false;
    startButton.setText("Start");
stop();
}
if(e.getSource()==resetButton)
{
    started=false;
     startButton.setText("Start");
     reset();
}

    }
    void start()
    {
        timer.start();
    }
    void stop()
    {
        timer.stop();
    }
    void reset()
    {
        el_time=0;
        hour= 0;
        minute = 0;
        secound = 0;
        secound_string = String.format("%02d", secound);
        minute_string = String.format("%02d", minute);
        hour_string = String.format("%02d", hour);
        timeLabel.setText(hour_string+":"+minute_string+":"+secound_string);
    }
    public static void main(String []args)
    {
       new Stopw();// stopwatch= new Stopw();
    }
}
