import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CountdownTimer extends JFrame implements ActionListener {
    JButton startButton = new JButton("Start Countdown");
    JLabel timeLabel = new JLabel();
    Color C = new Color(59, 89, 152);
    int elapsedTime = 0; // Elapsed time in milliseconds
    int durationInSeconds = 60; // Countdown duration in seconds
    boolean started = false;
    String secondString = String.format("%02d", durationInSeconds % 60);

    Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (elapsedTime > 0) {
                elapsedTime -= 1000;
                updateDisplay();
            } else {
                timer.stop();
                started = false;
                startButton.setText("Start Countdown");
            }
        }
    });

    CountdownTimer() {
        timeLabel.setText("00:" + secondString);
        timeLabel.setBounds(100, 100, 200, 100);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setBackground(C);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        startButton.setBounds(100, 200, 200, 50);
        startButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        add(timeLabel);
        add(startButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 420);
        setLocation(420, 200);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("Countdown Timer");
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            if (!started) {
                started = true;
                startButton.setText("Stop Countdown");
                startCountdown();
            } else {
                started = false;
                startButton.setText("Start Countdown");
                stopCountdown();
            }
        }
    }

    void startCountdown() {
        elapsedTime = durationInSeconds * 1000; // Convert seconds to milliseconds
        timer.start();
        updateDisplay();
    }

    void stopCountdown() {
        timer.stop();
    }

    void updateDisplay() {
        int minutes = (elapsedTime / 60000) % 60;
        int seconds = (elapsedTime / 1000) % 60;
        String minuteString = String.format("%02d", minutes);
        String secondString = String.format("%02d", seconds);
        timeLabel.setText(minuteString + ":" + secondString);
    }

    public static void main(String[] args) {
        new CountdownTimer();
    }
}
