package com.lbernardes.api.video;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoVideo(
        @NotNull
        Long id,

        String titulo,

        String descricao) {
}