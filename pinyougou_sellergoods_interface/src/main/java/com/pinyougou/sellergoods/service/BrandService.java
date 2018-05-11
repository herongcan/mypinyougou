package com.pinyougou.sellergoods.service;
import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

import java.util.List;
/**
 * 业务逻辑接口
 * @author Steven
 *
 */
public interface BrandService {

   /**
    * 返回全部列表
    * @return
    */
   public List<TbBrand> findAll();


   /**
    * 增加
    */
   void saveBrand(TbBrand brand);


   /**
    * 修改
    */
   void updateBrand(TbBrand brand);


   /**
    * 根据ID获取实体
    * @param id
    * @return
    */
   TbBrand findById(Long id);


   /**
    * 批量删除
    * @param ids
    */
   void deleteBrand(Long[] ids);

   /**
    * 分页
    * @param pageNum 当前页 码
    * @param pageSize 每页记录数
    * @return
    */
   PageResult<TbBrand> findPage(int pageNum, int pageSize, TbBrand brand);



}
