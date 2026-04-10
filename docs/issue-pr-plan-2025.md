# 2025 Issue and PR Plan

## Project Complexity
- medium

## Milestone Strategy
- M1(1-3月): 初始化与首批核心能力
- M2(4-7月): 核心扩展
- M3(8-10月): 修复与测试
- M4(11-12月): 文档与部署

## Issue Backlog
| # | Title | Labels | Milestone | Planned |
|---|---|---|---|---|
| #1 | 初始化学生域服务与工程结构 | type:feature,priority:P2,area:init | M1(1-3月) | 2025-01 |
| #2 | 建立学年配置与迁移基线 | type:feature,priority:P2,area:init | M1(1-3月) | 2025-01 |
| #3 | 实现学生档案与班级教师关联 | type:feature,priority:P1,area:core | M1(1-3月) | 2025-03 |
| #4 | 实现成绩录入与考勤管理 API | type:feature,priority:P2,area:core | M2(4-7月) | 2025-05 |
| #5 | 实现家长只读门户与周报导出 | type:feature,priority:P2,area:core | M2(4-7月) | 2025-06 |
| #6 | 修复重复学号合并与周边界错误 | type:bug,priority:P1,area:bugfix | M3(8-10月) | 2025-08 |
| #7 | 补齐导入幂等与权限回归测试 | type:test,priority:P2,area:test | M3(8-10月) | 2025-09 |
| #8 | 完善校方使用文档与发布说明 | type:docs,priority:P3,area:deploy | M4(11-12月) | 2025-11 |

## PR Cadence
- PR1 Foundation Setup: Closes #1, #2
- PR2 Core Capability A: Closes #3
- PR3 Core Capability B: Closes #4, #5
- PR4 Bugfix & Test: Closes #6, #7
- PR5 Docs & Deploy: Closes #8

## Standard PR Template Fields
- Summary
- Linked Issue
- Test Evidence
- Risk
- Rollback
