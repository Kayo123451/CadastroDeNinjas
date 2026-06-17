package dev.java.kayo.CadastroDeNinjas.Missoes;

import dev.java.kayo.CadastroDeNinjas.Ninjas.NinjaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {
}
