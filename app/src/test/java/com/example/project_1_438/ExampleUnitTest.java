package com.example.project_1_438;

import com.example.project_1_438.DAO.User;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void userIsCorrect() {
        assertEquals("joseph",CreateAccountActivity.testCreateAccount(new User("joseph",95045,"jnkjnk1","password",false)));
    }
    @Test
    public void passIsCorrect() {
        assertEquals("password",CreateAccountActivity.testCreateAccount(new User("joseph",95045,"jnkjnk1","password",false)));
    }
    @Test
    public void adminIsTrue() {
        assertEquals(true,CreateAccountActivity.testCreateAccount(new User("joseph",95045,"jnkjnk1","password",true)));
    }
    @Test
    public void zipCodeReturn() {
        assertEquals(95045,CreateAccountActivity.testCreateAccount(new User("joseph",95045,"jnkjnk1","password",true)));
    }
}