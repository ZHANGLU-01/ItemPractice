package com.springboot.service;

import com.springboot.mapper.HeroMapper;
import com.springboot.pojo.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {
    @Autowired
    private HeroMapper heroMapper;

    @Override
    public List<Hero> getAllHero() {
        return heroMapper.selectAll();
    }

    @Override
    public void InsertHero(Hero hero) {
        heroMapper.insert(hero);
    }

    @Override
    public Hero getOneHero(Integer id) {
        return heroMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateHero(Hero hero) {
        heroMapper.updateByPrimaryKey(hero);
    }

}
