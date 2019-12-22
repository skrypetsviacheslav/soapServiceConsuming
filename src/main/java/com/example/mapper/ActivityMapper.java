package com.example.mapper;

import com.example.consumingwebservice.wsdl.ActivityDto;
import com.example.entity.Activity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ActivityMapper {
    ActivityMapper INSTANCE = Mappers.getMapper(ActivityMapper.class);

    ActivityDto activityToActivityDto(Activity activity);

    Activity activityDtoToActivity(ActivityDto activityDto);
}
