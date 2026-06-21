package dev.java.kayo.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {


    private MissoesService missoesService;

    public  MissoesController(MissoesService missoesService){
        this.missoesService = missoesService;
    }


//    GET -- Mostrar as missoes
    @GetMapping("/listar")
    public List<MissoesModel > listarMissoes(){
        return missoesService.listarMissoes();
    }

//    Post -- Criar missao
    @PostMapping("/criarMissoes")
    public MissoesModel criarMissao(@RequestBody MissoesModel missoes){
        return  missoesService.criarMissoes(missoes);
    }

//    Put -- Atualizar missao

    @PutMapping("/atualizar/{id}")
    public MissoesModel alterarMissao(@PathVariable Long id, @RequestBody MissoesModel missoes){
       return missoesService.atualizarMissoes(id, missoes);
    }


// DELETE -- Deletar missoes
@DeleteMapping("/deletar/{id}")
    public MissoesModel deletarMissao(@PathVariable Long id){
        if (missoesService.listarNinjaID(id) != null){
            missoesService.deletarMissoes(id);
        }
        return null;
    }
}

