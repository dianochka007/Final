package Services;

import Controller.YahooStock;
import yahoofinance.YahooFinance;

import java.util.Calendar;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Objects;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static Controller.YahooStock.*;

public class DBServices {

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        String[] stockNames = {"GOOG", "INTC", "UBER", "AAPL", "PLTR", "RYAAY"};

        try {
            conn = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/Dbstock",
                            "root", "dianochka008");
            PreparedStatement st = conn.prepareStatement("INSERT INTO Stocks VALUES (?,?,?,?,?)");
            for (int i = 0; i < stockNames.length; i++) {
                st.setString(1, stockNames[i]);
                st.setDate(2, Date.valueOf(convertDate(Calendar.getInstance())));
                st.setBigDecimal(3, getStock(stockNames[i]).getDayHigh());
                st.setBigDecimal(4, getStock(stockNames[i]).getDayLow());
                st.setBigDecimal(5, getStock(stockNames[i]).getPreviousClose());

                st.executeUpdate();

            }

        } catch (SQLException | IOException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } finally {
            Objects.requireNonNull(conn).close();
        }
    }
}



