package com.andrsam.chatroom.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Application configuration.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {
    /**
     * RabbitMQ properties
     */

    /**
     * Host
     */
    @Value("${relay.host}")
    private String host;

    /**
     * Port
     */
    @Value("${relay.port}")
    private int port;

    /**
     * Login
     */
    @Value("${relay.client.login}")
    private String login;

    /**
     * Passcode
     */
    @Value("${relay.client.passcode}")
    private String passcode;

    /**
     * STOMP endpoint registration
     *
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
    }

    /**
     * RabbitMQ relay configuration
     *
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");

        registry.enableStompBrokerRelay("/topic")
                .setRelayHost(host)
                .setRelayPort(port)
                .setClientLogin(login)
                .setClientPasscode(passcode);
    }
}
