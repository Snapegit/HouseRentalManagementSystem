package com.dao;

import com.entity.ChushouhetongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChushouhetongVO;
import com.entity.view.ChushouhetongView;


/**
 * 出售合同
 * 
 * @author 
 * @email 
 * @date 2024-03-06 09:50:15
 */
public interface ChushouhetongDao extends BaseMapper<ChushouhetongEntity> {
	
	List<ChushouhetongVO> selectListVO(@Param("ew") Wrapper<ChushouhetongEntity> wrapper);
	
	ChushouhetongVO selectVO(@Param("ew") Wrapper<ChushouhetongEntity> wrapper);
	
	List<ChushouhetongView> selectListView(@Param("ew") Wrapper<ChushouhetongEntity> wrapper);

	List<ChushouhetongView> selectListView(Pagination page,@Param("ew") Wrapper<ChushouhetongEntity> wrapper);

	
	ChushouhetongView selectView(@Param("ew") Wrapper<ChushouhetongEntity> wrapper);
	

}
