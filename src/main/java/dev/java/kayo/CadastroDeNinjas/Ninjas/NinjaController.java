package dev.java.kayo.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vindas pra quem acessa ela")
    public String boasVindas (){
        return "Boas vindas";
    }

//    ENDPOINTS

//    Adicionar Ninjas (CREATE)

    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Essa rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do Ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
       NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja Criada com sucesso! " + "Nome: " + novoNinja.getNome() + " ID: " + novoNinja.getId());
    }

//    Mostrar todos os Ninjas (READ)

    @GetMapping("/listar")
    @Operation(summary = "Lista todos os ninjas do banco de dados", description = "Essa rota lista todos os ninjas que estão no banco de dados")
    @ApiResponses(value = {

            @ApiResponse(responseCode = "200", description = "Listagem de Ninjas"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado.")

    })
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

//    Mostrar Ninja por ID (READ)
@GetMapping("/listar/{id}")
@Operation(summary = "Lista um ninja especifico", description = "Essa rota lista o ninja do id que foi passado na requisição")
@ApiResponses(value = {

        @ApiResponse(responseCode = "200", description = "Ninja listado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Ninja não encontrado")

})
public ResponseEntity<?> listarNinjaID(@PathVariable Long id){
        if (ninjaService.listarNinjaID(id) != null){
        NinjaDTO ninja = ninjaService.listarNinjaID(id);
        return ResponseEntity.ok().body(ninja);
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com o id: " + id + " não encontrado!");
}

//    Alterar dados dos Ninjas (UPDATE)

    @PutMapping("/atualizar/{id}")

    @Operation(summary = "Altera ninja por id", description = "Essa rota altera um ninja pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Ninja não encontrado. Não foi possivel alterar")
    })

    public ResponseEntity<?> atualizarNinja(

            @Parameter(description = "Usuario manda o id no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados do ninja a ser atualizado no corpo da requisição")
            @RequestBody NinjaDTO ninjaDTO){

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

    @Operation(summary = "Deleta um ninja pelo seu id", description = "Essa rota deleta o ninja que ta cadastrado no id que foi passado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado. Não foi possivel deletar")
    })

    public ResponseEntity<String> deletarNinjaID(@PathVariable Long id){

        if (ninjaService.listarNinjaID(id) != null){
            ninjaService.deletarNinjaId(id);
            return ResponseEntity.ok("Ninja com o id: " + id + " deletado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O ninja com o id: " + id + " Não encontrado!");

    }


}
