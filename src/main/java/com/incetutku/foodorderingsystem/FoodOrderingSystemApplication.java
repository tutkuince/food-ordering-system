package com.incetutku.foodorderingsystem;

import com.incetutku.foodorderingsystem.dto.DessertDTO;
import com.incetutku.foodorderingsystem.dto.DrinkDTO;
import com.incetutku.foodorderingsystem.dto.MainCourseDTO;
import com.incetutku.foodorderingsystem.dto.OrderDTO;
import com.incetutku.foodorderingsystem.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@SpringBootApplication
public class FoodOrderingSystemApplication implements CommandLineRunner {

    private final Scanner scanner = new Scanner(System.in);
    private Set<MainCourseDTO> mainCourseDTOs = new HashSet<>();
    private Set<DessertDTO> dessertDTOs = new HashSet<>();
    private Set<DrinkDTO> drinkDTOs = new HashSet<>();
    private boolean isMainCourse = true;

    private final DatabaseInitializer databaseInitializer;
    private final CuisineService cuisineService;
    private final MainCourseService mainCourseService;
    private final DessertService dessertService;
    private final DrinkService drinkService;
    private final OrderService orderService;

    public FoodOrderingSystemApplication(
            DatabaseInitializer databaseInitializer,
            CuisineService cuisineService,
            MainCourseService mainCourseService,
            DessertService dessertService,
            DrinkService drinkService,
            OrderService orderService) {
        this.databaseInitializer = databaseInitializer;
        this.cuisineService = cuisineService;
        this.mainCourseService = mainCourseService;
        this.dessertService = dessertService;
        this.drinkService = drinkService;
        this.orderService = orderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(FoodOrderingSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        databaseInitializer.init();
        System.out.println("Welcome to the Food Ordering System!");

        while (true) {
            System.out.println("\nWould you like to have something to eat or drink?");
            System.out.println("Press 1 to select food.");
            System.out.println("Press 2 to select drink.");
            System.out.println("Press 3 to clear my sections.");
            System.out.println("Press 0 to calculate Order.");
            System.out.print("Make your choice: ");
            String option = scanner.next();

            switch (option) {
                case "1" -> showCuisines(isMainCourse);
                case "2" -> showDrinks();
                case "3" -> clearSections();
                case "0" -> {
                    showOrder();
                }
                default -> System.out.println("Invalid selection, please try again.");
            }
        }
    }

    private void clearSections() {
        System.out.println("Clear my section");
        mainCourseDTOs.clear();
        dessertDTOs.clear();
        drinkDTOs.clear();
    }

    private void showCuisines(boolean isMainCourse) {
        System.out.println("Which cuisine would you like to choose?");
        cuisineService.getAll().forEach(cuisine -> {
            System.out.printf("(%s) %s - %s \n", cuisine.getId(), cuisine.getName(), cuisine.getDesc());
        });
        System.out.println("Make your choice:");
        String cuisineChoice = scanner.next();

        if (isMainCourse) {
            showMainCourses(cuisineChoice);
        } else {
            showDesserts(cuisineChoice);
        }
    }

    private void showMainCourses(String cuisineChoice) {
        try {
            Long cuisineId = Long.valueOf(cuisineChoice);
            mainCourseService.getMainCoursesByCuisineId(cuisineId).forEach(mainCourse -> {
                System.out.printf("(%s) %s(Spicy=%s) - %s PLN \n", mainCourse.getId(), mainCourse.getName(), mainCourse.isSpicy(), mainCourse.getPrice());
            });
            System.out.println("Make your choice:");

            String mainCourseChoice = scanner.next();
            Long mainCourseId = Long.valueOf(mainCourseChoice);
            MainCourseDTO mainCourseById = mainCourseService.getMainCourseById(mainCourseId);
            mainCourseDTOs.add(mainCourseById);

            System.out.println("What would you like for dessert?");
            isMainCourse = false;
            showCuisines(false);
        } catch (Exception e) {
            System.out.println("Please enter a valid number.");
            isMainCourse = true;
        }
    }

    private void showDesserts(String cuisineChoice) {
        try {
            Long cuisineId = Long.valueOf(cuisineChoice);
            dessertService.getDessertsByCuisineId(cuisineId).forEach(dessert -> {
                System.out.printf("(%s) %s(Flavor=%s) %s PLN \n", dessert.getId(), dessert.getName(), dessert.getFlavor(), dessert.getPrice());
            });
            System.out.println("Make your choice:");

            String dessertChoice = scanner.next();
            Long dessertId = Long.valueOf(dessertChoice);
            DessertDTO dessertById = dessertService.getDessertById(dessertId);
            dessertDTOs.add(dessertById);

            isMainCourse = true;
        } catch (Exception e) {
            System.out.println("Please enter a valid number.");
        }
    }

    private void showDrinks() {
        try {
            System.out.println("What would you like to drink?");

            drinkService.getAllDrinks().forEach(drink -> {
                System.out.printf("(%s) %s %s PLN \n", drink.getId(), drink.getName(), drink.getPrice());
            });

            System.out.println("Make your choice:");
            String drinkChoice = scanner.next();
            Long drinkId = Long.valueOf(drinkChoice);
            DrinkDTO drinkById = drinkService.getDrinkById(drinkId);

            System.out.println("Do you want to add ice to your drink?(true/false)");
            boolean hasIce = scanner.nextBoolean();
            drinkById.setAddIce(hasIce);

            System.out.println("Do you want to add lemon to your drink?(true/false)");
            boolean hasLemon = scanner.nextBoolean();
            drinkById.setAddLemon(hasLemon);

            drinkDTOs.add(drinkById);
        } catch (Exception e) {
            System.out.println("Please enter a valid number.");
        }
    }

    private void showOrder() {
        if ((!mainCourseDTOs.isEmpty() && !dessertDTOs.isEmpty()) || !drinkDTOs.isEmpty()) {
            OrderDTO order = new OrderDTO();
            order.setDessertDTOs(dessertDTOs);
            order.setDrinkDTOs(drinkDTOs);
            order.setMainCourseDTOs(mainCourseDTOs);

            OrderDTO savedOrder = orderService.save(order);
            System.out.println(savedOrder);
            System.exit(0);
        } else {
            System.out.println("\n The order cannot be displayed because you have not placed an order. \n\n");
        }
    }


}
