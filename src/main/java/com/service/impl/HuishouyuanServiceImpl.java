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


import com.dao.HuishouyuanDao;
import com.entity.HuishouyuanEntity;
import com.service.HuishouyuanService;
import com.entity.vo.HuishouyuanVO;
import com.entity.view.HuishouyuanView;

@Service("huishouyuanService")
public class HuishouyuanServiceImpl extends ServiceImpl<HuishouyuanDao, HuishouyuanEntity> implements HuishouyuanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuishouyuanEntity> page = this.selectPage(
                new Query<HuishouyuanEntity>(params).getPage(),
                new EntityWrapper<HuishouyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuishouyuanEntity> wrapper) {
		  Page<HuishouyuanView> page =new Query<HuishouyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HuishouyuanVO> selectListVO(Wrapper<HuishouyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuishouyuanVO selectVO(Wrapper<HuishouyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuishouyuanView> selectListView(Wrapper<HuishouyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuishouyuanView selectView(Wrapper<HuishouyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
