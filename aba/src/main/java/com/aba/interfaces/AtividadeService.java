package com.aba.interfaces;

import com.aba.dto.AtividadeDTO;
import com.aba.dto.AtividadeDTOEditar;
import com.aba.model.Atividade;
import org.springframework.http.ResponseEntity;

public interface AtividadeService {

    public ResponseEntity<?> cadastrarAtividade(AtividadeDTO atividadeDTO);
    public ResponseEntity<?> editarAtividade(Long id, AtividadeDTOEditar atividadeDTOEditar);
    public ResponseEntity<?> removerAtividade(Long id);
    public ResponseEntity<?> consultarAtividade(Long id);
    public ResponseEntity<?> listarAtividades();
    public Atividade getAtividadeById(Long id);

}
