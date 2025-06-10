<template>
    <div>
      <div class="header" style="padding-left: 25px;">
        <!-- <span style="float: right;margin-right: 10%;"><el-button @click="delGood()" size="small">删除</el-button></span> -->
      </div>
      <div class="body">
        <div style="display: inline-block;">
          <router-link :to="'goodview/'+order.good_id">
            <img :src="baseApi + order.imgs" style="width: 100px;height:100px">
          </router-link>
        </div>
        <div style="display: inline-block;line-height: 40px" >
          <table>
            <tr style="width: auto;">
              <th style="width: 20%;">商品</th>
              <th style="width: 50%;">描述</th>
              <th style="width: 30%;">上架时间</th>
            </tr>
            <tr style="width: auto;">
              <a :href="'goodview/'+order.good_id">
                <td>{{order.name}}</td>
              </a>
              <td>{{order.description}}</td>
              <td>{{order.createTime}}</td>
              <el-popover
                  placement="bottom-start"
                  width="200"
                  trigger="hover"
                  :content=address>
                <td slot="reference" style="color: #42b983">{{ order.link_user }}</td>
              </el-popover>
    <!--          订单状态-->
              <template v-if="order.state==='已发货'">
                <td style="color: #42b983">{{order.state}}</td>
                <td>
                  <el-button style="margin-left: 20px;font-size: 15px;" type="primary" @click="receive">确认收货</el-button>
                </td>
              </template>
    
              <template v-else-if="order.state==='已收货'">
                <td style="color: #42b983"><a class="el-icon-check"></a>{{order.state}}</td>
              </template>
    
              <template v-else-if="order.state==='已支付'">
                <td style="color: #3b62f8"> {{order.state}}</td>
      
              </template>
    
              <template v-else>
                <td>{{order.state}}</td>

              </template>
    
            </tr>
          </table>
        </div>
      </div>
    </div>
    </template>
    
    <script>
    export default {
      name: "OrderItem",
      props:{
        order: Object,
      },
      created() {
        console.log(this.order)
      },
      delGood(){

      },
      data(){
        return{
          address: '电话:'+this.order.link_phone+' 地址:'+this.order.link_address,
          baseApi: this.$store.state.baseApi,
        }
      },
      methods:{
        //跳转到支付页面
        pay(){
          this.$router.push({path: 'pay',query:{money: this.order.total_price,orderNo: this.order.order_no}})
        },
        //确认收货
        receive(){
    
          this.$confirm('是否确认收货?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'info'
          }).then(() => {
    
            this.request.get("/api/order/received/"+this.order.order_no).then(res=>{
              if(res.code==='200'){
                this.$message.success("收货成功");
                this.order.state='已收货'
              }
            })
          })
    
        }
      }
    }
    </script>
    
    <style scoped>
    .header{
      background-color: rgb(67, 168, 157);
      height: 40px;
      border-radius: 25px 25px 0 0;
    }
    .body{
      background-color: white;
      padding: 20px;
      border-radius: 0 0 25px 25px;
      margin-bottom: 10px;
    }
    th,td{
    
      width: 120px;
      text-align: center;
    }
    th{
      font-size: 15px;
      color: #00b7ff;
      font-weight: normal;
    }
    </style>