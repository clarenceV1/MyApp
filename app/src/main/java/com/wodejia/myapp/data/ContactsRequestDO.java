package com.wodejia.myapp.data;

import java.io.Serializable;

/**
 * Created by clarence on 16/9/2.
 */
public class ContactsRequestDO implements Serializable {

    private String key;
    private String value;
    private String title;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
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
