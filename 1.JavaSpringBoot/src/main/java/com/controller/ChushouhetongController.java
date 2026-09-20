package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ChushouhetongEntity;
import com.entity.view.ChushouhetongView;

import com.service.ChushouhetongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 出售合同
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-06 09:50:15
 */
@RestController
@RequestMapping("/chushouhetong")
public class ChushouhetongController {
    @Autowired
    private ChushouhetongService chushouhetongService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChushouhetongEntity chushouhetong,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("dichangongsi")) {
			chushouhetong.setGongsizhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			chushouhetong.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ChushouhetongEntity> ew = new EntityWrapper<ChushouhetongEntity>();

		PageUtils page = chushouhetongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chushouhetong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChushouhetongEntity chushouhetong, 
		HttpServletRequest request){
        EntityWrapper<ChushouhetongEntity> ew = new EntityWrapper<ChushouhetongEntity>();

		PageUtils page = chushouhetongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chushouhetong), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChushouhetongEntity chushouhetong){
       	EntityWrapper<ChushouhetongEntity> ew = new EntityWrapper<ChushouhetongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chushouhetong, "chushouhetong")); 
        return R.ok().put("data", chushouhetongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChushouhetongEntity chushouhetong){
        EntityWrapper< ChushouhetongEntity> ew = new EntityWrapper< ChushouhetongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chushouhetong, "chushouhetong")); 
		ChushouhetongView chushouhetongView =  chushouhetongService.selectView(ew);
		return R.ok("查询出售合同成功").put("data", chushouhetongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChushouhetongEntity chushouhetong = chushouhetongService.selectById(id);
        return R.ok().put("data", chushouhetong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChushouhetongEntity chushouhetong = chushouhetongService.selectById(id);
        return R.ok().put("data", chushouhetong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChushouhetongEntity chushouhetong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(chushouhetong);
        chushouhetongService.insert(chushouhetong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChushouhetongEntity chushouhetong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(chushouhetong);
        chushouhetongService.insert(chushouhetong);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChushouhetongEntity chushouhetong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chushouhetong);
        chushouhetongService.updateById(chushouhetong);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chushouhetongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
