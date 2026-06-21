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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);
    }

//    Mostrar todos os Ninjas (READ)

    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas(){
        return ninjaService.listarNinjas();
    }

//    Mostrar Ninja por ID (READ)
@GetMapping("/listar/{id}")
public NinjaDTO listarNinjaID(@PathVariable Long id){
    return ninjaService.listarNinjaID(id);
}

//    Alterar dados dos Ninjas (UPDATE)

    @PutMapping("/atualizar/{id}")
    public NinjaDTO atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO){
        return ninjaService.atualizarNinja(id, ninjaDTO);

    }

//    Deletar Ninja  (DELETE)

    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaID(@PathVariable Long id){
        ninjaService.deletarNinjaId(id);

    }


}
