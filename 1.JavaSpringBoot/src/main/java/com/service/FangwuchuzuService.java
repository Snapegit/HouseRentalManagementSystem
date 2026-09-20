package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FangwuchuzuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FangwuchuzuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FangwuchuzuView;


/**
 * 房屋出租
 *
 * @author 
 * @email 
 * @date 2024-03-06 09:50:15
 */
public interface FangwuchuzuService extends IService<FangwuchuzuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangwuchuzuVO> selectListVO(Wrapper<FangwuchuzuEntity> wrapper);
   	
   	FangwuchuzuVO selectVO(@Param("ew") Wrapper<FangwuchuzuEntity> wrapper);
   	
   	List<FangwuchuzuView> selectListView(Wrapper<FangwuchuzuEntity> wrapper);
   	
   	FangwuchuzuView selectView(@Param("ew") Wrapper<FangwuchuzuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FangwuchuzuEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<FangwuchuzuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<FangwuchuzuEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<FangwuchuzuEntity> wrapper);



}

