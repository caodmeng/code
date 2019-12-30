package com.test.base.zuul.fallBack.exc;

public enum ErrorType implements ErrorCode {

	success(100000, "成功"),
	/**
	 * 100001 - 900000 为业务异常
	 * 100001 - 101000 段位错误直接跳转到登录页面
	 */
	loginError(100001, "未登录【登录超时】，请重新登录"),
    forwardError(100002, "跳转域名不在白名单内"),
	/**
	 * 101001 - 
	 */
	inParamError(101001, "非法入参"),

	getMchtError(102001, "获取商家信息失败"),
	getMchtDealerRelatError(102002, "未获取到地包会员关系"),
	addMchtCollectionErr(102003, "您已收藏该店铺，请前往用户中心>>我的收藏页面查看"),
	addItemCollectionErr(102004, "您已收藏该商品，请前往用户中心>>我的收藏页面查看"),

	//ots下单中心错误描述
	ShopCartItemNumMax(103001, "购物车最多存放50种商品"),

	//cms内容中心错误描述
	getNotifyError(104001, "获取公告信息失败"),
	delNotifyError(104002, "删除公告信息失败"),
	getPolicyError(104003, "获取政策信息失败"),
	policyParamError(104004, "政策开始时间不能大于政策结束时间"),
	updNotifyError(104005, "操作公告信息失败"),
	hotWordError(104006, "最多添加两个热词！"), 
	qryLabelError(104007, "查询渠道商标签失败！"),
	//fms文件中心错误描述
	impPolicyError(106001, "导入政策失败！"),
	impPolicyNoDataError(106002, "没有检测到可以导入的数据！"),
	expItemForCustMaxError(106003, "导出商品数不能大于50条，请筛选后再行导出！"),
	LectotypeExpItemError(106004, "您无权使用商品导出功能！"),
	//广告服务错误描述
	appAdError(105001, "该类型广告不能适用于APP端"),
	adItemVisibleError(105002, "该商品添加了可见性，不能选择"),
	pcAdObjError(105003, "该广告对象不能适用于电脑网页端"),
	appAdObjError(105004, "该广告对象不能适用于APP端"),
	adPublishNumOverfolow(105005, "该位置广告发布数量已满"),
	
	checkValidateError(899998, "未验证验证码或验证已过期"),
	createVerifyCodeError(899999, "生成验证码出错"),
	validateVerifyCodeError(900000, "验证码错误或已过期"),

	/**
	 * 900001 - 999999 段位为非业务系统异常
	 */
	zuulError(999998, "请求系统超时，请稍后重试"), sysError(999999, "系统错误");

	private Integer value;

	private String msg;


	ErrorType(Integer value, String msg) {
		this.value = value;
		this.msg = msg;
	}


	public Integer value() {
		return value;
	}


	public String msg() {
		return msg;
	}

}
