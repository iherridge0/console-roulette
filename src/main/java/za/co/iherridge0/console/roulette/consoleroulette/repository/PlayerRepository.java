package za.co.iherridge0.console.roulette.consoleroulette.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.iherridge0.console.roulette.consoleroulette.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
