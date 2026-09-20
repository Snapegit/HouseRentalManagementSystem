package com.dao;

import com.entity.FangwuchushouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FangwuchushouVO;
import com.entity.view.FangwuchushouView;


/**
 * 房屋出售
 * 
 * @author 
 * @email 
 * @date 2024-03-06 09:50:15
 */
public interface FangwuchushouDao extends BaseMapper<FangwuchushouEntity> {
	
	List<FangwuchushouVO> selectListVO(@Param("ew") Wrapper<FangwuchushouEntity> wrapper);
	
	FangwuchushouVO selectVO(@Param("ew") Wrapper<FangwuchushouEntity> wrapper);
	
	List<FangwuchushouView> selectListView(@Param("ew") Wrapper<FangwuchushouEntity> wrapper);

	List<FangwuchushouView> selectListView(Pagination page,@Param("ew") Wrapper<FangwuchushouEntity> wrapper);

	
	FangwuchushouView selectView(@Param("ew") Wrapper<FangwuchushouEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<FangwuchushouEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<FangwuchushouEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<FangwuchushouEntity> wrapper);



}
