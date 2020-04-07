# 数据库表格

### 注：

求职者就是普通的用户，前台的页面默认就用求职者的注册邮箱和登录密码来登录

### 							        表1公司信息表(COMPANY)

|      列名       |    类型     |                      约束                       |     描述     |
| :-------------: | :---------: | :---------------------------------------------: | :----------: |
|   COMPANY_ID    |     INT     |                   主键，自增                    |    公司ID    |
|  COMPANY_NAME   | VARCHAR(50) |                                                 |   公司名称   |
|  COMPANY_AREA   | VARCHAR(50) |                                                 |  公司所在地  |
|  COMPANY_SIZE   | VARCHAR(50) |                                                 |   公司规模   |
|  COMPANY_TYPE   | VARCHAR(50) |                                                 |   公司性质   |
|  COMPANY_STATE  |     INT     | 值为1（招聘中）、2（暂停招聘）、3（已结束招聘） | 公司招聘状态 |
|  COMPANY_SORT   |     INT     |                                                 |   显示排序   |
| COMPANY_VIEWNUM |     INT     |                                                 |    浏览数    |

###                                      表2公司描述(COMPANY_DESC)

|     列名     |     类型     |        约束        |          描述          |
| :----------: | :----------: | :----------------: | :--------------------: |
|  COMPANY_ID  |     INT      | 主键,COMPANY的外键 |        公司的ID        |
| COMPANY_DESC | VARCHAR(500) |                    |        公司描述        |
| COMPANY_IMG  | VARCHAR(500) |                    | 公司照片存储位置，格式 |
|   CREATED    |   DATETIME   |                    |        创建时间        |
|   UPDATED    |   DATETIME   |                    |        更新时间        |

###         							       表3职位信息表(JOB)

|     列名      |     类型     |                         约束                          |     描述     |
| :-----------: | :----------: | :---------------------------------------------------: | :----------: |
|    JOB_ID     |     INT      |                      主键，自增                       |    职位ID    |
|  COMPANY_ID   |     INT      |                     COMPANY的外键                     | 职位所属企业 |
|    JOB_CID    |     INT      |                     JOB_CAT的外键                     |   职位类型   |
|   JOB_NAME    | VARCHAR(50)  |                                                       |   职位名称   |
| JOB_HIRINGNUM |     INT      |                                                       |   招聘人数   |
|  JOB_SALARY   | VARCHAR(20)  |                                                       | 职位薪资区间 |
|   JOB_AREA    | VARCHAR(255) |                                                       |    所在地    |
|   JOB_DESC    | VARCHAR(255) |                                                       |   职位描述   |
|  JOB_ENDTIME  |  TIMESTAMP   |                                                       | 招聘结束日期 |
|   JOB_STATE   |     INT      | 值为1（招聘中），值为2（招聘已暂停），值为3（已结束） |   招聘状态   |

###                       			表4职位分类表(JOB_CAT)	

|    列名    |     类型     |             约束             |         描述         |
| :--------: | :----------: | :--------------------------: | :------------------: |
|    CID     |     INT      |             主键             |  工作类型分类的主键  |
| PARENT_CID |     INT      |                              | 工作分类所继承的分类 |
|    NAME    | VARCHAR2(20) |             非空             |      分类的名字      |
|   STATUS   |     INT      |      值为1:有效，0:无效      |      分类的状态      |
| IS_PARENT  |     INT      | 值为1:是父组件，0:不是父组件 |   判断是否为父组件   |
|  CREATED   |   DATETIME   |                              |       创建日期       |
|  UPDATED   |   DATETIME   |                              |       更新日期       |

###                       			表5职位申请表(JOB_APPLY)

|     列名     |   类型   |                 约束                  |       描述       |
| :----------: | :------: | :-----------------------------------: | :--------------: |
|   APPLY_ID   |   INT    |               主键,自增               |    职位申请ID    |
|    JOB_ID    |   INT    |                JOB外键                |     职位标识     |
| APPLICANT_ID |   INT    |             APPLICANT外键             |     求职者ID     |
|  APPLY_DATE  | DATETIME |                                       |   职位申请日期   |
| APPLY_STATE  |   INT    | 取值：1（申请）、2（审核）、3（通知） | 职位申请处理状态 |

### 					            表6求职者信息表(APPLICANT)

|         列名         |    类型     |   约束    |       描述       |
| :------------------: | :---------: | :-------: | :--------------: |
|     APPLICNT_ID      |     INT     | 主键,自增 |     求职者ID     |
|   APPLICANT_EMAIL    | VARCHAR(50) |   非空    | 求职者的注册邮箱 |
|    APPLICANT_PWD     | VARCHAR(50) |   非空    | 求职者的登录密码 |
| APPLICANT_REGISTDATE |  DATETIME   |           | 求职者的注册时间 |

###                            表7简历基本信息表（RESUME_BASICINFO)

|      列名      |     类型     |      约束       |      描述      |
| :------------: | :----------: | :-------------: | :------------: |
|  BASICINFO_ID  |     INT      |    主键,自增    |    简历标识    |
|  APPLICANT_ID  |     INT      | APPLICANT的外键 | 依赖求职者标识 |
|    REALNAME    | VARCHAR(50)  |      非空       |    真实姓名    |
|     GENDER     | VARCHAR(50)  |                 |      性别      |
|    BIRTHDAY    |     DATE     |                 |    出生日期    |
|  CURRENT_LOC   | VARCHAR(255) |                 |   当前所在地   |
|  RESIDENT_LOC  | VARCHAR(255) |                 |   户口所在地   |
|   TELEPHONE    | VARCHAR(50)  |                 |     手机号     |
|     EMAIL      | VARCHAR(50)  |                 |    邮箱地址    |
| JOB_INTENSION  | VARCHAR(50)  |                 |    求职意向    |
| JOB_EXPERIENCE | VARCHAR(255) |                 |    工作经验    |
|   HEAD_SHOT    | VARCHAR(255) |                 |    简历照片    |

###                          表8教育经历信息表(RESUME_EDUCATION)

|       列名       |    类型     |        约束        |   描述   |
| :--------------: | :---------: | :----------------: | :------: |
|   EDUCATION_ID   |     INT     |     主键,自增      |  教育ID  |
|   BASICINFO_ID   |     INT     | TB_BASICINFO的外键 | 简历标识 |
| GRADUATE_SCHOOL  | VARCHAR(50) |                    | 毕业学校 |
|  TIME_DURATION   |    DATE     |                    | 就读时间 |
| EDUCATION_DEGREE | VARCHAR(50) |                    |   学历   |
|    PROFESSION    | VARCHAR(50) |                    |   专业   |

###                  表9项目经验信息表(RESUME_PROJECT_EXPERIENCE)

|      列名      |     类型     |      约束       |      描述      |
| :------------: | :----------: | :-------------: | :------------: |
|   PROJECT_ID   |     INT      |    主键,自增    |  项目经验标识  |
|  BASICINFO_ID  |     INT      | BASICINFO的外键 |    简历标识    |
|  PROJECT_NAME  | VARCHAR(50)  |                 |    项目名称    |
| PROJECT_PERIOD | VARCHAR(50)  |                 | 项目参与时间段 |
|   JOB_TITLE    | VARCHAR(50)  |                 |    担任职务    |
|    JOB_DESC    | VARCHAR(255) |                 |    工作简述    |

### 								         表10用户表（USERS)

|     列名     |    类型     |                    约束                    |     描述     |
| :----------: | :---------: | :----------------------------------------: | :----------: |
|   USER_ID    |     INT     |                 主键,自增                  |    用户ID    |
|   APPLY_ID   |     INT     |               APPLY表的外键                |  求职者标识  |
| USER_LOGNAME | VARCHAR(50) |                    非空                    |  用户登录名  |
|   USER_PWD   | VARCHAR(50) |                                            | 用户登录密码 |
|  USER_EMAIL  | VARCHAR(50) |                                            | 用户登录邮箱 |
|  USER_ROLE   |     INT     | 值为0:超级管理员，1:公司管理员，2:普通用户 | 用户权限规则 |
|  USER_STATE  |     INT     |          值为1:启用，值为0:未启用          |   用户状态   |

