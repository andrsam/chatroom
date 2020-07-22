package com.andrsam.chatroom.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Defines a message
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage {

    public enum MessageType {
        CHAT, JOIN, LEAVE
    }

    /**
     * Message type
     */
    private MessageType type;

    /**
     * User name
     */
    private String sender;

    /**
     * Chat message
     */
    private String content;
}
