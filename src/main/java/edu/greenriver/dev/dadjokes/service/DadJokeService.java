package edu.greenriver.dev.dadjokes.service;

import edu.greenriver.dev.dadjokes.db.DadJokeRepository;
import edu.greenriver.dev.dadjokes.domain.DadJoke;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class DadJokeService {
    private DadJokeRepository repository;

    /**
     * @param repository for service
     */
    public DadJokeService(DadJokeRepository repository)
    {
        this.repository = repository;
    }

    public DadJoke getRandomMovie()
    {
        Random generator = new Random();
        List<DadJoke> movies = repository.findAll();
        int index = generator.nextInt(movies.size());
        return movies.get(index);
    }

    public List<DadJoke> all()
    {
        //convert to read-only list
        List<DadJoke> jokes = repository.findAll();
        return Collections.unmodifiableList(jokes);
    }



    public void addJoke(DadJoke joke)
    {
        //this will result in an INSERT SQL statement
        repository.save(joke);
    }

    public DadJoke updateDadJoke( int id, String newJokeText)
    {
        DadJoke currentJoke = repository.findById(id).orElseThrow();
        currentJoke.setDadjoke(newJokeText);

        return repository.save(currentJoke);
    }

    public void deleteJoke(int id)
    {
        repository.deleteById(id);
    }

}
