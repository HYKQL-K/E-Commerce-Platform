package com.rabbiter.em.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rabbiter.em.entity.Address;
import com.rabbiter.em.entity.Collect;
import com.rabbiter.em.entity.Good;
import com.rabbiter.em.mapper.AddressMapper;
import com.rabbiter.em.mapper.CollectMapper;
import com.rabbiter.em.mapper.GoodMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 收藏服务层
 * <p>
 *
 * @author zrx
 * @version v1.0.0
 * @date 2024/12/5 10:17
 */
@Service
public class CollectService extends ServiceImpl<CollectMapper, Collect> {

	@Resource
	private CollectMapper collectMapper;

	@Resource
	private GoodMapper goodMapper;

	/**
	 * 获取用户收藏的商品
	 *
	 * @param uId 用户id
	 * @return
	 */
	public List<Good> getUserCollectGood(Long uId) {
		List<Collect> collectList = collectMapper.getUserGood(uId);
		if (collectList.size() == 0) {
			return new ArrayList<>();
		}
		return goodMapper.selectBatchIds( collectList.stream().
				map(Collect::getGoodId).collect(Collectors.toList()) );
	}

	public Boolean delCollectGood(Long gId, Long uId) {

		collectMapper.delCollect(uId, gId);

		return true;
	}


	public List<Collect> selectGoodByUIdAndGId(Long uId, Long id) {
		if (uId ==null || id == null) {
			return new ArrayList<>();
		}
		return collectMapper.checkCollectExists(uId, id);
	}
}


