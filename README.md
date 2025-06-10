<div align="center">

# 🛍️ E-Commerce Platform 
> *基于 SpringBoot + Vue 的现代化电商系统*  
> **高并发场景优化 | 分布式事务解决方案 | 响应式前端设计**

![License](https://img.shields.io/badge/license-MIT-ffb02a)

</div>

---

## ✨ 核心特性
| 模块          | 技术亮点                                                                 |
|---------------|--------------------------------------------------------------------------|
| **后端架构**  | SpringCloud Alibaba 微服务集群 · Redis 分布式锁 · RocketMQ 事务消息       |
| **前端工程**  | Vue3 Composition API · Vite 构建 · Element Plus 深度定制                  |
| **数据层**    | ShardingSphere 分库分表 · Elasticsearch 商品搜索 · Canal 数据同步           |
| **运维部署**  | Docker+K8s 容器化 · Prometheus+Grafana 监控 · Jenkins 流水线              |

---



## 🚀 快速启动
```bash
# 后端服务
git clone https://github.com/yourname/backend.git
cd backend
mvn spring-boot:run -Dspring.profiles.active=dev

# 前端工程
git clone https://github.com/yourname/frontend.git
cd frontend
npm install
npm run dev
```

## 🌟 技术栈架构
### 🖥️ **后端架构**
| 组件             | 技术选型                          | 核心功能                                                                 |
|------------------|----------------------------------|--------------------------------------------------------------------------|
| **微服务框架**   | SpringCloud Alibaba             | 服务注册与发现(Nacos) · 分布式配置中心 · 服务熔断(Sentinel) [1,5](@ref)      |
| **分布式事务**   | Seata + RocketMQ                | TCC模式事务管理 · 消息最终一致性保障 [1,5](@ref)                            |
| **安全认证**     | Spring Security OAuth2          | JWT令牌签发 · RBAC权限控制 · 单点登录集成 [8](@ref)                           |
| **高并发处理**   | Redis + Redisson               | 分布式锁 · 热点数据缓存 · 秒杀队列控制 [9](@ref)                               |
| **API文档**      | Knife4j + Swagger3             | 自动化接口文档 · 在线调试 · 访问权限控制 [6](@ref)                             |

### 🎨 **前端工程**
| 模块             | 技术方案                          | 特性亮点                                                                 |
|------------------|----------------------------------|--------------------------------------------------------------------------|
| **核心框架**     | Vue3 + TypeScript               | Composition API · 类型安全 · 响应式数据流 [6,8](@ref)                       |
| **UI组件库**     | Element Plus 定制              | 主题色动态切换(#42b983) · 深色模式 · 按需加载优化 [6](@ref)                    |
| **状态管理**     | Pinia                           | 模块化Store · DevTools支持 · 轻量级替代Vuex [6](@ref)                          |
| **构建工具**     | Vite                            | 毫秒级HMR · Rollup打包 · 多环境配置 [6,8](@ref)                              |
| **可视化**       | ECharts 5                       | 销售数据看板 · 实时监控图表 · SVG矢量渲染 [6](@ref)                            |

### 🗄️ **数据层**
| 技术组件         | 应用场景                          | 关键配置                                                                 |
|------------------|----------------------------------|--------------------------------------------------------------------------|
| **分库分表**     | ShardingSphere 5.x              | 订单表水平分片(16库×64表) · 柔性事务配置 [5](@ref)                            |
| **搜索引擎**     | Elasticsearch 8                 | IK分词插件 · 商品多维度检索 · 聚合分析 [5,9](@ref)                           |
| **实时同步**     | Canal + Kafka                   | MySQL Binlog解析 · 增量数据同步ES [5](@ref)                                   |
| **关系数据库**   | MySQL 8.0 + Vitess              | InnoDB集群 · 读写分离 · 自动化分片管理 [5](@ref)                              |
| **NoSQL**        | Redis 6 + MongoDB 6            | 购物车数据 · 用户行为日志 · 非结构化存储 [5,9](@ref)                         |

### 🚀 **运维部署**
| 基础设施         | 工具链                            | 实现功能                                                                 |
|------------------|----------------------------------|--------------------------------------------------------------------------|
| **容器编排**     | Kubernetes 1.28 + Helm          | Pod自动扩缩容 · 金丝雀发布 · 服务网格(ISTIO) [5,9](@ref)                     |
| **CI/CD**        | Jenkins + GitLab Runner         | 流水线构建 · 镜像安全扫描 · 自动化压测 [5](@ref)                               |
| **监控告警**     | Prometheus + Grafana 9          | JVM指标监控 · 业务链路追踪 · 微信/邮件告警 [5,9](@ref)                      |
| **日志系统**     | ELK Stack                       | 分布式日志收集 · 异常关键字告警 · 可视化查询 [5](@ref)                         |
| **基础设施**     | Terraform + Ansible             | 云资源(IaaS)编排 · 配置自动化 · 多环境管理 [5](@ref)                           |

### 🔗 技术栈徽章墙
[![SpringBoot](https://img.shields.io/badge/SpringBoot-6DB33F?logo=springboot&logoColor=white)]()
[![Vue.js](https://img.shields.io/badge/Vue.js-42b983?logo=vuedotjs&logoColor=white)]()
[![Redis](https://img.shields.io/badge/Redis-DC382D?logo=redis&logoColor=white)]()
[![Kubernetes](https://img.shields.io/badge/Kubernetes-326CE5?logo=kubernetes&logoColor=white)]()
[![RocketMQ](https://img.shields.io/badge/RocketMQ-D77310?logo=apacherocketmq&logoColor=white)]()
[![Elasticsearch](https://img.shields.io/badge/Elasticsearch-005571?logo=elasticsearch)]()
[![ShardingSphere](https://img.shields.io/badge/ShardingSphere-1C1C1C?logo=apache&logoColor=white)]()

### 📐 架构示意图
```mermaid
graph TD
    A[用户请求] --> B(API Gateway)
    B --> C[商品服务]
    B --> D[订单服务]
    B --> E[支付服务]
    C --> F[(Redis集群)]
    D --> G[(MySQL分片)]
    E --> H[(RocketMQ)]
    H --> I[结算服务]
    F & G & I --> J{{监控告警系统}}
    J --> K[Grafana看板]
