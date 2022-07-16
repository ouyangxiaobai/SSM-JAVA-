package com.entity.view;

import com.entity.YongjinxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 佣金信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-17 00:59:07
 */
@TableName("yongjinxinxi")
public class YongjinxinxiView  extends YongjinxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YongjinxinxiView(){
	}
 
 	public YongjinxinxiView(YongjinxinxiEntity yongjinxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, yongjinxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
