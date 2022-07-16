package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuishouyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HuishouyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HuishouyuanView;


/**
 * 回收员
 *
 * @author 
 * @email 
 * @date 2021-03-17 00:59:07
 */
public interface HuishouyuanService extends IService<HuishouyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuishouyuanVO> selectListVO(Wrapper<HuishouyuanEntity> wrapper);
   	
   	HuishouyuanVO selectVO(@Param("ew") Wrapper<HuishouyuanEntity> wrapper);
   	
   	List<HuishouyuanView> selectListView(Wrapper<HuishouyuanEntity> wrapper);
   	
   	HuishouyuanView selectView(@Param("ew") Wrapper<HuishouyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuishouyuanEntity> wrapper);
   	
}

