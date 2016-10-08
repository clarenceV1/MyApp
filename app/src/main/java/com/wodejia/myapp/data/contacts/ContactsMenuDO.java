package com.wodejia.myapp.data.contacts;

import java.io.Serializable;

/**
 * Created by clarence on 16/9/2.
 */
public class ContactsMenuDO implements Serializable {

    private int key;
    private String value;
    private String title;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
