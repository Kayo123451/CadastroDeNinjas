package dev.java.kayo.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas (){
        return "Boas vindas";
    }

//    ENDPOINTS

//    Adicionar Ninjas (CREATE)

    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }

//    Mostrar todos os Ninjas (READ)

    @GetMapping("/listar")
    public String MostrarTodosOsNinjas(){
        return "Mostrar Ninjas";
    }

//    Mostrar Ninja por ID (READ)
@GetMapping("/listarID")
public String MostrarTodosOsNinjasPorId(){
    return "Mostrar Ninja por ID";
}

//    Alterar dados dos Ninjas (UPDATE)

    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterar Ninja por ID";
    }

//    Deletar Ninja  (DELETE)

    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "Deletar Ninja por ID";
    }


}
