package dev.java.kayo.CadastroDeNinjas.Missoes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.support.DefaultServerCodecConfigurer;
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
    @Operation (summary = "Lista as missoes", description = "Essa rota lista todas as missoes cadastradas do banco de dados")
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        List<MissoesDTO> listaMissoes = missoesService.listarMissoes();
        return ResponseEntity.ok(listaMissoes);
    }

//    Post -- Criar missao
    @PostMapping("/criarMissoes")
    @Operation(summary = "Cria uma nova missao", description = "Essa rota cria uma missao e insere no banco de dados")
    public ResponseEntity<?> criarMissao(@RequestBody MissoesDTO missoes){
        MissoesDTO missaoNova = missoesService.criarMissoes(missoes);
        return ResponseEntity.status(HttpStatus.CREATED).body("Missao criada com sucesso!");
    }

//    Put -- Atualizar missao

    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Altera uma missao", description = "Essa rota pega o id da missao e altera seu valor")
    public ResponseEntity<?> alterarMissao(

            @Parameter(description = "Usuario manda o id no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados da missao a ser atualizada no corpo da requisição")
            @RequestBody MissoesDTO missoes) {
        MissoesDTO missao = missoesService.atualizarMissoes(id, missoes);
        if (missao != null) {
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missao não encontrada!");
        }
    }


// DELETE -- Deletar missoes
@DeleteMapping("/deletar/{id}")
@Operation(summary = "Deleta uma missao", description = "Essa rota pega o id passado no caminho da requisição e deleta a missao")
    public ResponseEntity<?> deletarMissao(@PathVariable Long id){
        if (missoesService.listarNinjaID(id) != null){
            missoesService.deletarMissoes(id);
            return ResponseEntity.ok("Missao deletada com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missao não encontrada!");
    }
}

