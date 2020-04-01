package com.springboot.service;

import com.springboot.pojo.Hero;

import java.util.List;

public interface HeroService {
    public List<Hero> getAllHero();

    void InsertHero(Hero hero);

    Hero getOneHero(Integer id);

    void updateHero(Hero hero);
}
