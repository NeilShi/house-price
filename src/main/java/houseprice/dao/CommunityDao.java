package houseprice.dao;

import houseprice.domain.Community;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CommunityDao {
    @Select("SELECT * FROM community WHERE id = #{id}")
    Community findCommunityById(@Param("id") String id);
}
