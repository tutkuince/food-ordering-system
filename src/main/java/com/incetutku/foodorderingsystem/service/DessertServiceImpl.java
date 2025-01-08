package com.incetutku.foodorderingsystem.service;

import com.incetutku.foodorderingsystem.dto.CuisineDTO;
import com.incetutku.foodorderingsystem.dto.DessertDTO;
import com.incetutku.foodorderingsystem.entity.Dessert;
import com.incetutku.foodorderingsystem.mapper.DessertMapper;
import com.incetutku.foodorderingsystem.repository.DessertRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class DessertServiceImpl implements DessertService {

    private final DessertRepository dessertRepository;
    private final CuisineService cuisineService;

    public DessertServiceImpl(DessertRepository dessertRepository, CuisineService cuisineService) {
        this.dessertRepository = dessertRepository;
        this.cuisineService = cuisineService;
    }

    @Override
    @Transactional
    public DessertDTO save(DessertDTO dessertDTO) {
        Dessert savableDessert = DessertMapper.mapToDessert(dessertDTO);
        Dessert savedDessert = dessertRepository.save(savableDessert);
        DessertDTO savedDessertDTO = DessertMapper.mapToDessertDTO(savedDessert);
        CuisineDTO selectedCuisine = cuisineService.getById(dessertDTO.getCuisineId());
        Set<DessertDTO> dessertDTOS = selectedCuisine.getDessertDTOS();
        dessertDTOS.add(savedDessertDTO);
        cuisineService.save(selectedCuisine);
        return DessertMapper.mapToDessertDTO(savedDessert);
    }

    @Override
    public DessertDTO getDessertById(Long id) {
        Dessert selectedDessert = dessertRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dessert not found"));
        return DessertMapper.mapToDessertDTO(selectedDessert);
    }

    @Override
    public List<DessertDTO> getDessertsByCuisineId(Long cuisineId) {
        List<Dessert> dessertsByCuisineId = dessertRepository.findDessertsByCuisineId(cuisineId);
        return dessertsByCuisineId.stream().map(DessertMapper::mapToDessertDTO).toList();
    }

    @Override
    public List<DessertDTO> getAllDesserts() {
        return dessertRepository.findAll().stream().map(DessertMapper::mapToDessertDTO).toList();
    }
}
