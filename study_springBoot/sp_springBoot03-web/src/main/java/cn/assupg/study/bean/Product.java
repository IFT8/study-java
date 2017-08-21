package cn.assupg.study.bean;


import java.sql.Timestamp;

public class Product {
    private Long pid;
    private String name;
    private String type;
    private Double price;
    private Timestamp createTime;

    @Override
    public String toString() {
        return String.format("Product{pid=%d, name='%s', type='%s', price=%s, createTime=%s}", pid, name, type, price, createTime);
    }

    public Long getPid() {
        return pid;
    }

    public Product setPid(Long pid) {
        this.pid = pid;
        return this;
    }

    public String getName() {
        return (name == null) ? null : name.trim();
    }

    public Product setName(String name) {
        this.name = (name == null) ? null : name.trim();
        return this;
    }

    public String getType() {
        return (type == null) ? null : type.trim();
    }

    public Product setType(String type) {
        this.type = (type == null) ? null : type.trim();
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Product setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public Product setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
        return this;
    }
}
