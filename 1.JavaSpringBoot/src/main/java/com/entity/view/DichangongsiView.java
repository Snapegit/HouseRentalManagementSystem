package com.entity.view;

import com.entity.DichangongsiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 地产公司
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-06 09:50:15
 */
@TableName("dichangongsi")
public class DichangongsiView  extends DichangongsiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DichangongsiView(){
	}
 
 	public DichangongsiView(DichangongsiEntity dichangongsiEntity){
 	try {
			BeanUtils.copyProperties(this, dichangongsiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
