package dev.java.kayo.CadastroDeNinjas.Ninjas;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

//    Listar todos os ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

//    Listar ninjas por ID

    public NinjaModel listarNinjaID(Long id){
        Optional<NinjaModel> ninjaID = ninjaRepository.findById(id);
        return ninjaID.orElse(null);
    }

//    Criar um novo ninja

    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

//    Deletar um ninja

    public void deletarNinjaId(Long id){
        ninjaRepository.deleteById(id);
    }

}

//    Alterar um ninja

//    public NinjaModel atualizarNinja(NinjaModel ninja){
//        return ninjaRepository.save(ninja);
//    }
//
//}
