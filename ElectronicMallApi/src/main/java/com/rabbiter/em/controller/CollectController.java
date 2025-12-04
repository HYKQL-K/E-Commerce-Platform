package com.rabbiter.em.controller;

import com.rabbiter.em.common.Result;

import com.rabbiter.em.entity.Collect;
import com.rabbiter.em.entity.Good;
import com.rabbiter.em.entity.User;
import com.rabbiter.em.service.CartService;
import com.rabbiter.em.service.CollectService;
import com.rabbiter.em.utils.TokenUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 收藏接口传输类
 * <p>
 *
 * @author zrx
 * @version v1.0.0
 * @date 2024/12/5 10:16
 */

@RestController
@RequestMapping("/api/collect")
public class CollectController {

	@Resource
	private CollectService collectService;

	/**
	 * 添加数据
	 *
	 * @param id 商品id
	 * @return
	 */
	@PostMapping("/add/{id}")
	public Result add(@PathVariable Long id) {

		User nowUser = TokenUtils.getCurrentUser();

		List<Collect> collectList = collectService.selectGoodByUIdAndGId(Long.valueOf(nowUser.getId()), id);
		if (collectList.size() != 0) {
			return  Result.success("已收藏");
		}

		Collect collect = new Collect();
		collect.setGoodId(id);
		collect.setUserId(Long.valueOf(nowUser.getId()));

		return Result.success(collectService.saveOrUpdate(collect));
	}


	/**
	 * 删除收藏
	 *
	 * @param id 商品id
	 * @return
	 */
	@PostMapping("/del/{id}")
	public Result delete(@PathVariable Long id) {

		User nowUser = TokenUtils.getCurrentUser();

		collectService.delCollectGood(id, Long.valueOf(nowUser.getId()));

		return Result.success("删除收藏");
	}

	/**
	 * 查询用户收藏的商品数据
	 */
	@GetMapping("getAll")
	public Result getAllGood() {
		User nowUser = TokenUtils.getCurrentUser();

		return Result.success(collectService.getUserCollectGood(Long.valueOf(nowUser.getId())));
	}


}


