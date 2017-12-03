package com.example.colton.test;

import java.util.Date;

/**
 * Created by Colton on 12/2/2017.
 */

public class Items {

    private int _id;
    private String _name;
    private Date _date;

    public Items (String name) {
        this._name = name;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public int get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }
}
