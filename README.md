
<div align="center">
  <h1>🛍️ E-Commerce Platform</h1>
  
  <p>
    <strong>基于 Spring Boot + Vue 2 的前后端分离电商平台</strong>
  </p>
  
  <p>
    <img src="https://img.shields.io/badge/Spring%20Boot-2.x-green.svg?style=flat-square&logo=springboot&logoColor=white" alt="Spring Boot">
    <img src="https://img.shields.io/badge/Vue-2.6.x-brightgreen.svg?style=flat-square&logo=vue.js&logoColor=white" alt="Vue">
    <img src="https://img.shields.io/badge/Element%20UI-2.15.x-blue.svg?style=flat-square&logo=element&logoColor=white" alt="Element UI">
    <img src="https://img.shields.io/badge/MyBatis%20Plus-3.x-red.svg?style=flat-square&logo=mybatis&logoColor=white" alt="MyBatis Plus">
    <a href="./LICENSE.txt">
        <img src="https://img.shields.io/badge/License-MIT-yellow.svg?style=flat-square&logo=license&logoColor=white" alt="License">
    </a>
  </p>
</div>

## 📖 项目简介

**E-Commerce Platform** 是一款轻量级、功能完善的前后端分离电商系统。

项目摒弃了复杂的微服务架构，采用经典的 **Spring Boot + Vue 2** 单体架构，部署简单，非常适合个人学习、毕业设计或中小型项目快速开发。系统实现了从用户浏览、商品检索、购物车管理到订单支付的完整电商业务闭环。

### ✨ 核心特性

* **经典架构**：基于 Spring Boot 2.7 + Vue 2.6 构建，稳定可靠，上手难度低。
* **功能完善**：包含商品管理、购物车、订单系统、个人中心、后台管理等核心模块。
* **权限管理**：集成 JWT 实现用户鉴权，包含用户/管理员双角色系统。
* **数据可视化**：后台集成 ECharts，提供直观的销售报表与数据统计。
* **支付集成**：支持支付宝/微信支付接口对接（模拟或实战）。

---

## 🏗 代码结构

```text
E-Commerce-Platform
├── ElectronicMallApi          // 后端工程 (Spring Boot)
│   ├── src/main/java          // Java 源码
│   │   ├── config             // 全局配置 (跨域, 拦截器, Swagger)
│   │   ├── controller         // 控制层接口
│   │   ├── entity             // 实体类
│   │   ├── mapper             // DAO 层 (MyBatis Plus)
│   │   ├── service            // 业务逻辑层
│   │   └── utils              // 工具类 (JWT, 文件上传等)
│   └── src/main/resources     // 配置文件与 Mapper XML
├── ElectronicMallVue          // 前端工程 (Vue 2)
│   ├── src
│   │   ├── api                // Axios 接口封装
│   │   ├── components         // 公共组件 (Header, Aside)
│   │   ├── views              // 页面 (前台 Front, 后台 Manage)
│   │   └── store              // 状态管理 (Vuex)
├── demo.sql                   // 数据库初始化脚本
└── LICENSE.txt                // 开源协议
````

-----

## 🛠 技术栈

### 后端技术 (Backend)

| 组件 | 说明 |
| :--- | :--- |
| **Spring Boot** | 2.x | 核心应用框架 |
| **MyBatis Plus** | 3.x | ORM持久层框架 |
| **MySQL** | 5.7/8.0 | 关系型数据库 |
| **Hutool** | 5.x | Java通用工具类库 |
| **JWT** | 3.x | 用户登录与Token认证 |
| **Lombok** | 1.18 | 简化Java代码 |

### 前端技术 (Frontend)

| 组件 | 说明 |
| :--- | :--- |
| **Vue** | 2.6.14 | 前端核心框架 |
| **Vue CLI** | 5.x | 项目构建工具 |
| **Element UI** | 2.15.6 | 桌面端UI组件库 |
| **Axios** | 0.26.1 | HTTP客户端 |
| **Vuex** | 3.6.2 | 状态管理模式 |
| **ECharts** | 5.4.2 | 数据可视化图表 |

-----

## 🚀 快速启动

### 1\. 环境准备

确保本地环境满足以下要求：

  * **JDK**: 1.8+
  * **Maven**: 3.6+
  * **Node.js**: 14+ / 16+
  * **MySQL**: 5.7+

### 2\. 数据库初始化

1.  在 MySQL 中创建一个名为 `mall_db` (或根据 `application.yml` 配置) 的数据库。
2.  导入项目根目录下的 `demo.sql` 脚本以初始化表结构和数据。

### 3\. 后端启动 (ElectronicMallApi)

1.  使用 IDEA 打开 `ElectronicMallApi` 目录。
2.  等待 Maven 依赖下载完成。
3.  修改 `src/main/resources/application.yml` 中的数据库连接信息（用户名/密码）。
4.  运行 `ElectronicMallApplication.java` 启动服务。
5.  服务默认端口：`9090` (请以控制台输出为准)。

### 4\. 前端启动 (ElectronicMallVue)

```bash
cd ElectronicMallVue

# 安装依赖 (建议使用 npm 或 cnpm)
npm install

# 启动开发服务器
npm run dev
```

  * 前台访问地址：`http://localhost:8080/front/home`
  * 后台管理地址：`http://localhost:8080/login`

-----

## 🤝 贡献指南

1.  Fork 本仓库
2.  新建 Feat\_xxx 分支
3.  提交代码
4.  新建 Pull Request

## 📄 开源协议

本项目采用 [MIT License](https://www.google.com/search?q=./LICENSE.txt) 协议。

