package com.incetutku.foodorderingsystem.service;

import com.incetutku.foodorderingsystem.dto.DrinkDTO;
import com.incetutku.foodorderingsystem.entity.Drink;
import com.incetutku.foodorderingsystem.mapper.DrinkMapper;
import com.incetutku.foodorderingsystem.repository.DrinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkServiceImpl implements DrinkService {

    private final DrinkRepository drinkRepository;

    public DrinkServiceImpl(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    @Override
    public DrinkDTO save(DrinkDTO drinkDTO) {
        Drink savableDrink = DrinkMapper.mapToDrink(drinkDTO);
        Drink savedDrink = drinkRepository.save(savableDrink);
        return DrinkMapper.mapToDrinkDTO(savedDrink);
    }

    @Override
    public DrinkDTO getDrinkById(Long id) {
        Drink selectedDrink = drinkRepository.findById(id).orElseThrow(() -> new RuntimeException("Drink not found"));
        return DrinkMapper.mapToDrinkDTO(selectedDrink);
    }

    @Override
    public List<DrinkDTO> getAllDrinks() {
        return drinkRepository.findAll().stream().map(DrinkMapper::mapToDrinkDTO).toList();
    }
}
