package com.crud.tasks.service;

import com.crud.tasks.domain.*;
import com.crud.tasks.trello.client.TrelloClient;
import com.crud.tasks.trello.facade.TrelloFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTest {

    @InjectMocks
    private TrelloService trelloService;

    @Mock
    private TrelloClient trelloClient;


    @Test
    public void fetchTrelloBoardsTest() {
        // Given
        List<TrelloListDto> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloListDto("1", "my_list", false));

        List<TrelloBoardDto> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoardDto("1", "my_task 1", trelloLists));
        trelloBoards.add(new TrelloBoardDto("2", "my_task 2", trelloLists));
        when(trelloClient.getTrelloBoards()).thenReturn(trelloBoards);

        // When
        List<TrelloBoardDto> fetchedTrelloBoards = trelloService.fetchTrelloBoards();

        // Then
        assertEquals(2, fetchedTrelloBoards.size());
    }

    @Test
    public void createTrelloCardTest() {
        // Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("trello card", "description of trello card", "1", "1");
        CreatedTrelloCardDto createdTrelloCardDto1 = new CreatedTrelloCardDto("1", "name", "shortUrl");
        when(trelloClient.createNewCard(trelloCardDto)).thenReturn(createdTrelloCardDto1);

        // When
        CreatedTrelloCardDto createdTrelloCardDto2 = trelloClient.createNewCard(trelloCardDto);

        // Then
        assertEquals("1", createdTrelloCardDto2.getId());
        assertEquals("name", createdTrelloCardDto2.getName());
        assertEquals("shortUrl", createdTrelloCardDto2.getShortUrl());
    }
}
