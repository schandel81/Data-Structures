import java.util.ArrayList;
import java.util.Arrays;

class BuySell {
    int buyIndex;
    int sellIndex;
    BuySell(int buy, int sell) {
        this.buyIndex = buy;
        this.sellIndex = sell;
    }
}

public class StockBuySellToMaximiseProfit
{

    public static void main(String[] args) {
        ArrayList<Integer> inputArray = new ArrayList<Integer>(Arrays.asList(100,180,260,310,40,535,695));
        ArrayList<BuySell> result = new ArrayList<BuySell>();
        int i = 0;
        int buy = -1;
        int sell = -1;
        while(i < inputArray.size())
        {
            buy = -1;
            sell = -1;
            while(i+1 < inputArray.size() && inputArray.get(i) > inputArray.get(i+1))
                i++;
            if(i+1 == inputArray.size())
                break;
            buy = i++;
            while(i+1 < inputArray.size() && inputArray.get(i) < inputArray.get(i+1))
                i++;
            sell = i;
            result.add(new BuySell(buy, sell));
            i++;
        }
        for(BuySell x : result)
            System.out.println("Buy : " + x.buyIndex + " Sell : "+ x.sellIndex);



    }

}