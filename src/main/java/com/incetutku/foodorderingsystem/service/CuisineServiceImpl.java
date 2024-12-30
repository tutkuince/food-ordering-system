package com.incetutku.foodorderingsystem.service;

import com.incetutku.foodorderingsystem.dto.CuisineDTO;
import com.incetutku.foodorderingsystem.entity.Cuisine;
import com.incetutku.foodorderingsystem.mapper.CuisineMapper;
import com.incetutku.foodorderingsystem.repository.CuisineRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CuisineServiceImpl implements CuisineService {
    private final CuisineRepository cuisineRepository;

    public CuisineServiceImpl(CuisineRepository cuisineRepository) {
        this.cuisineRepository = cuisineRepository;
    }

    @Override
    public List<CuisineDTO> getAll() {
        return cuisineRepository.findAll().stream().map(CuisineMapper::toMapCuisineDTO).toList();
    }

    @Override
    public CuisineDTO getById(Long id) {
        Cuisine selectedCuisine = cuisineRepository.findById(id).orElseThrow(() -> new RuntimeException("Cuisine not found"));
        return CuisineMapper.toMapCuisineDTO(selectedCuisine);
    }

    @Override
    @Transactional
    public CuisineDTO save(CuisineDTO cuisineDTO) {
        Cuisine savableCuisine = CuisineMapper.toMapCuisine(cuisineDTO);
        Cuisine savedCuisine = cuisineRepository.save(savableCuisine);
        return CuisineMapper.toMapCuisineDTO(savedCuisine);
    }
}
