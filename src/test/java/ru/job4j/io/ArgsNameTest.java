package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ArgsNameTest {
    @Test
    public void whenGetFirst() {
        ArgsName argsName = new ArgsName();
        ArgsName jvm = argsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        assertThat(jvm.get("Xmx"), is("512"));
    }

    @Test
    public void whenGetFirstReorder() {
        ArgsName argsName = new ArgsName();
        ArgsName jvm = argsName.of(new String[] {"-encoding=UTF-8", "-Xmx=512"});
        assertThat(jvm.get("Xmx"), is("512"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenGetNotExist() {
        ArgsName argsName = new ArgsName();
        ArgsName jvm = argsName.of(new String[] {});
        jvm.get("Xmx");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenWrongSomeArgument() {
        ArgsName argsName = new ArgsName();
        ArgsName jvm = argsName.of(new String[] {"-enconding=UTF-8", "-Xmx="});
    }
}