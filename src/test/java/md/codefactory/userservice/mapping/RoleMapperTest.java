package md.codefactory.userservice.mapping;

import md.codefactory.userservice.domain.Role;
import md.codefactory.userservice.domain.enums.RoleName;
import md.codefactory.userservice.mapping.dto.RoleDto;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

public class RoleMapperTest {


    private final RoleMapper roleMapper = Mappers.getMapper(RoleMapper.class);

    @Test
    public void should_map_role_to_roleDto() {

        Role role = new Role();
        role.setName(RoleName.ROLE_USER);

        RoleDto roleDto = roleMapper.roleToRoleDto(role);

        assertThat(roleDto).isNotNull();
        assertThat(roleDto.getName()).isEqualTo(role.getName().toString());

    }

}