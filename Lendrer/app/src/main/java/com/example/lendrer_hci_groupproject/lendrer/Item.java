package com.example.lendrer_hci_groupproject.lendrer;

import java.util.Date;

/**
 * Created by Colton on 12/3/2017.
 */


//Each row in the database can be represented by an object
//Columns will represent the objects properties
public class Item {

    private int _id;
    private String _name;
    private String _date;
    private String _dueDate;
    private String _lentTo;

    public Item(){
    }

    public Item(String productname){
        this._name = productname;
    }

    public Item(String productname, String date, String _dueDate, String _lentTo){
        this._name = productname;
        this._date = date;
        this._dueDate = _dueDate;
        this._lentTo = _lentTo;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_name(String _productname) {
        this._name = _productname;
    }

    public void set_date(String _date) {
        this._date = _date;
    }

    public void set_dueDate(String _dueDate) {
        this._dueDate = _dueDate;
    }

    public void set_lentTo(String _lentTo) {
        this._lentTo = _lentTo;
    }

    public int get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }

    public String get_date() {
        return _date;
    }

    public String get_dueDate() {
        return _dueDate;
    }

    public String get_lentTo() {
        return _lentTo;
    }
}