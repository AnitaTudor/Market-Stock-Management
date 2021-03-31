package Model;

public class Stock {

    private final Integer id;
    private Integer marketCap;
    private Integer number;

    public Stock(Integer id, Integer marketCap, Integer number) {
        this.id = id;
        this.marketCap = marketCap;
        this.number = number;
    }


    public Integer getId() {
        return id;
    }

    public Integer getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Integer marketCap) {
        this.marketCap = marketCap;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}