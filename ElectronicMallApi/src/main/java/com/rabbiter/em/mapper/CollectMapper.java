package com.rabbiter.em.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rabbiter.em.entity.Collect;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CollectMapper extends BaseMapper<Collect> {

	@Select("select * from `collect` where user_id = #{uId}")
	public List<Collect> getUserGood(@Param("uId") Long uId);


	/**
	 * 删除用户的收藏
	 * 根据用户id和商品id进行删除操作
	 */
	@Delete("DELETE FROM `collect` " +
			"WHERE user_id = #{uId} AND good_id = #{gId}")
	void delCollect(Long uId, Long gId);


	/**
	 * 根据用户id和商品id查询对应收藏记录是否存在
	 * 可用于验证删除操作是否成功等情况
	 */
	@Select("SELECT * FROM `collect` " +
			"WHERE user_id = #{uId} AND good_id = #{gId}")
	List<Collect> checkCollectExists(@Param("uId")Long uId, @Param("gId")Long gId);
}
