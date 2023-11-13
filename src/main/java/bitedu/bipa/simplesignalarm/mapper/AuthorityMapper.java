package bitedu.bipa.simplesignalarm.mapper;

import bitedu.bipa.simplesignalarm.model.dto.RoleRequestDTO;
import bitedu.bipa.simplesignalarm.model.dto.UserOrgDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthorityMapper {
    int findAuthority(RoleRequestDTO roleRequestDTO);

    String getAuthorityName(int authorityCode);

}
