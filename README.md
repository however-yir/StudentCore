# StudentCore - 学生信息管理桌面系统 | Student Management Desktop System

🔥 A Java Swing student management system based on JDBC and MySQL.  
🚀 Built for dual-role desktop administration across students, courses, and grades.  
⭐ Supports local single-machine deployment, CRUD workflows, and classic teaching-management scenarios.

> 基于 Java Swing + JDBC + MySQL 的学生信息管理桌面系统，支持管理员与学生双角色登录，覆盖学生/课程/成绩等核心教学数据管理。

## 1. 项目定位

`StudentCore` 是一个典型的桌面端教务管理练手项目，强调“本地单机可运行、界面直观、CRUD 流程完整”。

系统采用 Swing 图形界面，不依赖浏览器。

## 2. 已实现功能

- 双角色登录：管理员、学生
- 学生信息管理：新增、查询、修改、删除
- 课程信息管理：新增、查询、修改、删除
- 成绩信息管理：新增、查询、修改、删除
- 基础权限区分：管理员可管理，学生以查询为主

## 3. 技术栈

- Java 8
- Java Swing
- JDBC
- MySQL 8.x
- Eclipse 工程结构（含 `mysql-connector-java-8.0.11.jar`）

## 4. 项目结构

```text
StudentCore
├── 完整源码/demo6/
│   ├── src/com/system/
│   │   ├── view/                   # 登录与各业务窗口
│   │   ├── dao/                    # 数据访问层
│   │   ├── entity/                 # 实体类
│   │   └── utils/DB.java           # 数据库连接配置
│   └── lib/mysql-connector-java-8.0.11.jar
├── 数据库文件/student_a.sql
└── README.md
```

## 5. 本地运行

### 5.1 环境准备

- JDK 8
- MySQL 8.x
- Eclipse（或任意支持 Swing 的 Java IDE）

### 5.2 初始化数据库

1. 创建数据库：`student_a`
2. 导入 [student_a.sql](数据库文件/student_a.sql)
3. 复制配置模板并填写数据库连接：

```bash
cd 完整源码/demo6
cp config/db.properties.example config/db.properties
```

也支持通过环境变量覆盖：

- `STUDENTCORE_DB_URL`
- `STUDENTCORE_DB_USERNAME`
- `STUDENTCORE_DB_PASSWORD`
- `STUDENTCORE_DB_DRIVER`

### 5.3 启动程序

推荐直接使用脚本（自动编译并启动）：

```bash
cd 完整源码/demo6
./run.sh
```

或者在 IDE 运行主入口：

- [Login.java](完整源码/demo6/src/com/system/view/Login.java)
- 方法：`public static void main(String[] args)`

## 6. 默认账号（来自 SQL 与源码说明）

- 管理员：`123456 / 123456`
- 学生示例：`20210601 / 123`（`20210602/03/04` 同规则）

## 7. 常见问题

- 登录失败：先确认 `DB.java` 中数据库连接是否修改为本机配置
- 驱动报错：确认项目已正确加载 `lib/mysql-connector-java-8.0.11.jar`
- 中文乱码：检查 IDE 编码为 UTF-8，数据库字符集为 `utf8`/`utf8mb4`

## 8. 改进建议

- 将 JDBC 配置继续迁移到更完整的构建体系（Maven/Gradle）
- 增加统一异常提示与日志
- 引入 Maven/Gradle，替换手工管理 jar 包方式

## 12.1 贡献建议

欢迎通过 Issue / PR 提交：

- 代码重构（DAO 层、窗口复用）
- 界面样式优化与用户体验改进
- 数据导入导出功能扩展
- 文档与运行脚本补充

## 12.2 许可说明

本仓库采用 MIT License，详见 [LICENSE](LICENSE)。