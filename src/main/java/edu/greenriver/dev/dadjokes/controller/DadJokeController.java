package edu.greenriver.dev.dadjokes.controller;


import edu.greenriver.dev.dadjokes.domain.DadJoke;
import edu.greenriver.dev.dadjokes.service.DadJokeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("jokes")
    public DadJoke updateDadJoke (@PathVariable int id,
                               @RequestBody String newJokeText )
    {
        return service.updateDadJoke(id, newJokeText);
    }

    public void deleteJoke(@PathVariable int id)
    {
        service.deleteJoke(id);
    }

}
