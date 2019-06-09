package by.viktor.exchangerates.presenter;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import by.viktor.exchangerates.adapter.CurrencyAdapter;
import by.viktor.exchangerates.model.CurrencyModel;

public class ReadCurrency extends AsyncTask<Void, Void, Void> {

    private Context context;
    private DateVariettyDey dvd = new DateVariettyDey();
    private ProgressDialog progressDialog;
    private static ArrayList<CurrencyModel> currencies;
    private RecyclerView mRvCurrency;
    private URL url;
    private String URL = "https://www.nbrb.by/Services/XmlExRates.aspx?ondate=" + dvd.dateDate();


    public ReadCurrency(Context context, RecyclerView mRvCurrency) {
        this.mRvCurrency = mRvCurrency;
        this.context = context;
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
    }

    @Override
    protected void onPreExecute() {
        progressDialog.show();
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        processXml(getData(dvd.dateTomorrow())); //курс валют на сегодня
//        processXml(getData(dvd.dateTomorrow())); //курс валют на завтра
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        progressDialog.dismiss();
        super.onPostExecute(aVoid);
        CurrencyAdapter adapter = new CurrencyAdapter(context, currencies);
        mRvCurrency.setLayoutManager(new LinearLayoutManager(context));
        mRvCurrency.setAdapter(adapter);
    }

    private void processXml(Document data) {
        if (data != null) {
            currencies = new ArrayList<>();
            Element root = data.getDocumentElement();
            NodeList items = root.getElementsByTagName("Currency");
            Log.d("TAG", "\n" + "--->> " + items.getLength());
            for (int i = 0; i < items.getLength(); i++) {
                Node currency = items.item(i);
                if (currency.getNodeType() == Node.ELEMENT_NODE) {
                    Element nElement = (Element) currency;
                    currencies.add(new CurrencyModel(getNode("NumCode", nElement), getNode("CharCode", nElement), getNode("Scale", nElement),
                            getNode("Name", nElement), getNode("Rate", nElement)));
                }
            }
            for (CurrencyModel currencyModel : currencies) {
                Log.d("TAG", "\n" + "--->> " + currencyModel.getName() + currencyModel.getCharCode() + currencyModel.getNumCode() +
                        currencyModel.getScale() + currencyModel.getRate());
            }
        } else {
            Log.d("TAGGGG", "Data = " + dvd.dateDate());
        }
    }

    public Document getData(String dateDay) {
        try {
            url = new URL(URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDoc = builder.parse(inputStream);
            return xmlDoc;

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getNode(String sTag, Element mElement) {
        NodeList mList = mElement.getElementsByTagName(sTag).item(0)
                .getChildNodes();
        Node mValue = mList.item(0);
        return mValue.getNodeValue();
    }
}
