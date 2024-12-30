package com.incetutku.foodorderingsystem.service;

import com.incetutku.foodorderingsystem.dto.CuisineDTO;
import com.incetutku.foodorderingsystem.dto.DessertDTO;
import com.incetutku.foodorderingsystem.dto.MainCourseDTO;
import com.incetutku.foodorderingsystem.entity.Drink;
import com.incetutku.foodorderingsystem.repository.DrinkRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DatabaseInitializer {

    private final List<CuisineDTO> savedCuisines = new ArrayList<>();

    private final CuisineService cuisineService;
    private final DessertService dessertService;
    private final MainCourseService mainCourseService;
    private final DrinkRepository drinkRepository;

    public DatabaseInitializer(CuisineService cuisineService,
                               DessertService dessertService,
                               MainCourseService mainCourseService,
                               DrinkRepository drinkRepository) {
        this.cuisineService = cuisineService;
        this.dessertService = dessertService;
        this.mainCourseService = mainCourseService;
        this.drinkRepository = drinkRepository;
    }

    public void init() {
        createCuisines();
        createDesserts();
        createMainCourses();
        createDrinks();
    }

    private void createCuisines() {
        this.savedCuisines.add(cuisineService.save(new CuisineDTO("Polish", "Known for hearty dishes like pierogi and bigos, reflecting traditional Eastern European flavors.")));
        this.savedCuisines.add(cuisineService.save((new CuisineDTO("Mexican", "Famous for vibrant flavors and spices, featuring tacos, enchiladas, and churros."))));
        this.savedCuisines.add(cuisineService.save((new CuisineDTO("Italian", "Renowned for its pasta, pizza, and creamy desserts like tiramisu and panna cotta."))));
    }

    private void createDesserts() {

        savedCuisines.forEach(cuisine -> {
            switch (cuisine.getName()) {
                case "Polish" -> {
                    dessertService.save(new DessertDTO("Sernik", 5.99, "Creamy, cheesy, slightly sweet.", cuisine.getId()));
                    dessertService.save(new DessertDTO("Pączki", 3.49, "Sweet, fluffy, with a fruity or custard filling.", cuisine.getId()));
                    dessertService.save(new DessertDTO("Makowiec", 4.99, "Nutty, sweet, with a hint of poppy seeds.", cuisine.getId()));
                }
                case "Mexican" -> {
                    dessertService.save(new DessertDTO("Churros", 4.50, "Sweet, cinnamon-spiced, crispy.", cuisine.getId()));
                    dessertService.save(new DessertDTO("Flan", 5.00, "Creamy, caramel, slightly eggy.", cuisine.getId()));
                    dessertService.save(new DessertDTO("Tres Leches Cake", 6.00, "Milky, moist, and sweet.", cuisine.getId()));
                }
                case "Italian" -> {
                    dessertService.save(new DessertDTO("Tiramisu", 6.99, "Coffee-flavored, creamy, with cocoa notes.", cuisine.getId()));
                    dessertService.save(new DessertDTO("Panna Cotta", 5.49, "Creamy, silky, with subtle vanilla.", cuisine.getId()));
                    dessertService.save(new DessertDTO("Cannoli", 4.99, "Sweet, creamy ricotta with hints of citrus or chocolate.", cuisine.getId()));
                }
            }
        });
    }

    private void createMainCourses() {
        savedCuisines.forEach(cuisine -> {
            switch (cuisine.getName()) {
                case "Polish" -> {
                    mainCourseService.save(new MainCourseDTO("Pierogi", 8.99, false, cuisine.getId()));
                    mainCourseService.save(new MainCourseDTO("Bigos", 10.49, false, cuisine.getId()));
                    mainCourseService.save(new MainCourseDTO("Gołąbki", 9.50, false, cuisine.getId()));
                }
                case "Mexican" -> {
                    mainCourseService.save(new MainCourseDTO("Tacos al Pastor", 7.99, true, cuisine.getId()));
                    mainCourseService.save(new MainCourseDTO("Enchiladas", 9.49, true, cuisine.getId()));
                    mainCourseService.save(new MainCourseDTO("Pozole", 8.99, true, cuisine.getId()));
                }
                case "Italian" -> {
                    mainCourseService.save(new MainCourseDTO("Lasagna", 11.99, false, cuisine.getId()));
                    mainCourseService.save(new MainCourseDTO("Spaghetti Carbonara", 10.99, false, cuisine.getId()));
                    mainCourseService.save(new MainCourseDTO("Risotto alla Milanese", 12.49, false, cuisine.getId()));
                }
            }
        });
    }

    private void createDrinks() {
        List<Drink> drinks = new ArrayList<>();
        drinks.add(new Drink("Cola", 2.00, true, true));
        drinks.add(new Drink("Iced Tea", 2.50, true, true));
        drinks.add(new Drink("Orange Juice", 3.00, true, false));
        drinks.add(new Drink("Mineral Water", 1.50, true, true));
        drinks.add(new Drink("Hot Coffee", 2.00, false, false));
        drinks.add(new Drink("Milkshake", 4.00, false, false));

        drinkRepository.saveAll(drinks);
    }
}
