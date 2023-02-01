package com.example.SpringCRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Post> getAll(){
        return jdbcTemplate.query("SELECT id, Insides FROM post",
                BeanPropertyRowMapper.newInstance(Post.class));
    }

    public Post getById(int id) {
        return jdbcTemplate.queryForObject("SELECT id, Insides FROM post WHERE " +
                "id = ?", BeanPropertyRowMapper.newInstance(Post.class), id);
    }

    public int save(List<Post> posts) {
        posts.forEach(post -> jdbcTemplate
                .update("INSERT INTO post(Insides) VALUES(?)",
                        post.getInsides()
                ));
        return 1;
    }

    public int update(Post post) {
        return jdbcTemplate.update("UPDATE post SET Insides=? WHERE id=?",
                post.getInsides(), post.getId());
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM post WHERE id=?", id);
    }
}
