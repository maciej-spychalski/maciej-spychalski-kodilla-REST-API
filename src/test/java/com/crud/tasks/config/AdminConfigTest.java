package com.crud.tasks.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminConfigTest {

    @Autowired
    AdminConfig adminConfig;

    @Test
    public void adminConfigTestSuite() {
        // Given, When & Then
        assertTrue(!adminConfig.getAdminMail().isEmpty());
    }
}
