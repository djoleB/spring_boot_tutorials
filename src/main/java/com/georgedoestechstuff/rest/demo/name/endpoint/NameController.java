package com.georgedoestechstuff.rest.demo.name.endpoint;

import com.georgedoestechstuff.rest.demo.common.Response;
import com.georgedoestechstuff.rest.demo.name.endpoint.payload.NameDto;
import com.georgedoestechstuff.rest.demo.name.service.NameService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NameController {

    private final NameService nameService;

    public NameController(NameService nameService) {
        this.nameService = nameService;
    }

    @GetMapping(path = "/names")
    public Response<NameDto> getFirstName() {

        List<NameDto> names = nameService.findAll();
        return createResponse(names);
    }

    @GetMapping(path = "/names/{id}")
    public Response<NameDto> getById(@PathVariable("id") Long id) {

        List<NameDto> nameDto = List.of(nameService.findById(id));
        return createResponse(nameDto);
    }

    @PostMapping(path = "/names")
    public Response<NameDto> saveName(@Validated @RequestBody NameDto nameDto) {

        List<NameDto> saved = List.of(nameService.save(nameDto));
        return createResponse(saved);
    }

    @PutMapping(path = "/names/{id}")
    public Response<NameDto> updateName(@PathVariable("id") Long id, @RequestBody NameDto nameDto) {

        List<NameDto> updated = List.of(nameService.update(id, nameDto));
        return createResponse(updated);
    }

    @DeleteMapping(path = "/names/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateName(@PathVariable("id") Long id) {

        nameService.deleteById(id);
    }

    private Response<NameDto> createResponse(List<NameDto> nameDto) {

        return  Response.<NameDto>builder()
                .data(nameDto)
                .build();
    }

}
