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
    @Id(autoincrement = true)
    private Long id;
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
     * 用户ID
     */
    private int userId;
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
     * @return
     */
    private int level;

    @Generated(hash = 797550883)
    public AccountDO(Long id, String account, int userId, String userNickname,
            String userIcon, String userName, int level) {
        this.id = id;
        this.account = account;
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
