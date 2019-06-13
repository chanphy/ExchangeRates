package by.viktor.exchangerates.views;

import com.arellomobile.mvp.MvpView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface ViewReadCurrency extends MvpView {

    void processXmlRateToday(Document data);
    Document getDataCurrencyToday(String dateDay);
    String getNode(String sTag, Element mElement);
}
