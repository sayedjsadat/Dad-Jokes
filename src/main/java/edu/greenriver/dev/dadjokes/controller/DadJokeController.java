package edu.greenriver.dev.dadjokes.controller;


import edu.greenriver.dev.dadjokes.domain.DadJoke;
import edu.greenriver.dev.dadjokes.service.DadJokeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class DadJokeController
{
    private DadJokeService service;

    public DadJokeController(DadJokeService service)
    {
        this.service = service;
    }

    @GetMapping("jokes")
    public List<DadJoke> all()
    {
        return service.all();
    }

    @PostMapping("jokes")
    public void addJoke (@RequestBody DadJoke newJoke)
    {
        service.addJoke(newJoke);
    }

    @PutMapping("jokes/{id}")
    public DadJoke updateDadJoke (@PathVariable int id,
                               @RequestBody String newJokeText )
    {
        return service.updateDadJoke(id, newJokeText);
    }

    @DeleteMapping("jokes/{id}")
    public void deleteJoke(@PathVariable int id)
    {
        service.deleteJoke(id);
    }

    @GetMapping("jokes/{id}")
    public DadJoke byId(@PathVariable int id){

        return service.byId(id);
    }

    @GetMapping("jokes/random")
    public DadJoke random(){

        Random random = new Random();
        int id = random.nextInt(1, 11);
        return service.byId(id);
    }

}
