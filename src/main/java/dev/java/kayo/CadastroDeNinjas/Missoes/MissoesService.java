package dev.java.kayo.CadastroDeNinjas.Missoes;


import dev.java.kayo.CadastroDeNinjas.Ninjas.NinjaDTO;
import dev.java.kayo.CadastroDeNinjas.Ninjas.NinjaMapper;
import dev.java.kayo.CadastroDeNinjas.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private final MissoesMapper missoesMapper;
    private final MissoesRepository missoesRepository;

    public MissoesService(MissoesMapper missoesMapper, MissoesRepository missoesRepository) {
        this.missoesMapper = missoesMapper;
        this.missoesRepository = missoesRepository;
    }

    //    Criar Missoes

    public MissoesDTO criarMissoes(MissoesDTO missoesDTO) {
        MissoesModel missoes = missoesMapper.map(missoesDTO);
        missoes = missoesRepository.save(missoes);
        return  missoesMapper.map(missoes);

    }

//    Listar Missoes

    public List<MissoesDTO> listarMissoes() {
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());

    }

//  Listar Missoes por ID

public MissoesDTO listarNinjaID(Long id) {
    Optional<MissoesModel> missoesID = missoesRepository.findById(id);
    return missoesID.map(missoesMapper::map).orElse(null);
}

//  Atualizar Missoes

    public MissoesDTO atualizarMissoes(Long id, MissoesDTO missoesDTO) {
      Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
      if(missaoExistente.isPresent()) {
          MissoesModel missaoAtualizada = missoesMapper.map(missoesDTO); //mapeia  o que tem dentro da variavel e transforma o MissoesModel no missoesDTO
          missaoAtualizada.setId(id);
          MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
          return missoesMapper.map(missaoSalva);
      }
      return null;
    }

//  Deletar missoes

    public void deletarMissoes(Long id){
        missoesRepository.deleteById(id);
    }


}
