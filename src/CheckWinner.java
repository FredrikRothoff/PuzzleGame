import javax.swing.*;
import java.util.ArrayList;

public class CheckWinner {
    public CheckWinner(ArrayList<JButton> list) {
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
}
