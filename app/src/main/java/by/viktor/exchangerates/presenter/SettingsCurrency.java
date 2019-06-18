package by.viktor.exchangerates.presenter;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Switch;

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

import by.viktor.exchangerates.adapter.SettingsAdapter;
import by.viktor.exchangerates.model.CurrencyModel;


public class SettingsCurrency extends AsyncTask<Void, Void, Void> {

    public static ArrayList<CurrencyModel> namesCurrency;
    public RecyclerView recyclerView;
    public Context context;
    private GetDateDey getDateDey = new GetDateDey();
    private ProgressDialog progressDialog;
    Switch aSwitch;
//    public static ArrayList<CurrencyModel> currencies;
    private String URL = "https://www.nbrb.by/Services/XmlExRates.aspx?ondate=";

    public SettingsCurrency(Context context, RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
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
        processXmlRateToday(getDataCurrencyToday(getDateDey.dateToday()));
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        progressDialog.dismiss();
        super.onPostExecute(aVoid);
        SettingsAdapter adapter = new SettingsAdapter(namesCurrency, context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
    }

    public void processXmlRateToday(Document data) {
        if (data != null) {
            namesCurrency = new ArrayList<>();
            Element root = data.getDocumentElement();
            NodeList items = root.getElementsByTagName("Currency");
            for (int i = 0; i < items.getLength(); i++) {
                Node currency = items.item(i);
                if (currency.getNodeType() == Node.ELEMENT_NODE) {
                    Element nElement = (Element) currency;
                    namesCurrency.add(new CurrencyModel(getNode("NumCode", nElement), getNode("CharCode", nElement), getNode("Scale", nElement),
                            getNode("Name", nElement), getNode("Rate", nElement)));
                }
            }
        } else {
            //TODO show error
        }
    }
    public Document getDataCurrencyToday(String dateDay) {
        try {
            java.net.URL url = new URL(URL + getDateDey.dateToday());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            return builder.parse(inputStream);

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
    public String getNode(String sTag, Element mElement) {
        NodeList mList = mElement.getElementsByTagName(sTag).item(0)
                .getChildNodes();
        Node mValue = mList.item(0);
        return mValue.getNodeValue();
    }
}
