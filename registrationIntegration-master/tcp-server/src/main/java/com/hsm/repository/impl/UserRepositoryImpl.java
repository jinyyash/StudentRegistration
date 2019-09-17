package com.hsm.repository.impl;

import com.hsm.models.User;
import com.hsm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final String QUERY = "SELECT * from user where username = ?";


    @Override
    public User findByUsername(String username) {
        return this.jdbcTemplate.queryForObject(QUERY, new UserMapper(),
                username);
    }
    private static final class UserMapper implements RowMapper<User> {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user=new User();
            user.setId(rs.getLong("id"));
            user.setUserName(rs.getString("user_name"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
            return user;

        }
    }
}
