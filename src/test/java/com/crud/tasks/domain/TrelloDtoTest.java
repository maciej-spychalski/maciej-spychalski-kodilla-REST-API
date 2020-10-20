
package com.crud.tasks.domain;


import org.junit.Test;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

//@RunWith(SpringRunner.class)

public class TrelloDtoTest {


    @Test
    public void TrelloDtoTestSuite() {
        // Given
        TrelloDto trelloDto = new TrelloDto(1, 1);

        // When & Then
        assertEquals(1, trelloDto.getBoard());
        assertEquals(1, trelloDto.getCard());
    }

}
