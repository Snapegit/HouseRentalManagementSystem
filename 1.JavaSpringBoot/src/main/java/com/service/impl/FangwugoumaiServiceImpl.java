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


import com.dao.FangwugoumaiDao;
import com.entity.FangwugoumaiEntity;
import com.service.FangwugoumaiService;
import com.entity.vo.FangwugoumaiVO;
import com.entity.view.FangwugoumaiView;

@Service("fangwugoumaiService")
public class FangwugoumaiServiceImpl extends ServiceImpl<FangwugoumaiDao, FangwugoumaiEntity> implements FangwugoumaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FangwugoumaiEntity> page = this.selectPage(
                new Query<FangwugoumaiEntity>(params).getPage(),
                new EntityWrapper<FangwugoumaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FangwugoumaiEntity> wrapper) {
		  Page<FangwugoumaiView> page =new Query<FangwugoumaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<FangwugoumaiVO> selectListVO(Wrapper<FangwugoumaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FangwugoumaiVO selectVO(Wrapper<FangwugoumaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FangwugoumaiView> selectListView(Wrapper<FangwugoumaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FangwugoumaiView selectView(Wrapper<FangwugoumaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
