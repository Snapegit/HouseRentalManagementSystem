package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChushouhetongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChushouhetongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChushouhetongView;


/**
 * 出售合同
 *
 * @author 
 * @email 
 * @date 2024-03-06 09:50:15
 */
public interface ChushouhetongService extends IService<ChushouhetongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChushouhetongVO> selectListVO(Wrapper<ChushouhetongEntity> wrapper);
   	
   	ChushouhetongVO selectVO(@Param("ew") Wrapper<ChushouhetongEntity> wrapper);
   	
   	List<ChushouhetongView> selectListView(Wrapper<ChushouhetongEntity> wrapper);
   	
   	ChushouhetongView selectView(@Param("ew") Wrapper<ChushouhetongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChushouhetongEntity> wrapper);

   	

}

