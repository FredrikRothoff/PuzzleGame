import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GameFrame extends JFrame implements ActionListener {
    GamePanel gamePanel;
    JButton resetButton;
    JButton quitButton;
   public GameFrame(){
        gamePanel = new GamePanel();

        resetButton = new JButton("Reset");
        resetButton.setBounds(100,500,100,30);
        resetButton.addActionListener(this);

        quitButton = new JButton("Quit");
        quitButton.setBounds(230,500,100,30);
        quitButton.addActionListener(this);

        this.setSize(new Dimension(450,560));
        this.setTitle("15 Puzzle Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.add(resetButton);
        this.add(quitButton);
        this.add(gamePanel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            this.remove(gamePanel);
            new GamePanel();
            this.add(gamePanel);
            SwingUtilities.updateComponentTreeUI(this);
        } else if (e.getSource() == quitButton) {
            System.exit(0);
        }
    }
}
