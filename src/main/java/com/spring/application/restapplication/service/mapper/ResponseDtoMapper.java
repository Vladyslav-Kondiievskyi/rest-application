package com.spring.application.restapplication.service.mapper;

public interface ResponseDtoMapper<D, T> {
    D mapToDto(T t);
}
