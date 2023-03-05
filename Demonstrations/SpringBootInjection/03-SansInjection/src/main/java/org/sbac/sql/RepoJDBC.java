package org.sbac.sql;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RepoJDBC {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    public void setDataSource(final DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("APPMESSAGE");
    }

    public List<String> allMessages() {
        return jdbcTemplate.query("SELECT * FROM APPMESSAGE", new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("CONTENT");
            }
        });
    }


    public int addMessageA(String message) {
        message = Jsoup.clean(message, Whitelist.simpleText());
        return jdbcTemplate.update(
                "INSERT INTO APPMESSAGE VALUES (? ,?)", null, message
        );
    }

}

