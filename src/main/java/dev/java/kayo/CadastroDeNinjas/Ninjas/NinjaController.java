package dev.java.kayo.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

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
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

//    Mostrar todos os Ninjas (READ)

    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

//    Mostrar Ninja por ID (READ)
@GetMapping("/listar/{id}")
public NinjaModel listarNinjaID(@PathVariable Long id){
    return ninjaService.listarNinjaID(id);
}

//    Alterar dados dos Ninjas (UPDATE)

//    @PutMapping("/atualizar")
//    public NinjaModel atualizarNinja(@RequestBody NinjaModel ninja){
//        return ninjaService.atualizarNinja(ninja);
//    }

//    Deletar Ninja  (DELETE)

    @DeleteMapping("/deletar/{id}")
    public NinjaModel deleteNinja(@PathVariable Long id){
        return ninjaService.deleteNinja(id);
    }


}
