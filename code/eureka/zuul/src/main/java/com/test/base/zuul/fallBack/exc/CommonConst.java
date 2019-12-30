package com.test.base.zuul.fallBack.exc;

/**
 * @author caodm3
 * @Description: 本类是一个通用常量类，用于存放通用常量
 * @date: 2019年03月25日  10:32
 */

public class CommonConst {
	/**
	 * 错误日志表 错误信息最大长度
	 */
	public static final int ERROR_MSG_MAX_LENGTH = 200;
	
	/**
	 * 下拉框-全部
	 */
	public static final short SELECT_ALL = 99;
	/**
	 * ID=-1L
	 */
    public static final Long LONG_ID = -1L;
    public static final Long LONG_ZERO = 0L;
    
    /*
     * 资源服务器图片前缀
     */
    public static final String HTTP_RSM_PATH = "httpRsmPath";
	
	/**
	 * @Function: com.ai.cmdc.common.beans
	 * @Description: 数据状态校验常量类
	 * @param: null
	 * @return
	 * @version: v1.0.0
	 * @author: caodm3
	 * @date: 2019/3/25 10:46
	 * Modification History:
	 * Date             Author      Version            Description
	 *---------------------------------------------------------*
	 * 2019/3/25 10:46    caodm3      v1.0.0             修改原因
	 */
	public static class DataStates {
		/**
		 * 正常状态数据.
		 */
		public static final Short NORMAL_STATE = 1;
		
		/**
		 * 删除状态数据.
		 */
		public static final Short DELETE_STATE = 0;
	}
	
	/**
	 * @Function: com.ai.cmdc.common.beans
	 * @Description: 日期格式校验常量类
	 * @param: null
	 * @return
	 * @version: v1.0.0
	 * @author: caodm3
	 * @date: 2019/3/25 10:46
	 * Modification History:
	 * Date             Author      Version            Description
	 *---------------------------------------------------------*
	 * 2019/3/25 10:46    caodm3      v1.0.0             修改原因
	 */
	public static class DATEFORMAT {
		/**
		 * DATETIME_FORMAT.
		 */
		public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
		
		/**
		 * DAY_FORMAT.
		 */
		public static final String DAY_FORMAT = "yyyy-MM-dd";
		
		/**
		 * yyyyMMdd
		 */
		public static final String YYYYMMDD = "yyyyMMdd";
		
		/**
		 * yyyyMM
		 */
		public static final String YYYYMM = "yyyyMM";
		
		/**
		 * STRING_FORMAT.
		 */
		public static final String STRING_FORMAT = "yyMMdd";
		
		/**
		 * MONTH_FORMAT.
		 */
		public static final String MONTH_FORMAT = "yyMM";
		
		/**
		 * TIMESTAMP_FORMAT. yyyyMMddHHmmss
		 */
		public static final String TIMESTAMP_FORMAT = "yyyyMMddHHmmss";
		
		/**
		 * TZ_FORMAT
		 */
		public static final String TZ_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
		
		/**
		 * 17位日期格式
		 */
		public static final String DATE_FORMAT_FOR_SYSTIME = "yyyyMMddHHmmssSSS"; //日期格式
	}
	
	/**
	 * @Function: com.ai.cmdc.common.beans
	 * @Description: 正则表达式校验常量
	 * @param: null
	 * @return
	 * @version: v1.0.0
	 * @author: caodm3
	 * @date: 2019/3/25 10:45
	 * Modification History:
	 * Date             Author      Version            Description
	 *---------------------------------------------------------*
	 * 2019/3/25 10:45    caodm3      v1.0.0             修改原因
	 */
	public static class PATTERN {
		
		public static final String EMAIL_PATTERN = "^([a-zA-Z0-9\\_\\-\\.])+@([a-zA-Z0-9\\_\\-\\.])"
		        + "+(\\.([a-zA-Z0-9])+)+$";
		public static final String MSISDN_PATTERN = ("^(13[0-9]|14[579]|15[0-9]|17[2-8]|18[0-9])[0-9]{8}|134[0-9]{8}"
		        + "|170[0-9]{8}|171[89]{1}[0-9]{7}$");
		//日期正则
		public static final String DATE_FORMAT_PATTERN = "^((?!0000)[0-9]{4}-((0[1-9]|1[0-2])-"
				+ "(0[1-9]|1[0-9]|2[0-8])|(0[13-9]|1[0-2])-(29|30)|(0[13578]|1[02])-31)|"
				+ "([0-9]{2}(0[48]|[2468][048]|[13579][26])|(0[48]|[2468][048]|[13579][26])00)-02-29)$";
		//sourceid正则
		public static final String SOURCE_ID_PATTERN = "^[0-9]{6}$";
		//apptype正则
		public static final String APP_TYPE_PATTERN = "^[0-8]{1}$";
		//ipv4正则
		public static final String IP_V4_PATTERN = "([1-9]|[1-9]\\d|1" + "\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1"
		        + "\\d{2}|2[0-4]\\d|25[0-5])){3}";
		//openidType正则
		public static final String OPEN_ID_TYPE = "0|1|2|6";
		//bindType正则
		public static final String BIND_TYPE = "^[1-6]{1}$";
		//金钱正则
		public static final String MONNEY_TYPE = "^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d)*)?$";
		
	}
	
	/**
	 * @Function: com.ai.cmdc.common.beans
	 * @Description: RedisTime
	 * @param: null
	 * @return
	 * @version: v1.0.0
	 * @author: caodm3
	 * @date: 2019/3/25 10:44
	 * Modification History:
	 * Date             Author      Version            Description
	 *---------------------------------------------------------*
	 * 2019/3/25 10:44    caodm3      v1.0.0             修改原因
	 */
	public class RedisTime {
		/**
		 * redis key失效时间
		 */
		public static final int EXPIRETIME = 60 * 60 * 24 * 2;
		public static final int EXPIRE = 2 * 60 * 60;
		public static final int EXPIRE_HALF_OF_HOUR = 60 * 30;
	}
	
	/**
	 * @Function: com.ai.cmdc.common.beans
	 * @Description: 数字常量
	 * @param: null
	 * @return
	 * @version: v1.0.0
	 * @author: caodm3
	 * @date: 2019/3/25 10:43
	 * Modification History:
	 * Date             Author      Version            Description
	 *---------------------------------------------------------*
	 * 2019/3/25 10:43    caodm3      v1.0.0             修改原因
	 */
	public static class Number {
		/**
		 * ONE.
		 */
		public static final int ONE = 1;
		/**
		 * TWO.
		 */
		public static final int TWO = 2;
		/**
		 * THREE.
		 */
		public static final int THREE = 3;
		/**
		 * FOUR.
		 */
		public static final int FOUR = 4;
		/**
		 * FIVE.
		 */
		public static final int FIVE = 5;
		/**
		 * SIX.
		 */
		public static final int SIX = 6;
		/**
		 * SERVEN.
		 */
		public static final int SERVEN = 7;
		/**
		 * EIGHT.
		 */
		public static final int EIGHT = 8;
		/**
		 * NINE.
		 */
		public static final int NINE = 9;
		/**
		 * TEN.
		 */
		public static final int TEN = 10;
		/**
		 * ELEVEN.
		 */
		public static final int ELEVEN = 11;
		/**
		 * TWELVE.
		 */
		public static final int TWELVE = 12;
		/**
		 * THIRTEEN.
		 */
		public static final int THIRTEEN = 13;
		/**
		 * FOURTEEN.
		 */
		public static final int FOURTEEN = 14;
		/**
		 * FIFTEEN.
		 */
		public static final int FIFTEEN = 15;
		/**
		 * SIXTEEN.
		 */
		public static final int SIXTEEN = 16;
		/**
		 * SEVENTEEN.
		 */
		public static final int SEVENTEEN = 17;
		/**
		 * TWENTY
		 */
		public static final int TWENTY = 20;
		
		/**
		 * HUNDRED.
		 */
		public static final int HUNDRED = 100;
		/**
		 * THOUSAND.
		 */
		public static final int THOUSAND = 1000;
		/**
		 * TENTHOUSAND
		 */
		public static final int TENTHOUSAND = 10000;
		/**
		 * MULTIPLE.
		 */
		public static final int MULTIPLE = 100000;
		/**
		 * ZERO.
		 */
		public static final int ZERO = 0;
		public static final Double DOUBLE_ZERO = 0d;
		/**
		 * MINUSONE.
		 */
		public static final int MINUSONE = -1;
		/**
		 * MINUSTWO.
		 */
		public static final long LONGMINUSTWO = -2;
		/**
		 * BYTELENGTH.
		 */
		public static final int BYTELENGTH = 1024;
		/**
		 * FIFTY.
		 */
		public static final int FIFTY = 50;
		/**
		 * SIXTY.
		 */
		public static final int SIXTY = 60;
		/**
		 * HUNDREDTWENTY.
		 */
		public static final int HUNDREDTWENTY = 120;
		/**
		 * TWO_HUNDRED.
		 */
		public static final int TWO_HUNDRED = 200;
		/**
		 * TWOHUNDREDANDFIFTYSIX.
		 */
		public static final int TWOHUNDREDANDFIFTYSIX = 256;
		/**
		 * THREE_THOUSAND.
		 */
		public static final int THREE_THOUSAND = 3000;
		/**
		 * FOUR_THOUSAND.
		 */
		public static final int FOUR_THOUSAND = 4000;
		/**
		 * THREE_THOUSAND.
		 */
		public static final int FIVE_THOUSAND = 5000;
		
		/**
		 * FILE_LENGTH.
		 */
		public static final int FILE_LENGTH = 512;
		
		/**
		 * NINETY_NINE
		 */
		public static final int NINETY_NINE = 99;
		
	}
	
	/**
	 * @Function: com.ai.cmdc.common.beans
	 * @Description: 字符常量类
	 * @param: null
	 * @return
	 * @version: v1.0.0
	 * @author: caodm3
	 * @date: 2019/3/25 10:44
	 * Modification History:
	 * Date             Author      Version            Description
	 *---------------------------------------------------------*
	 * 2019/3/25 10:44    caodm3      v1.0.0             修改原因
	 */
	public static class Character {
		public static final String ZERO = "0";
	}
	
	public static class Encoding {
		public static final String DEFAULT = "utf-8";
		public static final String UTF8 = "utf-8";
	}
	
	/**
	 * 
	 * @Description: 运营类目状态：0-未启用 1-启用
	 *
	 *
	 * @author: jiangyong-mac
	 * @date: 2019年6月11日  上午11:15:54
	 */
	public static class OprtCatState {
		public static final short ABLE = 1;
		public static final short UNABLE = 0;
	}
	
	/**
	 * @Description: 排序字段
	 *
	 * @author: ChenPing
	 * @date: 2019年6月11日  下午3:35:48
	 */
	public static class OrderBy {
		public static final String OPRT_CAT_ORDER = "OPRT_CAT_ORDER";
		public static final String OPRTCAT_ATTR_ORDER = "OPRTCAT_ATTR_ORDER";
		public static final String OPRTCAT_ATTRVAL_ORDER = "OPRTCAT_ATTR_ID,OPRTCAT_ATTRVAL_ORDER";
	}
	
	/**
	 * @Description: 商品状态
	 *
	 * @author: ChenPing
	 * @date: 2019年6月11日  下午5:55:01
	 */
	public static class ItemState {
		public static final Integer NOT_FINISHED = -1;
		public static final Integer SAVED = 0;
		public static final Integer WAIT_UPPER = 2;
		public static final Integer UPPERED = 3;
		public static final Integer CHECK_NOPASS = 4;
		public static final Integer PLATFORM_UPPERED = 13;
	}
	
	/**
	 * 活动适用平台启用状态
	 *
	 * @author: Zhoulk
	 */
	public static class ActPlatformState {
		public static final short ABLE = 1;
		public static final short UNABLE = 0;
	}
	
	/**
	 * 
	 * @Description: 文件上传规则属性
	 * @author: jiangyong-mac
	 * @date: 2019年6月15日  下午2:53:35
	 */
	public static class FileRuleEumn {
		public static final String REMOTE = "uploadDir";
		public static final String WIDTH = "width";
		public static final String HEIGHT = "height";
		public static final String VOLUME = "volume";
		public static final String TABLENAME = "tableName";
		public static final String FILETYPE = "fileType";
        public static final String PRSWIDTH = "comprsWidth";
        public static final String PRSHEIGHT = "comprsHeight";
        public static final String TEMPLATE = "template";
		//APP图标专用
		public static final String ICONMINW = "iconMinW"; //最小限制
		public static final String ICONMAXW = "iconMaxW"; //最大限制
		public static final String DIFFERENCE = "difference"; //长宽误差值
		
	}
	/**
	 * @Description: 收藏类型
	 *
	 * @author: ChenPing
	 * @date: 2019年6月28日  下午2:50:24
	 */
	public static class Collection {
		/**
		 * 商品
		 */
		public static final Short ITEM = 1;
		/**
		 * 店铺
		 */
		public static final Short STORE = 2;
		
	}
	public static class CollectState {
		/**
		 * 取消收藏
		 */
		public static final Short CANCEL = 0;
		/**
		 * 添加收藏
		 */
		public static final Short ADD = 1;
		
	}
}
