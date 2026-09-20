package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DichangongsiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DichangongsiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DichangongsiView;


/**
 * 地产公司
 *
 * @author 
 * @email 
 * @date 2024-03-06 09:50:15
 */
public interface DichangongsiService extends IService<DichangongsiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DichangongsiVO> selectListVO(Wrapper<DichangongsiEntity> wrapper);
   	
   	DichangongsiVO selectVO(@Param("ew") Wrapper<DichangongsiEntity> wrapper);
   	
   	List<DichangongsiView> selectListView(Wrapper<DichangongsiEntity> wrapper);
   	
   	DichangongsiView selectView(@Param("ew") Wrapper<DichangongsiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DichangongsiEntity> wrapper);

   	

}

