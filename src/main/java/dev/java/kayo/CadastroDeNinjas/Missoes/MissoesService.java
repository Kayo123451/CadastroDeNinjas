package dev.java.kayo.CadastroDeNinjas.Missoes;


import dev.java.kayo.CadastroDeNinjas.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository){
        this.missoesRepository = missoesRepository;
    }

//    Criar Missoes

    public MissoesModel criarMissoes(MissoesModel missoes) {
        return missoesRepository.save(missoes);
    }

//    Listar Missoes

    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();

    }

//  Listar Missoes por ID

public MissoesModel listarNinjaID(Long id) {
    Optional<MissoesModel> missoesID = missoesRepository.findById(id);
    return missoesID.orElse(null);

}

//  Atualizar Missoes

    public MissoesModel atualizarMissoes(Long id, MissoesModel missoesAtualizado) {
        if(missoesRepository.existsById(id)) {
            missoesAtualizado.setId(id);
            return missoesRepository.save(missoesAtualizado);
        }
        return null;
    }

//  Deletar missoes

    public void deletarMissoes(Long id){
        missoesRepository.deleteById(id);
    }


}
