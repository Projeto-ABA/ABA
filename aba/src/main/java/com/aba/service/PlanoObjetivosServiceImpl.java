package com.aba.service;

import com.aba.dto.PlanoObjetivosDTO;
import com.aba.dto.PlanosObjetivosDTO;
import com.aba.interfaces.PlanoObjetivosService;
import com.aba.model.Atividade;
import com.aba.model.Instrutor;
import com.aba.model.PlanoObjetivos;
import com.aba.repository.PlanoObjetivosRepository;
import com.aba.util.MessageError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanoObjetivosServiceImpl implements PlanoObjetivosService{

    @Autowired
    PlanoObjetivosRepository planoObjetivosRepository;

    @Autowired
    AtividadeServiceImpl atividadeService;

    @Autowired
    InstrutorServiceImpl instrutorService;

    public ResponseEntity<?> cadastrarPlanoObjetivos(PlanoObjetivosDTO planoObjetivosDTO) {
        Instrutor instrutor = this.instrutorService.getInstrutorByEmail(planoObjetivosDTO.getEmailInstrutor());
        if(instrutor == null){
            return MessageError.erroInstrutorNaoEncontradoByEmail(planoObjetivosDTO.getEmailInstrutor());
        }

        PlanoObjetivos planoObjetivos = new PlanoObjetivos(planoObjetivosDTO.getNomePlano(), instrutor,
                planoObjetivosDTO.getDescricaoAluno(), planoObjetivosDTO.getEstimativa());

        this.planoObjetivosRepository.save(planoObjetivos);
        return ResponseEntity.status(HttpStatus.OK).body(planoObjetivos.getDtoCompleto());
    }

    public ResponseEntity<?> editarPlanoObjetivos(Long id, PlanoObjetivosDTO planoObjetivosDTO) {
        PlanoObjetivos planoObjetivos = this.getPlanoObjetivosById(id);
        if(planoObjetivos == null){
            return MessageError.erroPlanoNaoEncontrado(id);
        }

        planoObjetivos.editar(planoObjetivosDTO, instrutorService.getInstrutorByEmail(planoObjetivosDTO.getEmailInstrutor()));
        this.planoObjetivosRepository.save(planoObjetivos);

        return ResponseEntity.status(HttpStatus.OK).body(planoObjetivos.getDtoCompleto());
    }

    public ResponseEntity<?> removerPlanoObjetivos(Long id) {
        PlanoObjetivos planoObjetivos = this.getPlanoObjetivosById(id);
        if(planoObjetivos == null){
            return MessageError.erroPlanoNaoEncontrado(id);
        }
        this.planoObjetivosRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Plano de Objetivos removido!");
    }

    public ResponseEntity<?> consultarPlanoObjetivos(Long id) {
        PlanoObjetivos planoObjetivos = this.getPlanoObjetivosById(id);
        if(planoObjetivos == null){
            return MessageError.erroPlanoNaoEncontrado(id);
        }

        return ResponseEntity.status(HttpStatus.OK).body(planoObjetivos.getDtoCompleto());
    }

    public ResponseEntity<?> listarPlanosDeObjetivos() {
        List<PlanoObjetivos> planoObjetivosList = this.planoObjetivosRepository.findAll();
        PlanosObjetivosDTO planosObjetivosDTO = new PlanosObjetivosDTO(planoObjetivosList);

        return ResponseEntity.status(HttpStatus.OK).body(planosObjetivosDTO.getDadosPlanosObjetivos());
    }

    public ResponseEntity<?> adicionarAtividadeNoPlano(Long idPlano, Long idAtividade) {
        Atividade atividade = this.atividadeService.getAtividadeById(idAtividade);
        if(atividade == null){
            return MessageError.erroAtividadeNaoEncontrada(idAtividade);
        }

        PlanoObjetivos planoObjetivos = this.getPlanoObjetivosById(idPlano);
        if(planoObjetivos == null){
            return MessageError.erroPlanoNaoEncontrado(idPlano);
        }

        planoObjetivos.addAtividade(atividade);
        this.planoObjetivosRepository.save(planoObjetivos);

        return ResponseEntity.status(HttpStatus.OK).body(planoObjetivos.getDtoCompleto());
    }

    public ResponseEntity<?> removerAtividadeDoPlano(Long idPlano, Long idAtividade) {
        Atividade atividade = this.atividadeService.getAtividadeById(idAtividade);
        if(atividade == null){
            return MessageError.erroAtividadeNaoEncontrada(idAtividade);
        }

        PlanoObjetivos planoObjetivos = this.getPlanoObjetivosById(idPlano);
        if(planoObjetivos == null){
            return MessageError.erroPlanoNaoEncontrado(idPlano);
        }

        planoObjetivos.removeAtividade(atividade);

        return ResponseEntity.status(HttpStatus.OK).body(planoObjetivos.getDtoCompleto());
    }

    public PlanoObjetivos getPlanoObjetivosById(Long id) {
        Optional<PlanoObjetivos> planoObjetivos = this.planoObjetivosRepository.findById(id);

        if (!planoObjetivos.isPresent()) {
            return null;
        }return planoObjetivos.get();
    }
}