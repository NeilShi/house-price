package houseprice.dao;

import houseprice.domain.Community;
import houseprice.nonentity.vo.CommunityInfoVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommunityDao {

    @Select("SELECT * FROM community WHERE id = #{id}")
    Community findCommunityById(@Param("id") String id);

    @Select("SELECT * FROM community WHERE name = #{name}")
    Community findCommunityByName(@Param("name") String name);

    @Insert({
            "<script>",
            "insert ignore into community(year, month, city, district, area, name, price, on_sale) values",
            "<foreach collection='communityInfoVoList' item='item' index='index' separator=','>",
            "(#{item.year}, #{item.month}, #{item.city}, #{item.district}, #{item.area}, #{item.name}, #{item.price}, #{item.on_sale})",
            "</foreach>",
            "</script>"
    })
    int insertCommunityList(@Param(value = "communityInfoVoList") List<CommunityInfoVo> communityInfoVoList);
}
