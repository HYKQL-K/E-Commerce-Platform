<!--
 * @Description: 
 * @Author: Rabbiter
 * @Date: 2023-03-26 15:27:05
-->
<template>
  <div class="list" style="width: 55%; height: 100%; margin: 20px auto">
    <div v-if="orders.length === 0" class="empty-box">
      <span style="font-family: 华文彩云; font-size: 40px">没有收藏记录</span>
    </div>
    <span v-for="order in orders" :key="order.id">
      <order-item :order="order" style="margin-bottom: 5px"></order-item>
    </span>
  </div>
</template>

<script>
import OrderItem from "@/components/CollectItem.vue";
import API from "@/utils/request";
export default {
  name: "OrderList",
  components: {
    "order-item": OrderItem,
  },
  data() {
    return {
      orders: {},
    };
  },
  created() {
    API.get("/api/collect/getAll").then((res) => {
      if (res.code === "200") {
        this.orders = res.data;
        console.log(this.orders)
        for (var i = 0; i < this.orders.length; ++i) {
          this.orders[i].create_time = this.orders[i].create_time
            .toLocaleString()
            .replace(/T/g, " ")
            .replace(/\.[\d]{3}Z/, "");
        }
      }
    });
  },
};
</script>

<style scoped>
.list {
  width: 60%;
  margin: 10px auto;
}

.empty-box {
  border-radius: 30px;
  text-align: center;
  background-color: white;
  padding: 100px;
}
</style>