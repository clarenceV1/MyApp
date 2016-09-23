package com.wodejia.myapp.data.contacts;

/**
 * Created by clarence on 16/9/5.
 */
public abstract class ContactsBaseRequestDO {
    /**
     * 名称首字母，没有就用昵称首字母 不需要存表
     */
    private String firstLetter;

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

}
