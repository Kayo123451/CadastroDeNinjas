package dev.java.kayo.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class
NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas (){
        return "Boas vindas";
    }

//    ENDPOINTS

//    Adicionar Ninjas (CREATE)

    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
       NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja Criada com sucesso! " + "Nome: " + novoNinja.getNome() + " ID: " + novoNinja.getId());
    }

//    Mostrar todos os Ninjas (READ)

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

//    Mostrar Ninja por ID (READ)
@GetMapping("/listar/{id}")
public ResponseEntity<?> listarNinjaID(@PathVariable Long id){
        if (ninjaService.listarNinjaID(id) != null){
        NinjaDTO ninja = ninjaService.listarNinjaID(id);
        return ResponseEntity.ok().body(ninja);
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com o id: " + id + " não encontrado!");
}

//    Alterar dados dos Ninjas (UPDATE)

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO){
        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaDTO);
        if (ninja != null){
            return ResponseEntity.ok(ninja);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja o id: " + id + " não encontrado!");
        }
    }

//    Deletar Ninja  (DELETE)

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaID(@PathVariable Long id){

        if (ninjaService.listarNinjaID(id) != null){
            ninjaService.deletarNinjaId(id);
            return ResponseEntity.ok("Ninja com o id: " + id + " deletado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O ninja com o id: " + id + " Não encontrado!");

    }


}
