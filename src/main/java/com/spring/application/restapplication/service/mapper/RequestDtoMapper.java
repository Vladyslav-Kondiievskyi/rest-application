package com.spring.application.restapplication.service.mapper;

public interface RequestDtoMapper<D, T> {
    T mapToModel(D dto);
}
