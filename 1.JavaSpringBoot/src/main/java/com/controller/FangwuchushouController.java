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

import com.entity.FangwuchushouEntity;
import com.entity.view.FangwuchushouView;

import com.service.FangwuchushouService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 房屋出售
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-06 09:50:15
 */
@RestController
@RequestMapping("/fangwuchushou")
public class FangwuchushouController {
    @Autowired
    private FangwuchushouService fangwuchushouService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FangwuchushouEntity fangwuchushou,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("dichangongsi")) {
			fangwuchushou.setGongsizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FangwuchushouEntity> ew = new EntityWrapper<FangwuchushouEntity>();

		PageUtils page = fangwuchushouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangwuchushou), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FangwuchushouEntity fangwuchushou, 
		HttpServletRequest request){
        EntityWrapper<FangwuchushouEntity> ew = new EntityWrapper<FangwuchushouEntity>();

		PageUtils page = fangwuchushouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangwuchushou), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FangwuchushouEntity fangwuchushou){
       	EntityWrapper<FangwuchushouEntity> ew = new EntityWrapper<FangwuchushouEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fangwuchushou, "fangwuchushou")); 
        return R.ok().put("data", fangwuchushouService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FangwuchushouEntity fangwuchushou){
        EntityWrapper< FangwuchushouEntity> ew = new EntityWrapper< FangwuchushouEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fangwuchushou, "fangwuchushou")); 
		FangwuchushouView fangwuchushouView =  fangwuchushouService.selectView(ew);
		return R.ok("查询房屋出售成功").put("data", fangwuchushouView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FangwuchushouEntity fangwuchushou = fangwuchushouService.selectById(id);
        return R.ok().put("data", fangwuchushou);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FangwuchushouEntity fangwuchushou = fangwuchushouService.selectById(id);
        return R.ok().put("data", fangwuchushou);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FangwuchushouEntity fangwuchushou, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fangwuchushou);
        fangwuchushouService.insert(fangwuchushou);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FangwuchushouEntity fangwuchushou, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fangwuchushou);
        fangwuchushouService.insert(fangwuchushou);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FangwuchushouEntity fangwuchushou, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangwuchushou);
        fangwuchushouService.updateById(fangwuchushou);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fangwuchushouService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	






    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<FangwuchushouEntity> ew = new EntityWrapper<FangwuchushouEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("dichangongsi")) {
            ew.eq("gongsizhanghao", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = fangwuchushouService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<FangwuchushouEntity> ew = new EntityWrapper<FangwuchushouEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("dichangongsi")) {
            ew.eq("gongsizhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = fangwuchushouService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<FangwuchushouEntity> ew = new EntityWrapper<FangwuchushouEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("dichangongsi")) {
            ew.eq("gongsizhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = fangwuchushouService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<FangwuchushouEntity> ew = new EntityWrapper<FangwuchushouEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("dichangongsi")) {
            ew.eq("gongsizhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = fangwuchushouService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<FangwuchushouEntity> ew = new EntityWrapper<FangwuchushouEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("dichangongsi")) {
            ew.eq("gongsizhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = fangwuchushouService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,FangwuchushouEntity fangwuchushou, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("dichangongsi")) {
            fangwuchushou.setGongsizhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<FangwuchushouEntity> ew = new EntityWrapper<FangwuchushouEntity>();
        int count = fangwuchushouService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangwuchushou), params), params));
        return R.ok().put("data", count);
    }



}
