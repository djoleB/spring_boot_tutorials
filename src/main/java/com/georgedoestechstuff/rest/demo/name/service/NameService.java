package com.georgedoestechstuff.rest.demo.name.service;

import com.georgedoestechstuff.rest.demo.name.mapper.NameMapper;
import com.georgedoestechstuff.rest.demo.name.dao.NameRepository;
import com.georgedoestechstuff.rest.demo.name.endpoint.payload.Name;
import com.georgedoestechstuff.rest.demo.name.endpoint.payload.NameDto;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public class NameService {

    private final NameRepository nameRepository;
    private final NameMapper nameMapper;

    public NameService(NameRepository nameRepository, NameMapper nameMapper) {
        this.nameRepository = nameRepository;
        this.nameMapper = nameMapper;
    }

    public NameDto findById(Long id) {

        Optional<Name> name = nameRepository.findById(id);

        return name.map(nameMapper::convertToDto).orElse(null);
    }

    public List<NameDto> findAll() {

        return nameRepository.findAll().stream()
                .map(nameMapper::convertToDto)
                .collect(Collectors.toList());
    }

    public NameDto save(NameDto nameDto) {

        Name name = nameMapper.convertToEntity(nameDto);

        return nameMapper.convertToDto(nameRepository.save(name));
    }

    public NameDto update(Long id, NameDto nameDto) {

        Optional<Name> existingName = nameRepository.findById(id);

        Name name = nameMapper.convertToEntity(nameDto);

        existingName.ifPresent(s -> name.setId(s.getId()));

        return nameMapper.convertToDto(nameRepository.save(name));
    }

    public void deleteById(Long id) {
        nameRepository.deleteById(id);
    }

}
