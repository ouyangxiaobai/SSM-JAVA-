package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YongjinxinxiDao;
import com.entity.YongjinxinxiEntity;
import com.service.YongjinxinxiService;
import com.entity.vo.YongjinxinxiVO;
import com.entity.view.YongjinxinxiView;

@Service("yongjinxinxiService")
public class YongjinxinxiServiceImpl extends ServiceImpl<YongjinxinxiDao, YongjinxinxiEntity> implements YongjinxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YongjinxinxiEntity> page = this.selectPage(
                new Query<YongjinxinxiEntity>(params).getPage(),
                new EntityWrapper<YongjinxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YongjinxinxiEntity> wrapper) {
		  Page<YongjinxinxiView> page =new Query<YongjinxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YongjinxinxiVO> selectListVO(Wrapper<YongjinxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YongjinxinxiVO selectVO(Wrapper<YongjinxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YongjinxinxiView> selectListView(Wrapper<YongjinxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YongjinxinxiView selectView(Wrapper<YongjinxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
