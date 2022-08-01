package com.aba.interfaces;

import com.aba.dto.AtividadeDTO;
import com.aba.dto.PlanoObjetivosDTO;
import com.aba.model.PlanoObjetivos;
import org.springframework.http.ResponseEntity;

public interface PlanoObjetivosService {
    public ResponseEntity<?> cadastrarPlanoObjetivos(PlanoObjetivosDTO planoObjetivosDTO);
    public ResponseEntity<?> editarPlanoObjetivos(Long id, PlanoObjetivosDTO planoObjetivosDTO);
    public ResponseEntity<?> consultarPlanoObjetivos(Long id);
    public ResponseEntity<?> removerPlanoObjetivos(Long id);
    public ResponseEntity<?> listarPlanosDeObjetivos();
    public ResponseEntity<?> adicionarAtividadeNoPlano(Long idPlano, Long idAtividade);
    public ResponseEntity<?> removerAtividadeDoPlano(Long idPlano, Long idAtividade);
    public PlanoObjetivos getPlanoObjetivosById(Long id);
}
