package com.example.litlites;

public class Stocks{
    String code;
    String iname;
    String types;
    String watt;
    String qty;
    String rates;

    public Stocks(){
    }

    public Stocks(String code, String iname, String types, String watt, String qty, String rates) {
        this.code = code;
        this.iname = iname;
        this.types = types;
        this.watt = watt;
        this.qty = qty;
        this.rates = rates;
    }

    public String getCode() {
        return code;
    }

    public String getIname() {
        return iname;
    }

    public String getTypes() {
        return types;
    }

    public String getWatt() {
        return watt;
    }

    public String getQty() {
        return qty;
    }

    public String getRates() {
        return rates;
    }
}
