package com.ts.app.sys.constants;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.google.common.collect.Maps;

public class Constants {
	
	/**
	 * 用户SESSION KEY
	 */
	public static final String SESSION_USER_KEY="SESSION_USER_KEY";
	
	/**
	 * 图片验证码
	 */
	public static final String IMG_CODE="imgCode";
	/**
	 * 短信验证码
	 */
	public static final String VER_CODE="verCode";
	
	/**
	 * 图片验证码创建时间
	 */
	public static final String IMG_BUILD_TIME="imgBuildTime";
	
	/**
	 * 返回结果（true成功，false失败）
	 */
	public static final String SUCCESS="success";
	
	/**
	 * json返回信息
	 */
	public static final String MSG="msg";
	
	/**
	 * 取消未支付订单的时间限制（分钟）
	 */
	public static final Integer CANCLE_NOPAY_ORDERS_TIME = 30;
    /**
     * 是否有效-正常
     */
	public static final String AVAILABLE_NORMAL = "0";
	/**
     * 是否有效-冻结
     */
	public static final String AVAILABLE_NO = "1";
	/**
     * 是否有效Map
     */	
    public static final Map<String,String> AVAILABLE_MAP =new HashMap<String,String>();
    static {
    	AVAILABLE_MAP.put(AVAILABLE_NORMAL, "正常");
    	AVAILABLE_MAP.put(AVAILABLE_NO, "冻结");
    }
    
    /**
     * 删除标志
     */
    public static final String DEL_FLAG="1";
    /**
     * 用户类型-0旅客
     */
	public static final String USER_TYPE_USER = "0";
	/**
     * 用户类型-1商家 
     */
	public static final String USER_TYPE_MERCHANT = "1";
	/**
     * 用户类型-2平台
     */
	public static final String USER_TYPE_BACKSTAGE = "2";
	/**
     * 用户类型MAP
     */
	public static final TreeMap<String,String> MAP_USER_TYPE = Maps.newTreeMap(); 
    static{
    	MAP_USER_TYPE.put(USER_TYPE_USER, "旅客");
    	MAP_USER_TYPE.put(USER_TYPE_MERCHANT, "商家");
    	MAP_USER_TYPE.put(USER_TYPE_BACKSTAGE, "平台");
    }
    
	
	/**
     * 优惠券类型-0商家
     */
	public static final String COUPON_TYPE_MERCHANT = "0";
	/**
     * 优惠券类型-1平台
     */
	public static final String COUPON_TYPE_BACKSTAGE = "1";
	/**
     * 优惠券类型MAP
     */
    public static final Map<String,String> MAP_COUPON_TYPE=Maps.newHashMap(); 
    static{
    	MAP_COUPON_TYPE.put(COUPON_TYPE_MERCHANT, "商家");
    	MAP_COUPON_TYPE.put(COUPON_TYPE_BACKSTAGE, "平台");
    }
	
	/**
     * 是否下架-0未下架
     */
	public static final String COUPON_AVAILABLE_NO = "0";
	/**
     * 是否下架-1下架
     */
	public static final String COUPON_AVAILABLE_YES = "1";

	
	/**
     * 审核状态-0待审核
     */
	public static final String CHECK_STATE_NORMAL = "0";
	/**
     * 审核状态-1审核通过
     */
	public static final String CHECK_STATE_YES = "1";
	/**
     * 审核状态-2审核未通过
     */
	public static final String CHECK_STATE_NO = "2";
	/**
     * 审核状态MAP
     */
	public static final TreeMap<String,String> CHECK_STATE_MAP = Maps.newTreeMap(); 
    static{
    	CHECK_STATE_MAP.put(CHECK_STATE_NORMAL, "待审核");
    	CHECK_STATE_MAP.put(CHECK_STATE_YES, "通过");
    	CHECK_STATE_MAP.put(CHECK_STATE_NO, "未通过");
    }
 
	/**
     * 是否是首页推荐房间-0 不是
     */
	public static final String ROOM_ISRECOMMEND_NO = "0";
	/**
     * 是否是首页推荐房间-1 是
     */
	public static final String ROOM_ISRECOMMEND_YES = "1";
	/**
     * 房间推荐状态MAP
     */
	public static final Map<String,String> ROOM_ISRECOMMEND_MAP=Maps.newHashMap(); 
    static{
    	ROOM_ISRECOMMEND_MAP.put(ROOM_ISRECOMMEND_NO, "未推荐");
    	ROOM_ISRECOMMEND_MAP.put(ROOM_ISRECOMMEND_YES, "已推荐");
    }
    
    /**
     * 房间是否优惠-0未优惠
     */
	public static final String ROOM_DIS_NO = "0";
	/**
     * 房间是否优惠-1优惠
     */
	public static final String ROOM_DIS_YES = "1";
	/**
     * 房间是否优惠
     */
	public static final Map<String,String> MAP_ROOM_DISFLAG=Maps.newHashMap(); 
    static{
    	MAP_ROOM_DISFLAG.put(ROOM_DIS_NO, "否");
    	MAP_ROOM_DISFLAG.put(ROOM_DIS_YES, "是");
    }

    
	/**
     * 性别-0男
     */
	public static final String USER_SEX_MALE = "0";
	/**
     * 性别-1女
     */
	public static final String USER_SEX_FEMALE = "1";
	public static final Map<String,String> MAP_USER_SEX=Maps.newHashMap(); 
    static{
    	MAP_USER_SEX.put(USER_SEX_MALE, "男");
    	MAP_USER_SEX.put(USER_SEX_FEMALE, "女");
    }
    
    /**
     * 是否提供发票-0是
     */
	public static final String ROOM_ISINOVICE_YES = "0";
	 /**
     * 是否提供发票-1否
     */
	public static final String ROOM_ISINOVICE_NO = "1";
	public static final Map<String,String> MAP_ROOM_ISINOVICE=Maps.newHashMap(); 
    static{
    	MAP_ROOM_ISINOVICE.put(ROOM_ISINOVICE_YES, "是");
    	MAP_ROOM_ISINOVICE.put(ROOM_ISINOVICE_NO, "否");
    }
    /**
     * 是否可退-0是
     */
	public static final String ROOM_ISWITHDRAW_YES = "0";
	 /**
     * 是否可退-1否
     */
	public static final String ROOM_ISWITHDRAW_NO = "1";
	public static final Map<String,String> MAP_ROOM_ISWITHDRAW=Maps.newHashMap(); 
    static{
    	MAP_ROOM_ISWITHDRAW.put(ROOM_ISWITHDRAW_YES, "是");
    	MAP_ROOM_ISWITHDRAW.put(ROOM_ISWITHDRAW_NO, "否");
    }
    
    /**
     * 是否可用优惠券-0是
     */
	public static final String ROOM_ISONSALE_YES = "0";
	 /**
     * 是否可用优惠券-1否
     */
	public static final String ROOM_ISONSALE_NO = "1";
	public static final Map<String,String> MAP_ROOM_ISONSALE=Maps.newHashMap(); 
    static{
    	MAP_ROOM_ISONSALE.put(ROOM_ISONSALE_NO, "否");
    	MAP_ROOM_ISONSALE.put(ROOM_ISONSALE_YES, "是");
    }
    
    /**
     * 留言反馈和用户评价 每页默认显示两条
     */
    public static final String PAGESIZE_2="2";
    
    /**
     * 消息中心 每页默认显示四条
     */
    public static final String PAGESIZE_4="4";
    
    
    /**
     * 退款状态-待退款
     */
	public static final String REFUND_STATE_NO = "0";
	/**
     * 退款状态-退款中
     */
	public static final String REFUND_STATE_ING = "1";
	/**
     * 退款状态-退款成功
     */
	public static final String REFUND_STATE_SUCCESS = "2";
	/**
     * 退款状态-退款失败
     */
	public static final String REFUND_STATE_FAIL = "3";
	/**
     * 退款状态Map
     */	
    public static final TreeMap<String,String> REFUND_STATE_MAP = new TreeMap<String,String>();
    static {
    	REFUND_STATE_MAP.put(REFUND_STATE_NO, "待退款");
    	REFUND_STATE_MAP.put(REFUND_STATE_ING, "退款中");
    	REFUND_STATE_MAP.put(REFUND_STATE_SUCCESS, "退款成功");
    	REFUND_STATE_MAP.put(REFUND_STATE_FAIL, "退款失败");
    }
    
    
    /**
     * 支付渠道-支付宝
     */
	public static final String TRADE_TYPE_ALIPAY = "0";
	/**
     * 支付渠道-微信
     */
	public static final String TRADE_TYPE_WXPAY = "1";
	/**
     * 支付渠道-到店
     */
	public static final String TRADE_TYPE_DAODIAN = "2";
	/**
     * 支付渠道-Map
     */	
    public static final TreeMap<String,String> TRADE_TYPE_MAP = new TreeMap<String,String>();
    static {
    	TRADE_TYPE_MAP.put(TRADE_TYPE_ALIPAY, "支付宝");
    	TRADE_TYPE_MAP.put(TRADE_TYPE_WXPAY, "微信");
    	TRADE_TYPE_MAP.put(TRADE_TYPE_DAODIAN, "到店付");
    }
    /**
     * 旅客端我的优惠券 
     * 是否已使用优惠券-0是
     */
	public static final String MYCOUPON_ISUSE_YES = "1";
	 /**
     * 是否已使用优惠券-1否
     */
	public static final String MYCOUPON_ISUSE_NO = "0";
	public static final Map<String,String> MAP_MYCOUPON_ISUSE=Maps.newHashMap(); 
    static{
    	MAP_MYCOUPON_ISUSE.put(MYCOUPON_ISUSE_YES, "是");
    	MAP_MYCOUPON_ISUSE.put(MYCOUPON_ISUSE_NO, "否");
    }
    /**
     * 优惠券 
	 * 是否过期-0否
	 */
	public static final String MYCOUPON_ISDUE_NO = "0";
	/**
	 * 是否过期-1是
	 */
	public static final String MYCOUPON_ISDUE_YES = "1";
	public static final Map<String,String> MAP_ROOM_ISUSE=Maps.newHashMap(); 
    static{
    	MAP_ROOM_ISUSE.put(MYCOUPON_ISDUE_YES, "是");
    	MAP_ROOM_ISUSE.put(MYCOUPON_ISDUE_NO, "否");
    }
    
    /**
     * 提现状态 -0 提现中
     */
    public static final String WITHDRAWSTATE_INIT = "0";
    /**
     * 提现状态 -1 提现成功
     */
    public static final String WITHDRAWSTATE_YES = "1";
    /**
     * 提现状态 -2 提现失败
     */
    public static final String WITHDRAWSTATE_NO = "2";
    
    /**
     * 提现状态map
     */
    public static final Map<String,String> WITHDRAWSTATE_MAP=new HashMap<>();
    static {
    	WITHDRAWSTATE_MAP.put(WITHDRAWSTATE_INIT, "提现中");
    	WITHDRAWSTATE_MAP.put(WITHDRAWSTATE_YES, "提现成功");
    	WITHDRAWSTATE_MAP.put(WITHDRAWSTATE_NO, "提现失败");
    }
    
    
    /**
     * 订单状态-0 待确认
     */
	public static final String ORDER_STATE_NORMAL = "0";
	/**
     * 订单状态-1 未付款（已确认）
     */
	public static final String ORDER_STATE_CONFIRM = "1";
	/**
     * 订单状态-2 已付款（已订房）
     */
	public static final String ORDER_STATE_RESERVE = "2";
	/**
     * 订单状态-3 已入住
     */
	public static final String ORDER_STATE_IN = "3";
	/**
     * 订单状态-4 已退房
     */
	public static final String ORDER_STATE_OUT = "4";
	/**
     * 订单状态-5 已完结
     */
	public static final String ORDER_STATE_FINISH = "5";
	/**
     * 订单状态-6 已取消
     */
	public static final String ORDER_STATE_CANCEL = "6";
	/**
     * 订单状态Map
     */
	public static final TreeMap<String,String> MAP_ORDER_STATE=Maps.newTreeMap(); 
	static{
    	MAP_ORDER_STATE.put(ORDER_STATE_NORMAL, "待确认");
    	MAP_ORDER_STATE.put(ORDER_STATE_CONFIRM, "未付款");
    	MAP_ORDER_STATE.put(ORDER_STATE_RESERVE, "已订房");
    	MAP_ORDER_STATE.put(ORDER_STATE_IN, "已入住");
    	MAP_ORDER_STATE.put(ORDER_STATE_OUT, "已退房");
    	MAP_ORDER_STATE.put(ORDER_STATE_FINISH, "已完结");
    	MAP_ORDER_STATE.put(ORDER_STATE_CANCEL, "已取消");
    }
    
    /**
     * 消息读取类型 -0 系统消息
     */
    public static final String MESSAGE_TYPE_SYS="0";
    /**
     * 消息读取状态-1 短信消息
     */
    public static final String MESSAGE_TYPE_SMS="1";
    /**
     * 消息类型map
     */
	public static final TreeMap<String,String> MAP_MESSAGE_TYPE=Maps.newTreeMap(); 
	static{
		MAP_MESSAGE_TYPE.put(MESSAGE_TYPE_SYS, "系统消息");
		MAP_MESSAGE_TYPE.put(MESSAGE_TYPE_SMS, "短信信息");
    }
    
	
    /**
     * 消息读取状态 -0 未读
     */
    public static final String READSTATE_NO="0";
    /**
     * 消息读取状态-1 已读
     */
    public static final String READSTATE_YES="1";
    /**
     * 消息读取状态map
     */
    public static final TreeMap<String,String> MAP_READ_STATE=Maps.newTreeMap(); 
	static{
		MAP_READ_STATE.put(READSTATE_NO, "未读");
		MAP_READ_STATE.put(READSTATE_YES, "已读");
    }
    
    /**
     * 支付状态 -0 待付款
     */
    public static final String PAY_STATE_NORMAL = "0";
    /**
     * 支付状态  -1 已付款
     */
    public static final String PAY_STATE_YES = "1";
    /**
     * 支付状态  -2 已取消
     */
    public static final String PAY_STATE_NO = "2";
    
    /**
     * 支付状态map
     */
    public static final Map<String,String> MAP_PAY_STATE=new HashMap<>();
    static {
    	MAP_PAY_STATE.put(PAY_STATE_NORMAL, "待付款");
    	MAP_PAY_STATE.put(PAY_STATE_YES, "已付款");
    	MAP_PAY_STATE.put(PAY_STATE_NO, "已取消");
    }
    /**
	 * 周六日是否可用-0可用
	 */
	public static final String EXCLUDE_FLAG_YES = "0";
	/**
	 * 周六日是否可用-1不可用
	 */
	public static final String EXCLUDE_FLAG_NO = "1";
	/**
	 * 是否封面图 ---0否
	 */
	public static final String COVER_FLAG_NO = "0";
	/**
	 * 是否封面图 ---1是
	 */
	public static final String COVER_FLAG_YES = "1";
	/**
	 * 用户评价不为空时设施分数所占的评定比例
	 */
	public static final double FACILITIES_SCORE_PROPORTION = 0.7;
	/**
	 * 短信自定义模板的key
	 */
	public static final String MESSAGE_CONTENT = "AkUXj1";
	/**
	 * 短信验证码的key
	 */
	public static final String MESSAGE_CODE = "2XkTQ1";
	/**
	 * 反馈类型-0 旅客反馈 
	 */
	public static final String FEEDBACK_TYPE_USER = "0";
	
	/**
	 * 反馈类型-1 商家反馈
	 */
	public static final String FEEDBACK_TYPE_MERCHANT = "1";
	/**
	 * 订单—0 在线付 
	 */
	public static final String TRADE_TYPE_FLAG_ONLINE= "0";
	
	/**
	 * 订单-1 到店付
	 */
	public static final String TRADE_TYPE_FLAG_TOSHOP = "1";
	
	/**
     * 订单-订房渠道
     */
    public static final Map<String,String> MAP_TRADE_TYPE=new HashMap<>();
    static {
    	MAP_TRADE_TYPE.put(TRADE_TYPE_FLAG_ONLINE, "在线付 ");
    	MAP_TRADE_TYPE.put(TRADE_TYPE_FLAG_TOSHOP, "到店付");
    }
    
	/**
	 * 首页推荐—0不推荐
	 */
	public static final String ISRECOMMEND_NO= "0";
	
	/**
	 * 首页推荐—1推荐
	 */
	public static final String ISRECOMMEND_YES = "1";
	
	/**
	 * 记录前一次点击的URLKEY
	 */
	public static final String URL_KEY="urlkey";
	
	/**
	 * 订单类型-交易完成的订单
	 */
    public static final String ORDER_TYPE_FINISH="0";
    
    /**
     * 订单类型-成交的订单
     */
    public static final String ORDER_TYPE_SUCCESS="1";
    
    /**
     * 订单类型-退订的订单
     */
    public static final String ORDER_TYPE_REFUND="2";
    
    /**
     * 常见问题类型标识-旅客端
     */
    public static final String PROBLEM_FLAG_USER="0";
    
    /**
     * 常见问题类型标识-商户端
     */
    public static final String PROBLEM_FLAG_MERCHANT="1";
    
    /**
     * 常见问题类型标识map
     */
    public static final Map<String,String> MAP_PROBLEM_FLAG=new HashMap<>();
    static {
    	MAP_PROBLEM_FLAG.put(PROBLEM_FLAG_USER, "旅客端常见问题");
    	MAP_PROBLEM_FLAG.put(PROBLEM_FLAG_MERCHANT, "商户端常见问题");
    }
    
    /**
     * 是否已退房- 0 未退房
     */
	public static final String ROOM_REFUND_NO = "0";
    
    /**
     * 是否已退房- 1 已退房
     */
	public static final String ROOM_REFUND_YES = "1";
	/**
     * 用户类型MAP
     */
	public static final TreeMap<String,String> MAP_ROOM_REFUND = Maps.newTreeMap(); 
    static{
    	MAP_ROOM_REFUND.put(ROOM_REFUND_YES, "已退房");
    	MAP_ROOM_REFUND.put(ROOM_REFUND_NO, "未退房");
    }
}
