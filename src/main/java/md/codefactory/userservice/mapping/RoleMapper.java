package md.codefactory.userservice.mapping;

import md.codefactory.userservice.domain.Role;
import md.codefactory.userservice.mapping.dto.RoleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role roleDtoToRole(RoleDto roleDto);

    RoleDto roleToRoleDto(Role role);
}
