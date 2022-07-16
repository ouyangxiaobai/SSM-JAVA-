package com.entity.view;

import com.entity.HuishouyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 回收员
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-17 00:59:07
 */
@TableName("huishouyuan")
public class HuishouyuanView  extends HuishouyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HuishouyuanView(){
	}
 
 	public HuishouyuanView(HuishouyuanEntity huishouyuanEntity){
 	try {
			BeanUtils.copyProperties(this, huishouyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
