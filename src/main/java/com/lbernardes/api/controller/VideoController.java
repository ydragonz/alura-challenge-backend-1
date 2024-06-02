package com.lbernardes.api.controller;

import com.lbernardes.api.video.DadosAtualizacaoVideo;
import com.lbernardes.api.video.DadosCadastroVideo;
import com.lbernardes.api.video.Video;
import com.lbernardes.api.video.VideoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("videos")
public class VideoController {

    @Autowired
    private VideoRepository repository;

    @PostMapping
    @Transactional
    public Video cadastrar(@RequestBody @Valid DadosCadastroVideo dados) {
        return repository.save(new Video(dados));
    }

    @GetMapping
    public List<Video> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Video> exibir(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping
    @Transactional
    public Video atualizar(@RequestBody @Valid DadosAtualizacaoVideo dados) {
        Video video = repository.getReferenceById(dados.id());
        video.atualizarDados(dados);
        return repository.save(video);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}