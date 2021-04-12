package View;

import Controller.YahooStock;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        YahooStock yahooStock = new YahooStock();
        //System.out.println(yahooStock.getStock("AAPL"));
        String[] stockNames = {"GOOG", "INTC", "UBER", "AAPL", "PLTR"};
        // System.out.println(yahooStock.getStocks(stockNames));
        yahooStock.getHistory("UBER", 2, "weekly");


    }
}
