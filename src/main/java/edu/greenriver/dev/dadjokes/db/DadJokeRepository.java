package edu.greenriver.dev.dadjokes.db;


import edu.greenriver.dev.dadjokes.domain.DadJoke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadJokeRepository extends JpaRepository<DadJoke, Integer>
{
    //we have all the CRUD methods we need
}
