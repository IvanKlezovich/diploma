package com.example.diploma.mapper;

import com.example.diploma.dto.AddressDto;
import com.example.diploma.entity.Address;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

  AddressDto toAddressDto(Address addressDto);

  Address toEntity(AddressDto addressDto);

  List<AddressDto> toAddressDtoList(List<Address> addressDtoList);

  List<Address> toEntityList(List<AddressDto> addressDtoDtoList);
}
