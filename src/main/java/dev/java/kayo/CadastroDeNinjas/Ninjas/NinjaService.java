package dev.java.kayo.CadastroDeNinjas.Ninjas;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaMapper ninjaMapper;
    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaMapper ninjaMapper, NinjaRepository ninjaRepository) {
        this.ninjaMapper = ninjaMapper;
        this.ninjaRepository = ninjaRepository;
    }

    //    Listar todos os ninjas
    public List<NinjaDTO> listarNinjas(){
        List <NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

//    Listar ninjas por ID

    public NinjaDTO listarNinjaID(Long id){
        Optional<NinjaModel> ninjaID = ninjaRepository.findById(id);
        return ninjaID.map(ninjaMapper::map).orElse(null);
    }

//    Criar um novo ninja

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

//    Deletar um ninja

    public void deletarNinjaId(Long id){
        ninjaRepository.deleteById(id);
    }

//    Alterar um ninja

    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if(ninjaExistente.isPresent()){
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO); //mapeia  o que tem dentro da variavel e transforma o ninjaModel no NinjaDTO
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }

}
