package com.wodejia.myapp.data;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by clarence on 16/9/9.
 */
@Entity
public class AccountDO {
    /**
     * 用户ID
     */
    @Id(autoincrement = true)
    private Long userId;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    @Transient
    private String password;
    /**
     * 用户昵称
     */
    private String userNickname;
    /**
     *  用户头像
     */
    private String userIcon;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 等级
     *
     * @return
     */
    private int level;

    @Generated(hash = 52373536)
    public AccountDO(Long userId, String account, String userNickname,
            String userIcon, String userName, int level) {
        this.userId = userId;
        this.account = account;
        this.userNickname = userNickname;
        this.userIcon = userIcon;
        this.userName = userName;
        this.level = level;
    }

    @Generated(hash = 443324541)
    public AccountDO() {
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
