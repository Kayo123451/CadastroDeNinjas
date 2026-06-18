package dev.java.kayo.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

//    GET -- Mandar uma requisição para mostrar as missoes
    @GetMapping("/listar")
    public String listarMissao(){
        return "lista de missoes";
    }

//    Post -- Mandar uma requisição para criar as missoes
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missao criada";
    }

//    Put -- Mandar uma requisição para alterar as missoes

    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missao alterada";
    }

//    Delete -- Mandar uma requisição para deletar as missoes
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao deletada";
    }


}
