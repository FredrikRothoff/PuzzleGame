import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class GamePanel extends JPanel implements ActionListener {
    protected static ArrayList<JButton> allButtons = new ArrayList<>();
    protected static JButton emptySpace = new JButton("" + 0);

    public GamePanel() {
        this.setLayout(new GridLayout(5, 3));
        this.setBounds(0, 0, 450, 500);
        this.setBackground(Color.CYAN);

        ArrayList<Integer> randomNums = RandomNumbers.GenerateRandomNumbers(15);

        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {

                int tempNum = randomNums.get(count);

                if(tempNum == 0){
                    emptySpace.addActionListener(this);

                    this.add(emptySpace);
                    allButtons.add(emptySpace);

                    emptySpace.setVisible(false);
                    count++;
                    continue;
                }

                JButton button = new JButton("" + randomNums.get(count));
                button.addActionListener(this);
                button.setFont(new Font("Arial", Font.BOLD, 32));
                this.add(button);
                allButtons.add(button);
                count++;
            }
        }
    }
        public void swap (JButton clickedButton) {
            this.add(clickedButton, allButtons.indexOf(emptySpace));
            this.add(emptySpace, allButtons.indexOf(clickedButton));
            this.revalidate();
            Collections.swap(allButtons, allButtons.indexOf(emptySpace), allButtons.indexOf(clickedButton));

            int indexFirst = Integer.parseInt(allButtons.get(0).getText());
            int indexLast = Integer.parseInt(allButtons.get(allButtons.size() - 2).getText());
            int lastSupposedNumber = allButtons.size() - 1;

            if (indexFirst == 1 && indexLast == lastSupposedNumber) {
                boolean gameWon = checkWinCondition(allButtons);

                if (gameWon) {
                    gameWon();
                }
            }
        }
    public static void gameWon(){
        JOptionPane.showMessageDialog(null,"Congratulaaaaatioooons! You Won!");
    }
    public static boolean checkWinCondition(ArrayList<JButton> list){
        for (int i = 0; i < list.size(); i++) {
            int tempNum = Integer.parseInt(list.get(i).getText());

            if(tempNum != i + 1 && i != list.size() - 1){
                break;
            }
            else if(tempNum == 0 && i == list.size() - 1){
                return true;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        if ((allButtons.indexOf(clickedButton) + 1) == allButtons.indexOf(emptySpace)) {
            swap(clickedButton);
            System.out.println("swap + 1");
        } else if ((allButtons.indexOf(clickedButton) - 1) == allButtons.indexOf(emptySpace)) {
            swap(clickedButton);
            System.out.println("swap - 1");
        } else if ((allButtons.indexOf(clickedButton) + 3 == allButtons.indexOf(emptySpace))) {
           swap(clickedButton);
            System.out.println("swap - 3");
        } else if ((allButtons.indexOf(clickedButton) - 3 == allButtons.indexOf(emptySpace))) {
            swap(clickedButton);
            System.out.println("swap + 3");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid button");
            System.out.println(clickedButton.getText());
        }
    }
}

