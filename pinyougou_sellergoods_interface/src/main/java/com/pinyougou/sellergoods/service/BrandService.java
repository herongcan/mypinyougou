package com.pinyougou.sellergoods.service;
import java.util.List;
import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

/**
 * 品牌业务逻辑接口
 * @author Steven
 *
 */
public interface BrandService {
   /**
    * 查询所有品牌
    * @return
    */
   public List<TbBrand> findAll();
   /**
    * 分页查询品牌列表
    * @return
    */
   public PageResult<TbBrand> findPage(int pageNum, int pageSize,TbBrand brand);
   /**
    * 新增品牌
    * @param brand
    */
   public void saveBrand(TbBrand brand);
   /**
    * 查询修改品牌信息
    * @param id
    */
   TbBrand findById(Long id);
   /**
    * 修改品牌
    * @param brand
    */
   public void updateBrand(TbBrand brand);
   /**
    * 跟据id列表删除数据
    * @param ids
    */
   public void deleteBrand(Long[] ids);

}
