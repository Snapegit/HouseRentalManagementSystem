package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ChushouhetongDao;
import com.entity.ChushouhetongEntity;
import com.service.ChushouhetongService;
import com.entity.vo.ChushouhetongVO;
import com.entity.view.ChushouhetongView;

@Service("chushouhetongService")
public class ChushouhetongServiceImpl extends ServiceImpl<ChushouhetongDao, ChushouhetongEntity> implements ChushouhetongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChushouhetongEntity> page = this.selectPage(
                new Query<ChushouhetongEntity>(params).getPage(),
                new EntityWrapper<ChushouhetongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChushouhetongEntity> wrapper) {
		  Page<ChushouhetongView> page =new Query<ChushouhetongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ChushouhetongVO> selectListVO(Wrapper<ChushouhetongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChushouhetongVO selectVO(Wrapper<ChushouhetongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChushouhetongView> selectListView(Wrapper<ChushouhetongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChushouhetongView selectView(Wrapper<ChushouhetongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
