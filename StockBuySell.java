public class StockBuySell
{
    public static void main(String[] args)
    {
        int price[] = { 7, 1, 5, 3, 6, 4  };
        int n = price.length;

        maxProfit(price, 0, n - 1);
       // System.out.print();
    }


    public static void maxProfit(int[] prices,int l,int r)
    {

        int min_price=0, profit=0,max_profit=0;

        min_price = prices[0];
        for(int i=1;i<prices.length;i++)
        {
            min_price = Math.min(min_price,prices[i]);
            profit = prices[i]-min_price;
            max_profit = Math.max(max_profit,profit);
        }
        System.out.println("value of max profit = " + max_profit);

    }
}
