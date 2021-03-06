package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConfigTest {
    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithoutCommentAndWithNoCorrectLine() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test
    public void whenPairWithComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.name"), is("Alexey"));
        assertThat(config.value("hibernate.connection.surname"), is("Sapsay"));
        assertThat(config.value("hibernate.dialect"), is("org.hibernate.dialect.PostgreSQLDialect"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithCommentAndNullValue() {
        String path = "./data/pair_with_comment_and_null_value.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithCommentAndNullValue2() {
        String path = "./data/pair_with_comment_and_null_value2.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithCommentAndNullValue3() {
        String path = "./data/pair_with_comment_and_null_value3.properties";
        Config config = new Config(path);
        config.load();
    }
}