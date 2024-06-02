package com.lbernardes.api.video;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroVideo(


        @NotBlank
        String titulo,
        @NotBlank
        String descricao,
        @NotBlank
        String url) {
}