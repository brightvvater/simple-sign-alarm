package bitedu.bipa.simplesignalarm.mapper;
import bitedu.bipa.simplesignalarm.model.dto.PositionAndGradeDTO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface CommonMapper {
    PositionAndGradeDTO getPositionAndGrade(int userId);

}
