package com.dao;

import com.entity.FangwuchuzuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FangwuchuzuVO;
import com.entity.view.FangwuchuzuView;


/**
 * 房屋出租
 * 
 * @author 
 * @email 
 * @date 2024-03-06 09:50:15
 */
public interface FangwuchuzuDao extends BaseMapper<FangwuchuzuEntity> {
	
	List<FangwuchuzuVO> selectListVO(@Param("ew") Wrapper<FangwuchuzuEntity> wrapper);
	
	FangwuchuzuVO selectVO(@Param("ew") Wrapper<FangwuchuzuEntity> wrapper);
	
	List<FangwuchuzuView> selectListView(@Param("ew") Wrapper<FangwuchuzuEntity> wrapper);

	List<FangwuchuzuView> selectListView(Pagination page,@Param("ew") Wrapper<FangwuchuzuEntity> wrapper);

	
	FangwuchuzuView selectView(@Param("ew") Wrapper<FangwuchuzuEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<FangwuchuzuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<FangwuchuzuEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<FangwuchuzuEntity> wrapper);



}
