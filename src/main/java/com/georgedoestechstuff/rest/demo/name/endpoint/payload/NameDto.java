package com.georgedoestechstuff.rest.demo.name.endpoint.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NameDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String address;

}
