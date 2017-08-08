package cn.assupg.study.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("unused")
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String name;

    @Column
    private Short age;

    @Column
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
