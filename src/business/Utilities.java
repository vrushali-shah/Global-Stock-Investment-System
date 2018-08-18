/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.Stock.Risk;
import business.Stock.Stock;
import business.Stock.StockCatalog;
import business.Stock.StockHistory;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.NumberFormatter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeriesCollection;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public class Utilities {

    public static boolean isTextFieldEmpty(String x) {

        if (x.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Kindly enter details");
            return true;
        }
        return false;
    }

    public static boolean isValidNumber(String x) {

        try {
            int tempD = Integer.parseInt(x.trim());
            if (tempD <= 0) {
                JOptionPane.showMessageDialog(null, "Invalid input!\nKindly enter a valid value!");
                return false;
            }
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input!\nKindly enter a valid value!");
            return false;
        }
    }

    public static boolean isNameLength4(String text) {
        if (text.trim().length() < 4) {
            JOptionPane.showMessageDialog(null, "String is too short!\n");

            return false;
        } else {
            return true;
        }
    }

    public static String toProperCase(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1, text.length()).toLowerCase();
    }

    public static boolean validateEmail(String email) {

        //Pattern p=Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Pattern p = Pattern.compile("^[_a-z0-9-\\+]+(\\.[_a-z0-9-]+)*@[_a-z0-9-]+(\\.[a-z0-9]+)*(\\.[a-z]{2,})$", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(email);

        return m.matches();
    }

    public static JTextField createTextField() {
        JTextField field = new JTextField();
        ((AbstractDocument) field.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int off, String str, AttributeSet attr)
                    throws BadLocationException {
                fb.insertString(off, str.replaceAll("\\D++", ""), attr);  // remove non-digits
            }

            @Override
            public void replace(FilterBypass fb, int off, int len, String str, AttributeSet attr)
                    throws BadLocationException {
                fb.replace(off, len, str.replaceAll("\\D++", ""), attr);  // remove non-digits
            }
        });
        return field;
    }

    public static JFormattedTextField createFormattedTextField() {
        NumberFormat integerFormat = NumberFormat.getIntegerInstance();
        NumberFormatter formatter = new NumberFormatter(integerFormat);
        formatter.setAllowsInvalid(false);
        formatter.setMinimum(0);

        formatter.setOverwriteMode(true);
        JFormattedTextField textfield = new JFormattedTextField(formatter);
        textfield.setFocusLostBehavior(JFormattedTextField.COMMIT);
        return textfield;
    }

    public static float getConversionRate(String to, String from) {
        String url_str = "https://v3.exchangerate-api.com/pair/ae28603ab2cc3f730cc3942d/" + to + "/" + from;
        String req_result = "-1"; // Making Request
        try {
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();
            // Convert to JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));

            JsonObject jsonobj = root.getAsJsonObject();
            // Accessing object
            req_result = jsonobj.get("rate").getAsString();
            // System.out.println(req_result);

        } catch (Exception e) {
            System.out.println("in conversion: " + e.getMessage());
        }
        return Float.parseFloat(req_result);
    }

    public static StockCatalog stock(String fileName) {

        Risk risk[] = Risk.values();
        Random rm = new Random();
        int x = 0;
        ArrayList<String> rs = new ArrayList<>();

        StockCatalog stockCatalog = new StockCatalog();
        String nameExpression = "//name";
        String valueExpression = "//datum[@type='float']";
        String dateExpression = "//datum[@type='date']";
        NodeList nodeList1 = null;
        NodeList nodeList2 = null;

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        XPath xPath = XPathFactory.newInstance().newXPath();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {

            //File file = new File("C:\\Users\\Prashant\\Desktop\\"+fileName+".csv");
            File file = new File(System.getProperty("user.dir") + "\\db4o stock\\" + fileName + ".csv");
            Scanner sc = new Scanner(new FileReader(file));

            while (sc.hasNext()) {
                rs.add(sc.next());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        long start = System.currentTimeMillis();
        for (String sym : rs) {

            try {

                String xml = "https://www.quandl.com/api/v3/datasets/" + fileName.toUpperCase() + "/" + sym + ".xml?column_index=4&start_date=2017-08-01"
                        + "&end_date=2017-11-01&collapse=weekly&api_key=5rMecj5wHGP-mLen3M76";
                //"https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY_ADJUSTED&symbol=MSFT&apikey=76IWYGRVWZMJG57Q";
                DocumentBuilder builder = builderFactory.newDocumentBuilder();
                Document xmlDocument;
                try {
                    xmlDocument = builder.parse(xml);
                } catch (Exception e) {
                    System.out.println(sym);
                    x++;
                    continue;
                }

                Stock s = new Stock();

                //get Company name and symbol
                nodeList1 = (NodeList) xPath.compile(nameExpression).evaluate(xmlDocument, XPathConstants.NODESET);
                s.setCompanyName(nodeList1.item(0).getFirstChild().getNodeValue());
                s.setSymbol(sym);
                s.setRisk(risk[rm.nextInt(risk.length)]);

                //get list of date and list of price
                nodeList1 = (NodeList) xPath.compile(dateExpression).evaluate(xmlDocument, XPathConstants.NODESET);
                nodeList2 = (NodeList) xPath.compile(valueExpression).evaluate(xmlDocument, XPathConstants.NODESET);

                for (int i = 0; i < nodeList1.getLength(); i++) {
                    s.addHistory(formatter.parse(nodeList1.item(i).getFirstChild().getNodeValue()),
                            Double.parseDouble(nodeList2.item(i).getFirstChild().getNodeValue()));
                }
                stockCatalog.addStock(s);
            } catch (ParserConfigurationException | XPathExpressionException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        System.out.println("Success! " + (System.currentTimeMillis() - start));
        System.out.println(x);
        return stockCatalog;
    }

    public static double currentPrice(Stock s) {
        int x = 0;
        String symbol = s.getSymbol();
        String stockMarket = s.getNetwork().getCountry().getStockMarket();
        String valueExpression = "//datum[@type='float']";
        NodeList nodeList2 = null;

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        XPath xPath = XPathFactory.newInstance().newXPath();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        double price = -1;
        long start = System.currentTimeMillis();
        Date date = new Date();
        LocalDate ldate=LocalDate.now().minusDays(1);
      
        try {

            String xml = "https://www.quandl.com/api/v3/datasets/" + stockMarket + "/" + symbol + ".xml?column_index=4&start_date=" +  ldate.toString()
                    + "&end_date=" + ldate.toString() + "&collapse=weekly&api_key=5rMecj5wHGP-mLen3M76";
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDocument;
            try {
                xmlDocument = builder.parse(xml);
            } catch (Exception e) {
                System.out.println(symbol);
                x++;
                return -1;
            }

            //get Company name and symbol
            //get list of date and list of price
            nodeList2 = (NodeList) xPath.compile(valueExpression).evaluate(xmlDocument, XPathConstants.NODESET);

            price = Double.parseDouble(nodeList2.item(0).getFirstChild().getNodeValue());

        } catch (ParserConfigurationException | XPathExpressionException e) {
            System.out.println("Error in currentprice");
            price = -1;

        } catch (Exception e) {
            System.out.println("Error in currentprice");
            price = -1;

        }

//        System.out.println("Success! " + (System.currentTimeMillis() - start));
//        System.out.println(x);
        return price;
    }

    public static double newSite(String symbol) {

        String url_str = "https://api.iextrading.com/1.0/stock/" + symbol + "/quote";
        String req_result = "-1"; // Making Request
        try {
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();
            // Convert to JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));

            JsonObject jsonobj = root.getAsJsonObject();
            // Accessing object
            req_result = jsonobj.get("close").getAsString();
//            Scanner s = new Scanner(request.getInputStream()).useDelimiter("\\A");
//            req_result = s.hasNext() ? s.next() : "";
//            System.out.println(req_result);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return Double.parseDouble(req_result);

    }

    public static CategoryDataset createDataset(List<StockHistory> stockHistoryList) {

        SimpleDateFormat formatter = new SimpleDateFormat("yy-MM-dd");

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (StockHistory stockhistory : stockHistoryList) {
            dataset.setValue(stockhistory.getPrice(), "stock", formatter.format(stockhistory.getDate()));
        }
        return dataset;
    }

    public static CategoryDataset createDatasetGroup(List<Stock> stocks) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int i = 0;
        for (Stock s : stocks) {
            
            for (StockHistory stockhistory : s.getStockHistoryList()) {
                dataset.addValue(stockhistory.getPrice(), s.getSymbol(), formatter.format(stockhistory.getDate()));
            }
            i++;
        }
        return dataset;
    }

    public static PieDataset createPieDataset(Map<String, Integer> map) {
        DefaultPieDataset dataset = new DefaultPieDataset();

        for (Map.Entry<String, Integer> m : map.entrySet()) {
            dataset.setValue(m.getKey(), m.getValue());
        }
        return dataset;
    }

}
