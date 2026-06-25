package dev.java.kayo.CadastroDeNinjas.Missoes;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {


    private final MissoesService missoesService;

    public  MissoesController(MissoesService missoesService){
        this.missoesService = missoesService;
    }


//    GET -- Mostrar as missoes
    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        List<MissoesDTO> listaMissoes = missoesService.listarMissoes();
        return ResponseEntity.ok(listaMissoes);
    }

//    Post -- Criar missao
    @PostMapping("/criarMissoes")
    public ResponseEntity<?> criarMissao(@RequestBody MissoesDTO missoes){
        MissoesDTO missaoNova = missoesService.criarMissoes(missoes);
        return ResponseEntity.status(HttpStatus.CREATED).body("Missao criada com sucesso!");
    }

//    Put -- Atualizar missao

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missoes) {
        MissoesDTO missao = missoesService.atualizarMissoes(id, missoes);
        if (missao != null) {
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missao não encontrada!");
        }
    }


// DELETE -- Deletar missoes
@DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarMissao(@PathVariable Long id){
        if (missoesService.listarNinjaID(id) != null){
            missoesService.deletarMissoes(id);
            return ResponseEntity.ok("Missao deletada com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missao não encontrada!");
    }
}

