package com.eadp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.eadp.dao.BaseDao;

/**
 * 
 * @author bolong.chen
 *
 */
@RestController
@RequestMapping("debug")
public class DebugController {

	@Autowired
	private BaseDao dao;

	@PostMapping("/queryAsMap")
	public ResponseEntity<List<Map<String, Object>>> queryAsMap(@RequestBody JSONObject json) {
		String sql = json.get("sql").toString();
		JSONObject params = json.getJSONObject("params");
		if (params == null) {
			params = new JSONObject();
		}
		List<Map<String, Object>> list = dao.queryAsMap(sql, params);
		return ResponseEntity.ok(list);
	}
}
