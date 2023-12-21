import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Queue;

public class MilanMadrid extends JFrame {

    int x = 700;
    int y = 300;

    JButton milan = new JButton("AC Milan");
    JButton madrid = new JButton("AC Madrid");
    JLabel result = new JLabel("Result: 0 X 0");
    JLabel scorer = new JLabel("Last Scorer: N/A");
    JLabel winners = new JLabel("Winner: DRAW");

    boolean isUpdated = false;

    boolean isUpdated() {
        return isUpdated;
    }

    int scoreMilan = 0;
    int scoreMadrid = 0;

    public void updateFrame() {
        revalidate();
        repaint();
        isUpdated = true;
    }

    public void setNewWinner() {
        if(scoreMilan > scoreMadrid) {
            winners.setText("Winner: Milan");
            winners.setBounds(x/2 - 100, y/2, 250,50);
        } else if(scoreMadrid > scoreMilan) {
            winners.setText("Winner: Madrid");
            winners.setBounds(x/2 - 100, y/2, 250,50);
        } else {
            winners.setText("Winner: DRAW");
            winners.setBounds(x/2 - 100, y/2, 250,50);
        }
    }

    public MilanMadrid() {

        setSize(x,y);

        add(milan);
        add(madrid);
        add(result);
        add(scorer);
        add(winners);

        milan.setSize(100,50);
        madrid.setSize(100,50);
        result.setSize(100,50);
        scorer.setSize(100,50);
        winners.setSize(100,50);

        milan.setLocation(x/10,y/20);
        madrid.setLocation(x - x/10 - madrid.getWidth(), y/20);
        result.setLocation(x/10,y /2);
        scorer.setBounds(x -x/10 - 150,y/2,150,10);
        winners.setLocation(x/2,y /2);
        winners.setBounds(x/2 - 100, y/2, 300,50);
        milan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scoreMilan++;
                isUpdated = false;
                result.setText("Result:" + scoreMilan + " X " + scoreMadrid);
                scorer.setText("Last Scorer: Milan");
                scorer.setBounds(x -x/10 - 150,y/2,150,10);
                setNewWinner();
            }

        });

        madrid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scoreMadrid++;
                isUpdated = false;
                result.setText("Result:" + scoreMilan + " X " + scoreMadrid);
                scorer.setText("Last Scorer: Madrid");
                scorer.setBounds(x -x/10 - 150,y/2,150,10);
                setNewWinner();
            }

        });

    }

    public static void main(String[]args){
        MilanMadrid window = new MilanMadrid();
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while(true) {
            if(window.isUpdated()) {
                window.updateFrame();
            }
        }

    }
}
