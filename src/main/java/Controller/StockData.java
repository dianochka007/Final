package Controller;

import java.math.BigDecimal;

public class StockData {
    private String name;
    private BigDecimal price;
    private BigDecimal change;
    private BigDecimal bid;
    private BigDecimal previousClose;
    private BigDecimal dayHigh;
    private BigDecimal dayLow;

    public StockData(String name, BigDecimal price, BigDecimal change, BigDecimal bid, BigDecimal previousClose, BigDecimal dayHigh, BigDecimal dayLow) {
        this.name = name;
        this.price = price;
        this.change = change;
        this.bid = bid;
        this.previousClose = previousClose;
        this.dayHigh = dayHigh;
        this.dayLow = dayLow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getChange() {
        return change;
    }

    public void setChange(BigDecimal change) {
        this.change = change;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

    public BigDecimal getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(BigDecimal previousClose) {
        this.previousClose = previousClose;
    }

    public BigDecimal getDayHigh() {
        return dayHigh;
    }

    public void setDayHigh(BigDecimal dayHigh) {
        this.dayHigh = dayHigh;
    }

    public BigDecimal getDayLow() {
        return dayLow;
    }

    public void setDayLow(BigDecimal dayLow) {
        this.dayLow = dayLow;
    }

    @Override
    public String toString() {
        return "StockData{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", change=" + change +
                ", bid=" + bid +
                ", previousClose=" + previousClose +
                ", dayHigh=" + dayHigh +
                ", dayLow=" + dayLow +
                '}';
    }
}
