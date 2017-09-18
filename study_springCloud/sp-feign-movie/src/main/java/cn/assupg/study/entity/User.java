package cn.assupg.study.entity;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("unused")
public class User implements Serializable {
    private Long id;

    private String username;

    private String name;

    private Short age;

    private BigDecimal balance;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return (username == null) ? null : username.trim();
    }

    public User setUsername(String username) {
        this.username = (username == null) ? null : username.trim();
        return this;
    }

    public String getName() {
        return (name == null) ? null : name.trim();
    }

    public User setName(String name) {
        this.name = (name == null) ? null : name.trim();
        return this;
    }

    public Short getAge() {
        return age;
    }

    public User setAge(Short age) {
        this.age = age;
        return this;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public User setBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }
}