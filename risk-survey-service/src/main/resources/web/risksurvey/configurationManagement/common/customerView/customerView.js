cola(function (model) {
    model.set("policyHolder", []);//投保人
    model.set("byTheApplicant", []);//被保人

    var actualId = cola.util.queryParams().actualId;
    var kinds = "plcApplicant,plcInsurant";

    //险类下拉框
    model.set("classCodeList",[
        {
            key: "53",
            value: "特殊综合险"
        },
        {
            key: "YA",
            value: "货运预约协议保险"
        },
        {
            key: "01",
            value: "企业财产保险"
        },
        {
            key: "02",
            value: "特殊标的保险"
        },
        {
            key: "03",
            value: "家庭财产保险"
        },
        {
            key: "04",
            value: "特殊家财保险"
        },
        {
            key: "05",
            value: "机动车辆保险"
        },
        {
            key: "07",
            value: "工程保险"
        },
        {
            key: "08",
            value: "工程一切险"
        },
        {
            key: "09",
            value: "国内货物运输保险"
        },
        {
            key: "10",
            value: "进出口货物运输保险"
        },
        {
            key: "11",
            value: "船舶保险"
        },
        {
            key: "12",
            value: "石油保险"
        },
        {
            key: "13",
            value: "航空航天保险"
        },
        {
            key: "14",
            value: "核能源保险"
        },
        {
            key: "15",
            value: "责任保险"
        },
        {
            key: "16",
            value: "产品责任保险"
        },
        {
            key: "17",
            value: "雇主责任保险"
        },
        {
            key: "18",
            value: "职业责任保险"
        }
    ]);

    //险种下拉框
    model.set("riskCodeList",[
        {
            key: "1527",
            value: "董事、监理及高级管理人员责任保险"
        },
        {
            key: "1392",
            value: "机场责任险"
        },
        {
            key: "2291",
            value: "产品质量保证保险"
        },
        {
            key: "1302",
            value: "机场责任险"
        },
        {
            key: "2791",
            value: "非工伤职员团体意外伤害保险"
        },
        {
            key: "2201",
            value: "雇员忠诚保证保险"
        },
        {
            key: "0110",
            value: "商业楼宇财产基本险"
        },
        {
            key: "0111",
            value: "商业楼宇财产综合险"
        },
        {
            key: "0112",
            value: "商业楼宇财产一切险"
        },
        {
            key: "0113",
            value: "电厂财产保险基本险"
        },
        {
            key: "0114",
            value: "电厂财产保险综合险"
        },
        {
            key: "0116",
            value: "电厂机器损坏保险"
        },
        {
            key: "0705",
            value: "道路建筑工程一切险"
        },
        {
            key: "0706",
            value: "地铁建筑工程一切险"
        },
        {
            key: "2711",
            value: "团体人身意外伤害保险"
        },
        {
            key: "2792",
            value: "游乐平安意外伤害保险"
        },
        {
            key: "2712",
            value: "安全行－交通工具意外伤害保险"
        },
        {
            key: "2786",
            value: "短期团体意外伤害保险"
        },
        {
            key: "2794",
            value: "团体人身意外伤害保险"
        },
        {
            key: "2714",
            value: "航空旅客意外伤害保险"
        },
        {
            key: "2785",
            value: "安全行－交通工具意外伤害保险"
        },{
            key: "2715",
            value: "综合交通意外伤害保险"
        },
        {
            key: "2705",
            value: "出境人员意外伤害保险"
        },{
            key: "2702",
            value: "乘客人身意外伤害保险"
        },{
            key: "2788",
            value: "学生幼儿意外伤害保险"
        },{
            key: "2718",
            value: "安心卡A-人身意外伤害综合保险"
        },{
            key: "2789",
            value: "伴你行A款"
        },{
            key: "2719",
            value: "安心卡B-人身意外伤害综合保险"
        },{
            key: "2720",
            value: "安心卡C-人身意外伤害综合保险"
        },{
            key: "0503",
            value: "机动车辆保险摩托车、拖拉机保险"
        },{
            key: "0910",
            value: "货物运输预约保险"
        },{
            key: "1395",
            value: "卫星及发射责任保险"
        },{
            key: "1305",
            value: "发射前保险"
        },{
            key: "2292",
            value: "备份原有产品质量保证保险险种数据"
        },{
            key: "2202",
            value: "产品质量保证保险"
        },{
            key: "2793",
            value: "交通工具意外伤害保险"
        },{
            key: "2703",
            value: "机动车驾驶人员意外伤害保险"
        },{
            key: "1528",
            value: "物业管理责任保险"
        },{
            key: "2784",
            value: "乘客意外伤害险"
        },{
            key: "0402",
            value: "个人贷款抵押房屋综合保险"
        },{
            key: "0103",
            value: "财产保险"
        },{
            key: "0101",
            value: "财产基本保险"
        },{
            key: "0105",
            value: "机器损坏保险"
        },{
            key: "0107",
            value: "机损利损险"
        },{
            key: "0104",
            value: "财产一切险"
        },{
            key: "0106",
            value: "利润损失保险"
        },{
            key: "1504",
            value: "校(园)方责任保险"
        },{
            key: "0901",
            value: "国内公路运输货物保险"
        },{
            key: "0904",
            value: "国内航空货物运输保险"
        },{
            key: "0903",
            value: "国内铁路运输货物保险"
        },{
            key: "1393",
            value: "卫星发射保险"
        },{
            key: "1516",
            value: "雇主责任保险"
        },{
            key: "1101",
            value: "船舶保险"
        },{
            key: "0905",
            value: "国内航空旅客行李保险"
        },{
            key: "2602",
            value: "团体重大疾病保险"
        },{
            key: "2776",
            value: "境外人员意外伤害保险"
        },{
            key: "2706",
            value: "个人旅游意外伤害保险"
        },{
            key: "0301",
            value: "家庭财产保险"
        },{
            key: "0799",
            value: "安装工程一切险"
        },{
            key: "0530",
            value: "机动车辆提车保险"
        },{
            key: "2717",
            value: "学生、幼儿平安保险"
        },{
            key: "0401",
            value: "个人贷款抵押房屋保险"
        },{
            key: "2304",
            value: "盈盛家庭财产保险"
        },{
            key: "1804",
            value: "物业管理责任保险"
        },{
            key: "1807",
            value: "保险经纪人职业责任保险"
        },{
            key: "1519",
            value: "律师执业责任保险"
        },{
            key: "1811",
            value: "保险代理人职业责任保险"
        },{
            key: "1001",
            value: "进口货物保险"
        },{
            key: "0108",
            value: "计算机保险"
        },{
            key: "2901",
            value: "圆丰投资保障型3年期家庭财产保险"
        },{
            key: "1546",
            value: "风景名胜区责任保险"
        },{
            key: "2798",
            value: "人身意外通用险种"
        },{
            key: "1521",
            value: "建设工程设计责任保险"
        },{
            key: "1515",
            value: "产品责任险"
        },{
            key: "1002",
            value: "出口货物保险"
        },{
            key: "1507",
            value: "旅行社责任保险"
        },{
            key: "1558",
            value: "电梯责任保险"
        },{
            key: "1509",
            value: "供电责任保险"
        },{
            key: "1512",
            value: "家政服务人员责任保险"
        },{
            key: "0902",
            value: "公路货物运输定额保险"
        },{
            key: "2701",
            value: "人身意外伤害保险"
        },{
            key: "2725",
            value: "出租屋居住人员意外伤害保险"
        },{
            key: "5302",
            value: "个人贷款抵押房屋综合保险"
        },{
            key: "0502",
            value: "机动车辆保险特种车保险"
        },{
            key: "1301",
            value: "飞机机身及零备件一切险及责任险"
        },{
            key: "0908",
            value: "物流货物保险"
        },{
            key: "0909",
            value: "油气管道运输保险"
        },{
            key: "1505",
            value: "道路客运承运人责任保险"
        },{
            key: "1506",
            value: "道路危险货物承运人责任保险"
        },{
            key: "1510",
            value: "个人责任保险"
        },{
            key: "1511",
            value: "居家责任保险"
        },{
            key: "1514",
            value: "家庭雇佣责任保险"
        },{
            key: "1522",
            value: "公众责任保险(涉外)"
        },{
            key: "1525",
            value: "动物饲养责任保险"
        },{
            key: "1526",
            value: "产品责任险（涉外）"
        },{
            key: "2301",
            value: "中小企业综合保险"
        },{
            key: "1523",
            value: "物流责任保险"
        },{
            key: "0704",
            value: "建筑施工企业综合保险"
        },{
            key: "1517",
            value: "工伤责任保险"
        },{
            key: "0703",
            value: "建筑、安装工程保险"
        },{
            key: "1520",
            value: "注册会计师执业责任保险"
        },{
            key: "1524",
            value: "特种设备检验检测责任保险"
        },{
            key: "1508",
            value: "电梯责任保险"
        },{
            key: "2796",
            value: "航空旅客人身意外伤害保险"
        },{
            key: "2795",
            value: "短期综合意外伤害保险"
        },{
            key: "2721",
            value: "伴你行C款"
        },{
            key: "2722",
            value: "A款"
        },{
            key: "2302",
            value: "家佣乐保险"
        },{
            key: "1213",
            value: "石油类财产基本险"
        },{
            key: "1907",
            value: "长途汽车客运治安责任保险"
        },{
            key: "1106",
            value: "沿海内河渔船保险"
        },{
            key: "1303",
            value: "卫星发射及初始运行保险"
        },{
            key: "2393",
            value: "办公室综合保险"
        },{
            key: "1103",
            value: "船舶建造保险"
        },{
            key: "9998",
            value: "暂保单"
        },{
            key: "9999",
            value: "预约保险"
        },{
            key: "2787",
            value: "借款人意外伤害保险"
        },{
            key: "0310",
            value: "上海民用管道煤气（天然气）保险"
        },{
            key: "2394",
            value: "加油站综合保险"
        },{
            key: "0302",
            value: "“金安”农村家庭财产保险（A款）"
        },{
            key: "0508",
            value: "机动车辆保险通用版"
        },{
            key: "DAB",
            value: "摩托车辆保险"
        },{
            key: "1215",
            value: "石油类财产一切险"
        },{
            key: "1403",
            value: "核能源建筑工程一切险"
        },{
            key: "1217",
            value: "石油类建工一切险"
        },{
            key: "1218",
            value: "石油类安工一切险"
        },{
            key: "1220",
            value: "石油类雇主责任险"
        },{
            key: "2303",
            value: "盈安家庭财产保险"
        },{
            key: "0906",
            value: "国内水路货物运输保险"
        },{
            key: "0702",
            value: "安装工程一切险"
        },{
            key: "0207",
            value: "企业用电安全保险"
        },{
            key: "2305",
            value: "家祥乐(C款)"
        },{
            key: "2700",
            value: "短期意外险与健康险"
        },{
            key: "0198",
            value: "财产一切险"
        },{
            key: "0511",
            value: "机动车综合商业保险"
        },{
            key: "0513",
            value: "摩托车、拖拉机综合商业保险"
        },{
            key: "2730",
            value: "建设工程团体人身意外伤害保险"
        },{
            key: "1404",
            value: "核能源安装工程一切险"
        },{
            key: "1599",
            value: "责任险通用险种"
        },{
            key: "1539",
            value: "免疫接种责任保险"
        },{
            key: "0898",
            value: "安装工程一切险"
        },{
            key: "0517",
            value: "公务机动车辆保险"
        },{
            key: "0518",
            value: "渠道专属车险"
        },{
            key: "2306",
            value: "家祥乐(D款)"
        },{
            key: "1406",
            value: "核能源雇主责任保险"
        },{
            key: "1405",
            value: "核能源公众责任保险"
        },{
            key: "1216",
            value: "石油类机器损坏险"
        },{
            key: "0701",
            value: "建筑工程一切险"
        },{
            key: "DAE",
            value: "机动车辆提车保险"
        },{
            key: "2308",
            value: "盈家家庭财产保险"
        },{
            key: "1702",
            value: "雇主责任保险（涉外）"
        },{
            key: "0507",
            value: "机动车交通事故责任强制保险"
        },{
            key: "1602",
            value: "产品责任险（涉外）"
        },{
            key: "1501",
            value: "公众责任保险"
        },{
            key: "0501",
            value: "机动车辆保险"
        },{
            key: "1304",
            value: "卫星发射三者责任保险"
        },{
            key: "000",
            value: "PUB"
        },{
            key: "2707",
            value: "手术意外伤害保险"
        },{
            key: "2708",
            value: "学生幼儿人身意外伤害保险"
        },{
            key: "0109",
            value: "现金保险"
        },{
            key: "2783",
            value: "短期团体意外伤害保险"
        },{
            key: "0011",
            value: "虚拟险种"
        },{
            key: "2713",
            value: "航空旅客意外伤害保险(行业指导性条款)"
        },{
            key: "0000",
            value: "通用险种"
        },{
            key: "0801",
            value: "建筑工程一切险"
        },{
            key: "0802",
            value: "安装工程一切险"
        },{
            key: "1532",
            value: "保险代理人职业责任保险"
        },{
            key: "1530",
            value: "吊装责任保险"
        },{
            key: "1529",
            value: "餐饮业经营者责任保险"
        },{
            key: "0303",
            value: "“金安”农村家庭财产保险（B款）"
        },{
            key: "0392",
            value: "定额家财保险"
        },{
            key: "1544",
            value: "宠物犬饲养责任保险"
        },{
            key: "1536",
            value: "煤矿雇主责任保险"
        },{
            key: "1534",
            value: "工程项目监理责任保险"
        },{
            key: "1535",
            value: "工程监理责任保险"
        },{
            key: "1533",
            value: "保安公司责任保险"
        },{
            key: "2312",
            value: "公路综合保险(B)"
        },{
            key: "2311",
            value: "公路综合保险(A)"
        },{
            key: "2313",
            value: "起重机械综合保险"
        },{
            key: "1541",
            value: "建筑施工企业雇主责任保险"
        },{
            key: "0394",
            value: "定额家财保险"
        },{
            key: "0504",
            value: "机动车提车险（暂保单）"
        },{
            key: "0305",
            value: "旅行不便保险"
        },{
            key: "0304",
            value: "居民用户管道燃气财产保险"
        },{
            key: "2309",
            value: "盈和家庭财产保险"
        },{
            key: "2399",
            value: "组合险通用险种"
        },{
            key: "0117",
            value: "财产基本保险(个人贷款抵押住宅)"
        },{
            key: "0121",
            value: "财产一切险(个人贷款抵押住宅)"
        },{
            key: "0118",
            value: "财产综合保险(个人贷款抵押住宅)"
        },{
            key: "2723",
            value: "手术麻醉意外伤害保险"
        },{
            key: "2314",
            value: "轮渡货物综合保险"
        },{
            key: "1104",
            value: "沿海内河船舶建造保险"
        },{
            key: "0306",
            value: "信用卡购物保障保险"
        },{
            key: "0307",
            value: "个人账户资金保险"
        },{
            key: "1552",
            value: "非机动车第三者责任保险"
        },{
            key: "0126",
            value: "煤矿财产保险"
        },{
            key: "1107",
            value: "海上船舶海盗损失保险"
        },{
            key: "2727",
            value: "交通工具意外伤害保险"
        },{
            key: "1557",
            value: "烟花爆竹企业安全生产责任险"
        },{
            key: "3106",
            value: "种植业天气指数保险"
        },{
            key: "3107",
            value: "玉米种植保险"
        },{
            key: "3102",
            value: "果树保险"
        },{
            key: "3104",
            value: "林木综合保险"
        },{
            key: "3103",
            value: "露地蔬菜种植保险"
        },{
            key: "3108",
            value: "油菜保险"
        },{
            key: "3110",
            value: "小麦保险"
        },{
            key: "3111",
            value: "青稞保险"
        },{
            key: "3113",
            value: "甘蔗保险"
        },{
            key: "3114",
            value: "橡胶保险"
        },{
            key: "1547",
            value: "承运人旅客责任保险"
        },{
            key: "1598",
            value: "责任险通用险种(非定额)"
        },{
            key: "0999",
            value: "货物运输通用险种"
        },{
            key: "0399",
            value: "家财险通用险种"
        },{
            key: "1548",
            value: "会议配套服务供应商责任保险"
        },{
            key: "2310",
            value: "盈兴家庭财产保险"
        },{
            key: "2797",
            value: "意外险通用险种——工商银行财富客户意外险"
        },{
            key: "1545",
            value: "雇主责任保险(B)"
        },{
            key: "1550",
            value: "职业院校学生实习责任保险"
        },{
            key: "2315",
            value: "家用燃气综合保险"
        },{
            key: "1553",
            value: "教职员工校方责任保险"
        },{
            key: "1561",
            value: "注册税务师执业责任保险"
        },{
            key: "3105",
            value: "林木火灾保险"
        },{
            key: "3101",
            value: "水稻种植保险"
        },{
            key: "3220",
            value: "能繁母猪保险"
        },{
            key: "3118",
            value: "蔬菜（瓜果）大棚保险"
        },{
            key: "3115",
            value: "坚果保险"
        },{
            key: "3117",
            value: "丝瓜络保险"
        },{
            key: "3119",
            value: "西甜瓜种植保险"
        },{
            key: "2317",
            value: "铁路货车综合保险"
        },{
            key: "1110",
            value: "集装箱保险(定期)"
        },{
            key: "2316",
            value: "办公室综合保险"
        },{
            key: "0708",
            value: "高速铁路建筑工程一切险"
        },{
            key: "0709",
            value: "高速铁路安装工程一切险"
        },{
            key: "1109",
            value: "沿海内河船东保障和赔偿责任保险"
        },{
            key: "2204",
            value: "信用贷款保证保险通用险种"
        },{
            key: "3120",
            value: "云南省烟草种植保险"
        },{
            key: "1568",
            value: "资产监管责任保险"
        },{
            key: "3401",
            value: "农房保险"
        },{
            key: "0127",
            value: "文物艺术品保险"
        },{
            key: "1575",
            value: "养老机构责任保险"
        },{
            key: "3301",
            value: "林木综合保险"
        },{
            key: "3302",
            value: "林木火灾保险"
        },{
            key: "2206",
            value: "个人抵押贷款履约保证保险"
        },{
            key: "2207",
            value: "企业抵押贷款履约保证保险"
        },{
            key: "1513",
            value: "银行卡盗刷责任保险"
        },{
            key: "2102",
            value: "个人分期付款信用保险"
        },{
            key: "0515",
            value: "机动车单程提车保险"
        },{
            key: "0519",
            value: "店面机动车辆商业保险"
        },{
            key: "0313",
            value: "网络游戏帐号出租安全保险"
        },{
            key: "0315",
            value: "网络游戏代练安全保险"
        },{
            key: "3221",
            value: "生猪价格指数保险"
        },{
            key: "2801",
            value: "团体补充医疗保险"
        },{
            key: "2208",
            value: "理财投资类保证保险通用险种"
        },{
            key: "3141",
            value: "茶叶种植保险"
        },{
            key: "3303",
            value: "苗木种植保险"
        },{
            key: "3144",
            value: "水生植物种植保险"
        },{
            key: "3222",
            value: "能繁母牛保险"
        },{
            key: "3223",
            value: "淡水养殖保险（互助）"
        },{
            key: "3224",
            value: "海水养殖保险（互助）"
        },{
            key: "1401",
            value: "核物质损失保险"
        },{
            key: "1402",
            value: "核第三者责任保险"
        },{
            key: "1579",
            value: "第三方交易平台网络真品责任保险"
        },{
            key: "1576",
            value: "电子产品延长保修服务合同责任保险"
        },{
            key: "1578",
            value: "第三方支付平台网络支付责任保险"
        },{
            key: "1581",
            value: "诉讼财产保全责任保险"
        },{
            key: "3146",
            value: "绿肥牧草作物保险"
        },{
            key: "3403",
            value: "农业机械综合保险"
        },{
            key: "1582",
            value: "出租人责任保险"
        },{
            key: "1577",
            value: "银行外包责任保险"
        },{
            key: "3225",
            value: "养蚕保险"
        },{
            key: "3147",
            value: "中草药种植保险"
        },{
            key: "3226",
            value: "养殖业天气指数保险"
        },{
            key: "2307",
            value: "家政服务人员责任定额保险"
        },{
            key: "2716",
            value: "自由行－交通工具意外伤害保险"
        },{
            key: "2782",
            value: "乘客意外伤害险"
        },{
            key: "2790",
            value: "伴你行B款"
        },{
            key: "1306",
            value: "点火至起飞保险"
        },{
            key: "2710",
            value: "建筑施工人员团体意外伤害保险"
        },{
            key: "0102",
            value: "财产综合保险"
        },{
            key: "0203",
            value: "现金保险(涉外)"
        },{
            key: "0520",
            value: "电销机动车辆商业保险"
        },{
            key: "0122",
            value: "2008版财产基本险"
        },{
            key: "0123",
            value: "2008版财产综合险"
        },{
            key: "0124",
            value: "2008版财产一切险"
        },{
            key: "9997",
            value: "公网出单用预约协议"
        },{
            key: "0125",
            value: "工程机械设备保险"
        },{
            key: "0196",
            value: "种植业保险"
        },{
            key: "0510",
            value: "电销机动车辆保险"
        },{
            key: "2724",
            value: "家用燃气用户意外伤害保险"
        },{
            key: "0309",
            value: "自然灾害家庭财产保险"
        },{
            key: "0912",
            value: "国内公路果蔬货物运输定额保险"
        },{
            key: "0913",
            value: "轮渡货物运输保险"
        },{
            key: "1559",
            value: "校园足球运动责任保险"
        },{
            key: "1562",
            value: "公路货运承运人责任保险"
        },{
            key: "1560",
            value: "注册资产评估师执业责任保险"
        },{
            key: "1563",
            value: "安全生产责任保险"
        },{
            key: "1564",
            value: "全国职业院校学生实习责任保险"
        },{
            key: "1565",
            value: "校方责任保险"
        },{
            key: "3201",
            value: "养鹅保险"
        },{
            key: "3202",
            value: "种鸡保险"
        },{
            key: "3203",
            value: "肉鸡保险"
        },{
            key: "3204",
            value: "种鸭保险"
        },{
            key: "3205",
            value: "肉鸭保险"
        },{
            key: "3206",
            value: "藏系羊保险"
        },{
            key: "3208",
            value: "育肥猪保险"
        },{
            key: "3209",
            value: "奶牛保险"
        },{
            key: "0509",
            value: "店面机动车辆保险"
        },{
            key: "1566",
            value: "新疆维吾尔自治区分公司安全生产责任保险"
        },{
            key: "1567",
            value: "环境污染责任保险"
        },{
            key: "3121",
            value: "苹果种植保险"
        },{
            key: "1572",
            value: "监护人责任保险"
        },{
            key: "0311",
            value: "网络游戏卖家出售财产保险"
        },{
            key: "3123",
            value: "烟草种植保险"
        },{
            key: "2726",
            value: "境外中资企业机构人员意外伤害保险"
        },{
            key: "0312",
            value: "网络充值安全保险"
        },{
            key: "9901",
            value: "网络购物退换货运费损失保险"
        },{
            key: "1574",
            value: "食品安全责任保险"
        },{
            key: "0316",
            value: "网络游戏虚拟财产交易安全保险"
        },{
            key: "1549",
            value: "江泰旅行社责任保险"
        },{
            key: "1554",
            value: "煤矿企业安全生产责任险"
        },{
            key: "1556",
            value: "危险化学品企业安全生产责任险"
        },{
            key: "1569",
            value: "机动车辆延长保修责任保险"
        },{
            key: "1571",
            value: "民生救助责任保险"
        },{
            key: "1573",
            value: "供热责任保险"
        },{
            key: "0314",
            value: "网络账号安全保险"
        },{
            key: "2904",
            value: "圆丰产品1年期（网销）"
        },{
            key: "3124",
            value: "豆类作物种植保险"
        },{
            key: "3125",
            value: "马铃薯种植保险"
        },{
            key: "3126",
            value: "棉花种植保险"
        },{
            key: "3130",
            value: "梨种植保险"
        },{
            key: "3131",
            value: "桃种植保险"
        },{
            key: "3132",
            value: "杏种植保险"
        },{
            key: "3133",
            value: "樱桃种植保险"
        },{
            key: "3134",
            value: "枣种植保险"
        },{
            key: "3136",
            value: "柿子种植保险"
        },{
            key: "3139",
            value: "农作物收获期保险"
        },{
            key: "3213",
            value: "种猪养殖保险"
        },{
            key: "3140",
            value: "作物制种保险"
        },{
            key: "3127",
            value: "花生种植保险"
        },{
            key: "3128",
            value: "芝麻种植保险"
        },{
            key: "3129",
            value: "甜菜种植保险"
        },{
            key: "3137",
            value: "柑橘种植保险"
        },{
            key: "3138",
            value: "香蕉种植保险"
        },{
            key: "3211",
            value: "肉牛养殖保险"
        },{
            key: "9902",
            value: "代步车服务保险"
        },{
            key: "3112",
            value: "香料烟保险"
        },{
            key: "3122",
            value: "小杂粮种植保险"
        },{
            key: "3142",
            value: "种植业目标价格保险"
        },{
            key: "2321",
            value: "汽车经销商综合保险"
        },{
            key: "2322",
            value: "汽车修理厂综合保险"
        },{
            key: "2209",
            value: "个人贷款保证保险"
        },{
            key: "6001",
            value: "地方性巨灾保险通用险种（财产损失部分）"
        },{
            key: "6002",
            value: "宁波市巨灾保险（居民人身伤亡抚恤保险)"
        },{
            key: "1111",
            value: "船舶抵押权保证保险"
        },{
            key: "3145",
            value: "花卉种植保险"
        },{
            key: "3229",
            value: "驴养殖保险"
        },{
            key: "2211",
            value: "投标保证保险主险"
        },{
            key: "2212",
            value: "建设工程施工合同履约保证保险"
        },{
            key: "2805",
            value: "重大疾病海外医疗综合保险"
        },{
            key: "2729",
            value: "机动车驾驶培训学员意外伤害保险"
        },{
            key: "3149",
            value: "食用菌种植保险"
        },{
            key: "1584",
            value: "网络借贷信息中介服务平台标准化信贷审核责任保险"
        },{
            key: "9996",
            value: "贷记卡保证保险预约协议"
        },{
            key: "2210",
            value: "单用途商业预付卡履约保证保险"
        },{
            key: "1585",
            value: "预定取消保险"
        },{
            key: "3150",
            value: "秋播大白菜种植保险"
        },{
            key: "3227",
            value: "鸽养殖保险"
        },{
            key: "2806",
            value: "个人医疗保险"
        },{
            key: "6099",
            value: "中国城乡居民住宅地震巨灾保险"
        },{
            key: "0160",
            value: "财产险组合产品"
        },{
            key: "1112",
            value: "船东保障和赔偿责任险"
        },{
            key: "2903",
            value: "“圆丰产品2016版”系列产品"
        },{
            key: "3228",
            value: "养殖业目标价格保险"
        },{
            key: "1583",
            value: "首台（套）重大技术装备保险"
        },{
            key: "2902",
            value: "圆丰投资保障型5年期家庭财产保险"
        },{
            key: "0505",
            value: "机动车提车险"
        },{
            key: "1214",
            value: "石油类财产综合险"
        },{
            key: "1219",
            value: "石油类公众责任险"
        },{
            key: "1901",
            value: "特种设备第三者责任保险"
        },{
            key: "1537",
            value: "医务人员法定传染病责任保险"
        },{
            key: "0907",
            value: "国内水路、陆路货物运输保险"
        },{
            key: "2709",
            value: "执法人员团体人身意外伤害保险"
        },{
            key: "1531",
            value: "保险经纪人职业责任保险"
        },{
            key: "1540",
            value: "特种设备第三者责任保险"
        },{
            key: "0119",
            value: "财产保险(个人贷款抵押住宅)"
        },{
            key: "2799",
            value: "意外险卡折通用险种"
        },{
            key: "1108",
            value: "船舶污染责任保险"
        },{
            key: "3109",
            value: "杂交水稻保险"
        },{
            key: "3207",
            value: "羊养殖保险"
        },{
            key: "3402",
            value: "涉农意外保险"
        },{
            key: "0914",
            value: "网络购物退换货运费损失保险"
        },{
            key: "2775",
            value: "境外人员意外伤害保险"
        },{
            key: "1903",
            value: "道路客运承运人责任保险"
        },{
            key: "0599",
            value: "机动车辆保险"
        },{
            key: "0120",
            value: "信用卡盗用保险"
        },{
            key: "1394",
            value: "卫星运行寿命保险"
        },{
            key: "0516",
            value: "家庭机动车辆保险"
        },{
            key: "1105",
            value: "油污责任保险"
        },{
            key: "0707",
            value: "地铁安装工程一切险"
        },{
            key: "2704",
            value: "旅游观光景点、娱乐场所人身意外伤害保险"
        },{
            key: "1102",
            value: "沿海内河船舶保险"
        },{
            key: "1518",
            value: "医疗责任保险"
        },{
            key: "1503",
            value: "展览会责任保险条款"
        },{
            key: "1502",
            value: "火灾公众责任保险"
        },{
            key: "0512",
            value: "特种车综合商业保险"
        },{
            key: "1538",
            value: "上海民用管道煤气（天然气）保险"
        },{
            key: "0403",
            value: "个人房屋抵押贷款还贷保证保险"
        },{
            key: "2203",
            value: "船舶抵押权保证保险"
        },{
            key: "1555",
            value: "非煤矿山安全生产责任险"
        },{
            key: "0911",
            value: "国内货物运输保险（通用版）"
        },{
            key: "2728",
            value: "特定场所意外伤害保险"
        },{
            key: "2205",
            value: "车辆贷款保证保险"
        },{
            key: "2103",
            value: "国内短期贸易信用保险"
        },{
            key: "1580",
            value: "无人驾驶飞行器责任保险"
        },{
            key: "0115",
            value: "电厂财产保险一切险"
        },{
            key: "0197",
            value: "养殖业保险"
        },{
            key: "2320",
            value: "中国工商银行理财金账户专属家庭综合保险"
        },{
            key: "3210",
            value: "牦牛保险"
        },{
            key: "1570",
            value: "网络商品交易退货运费责任保险"
        },{
            key: "2101",
            value: "金融机构贷款损失信用保险"
        },{
            key: "3135",
            value: "葡萄种植保险"
        },{
            key: "3212",
            value: "种牛养殖保险"
        },{
            key: "3148",
            value: "油料作物种植保险"
        },{
            key: "2802",
            value: "癌症保险"
        },{
            key: "2803",
            value: "女性特定疾病保险"
        },{
            key: "2804",
            value: "重大疾病保险"
        }
    ]);

    //案件状态下拉框
    model.set("claimStatusList",[
        {
            key: "01",
            value: "报案"
        },
        {
            key: "02",
            value: "立案"
        },
        {
            key: "03",
            value: "注销"
        },
        {
            key: "04",
            value: "结案"
        },
        {
            key: "05",
            value: "重开赔案"
        },
        {
            key: "06",
            value: "重开案结案"
        }
    ]);

    $.ajax({
        url:"controller/insurance/businessEntity/findCustomerEntities?actualId="+actualId,
        type: "GET",
        async: false,
        sendJson: true,
        success: function(data) {
            debugger;
            var policyHolder = data.plcApplicant;//投保人
            var byTheApplicant = data.plcInsurant;//被保人

            //循环设置投保人数据
            for( var i=0;i<policyHolder.length;i++ ){
                var paramsApplicant = {
                    idType: policyHolder[i].identifyType,
                    idNo: policyHolder[i].identifyNumber,
                    idName: policyHolder[i].customerName
                };

                //查询客户ID(PartyId)
                $.ajax({
                    url:"controller/risksurvey/ecifClient/searchParty?sysId=B102&interruptFlag=0",
                    type: "POST",
                    sendJson: true,
                    async: false,
                    contentType: "application/json",
                    data: JSON.stringify(paramsApplicant),
                    success: function (data) {
                        //ecif有数据的情况
                        if( data.responseCode != 0 ){
                            var partyId = data.partyIdObj.partyId;

                            //获取客户风险等级
                            $.ajax({
                                url: "controller/risksurvey/ecifClient/getCustRiskLevel?sysId=B102&interruptFlag=0",
                                type: "POST",
                                contentType: "application/json",
                                async: false,
                                data: JSON.stringify({
                                    partyId: partyId
                                }),
                                success: function (data) {
                                    //设置当前投保人的风险等级: 如果有人工分级就设人工分级,否则设为自动分级
                                    policyHolder[i].customerLevel = data.custRiskLevel.manualRiskLevelCode?data.custRiskLevel.manualRiskLevelCode:data.custRiskLevel.autoRiskLevelCode;
                                    if(policyHolder[i].customerLevel == "1"){
                                        policyHolder[i].customerLevel = "禁止";
                                    }else if(policyHolder[i].customerLevel == "2"){
                                        policyHolder[i].customerLevel = "高";
                                    }else if(policyHolder[i].customerLevel == "3"){
                                        policyHolder[i].customerLevel = "中";
                                    }else if(policyHolder[i].customerLevel == "4"){
                                        policyHolder[i].customerLevel = "低";
                                    }
                                }
                            });

                            //获取客户投保历史信息
                            $.ajax({
                                url: "controller/risksurvey/ecifClient/getPolicy?sysId=B102&interruptFlag=0",
                                type: "POST",
                                contentType: "application/json",
                                async: false,
                                data: JSON.stringify({
                                    partyIdObj: {
                                        partyId: partyId
                                    }
                                }),
                                success: function (data) {
                                    //设置当前投保人的历史保单
                                    policyHolder[i].historyPolicy = data.policys;
                                    //计算当前投保人的历史所有有效保单的总保费 -> 即:客户风险累积
                                    var sum = 0;
                                    if( data.policys ){
                                        for(var j= 0,len=data.policys.length;j<len;j++){
                                            sum += data.policys[j].rmbpremiumAMT;
                                        }
                                    }
                                    policyHolder[i].sum = sum;
                                }
                            })

                            //获取客户历史理赔信息
                            $.ajax({
                                url: "controller/risksurvey/ecifClient/getClaim?sysId=B102&interruptFlag=0",
                                type: "POST",
                                contentType: "application/json",
                                async: false,
                                data: JSON.stringify({
                                    partyIdObj: {
                                        partyId: partyId
                                    }
                                }),
                                success: function (data) {
                                    //设置当前投保人的历史理赔保单
                                    policyHolder[i].historyClaims = data.claims;
                                }
                            })
                        }else{
                            cola.NotifyTipManager.warning({
                                message:"",
                                description:"该客户ID下: ecif无数据 - (投保人)",
                                showDuration:3000
                            });
                        }

                    }
                })
            }
            model.set("policyHolder", policyHolder);//设置投保人
            if(model.get("policyHolder.historyPolicy")){
                //时间格式转换
                model.get("policyHolder").each(function (item) {
                    item.get("historyPolicy").each(function (entity) {
                        var start=XDate(entity.get("startTime")).toString("yyyy-MM-dd");
                        var endTime = XDate(entity.get("endTime")).toString("yyyy-MM-dd");
                        entity.set("startTime",start);
                        entity.set("endTime",endTime);
                    })
                })
            }
            if(model.get("policyHolder.historyClaims")){
                model.get("policyHolder").each(function (item) {
                    item.get("historyClaims").each(function (entity) {
                        var claimEndTime = "";
                        var claimRptTime = "";
                        var demageTime = "";
                        if(entity.get("claimEndTime")){
                            claimEndTime = XDate(entity.get("claimEndTime")).toString("yyyy-MM-dd");
                        }
                        if(entity.get("claimRptTime")){
                            claimRptTime = XDate(entity.get("claimRptTime")).toString("yyyy-MM-dd");
                        }
                        if(entity.get("demageTime")){
                            claimRptTime = XDate(entity.get("demageTime")).toString("yyyy-MM-dd");
                        }
                        entity.set("demageTime",demageTime);
                        entity.set("claimRptTime",claimRptTime);
                        entity.set("claimEndTime",claimEndTime);
                    })
                })
            }




            //循环设置被保人数据
            for( var i=0;i<byTheApplicant.length;i++ ){
                var paramsInsurant = {
                    idType: byTheApplicant[i].identifyType,
                    idNo: byTheApplicant[i].identifyNumber,
                    idName: byTheApplicant[i].customerName
                };

                //查询客户ID(PartyId)
                $.ajax({
                    url:"controller/risksurvey/ecifClient/searchParty?sysId=B102&interruptFlag=0",
                    type: "POST",
                    sendJson: true,
                    async: false,
                    contentType: "application/json",
                    data: JSON.stringify(paramsInsurant),

                    success: function (data) {

                        //ecif有数据的情况
                        if( data.responseCode != 0 ){
                            var partyId = data.partyIdObj.partyId;

                            //获取客户风险等级
                            $.ajax({
                                url: "controller/risksurvey/ecifClient/getCustRiskLevel?sysId=B102&interruptFlag=0",
                                type: "POST",
                                contentType: "application/json",
                                async: false,
                                data: JSON.stringify({
                                    partyId: partyId
                                }),
                                success: function (data) {
                                    //设置当前被保人的风险等级: 如果有人工分级就设人工分级,否则设为自动分级
                                    byTheApplicant[i].customerLevel = data.custRiskLevel.manualRiskLevelCode?data.custRiskLevel.manualRiskLevelCode:data.custRiskLevel.autoRiskLevelCode;
                                    if(byTheApplicant[i].customerLevel == "1"){
                                        byTheApplicant[i].customerLevel = "禁止";
                                    }else if(byTheApplicant[i].customerLevel == "2"){
                                        byTheApplicant[i].customerLevel = "高";
                                    }else if(byTheApplicant[i].customerLevel == "3"){
                                        byTheApplicant[i].customerLevel = "中";
                                    }else if(byTheApplicant[i].customerLevel == "4"){
                                        byTheApplicant[i].customerLevel = "低";
                                    }
                                }
                            });

                            //获取客户投保历史信息
                            $.ajax({
                                url: "controller/risksurvey/ecifClient/getPolicy?sysId=B102&interruptFlag=0",
                                type: "POST",
                                contentType: "application/json",
                                async: false,
                                data: JSON.stringify({
                                    partyIdObj: {
                                        partyId: partyId
                                    }
                                }),
                                success: function (data) {
                                    debugger;
                                    //设置当前投保人的历史保单
                                    byTheApplicant[i].historyPolicy = data.policys;

                                    //计算当前投保人的历史所有有效保单的总保费 -> 即:客户风险累积
                                    var sum = 0;
                                    if( data.policys ){
                                        for(var j= 0,len=data.policys.length;j<len;j++){
                                            sum += data.policys[j].rmbpremiumAMT;
                                        }
                                    }
                                    byTheApplicant[i].sum = sum;
                                }
                            })

                            //获取客户历史理赔信息
                            $.ajax({
                                url: "controller/risksurvey/ecifClient/getClaim?sysId=B102&interruptFlag=0",
                                type: "POST",
                                contentType: "application/json",
                                async: false,
                                data: JSON.stringify({
                                    partyIdObj: {
                                        partyId: partyId
                                    }
                                }),
                                success: function (data) {
                                    //设置当前投保人的历史理赔保单
                                    byTheApplicant[i].historyClaims = data.claims;
                                }
                            })
                        }else{
                            cola.NotifyTipManager.warning({
                                message:"",
                                description:"该客户ID下: ecif无数据 - (被保人)",
                                showDuration:3000
                            });
                        }


                    }
                })
            }
            model.set("byTheApplicant", byTheApplicant);//设置被保人
            if(model.get("byTheApplicant.historyPolicy")){
                //时间格式转换
                model.get("byTheApplicant").each(function (item) {
                    item.get("historyPolicy").each(function (entity) {
                        var start=XDate(entity.get("startTime")).toString("yyyy-MM-dd");
                        var endTime = XDate(entity.get("endTime")).toString("yyyy-MM-dd");
                        entity.set("startTime",start);
                        entity.set("endTime",endTime);
                    })
                })
            }
            if(model.get("byTheApplicant.historyClaims")){
                model.get("byTheApplicant").each(function (item) {
                    item.get("historyClaims").each(function (entity) {
                        var claimEndTime = "";
                        var claimRptTime = "";
                        var demageTime = "";
                        if(entity.get("claimEndTime")){
                            claimEndTime = XDate(entity.get("claimEndTime")).toString("yyyy-MM-dd");
                        }
                        if(entity.get("claimRptTime")){
                            claimRptTime = XDate(entity.get("claimRptTime")).toString("yyyy-MM-dd");
                        }
                        if(entity.get("demageTime")){
                            claimRptTime = XDate(entity.get("demageTime")).toString("yyyy-MM-dd");
                        }
                        entity.set("claimRptTime",claimRptTime);
                        entity.set("claimEndTime",claimEndTime);
                        entity.set("demageTime",demageTime);
                    })
                })
            }
        }
    });
});