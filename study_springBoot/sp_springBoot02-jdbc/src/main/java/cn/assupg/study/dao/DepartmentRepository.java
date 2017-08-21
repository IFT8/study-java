package cn.assupg.study.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(String name) {
        String sql = "INSERT INTO t_department (department_name) VALUES ('" + name + "')";
        jdbcTemplate.execute(sql);
    }

    public void listAll() {
        //String sql = "SELECT * FROM t_department WHERE department_delete_flag = ?";
        //String[] args = new String[]{"N"};
        //jdbcTemplate.query(sql)
    }
}
