package com.gerenciamentodeprocessos.dtos;

import java.util.UUID;

public record LoginResponseDTO(String token, UUID id) {
}
