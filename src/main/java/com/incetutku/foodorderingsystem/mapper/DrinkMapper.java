package com.incetutku.foodorderingsystem.mapper;

import com.incetutku.foodorderingsystem.dto.DrinkDTO;
import com.incetutku.foodorderingsystem.entity.Drink;

public class DrinkMapper {
    private DrinkMapper() {
    }

    public static Drink mapToDrink(DrinkDTO drinkDTO) {
        Drink drink = new Drink();
        drink.setId(drinkDTO.getId());
        drink.setName(drinkDTO.getName());
        drink.setPrice(drinkDTO.getPrice());
        drink.setAddIce(drinkDTO.isAddIce());
        drink.setAddLemon(drinkDTO.isAddLemon());
        return drink;
    }

    public static DrinkDTO mapToDrinkDTO(Drink drink) {
        DrinkDTO drinkDTO = new DrinkDTO();
        drinkDTO.setId(drink.getId());
        drinkDTO.setName(drink.getName());
        drinkDTO.setPrice(drink.getPrice());
        drinkDTO.setAddIce(drink.isAddIce());
        drinkDTO.setAddLemon(drink.isAddLemon());
        return drinkDTO;
    }
}
