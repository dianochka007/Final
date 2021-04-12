package Controller;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class YahooStock {

    public static StockData getStock(String stockName) throws IOException {
        StockData data = null;
        Stock stock = YahooFinance.get(stockName);
        data = new StockData(stock.getName(), stock.getQuote().getPrice(), stock.getQuote().getChange(), stock.getQuote().getBid(), stock.getQuote().getPreviousClose(), stock.getQuote().getDayHigh(), stock.getQuote().getDayLow());
        return data;
    }

    public static Map<String, Stock> getStocks(String[] stockNames) throws IOException {
        Map<String, Stock> stock = YahooFinance.get(stockNames);
        return stock;
    }

    //public static void getHistory(String stockName) throws IOException { // should use map <> as an argument in the brackets ‹
    //  Stock stock = YahooFinance.get(stockName); // should use map<>
    //List<HistoricalQuote> history = stock.getHistory(); // ? why get History does not work with maps
    //for (HistoricalQuote quote:history) {
    //  System.out.println("===========================");
    //System.out.println("Symbol: "+quote.getSymbol());
    //System.out.println("Date: "+convertDate(quote.getDate()));
    //System.out.println("High Price: "+quote.getHigh());
    //System.out.println("Low Price: "+quote.getLow());
    //System.out.println("Closed Price: "+quote.getClose());
    //System.out.println("===========================");
    //}
//}
    public static BigDecimal getHistory(String stockName, int year, String searchType) throws IOException { // should use map <> as an argument in the brackets ‹
        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        from.add(Calendar.YEAR, Integer.valueOf("-" + year));

        Stock stock = YahooFinance.get(stockName);
        List<HistoricalQuote> history = stock.getHistory(from, to, getInterval(searchType)); // ? why get History does not work with maps
        for (HistoricalQuote quote : history) {
            System.out.println("===========================");
            System.out.println("Symbol: " + quote.getSymbol());
            System.out.println("Date: " + convertDate(quote.getDate()));
            System.out.println("High Price: " + quote.getHigh());
            System.out.println("Low Price: " + quote.getLow());
            System.out.println("Closed Price: " + quote.getClose());
            System.out.println("===========================");
        }
        return null;
    }

    private static Interval getInterval(String searchType) {
        Interval interval = null;
        switch (searchType.toUpperCase()) {
            case "MONTHLY":
                interval = Interval.MONTHLY;
                break;
            case "WEEKLY":
                interval = Interval.WEEKLY;
                break;
            case "DAILY":
                interval = Interval.DAILY;
                break;

            default:
                break;
        }
        return interval;
    }

    public static String convertDate(Calendar cal) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = format.format(cal.getTime());
        return formatDate;
    }


}


