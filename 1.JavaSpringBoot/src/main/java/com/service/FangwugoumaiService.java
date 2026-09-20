package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FangwugoumaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FangwugoumaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FangwugoumaiView;


/**
 * 房屋购买
 *
 * @author 
 * @email 
 * @date 2024-03-06 09:50:15
 */
public interface FangwugoumaiService extends IService<FangwugoumaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangwugoumaiVO> selectListVO(Wrapper<FangwugoumaiEntity> wrapper);
   	
   	FangwugoumaiVO selectVO(@Param("ew") Wrapper<FangwugoumaiEntity> wrapper);
   	
   	List<FangwugoumaiView> selectListView(Wrapper<FangwugoumaiEntity> wrapper);
   	
   	FangwugoumaiView selectView(@Param("ew") Wrapper<FangwugoumaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FangwugoumaiEntity> wrapper);

   	

}

