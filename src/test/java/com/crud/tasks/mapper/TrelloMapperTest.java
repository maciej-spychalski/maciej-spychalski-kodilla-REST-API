package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTest {

    @Autowired
    TrelloMapper trelloMapper;

    @Test
    public void trelloBoardAndTrelloListMapperToDtoTestSuite() {
        // Given
        List<TrelloList> list = new ArrayList<>();
        list.add(new TrelloList("1", "list domain 1", true));
        list.add(new TrelloList("2", "list domain 2", false));

        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(new TrelloBoard("1", "Trello Board domain", list));

        // When
        List<TrelloBoardDto> trelloBoardToDto = trelloMapper.mapToBoardsDto(trelloBoardList);
        // Then
        assertEquals(1, trelloBoardToDto.size());
        assertEquals("1", trelloBoardToDto.get(0).getId());
        assertEquals("Trello Board domain", trelloBoardToDto.get(0).getName());
        assertEquals(2, trelloBoardToDto.get(0).getLists().size());
        assertEquals("1", trelloBoardToDto.get(0).getLists().get(0).getId());
        assertEquals("list domain 1", trelloBoardToDto.get(0).getLists().get(0).getName());
        assertEquals(true, trelloBoardToDto.get(0).getLists().get(0).isClosed());
    }

    @Test
    public void trelloBoardAndTrelloListMapperFromDtoTestSuite() {
        // Given
        List<TrelloListDto> listDto = new ArrayList<>();
        listDto.add(new TrelloListDto("3", "list Dto 3", true));
        listDto.add(new TrelloListDto("4", "list Dto 4", false));

        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        trelloBoardDtoList.add(new TrelloBoardDto("2", "Trello Board Dto", listDto));

        // When
        List<TrelloBoard> trelloBoardFromDto = trelloMapper.mapToBoards(trelloBoardDtoList);

        // Then
        assertEquals(1, trelloBoardFromDto.size());
        assertEquals("2", trelloBoardFromDto.get(0).getId());
        assertEquals("Trello Board Dto", trelloBoardFromDto.get(0).getName());
        assertEquals(2, trelloBoardFromDto.get(0).getLists().size());
        assertEquals("4", trelloBoardFromDto.get(0).getLists().get(1).getId());
        assertEquals("list Dto 4", trelloBoardFromDto.get(0).getLists().get(1).getName());
        assertEquals(false, trelloBoardFromDto.get(0).getLists().get(1).isClosed());
    }

    @Test
    public void trelloCardMapperToDtoTestSuite() {
        // Given
        TrelloCard trelloCard = new TrelloCard("Task domain", "Description domain", "1", "1");

        // When
        TrelloCardDto trelloCardToDto = trelloMapper.mapToCardDto(trelloCard);

        // Then
        assertEquals("Task domain", trelloCardToDto.getName());
        assertEquals("Description domain", trelloCardToDto.getDescription());
        assertEquals("1", trelloCardToDto.getPos());
        assertEquals("1", trelloCardToDto.getListId());
    }

    @Test
    public void trelloCardMapperFromDtoTestSuite() {
        // Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Task Dto", "Description Dto", "2", "2");

        // When
        TrelloCard trelloCardFromDto = trelloMapper.mapToCard(trelloCardDto);

        // Then
        assertEquals("Task Dto", trelloCardFromDto.getName());
        assertEquals("Description Dto", trelloCardFromDto.getDescription());
        assertEquals("2", trelloCardFromDto.getPos());
        assertEquals("2", trelloCardFromDto.getListId());
    }
}
