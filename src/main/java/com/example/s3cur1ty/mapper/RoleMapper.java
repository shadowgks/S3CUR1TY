package com.example.s3cur1ty.mapper;

import com.example.s3cur1ty.dto.req.RoleReqDTO;
import com.example.s3cur1ty.dto.res.RoleResDTO;
import com.example.s3cur1ty.model.entites.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleResDTO toDto(Role user);
    Role toEntity(RoleReqDTO roleReqDTO);
}