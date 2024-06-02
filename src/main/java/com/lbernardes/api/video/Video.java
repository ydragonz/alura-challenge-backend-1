package com.lbernardes.api.video;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "videos")
@Entity(name = "Video")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Video {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo, descricao, url;

    public Video(DadosCadastroVideo dados) {
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
        this.url = dados.url();
    }

    public void atualizarDados(DadosAtualizacaoVideo dados) {
        if(dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if(dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
    }
}