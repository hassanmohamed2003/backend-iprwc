package com.example.backendwebshop.domain.mapper;

public interface Mapper<E,D> {
    E fromDTOToEntity(D d);
    D fromEntityToDTO(E e);
    E fromIdToEntity(String id);
}