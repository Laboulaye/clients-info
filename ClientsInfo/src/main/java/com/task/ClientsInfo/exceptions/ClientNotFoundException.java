package com.task.ClientsInfo.exceptions;

import lombok.NoArgsConstructor;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException() {
        super("Client not found");
    }
}
