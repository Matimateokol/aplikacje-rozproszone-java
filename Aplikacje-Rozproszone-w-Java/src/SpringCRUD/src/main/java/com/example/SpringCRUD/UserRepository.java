package com.example.SpringCRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getAll(){
        return jdbcTemplate.query("SELECT id, name FROM user",
                BeanPropertyRowMapper.newInstance(User.class));
    }

    public User getById(int id) {
        return jdbcTemplate.queryForObject("SELECT id, name FROM user WHERE " +
                "id = ?", BeanPropertyRowMapper.newInstance(User.class), id);
    }

    public int save(List<User> users) {
        users.forEach(user -> jdbcTemplate
                .update("INSERT INTO user(name) VALUES(?)",
                        user.getName()
                ));
        return 1;
    }

    public int update(User user) {
        return jdbcTemplate.update("UPDATE user SET name=? WHERE id=?",
                user.getName(), user.getId());
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM user WHERE id=?", id);
    }
}
