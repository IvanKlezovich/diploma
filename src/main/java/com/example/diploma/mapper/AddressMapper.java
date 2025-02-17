package com.example.diploma.mapper;

import com.example.diploma.dto.AddressDto;
import com.example.diploma.entity.Address;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDto toAddressDto(Address addressDto);
    Address toEntity(AddressDto addressDto);

    List<AddressDto> toAddressDtoList(List<Address> addressDtoList);
    List<Address> toEntityList(List<AddressDto> addressDtoDtoList);
}
