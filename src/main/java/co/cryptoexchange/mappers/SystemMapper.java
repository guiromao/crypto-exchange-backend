package co.cryptoexchange.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SystemMapper {

    @Update("UPDATE systems SET btc_Supply=#{value} WHERE id=1")
    public void updateBtc(@Param("value") Double value);

    @Update("UPDATE systems SET ada_Supply=#{value} WHERE id=1")
    public void updateAda(@Param("value") Double value);

}
