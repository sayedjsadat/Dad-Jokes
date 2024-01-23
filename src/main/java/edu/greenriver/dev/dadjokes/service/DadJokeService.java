package edu.greenriver.dev.dadjokes.service;

import edu.greenriver.dev.dadjokes.db.DadJokeRepository;
import edu.greenriver.dev.dadjokes.domain.DadJoke;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DadJokeService {
    private DadJokeRepository repository;

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
        List<DadJoke> movies = repository.findAll();
        return Collections.unmodifiableList(movies);
    }



    public void addJoke(DadJoke addJoke)
    {
        //this will result in an INSERT SQL statement
        repository.save(addJoke);
    }

    public Movie updateDadJoke(DadJoke updateDadJoke, String dadjoke)
    {
        //find the movie that matches
        /*Movie savedMovie = movies.get(movieIndexOf(title));

        //update the data in the movie
        savedMovie.setGenre(updatedMovie.getGenre());
        savedMovie.setReleaseYear(updatedMovie.getReleaseYear());
        savedMovie.setInternational(updatedMovie.isInternational());
        savedMovie.setRating(updatedMovie.getRating());

        return savedMovie;*/
        return null;
    }

    public void deleteMovie(String title)
    {
        /*int index = movieIndexOf(title);
        movies.remove(index);*/
    }

    //returns the index where the matching movie title is found
    private int movieIndexOf(String dadjoke)
    {
        List<DadJoke> movies = repository.findAll();
        for (int i = 0; i < movies.size(); i++)
        {
            DadJoke next = dadjoke.get(i);
            if (next.getTitle().equalsIgnoreCase(title))
            {
                return i;
            }
        }

        return -1;
    }
}
