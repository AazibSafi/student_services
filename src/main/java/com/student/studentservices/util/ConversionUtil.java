package com.student.studentservices.util;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConversionUtil {

    @Autowired
    private ModelMapper modelMapper;

    public <D, T> List<D> mapEntityListToDtoList(Collection<T> entityList, Class<D> outCLass) {
        return entityList.stream()
                .map(entity -> mapEntityToDto(entity, outCLass))
                .collect(Collectors.toList());
    }

    public <T> T mapEntityToDto(Object entityObject, Class<T> dtoObject) {
        return modelMapper.map(entityObject, dtoObject);
    }

    public <T> T mapDtoToEntity(Object dtoObject, Class<T> entityObject) {
        return modelMapper.map(dtoObject, entityObject);
    }

    public void mapSourceModelToDestinationModel(Object source, Object destination) {
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(source, destination);
    }

}
