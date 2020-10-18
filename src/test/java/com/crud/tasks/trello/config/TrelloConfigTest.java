package com.crud.tasks.trello.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloConfigTest {

    @Autowired
    TrelloConfig trelloConfig;

    @Test
    public void trelloConfigTestSuite() {
        // Given, When & Then
        assertTrue(!trelloConfig.getTrelloApiEndpoint().isEmpty());
        assertTrue(!trelloConfig.getTrelloAppKey().isEmpty());
        assertTrue(!trelloConfig.getTrelloToken().isEmpty());
        assertTrue(!trelloConfig.getTrelloUsername().isEmpty());
    }
}
