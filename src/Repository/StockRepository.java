package Repository;

import Model.Stock;

import java.util.ArrayList;

public class StockRepository {
    ArrayList<Stock> stocks= new ArrayList<Stock>();
    public static StockRepository instance =null;

    public void addStock(Stock stock) {
        stocks.add(stock);

    }


    public ArrayList<Stock> findStocks() {
        return stocks;

    }

    public Stock findStockById(Integer id) {
        return stocks.get(id);
    }

    public void deleteStockByMarketCap(Integer marketCap) {

        for(int i=0 ; i<stocks.size();i++)
        {
            if(stocks.get(i).getMarketCap()==marketCap)
            {
                stocks.remove(i);
            }

        }

    }

    public void updateStocks(Stock stock) {

        for(int i=0 ; i<stocks.size();i++){
            if(stocks.get(i)==stock)
            {
                stocks.set(i,stock);

            }

        }
    }

    public static StockRepository getInstance() {
        if (instance == null)
            instance = new StockRepository();
        return instance;
    }

}
