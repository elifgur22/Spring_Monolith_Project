package com.elif.mapper;

import com.elif.dto.request.DoktorInfoRequestDto;
import com.elif.dto.request.DoktorSaveRequestdto;
import com.elif.dto.response.DoktorResponseDto;
import com.elif.entity.Doktor;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DoktorMapper {
    DoktorMapper INSTANCE = Mappers.getMapper(DoktorMapper.class);

    Doktor fromDoktorSaveRequestDtoToDoktor(final DoktorSaveRequestdto dto);

    DoktorResponseDto fromDoktorToDoktorResponseDto (final Doktor doktor);
    Doktor fromDoktorInfoRequestDtoToDoktor (final DoktorInfoRequestDto dto);

}
