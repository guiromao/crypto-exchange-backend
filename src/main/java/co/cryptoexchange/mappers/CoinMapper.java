package co.cryptoexchange.mappers;

import co.cryptoexchange.model.Coin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CoinMapper {

    @Select("SELECT * FROM coins WHERE code=#{code}")
    Coin findCoin(@Param("code") String code);

    @Select("SELECT value FROM coins WHERE code=#{code} LIMIT 1")
    Double getValueOfCoin(@Param("code") String code);

    @Update("UPDATE coins SET value = #{value} WHERE coin_Id = #{id}")
    int updateValue(@Param("id") Long id, @Param("value") Double value);

}
