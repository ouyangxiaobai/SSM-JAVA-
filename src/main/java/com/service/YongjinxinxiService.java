package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YongjinxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YongjinxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YongjinxinxiView;


/**
 * 佣金信息
 *
 * @author 
 * @email 
 * @date 2021-03-17 00:59:07
 */
public interface YongjinxinxiService extends IService<YongjinxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YongjinxinxiVO> selectListVO(Wrapper<YongjinxinxiEntity> wrapper);
   	
   	YongjinxinxiVO selectVO(@Param("ew") Wrapper<YongjinxinxiEntity> wrapper);
   	
   	List<YongjinxinxiView> selectListView(Wrapper<YongjinxinxiEntity> wrapper);
   	
   	YongjinxinxiView selectView(@Param("ew") Wrapper<YongjinxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YongjinxinxiEntity> wrapper);
   	
}

