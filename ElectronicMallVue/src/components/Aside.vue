<template>
  <el-menu :default-openeds="['2', 'good']" style="height: 100%;"
           background-color="rgb(48,65,86)"
           text-color ="#fff"
           :collapse-transition="false"
           :collapse="isCollapse"
           router
  >
    <div style="height: 60px;margin-left: 30px; line-height: 60px">
      <router-link to="/manage/home">
        <img src="../resource/logo.png" style="width: 32px;position: relative; top: 7px;right: 6px;">
      </router-link>
      <span slot="title" style="color: aliceblue;font-size: 20px" v-show="!isCollapse">在线商城后台管理</span>
    </div>
    <el-menu-item index="/manage/home" class="el-item-menu" style="font-size: 16px">
      <i class="iconfont icon-r-home" style="font-size: 24px;color: white;"></i><span slot="title"> 主页</span>
    </el-menu-item>
    <el-menu-item index="/" class="el-item-menu" style="font-size: 16px">
      <i class="iconfont icon-r-mark1" style="font-size: 24px;color: white;"></i><span slot="title"> 前台</span>
    </el-menu-item>

    <el-submenu index="2" style="font-size: 16px">
      <template slot="title" >
        <i class="iconfont icon-r-setting" style="font-size: 24px;color: white;"></i><span slot="title"> 系统管理</span></template>
      <el-submenu v-show="userGroup" index="user"  class="el-item-menu">
        <template slot="title" ><i class="iconfont icon-r-user2" style="font-size: 24px;color: white;"></i> 用户管理</template>
        <el-menu-item index="/manage/user" v-if="menuFlags.userMenu"> 用户管理</el-menu-item>
      </el-submenu>
      <el-submenu v-if="fileGroup" index="file"  class="el-item-menu"  style="font-size: 18px">
        <template slot="title"><i class="iconfont icon-r-paper" style="font-size: 24px;color: white;"></i> 文件管理</template>
        <el-menu-item index="/manage/file" v-if="menuFlags.fileMenu">文件管理</el-menu-item>
        <el-menu-item index="/manage/avatar" v-if="menuFlags.avatarMenu">头像管理</el-menu-item>
      </el-submenu>
      <el-submenu v-if="GoodGroup" index="good"  class="el-item-menu"  style="font-size: 18px">
        <template slot="title"><i class="iconfont icon-r-find" style="font-size: 24px;color: white;"></i> 商品管理</template>
        <el-menu-item index="/manage/category" v-if="menuFlags.categoryMenu">商品分类管理</el-menu-item>
        <el-menu-item index="/manage/carousel" v-if="menuFlags.carouselMenu">轮播图管理</el-menu-item>
        <el-menu-item index="/manage/good" v-if="menuFlags.goodMenu">商品管理</el-menu-item>
        <el-menu-item index="/manage/order" v-if="menuFlags.orderMenu">订单管理</el-menu-item>
      </el-submenu>
      <el-submenu v-if="incomeGroup" index="income"  class="el-item-menu"  style="font-size: 18px">
        <template slot="title"><i class="iconfont icon-r-shield" style="font-size: 24px;color: white;"></i> 营收管理</template>
        <el-menu-item index="/manage/incomeChart" v-if="menuFlags.incomeChartMenu">图表分析</el-menu-item>
        <el-menu-item index="/manage/incomeRank" v-if="menuFlags.incomeRankMenu">收入排行榜</el-menu-item>
        <el-menu-item index="/manage/marketingRank" v-if="menuFlags.marketingRank">营销排行榜</el-menu-item>

      </el-submenu>
    </el-submenu>
  </el-menu>
</template>

<script>
import request from "@/utils/request";


export default {
  name: "Aside",
  props: {
    isCollapse: Boolean,
  },
  data() {
    return{
      role : 'user',
      menuFlags: {
        userMenu: false,
        fileMenu: false,
        avatarMenu: false,
        goodMenu: false,
        carouselMenu: false,
        orderMenu: false,
        categoryMenu: false,
        incomeChartMenu: false,
        incomeRankMenu: false,
      }
    }
  },
  computed: {
    userGroup: function (){
      return this.menuFlags.userMenu
    },
    fileGroup: function (){
      return this.menuFlags.fileMenu || this.menuFlags.avatarMenu
    },
    GoodGroup: function (){
      return this.menuFlags.goodMenu ||this.menuFlags.orderMenu || this.menuFlags.categoryMenu || this.menuFlags.carouselMenu
    },
    incomeGroup: function () {
      return this.menuFlags.incomeChartMenu || this.menuFlags.incomeRankMenu
    }
  },
  mounted() {
    
  },
  created() {
    request.post("http://localhost:9191/role").then(res=>{
      if(res.code==='200'){
        this.role = res.data;
        console.log("asider，role："+this.role)
        if(this.role === 'admin'){
          this.menuFlags.userMenu = true
          this.menuFlags.fileMenu = true
          this.menuFlags.avatarMenu = true
          this.menuFlags.categoryMenu = true
          this.menuFlags.goodMenu = true
          this.menuFlags.carouselMenu = true
          this.menuFlags.orderMenu = true
          this.menuFlags.incomeChartMenu = true
          this.menuFlags.incomeRankMenu = true
          this.menuFlags.marketingRank = true
        }
        else if(this.role==='user'){

        }
        console.log(this.menuFlags)
      }
    })
  }
}
</script>

<style scoped>

</style>