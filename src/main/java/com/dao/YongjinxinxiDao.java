package com.dao;

import com.entity.YongjinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YongjinxinxiVO;
import com.entity.view.YongjinxinxiView;


/**
 * 佣金信息
 * 
 * @author 
 * @email 
 * @date 2021-03-17 00:59:07
 */
public interface YongjinxinxiDao extends BaseMapper<YongjinxinxiEntity> {
	
	List<YongjinxinxiVO> selectListVO(@Param("ew") Wrapper<YongjinxinxiEntity> wrapper);
	
	YongjinxinxiVO selectVO(@Param("ew") Wrapper<YongjinxinxiEntity> wrapper);
	
	List<YongjinxinxiView> selectListView(@Param("ew") Wrapper<YongjinxinxiEntity> wrapper);

	List<YongjinxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<YongjinxinxiEntity> wrapper);
	
	YongjinxinxiView selectView(@Param("ew") Wrapper<YongjinxinxiEntity> wrapper);
	
}
