package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.YongjinxinxiEntity;
import com.entity.view.YongjinxinxiView;

import com.service.YongjinxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 佣金信息
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-17 00:59:07
 */
@RestController
@RequestMapping("/yongjinxinxi")
public class YongjinxinxiController {
    @Autowired
    private YongjinxinxiService yongjinxinxiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YongjinxinxiEntity yongjinxinxi, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huishouyuan")) {
			yongjinxinxi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YongjinxinxiEntity> ew = new EntityWrapper<YongjinxinxiEntity>();
		PageUtils page = yongjinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yongjinxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YongjinxinxiEntity yongjinxinxi, HttpServletRequest request){
        EntityWrapper<YongjinxinxiEntity> ew = new EntityWrapper<YongjinxinxiEntity>();
		PageUtils page = yongjinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yongjinxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YongjinxinxiEntity yongjinxinxi){
       	EntityWrapper<YongjinxinxiEntity> ew = new EntityWrapper<YongjinxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yongjinxinxi, "yongjinxinxi")); 
        return R.ok().put("data", yongjinxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YongjinxinxiEntity yongjinxinxi){
        EntityWrapper< YongjinxinxiEntity> ew = new EntityWrapper< YongjinxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yongjinxinxi, "yongjinxinxi")); 
		YongjinxinxiView yongjinxinxiView =  yongjinxinxiService.selectView(ew);
		return R.ok("查询佣金信息成功").put("data", yongjinxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YongjinxinxiEntity yongjinxinxi = yongjinxinxiService.selectById(id);
        return R.ok().put("data", yongjinxinxi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YongjinxinxiEntity yongjinxinxi = yongjinxinxiService.selectById(id);
        return R.ok().put("data", yongjinxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YongjinxinxiEntity yongjinxinxi, HttpServletRequest request){
    	yongjinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yongjinxinxi);

        yongjinxinxiService.insert(yongjinxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YongjinxinxiEntity yongjinxinxi, HttpServletRequest request){
    	yongjinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yongjinxinxi);

        yongjinxinxiService.insert(yongjinxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody YongjinxinxiEntity yongjinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yongjinxinxi);
        yongjinxinxiService.updateById(yongjinxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yongjinxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<YongjinxinxiEntity> wrapper = new EntityWrapper<YongjinxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huishouyuan")) {
			wrapper.eq("zhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = yongjinxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
