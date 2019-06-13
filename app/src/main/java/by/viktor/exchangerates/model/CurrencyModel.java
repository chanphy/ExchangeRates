package by.viktor.exchangerates.model;

public class CurrencyModel {

    private String NumCode;
    private String CharCode;
    private String Scale;
    private String Name;
    private String Rate;


    public CurrencyModel( String NumCode, String CharCode, String Scale, String Name, String Rate) {

        this.NumCode = NumCode;
        this.CharCode = CharCode;
        this.Scale = Scale;
        this.Name = Name;
        this.Rate = Rate;
    }

    public String getNumCode() {
        return NumCode;
    }

    public String getCharCode() {
        return CharCode;
    }

    public String getScale() {
        return Scale;
    }

    public String getName() {
        return Name;
    }

    public String getRate() {
        return Rate;
    }
}
