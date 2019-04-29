package com.shopping.item.mapper;

import com.shopping.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface BrandMapper extends Mapper<Brand> {
    @Insert("insert into tb_category_brand (category_id, brand_id) VALUES (#{cid},#{bid})")
    void saveCategoryBrand(@Param("cid") Long cid,@Param("bid") Long bid);
}
