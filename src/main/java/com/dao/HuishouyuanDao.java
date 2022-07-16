package com.dao;

import com.entity.HuishouyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HuishouyuanVO;
import com.entity.view.HuishouyuanView;


/**
 * 回收员
 * 
 * @author 
 * @email 
 * @date 2021-03-17 00:59:07
 */
public interface HuishouyuanDao extends BaseMapper<HuishouyuanEntity> {
	
	List<HuishouyuanVO> selectListVO(@Param("ew") Wrapper<HuishouyuanEntity> wrapper);
	
	HuishouyuanVO selectVO(@Param("ew") Wrapper<HuishouyuanEntity> wrapper);
	
	List<HuishouyuanView> selectListView(@Param("ew") Wrapper<HuishouyuanEntity> wrapper);

	List<HuishouyuanView> selectListView(Pagination page,@Param("ew") Wrapper<HuishouyuanEntity> wrapper);
	
	HuishouyuanView selectView(@Param("ew") Wrapper<HuishouyuanEntity> wrapper);
	
}
