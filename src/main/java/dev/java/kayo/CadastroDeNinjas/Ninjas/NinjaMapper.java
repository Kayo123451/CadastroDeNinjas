package dev.java.kayo.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = new NinjaModel();

        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setRank(ninjaDTO.getRank());
        ninjaModel.setMissoes(ninjaDTO.getMissoes());

        return ninjaModel;

    }
        public NinjaDTO map(NinjaModel ninjaModel) {

        NinjaDTO ninjaDTO = new NinjaDTO();

            ninjaDTO.setNome(ninjaModel.getNome());
            ninjaDTO.setIdade(ninjaModel.getIdade());
            ninjaDTO.setEmail(ninjaModel.getEmail());
            ninjaDTO.setId(ninjaModel.getId());
            ninjaDTO.setRank(ninjaModel.getRank());
            ninjaDTO.setMissoes(ninjaModel.getMissoes());

            return ninjaDTO;

        }



}
