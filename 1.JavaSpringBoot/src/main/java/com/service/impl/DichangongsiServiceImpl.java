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


import com.dao.DichangongsiDao;
import com.entity.DichangongsiEntity;
import com.service.DichangongsiService;
import com.entity.vo.DichangongsiVO;
import com.entity.view.DichangongsiView;

@Service("dichangongsiService")
public class DichangongsiServiceImpl extends ServiceImpl<DichangongsiDao, DichangongsiEntity> implements DichangongsiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DichangongsiEntity> page = this.selectPage(
                new Query<DichangongsiEntity>(params).getPage(),
                new EntityWrapper<DichangongsiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DichangongsiEntity> wrapper) {
		  Page<DichangongsiView> page =new Query<DichangongsiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DichangongsiVO> selectListVO(Wrapper<DichangongsiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DichangongsiVO selectVO(Wrapper<DichangongsiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DichangongsiView> selectListView(Wrapper<DichangongsiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DichangongsiView selectView(Wrapper<DichangongsiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
