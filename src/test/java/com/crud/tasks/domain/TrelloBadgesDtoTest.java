package com.crud.tasks.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrelloBadgesDtoTest {

    @Test
    public void TrelloBadgesDtoTestSuite() {
        // Given
        TrelloDto trelloDto = new TrelloDto(1, 1);
        TrelloAttachmentsByTypeDto trelloAttachmentsByTypeDto = new TrelloAttachmentsByTypeDto(trelloDto);
        TrelloBadgesDto trelloBadgesDto = new TrelloBadgesDto(1,trelloAttachmentsByTypeDto);

        // When & Then
        assertEquals(1, trelloBadgesDto.getVotes());
        assertEquals(1, trelloBadgesDto.getAttachments().getTrello().getBoard());
        assertEquals(1, trelloBadgesDto.getAttachments().getTrello().getCard());
    }
}
