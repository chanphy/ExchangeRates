package by.viktor.exchangerates.model;

public class CurrencyModel {

    public String NumCode;
    public String CharCode;
    public String Scale;
    public String Name;
    public String Rate;


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

    public void setNumCode(String numCode) {
        this.NumCode = numCode;
    }

    public String getCharCode() {
        return CharCode;
    }

    public void setCharCode(String charCode) {
        this.CharCode = charCode;
    }

    public String getScale() {
        return Scale;
    }

    public void setScale(String Scale) {
        Scale = Scale;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        Name = Name;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String Rate) {
        Rate = Rate;
    }
}
