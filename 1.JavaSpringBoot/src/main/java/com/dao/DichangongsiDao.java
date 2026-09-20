package com.dao;

import com.entity.DichangongsiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DichangongsiVO;
import com.entity.view.DichangongsiView;


/**
 * 地产公司
 * 
 * @author 
 * @email 
 * @date 2024-03-06 09:50:15
 */
public interface DichangongsiDao extends BaseMapper<DichangongsiEntity> {
	
	List<DichangongsiVO> selectListVO(@Param("ew") Wrapper<DichangongsiEntity> wrapper);
	
	DichangongsiVO selectVO(@Param("ew") Wrapper<DichangongsiEntity> wrapper);
	
	List<DichangongsiView> selectListView(@Param("ew") Wrapper<DichangongsiEntity> wrapper);

	List<DichangongsiView> selectListView(Pagination page,@Param("ew") Wrapper<DichangongsiEntity> wrapper);

	
	DichangongsiView selectView(@Param("ew") Wrapper<DichangongsiEntity> wrapper);
	

}
