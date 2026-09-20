package com.entity.view;

import com.entity.ChushouhetongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 出售合同
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-06 09:50:15
 */
@TableName("chushouhetong")
public class ChushouhetongView  extends ChushouhetongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChushouhetongView(){
	}
 
 	public ChushouhetongView(ChushouhetongEntity chushouhetongEntity){
 	try {
			BeanUtils.copyProperties(this, chushouhetongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
