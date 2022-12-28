import java.util.ArrayList;
import java.util.Collections;
public class RandomNumbers {

    private RandomNumbers(){}
    public static ArrayList<Integer> GenerateRandomNumbers (int n){
        ArrayList<Integer> intList = new ArrayList<>(n);
        for (int i = 0; i < 15; i++) {
            intList.add(i);
        }
        Collections.shuffle(intList);
        return intList;
    }

}
