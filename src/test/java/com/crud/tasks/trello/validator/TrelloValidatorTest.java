package com.crud.tasks.trello.validator;


import com.crud.tasks.domain.*;
import nl.altindag.log.LogCaptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloValidatorTest {

    @Autowired
    TrelloValidator validator;

    @Test
    public void validateCardTestSuite() {
        // Given
        String expectedInfoMessageWhenTest = "Someone is testing my application!";
        String expectedInfoMessage = "Seems that my application is used in proper way.";
        LogCaptor logCaptor = LogCaptor.forClass(TrelloValidator.class);
        TrelloCard trelloCard1 = new TrelloCard("test", "test descripton", "1", "1");
        TrelloCard trelloCard2 = new TrelloCard("Trello card", "card descripton", "2", "2");

        // When
        validator.validateCard(trelloCard1);
        validator.validateCard(trelloCard2);

        // Then
        assertTrue(logCaptor.getInfoLogs().contains(expectedInfoMessageWhenTest));
        assertTrue(logCaptor.getInfoLogs().contains(expectedInfoMessage));
    }

    @Test
    public void validateTrelloBoardsTestSuite() {
        // Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "test_list", false));

        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(new TrelloBoard("1", "test", trelloLists));
        trelloBoardList.add(new TrelloBoard("1", "Board name", trelloLists));

        // when
        List<TrelloBoard> validatedTrelloBoards = validator.validateTrelloBoards(trelloBoardList);

        assertEquals(1, validatedTrelloBoards.size());
    }
}
