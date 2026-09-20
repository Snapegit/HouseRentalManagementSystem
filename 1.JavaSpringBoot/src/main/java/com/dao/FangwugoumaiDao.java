package com.dao;

import com.entity.FangwugoumaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FangwugoumaiVO;
import com.entity.view.FangwugoumaiView;


/**
 * 房屋购买
 * 
 * @author 
 * @email 
 * @date 2024-03-06 09:50:15
 */
public interface FangwugoumaiDao extends BaseMapper<FangwugoumaiEntity> {
	
	List<FangwugoumaiVO> selectListVO(@Param("ew") Wrapper<FangwugoumaiEntity> wrapper);
	
	FangwugoumaiVO selectVO(@Param("ew") Wrapper<FangwugoumaiEntity> wrapper);
	
	List<FangwugoumaiView> selectListView(@Param("ew") Wrapper<FangwugoumaiEntity> wrapper);

	List<FangwugoumaiView> selectListView(Pagination page,@Param("ew") Wrapper<FangwugoumaiEntity> wrapper);

	
	FangwugoumaiView selectView(@Param("ew") Wrapper<FangwugoumaiEntity> wrapper);
	

}
