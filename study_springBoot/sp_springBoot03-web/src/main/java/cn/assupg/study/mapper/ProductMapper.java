package cn.assupg.study.mapper;

import cn.assupg.study.bean.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Insert(value = "INSERT INTO products (name, type, price) VALUES (#{name}, #{type}, #{price})")
    Long add(Product product);

    @Delete(value = "DELETE FROM products WHERE pid=${arg1}")
    void deleteByPrimaryKey(Long primaryKey);

    @Update(value = "UPDATE products SET name = #{name},type = #{type}, price = #{price} WHERE pid = #{pid}")
    void update(Product product);

    @Select(value = "SELECT * FROM products WHERE pid = #{arg1}")
    Product getByPrimaryKey(Long primaryKey);

    @Select(value = "SELECT * FROM products ORDER BY pid DESC ")
    List<Product> queryByLists();
}
