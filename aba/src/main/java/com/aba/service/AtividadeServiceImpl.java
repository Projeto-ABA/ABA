package com.aba.service;

import com.aba.dto.AtividadeDTO;
import com.aba.dto.AtividadeDTOCompleto;
import com.aba.dto.AtividadeDTOEditar;
import com.aba.dto.AtividadesDTO;
import com.aba.excecoes.AlunoInexistenteException;
import com.aba.interfaces.AtividadeService;
import com.aba.model.Aluno;
import com.aba.model.Atividade;
import com.aba.repository.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtividadeServiceImpl implements AtividadeService {

    @Autowired
    AtividadeRepository atividadeRepository;

    @Autowired
    InstrutorServiceImpl instrutorService;

    @Override
    public ResponseEntity<?> cadastrarAtividade(AtividadeDTO atividadeDTO) {
        Atividade atividade;
        atividade = new Atividade(this.instrutorService.getInstrutorByEmail(atividadeDTO.getEmailInstrutor()),
                atividadeDTO.getDescricao(), atividadeDTO.getTitulo(), atividadeDTO.getDataRealizacao());

        this.atividadeRepository.save(atividade);
        return ResponseEntity.status(HttpStatus.CREATED).body(atividade.getDtoCompleto());
    }

    public ResponseEntity<?> editarAtividade(Long id, AtividadeDTOEditar atividadeDTOEditar) {
        Atividade atividade;
        atividade = this.atividadeRepository.getReferenceById(id);

        atividade.editar(atividadeDTOEditar, this.instrutorService.getInstrutorByEmail(atividadeDTOEditar.getEmailInstrutor()));
        this.atividadeRepository.save(atividade);

        return ResponseEntity.status(HttpStatus.OK).body(atividade.getDtoCompleto());
    }

    public ResponseEntity<?> removerAtividade(Long id) {
        this.atividadeRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Atividade removida!");
    }


    public ResponseEntity<?> consultarAtividade(Long id){
        Atividade atividade;
        atividade = this.getAtividadeById(id);

        return ResponseEntity.status(HttpStatus.OK).body(atividade.getDtoCompleto());
    }

    public ResponseEntity<?> listarAtividades() {
        List<Atividade> atividades = this.atividadeRepository.findAll();
        AtividadesDTO atividadesDTO = new AtividadesDTO(atividades);

        return ResponseEntity.status(HttpStatus.OK).body(atividadesDTO.getDadosAtividades());
    }

    public Atividade getAtividadeById(Long id) {
        Optional<Atividade> atividadeOptional = this.atividadeRepository.findById(id);

        if (!atividadeOptional.isPresent()) {
            return null;
        }

        return atividadeOptional.get();
    }

    public Atividade getAtividadeByTitulo(String titulo) {
        Optional<Atividade> atividadeOptional = this.atividadeRepository.findByTitulo(titulo);

        if (!atividadeOptional.isPresent()) {
            return null;
        }

        return atividadeOptional.get();
    }

}