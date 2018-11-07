package com.spring.test.domain;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 常量类，全部大写，而且interface的变量本身就是public static final
 *
 * @author asheng
 * @create 2018/7/18
 * @description Constants
 */
public interface Constants {

    /** 初始化错误提示 */
    String INIT_ERROR_TIP = "%s can not be init !";

    /** 前后端数据加密的Key */
    String AES_KEY = "billion@app1.com";

    /** 前后端数据的加密方法 */
    String AES_TYPE = "AES/ECB/PKCS5Padding";

    /** 字符集编码 */
    String CHARSET = "UTF-8";

    /** 字符集编码 */
    Charset UTF_8 = Charset.forName(CHARSET);

    /** 开发服标识 */
    String PROFILE_DEV = "dev";

    /** 线程池前缀 */
    String THREAD_POOL_PREFIX = "billion-app-server-";

    /** 用户token */
    String TOKEN = "token";

    /** 不进行token校验的路径 */
    List<String> UN_HANDLER_URL = Arrays.asList("/user/**");

    /** 配置文件前缀 */
    String PROP_PREFIX = "application-";

    /** application.properties */
    String APPLICATION = "application.properties";

    //手机号码正则匹配
    String REGEX_MOBILE_EXACT = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";

    //匹配手机号码Pattern
    Pattern MOBILE_PATTERN = Pattern.compile(REGEX_MOBILE_EXACT);

    /** token分隔符 */
    String SEPARATOR = "\\.";

    /** https协议 */
    String PROTOCOL = "https";

    /** 分隔符 */
    String SPLIT = "/";

    /** 大类编号 */
    String CATALOG_NO = "600000";

    /** 前端加密字段 */
    String ENCRYPT_CONTENT = "encryptContent";

    /** 风控结果 */
    interface Risk{
        /** 风控通过 */
        String PASS = "pass";
        /** 反欺诈决绝 */
        String ANTIFRAUD_REJECT = "antiFraudReject";
        /** 人审拒绝 */
        String AUDIT_REJECT = "auditReject";
        /** 送人审 */
        String HUMAN_AUDIT = "humanAudit";
    }

    /** 认证方式 */
    interface AuthenticMode{
		/** 全流程方式 ORC + 人脸 */
        String WHOLE_RECOGNIZE = "whole";
		/** 人脸 */
        String FACE_RECOGNIZE = "face";
		/** faceId */
        String FACE_ID = "faceId";
		/** touchId */
        String TOUCH_ID = "touchId";
        /** 设备认证 */
        String DEVICE = "device";
        /** 设备认证且密码缺失 */
        String DEVICE_EMPTY = "deviceEmpty";
		/** 短信认证 */
		String SMS_CODE = "smsCode";
    }

    /** 订单状态 */
    interface OrderStates{
        /** 创建 */
        String CREATE = "1";
        /** 审核中 */
        String IN_AUDIT = "2";
        /** 审核拒绝 */
        String AUDIT_REJECT = "3";
        /** 审核通过 */
        String AUDIT_PASS = "4";
        /** 匹配中 */
        String MATCHING = "5";
         /** 待确认 */
        String PRE_CONFIRM = "6";
         /** 待放款 */
        String PRE_LOAN = "7";
         /** 交易失败 */
        String TRANSACT_FAIL = "8";
         /** 交易取消 */
        String TRANSACT_CANCEL = "9";
         /** 交易成功 */
        String TRANSACT_SUCCESS = "0";
    }

    interface FaceResult{
        /** 实名结果T */
        String T = "T";
        /** 实名结果F */
        String F = "F";
        /** 实名结果C */
        String C = "C";
        /** 实名结果R */
        String R = "R";
    }

    /** 首页订单状态 */
    interface IndexOrderState{
        /** 借款成功 */
        String BORROW_SUCCESS = "borrowSuccess";
        /** 借款失败 */
        String BORROW_FAILURE = "borrowFailure";
        /** 还款成功 */
        String REPAY_SUCCESS = "repaySuccess";
        /** 还款失败 */
        String REPAY_FAILURE = "repayFailure";
        /** 处理中 */
        String PROCESSING = "processing";
        /** 待确认 */
        String PRE_CONFIRM = "preConfirm";
        /** 已逾期 */
        String OVERDUE = "overdue";
    }

    interface DevicePasswordState{
        /** 未激活 */
        byte NOT_ACTIVE = 0;
        /** 激活 */
        byte ACTIVE = 1;
    }

    interface RepayStates{
        /** 已还清 */
        String REPAYED = "0";
        /** 未还清 */
        String PRE_REPAY = "1";
        /** 部分还清 */
        String PART_REPAY = "2";
        /** 还款中 */
        String PROCESSING = "3";
    }

    interface UserCreditState{
        /** 未授信 */
        String PRE_CREDIT = "0";
        /** 授信中 */
        String CREDITING = "1";
        /** 授信失败 */
        String CREDIT_FAIL = "2";
        /** 已授信 */
        String CREDITED = "3";
    }

	/** 提现单状态 */
    interface WithdrawState{
		/** 还款成功 */
		String REPAY_SUCCESS = "0";
		/** 还款已提交 */
		String REPAY_COMMIT = "1";
		/** 还款处理中 */
		String REPAY_PROCESSING = "2";
		/** 还款失败 */
		String REPAY_FAIL = "3";
	}

    /** 认证状态 */
	interface AuthorizeState{
        /** 已认证 */
        String AUTH = "1";
        /** 未认证 */
        String NOT_AUTH = "0";
    }

    String ORDER_STATE_AUDIT_REJECT = "3";
    String ORDER_STATE_TRANSACTION_FAIL = "8";
    String ORDER_STATE_TRANSACTION_CANCEL = "9";
    String ORDER_STATE_TRANSACTION_SUCCESS = "0";

    String[] ORDER_ULTIMATE_STATES = {ORDER_STATE_AUDIT_REJECT, ORDER_STATE_TRANSACTION_FAIL, ORDER_STATE_TRANSACTION_CANCEL, ORDER_STATE_TRANSACTION_SUCCESS};

    /** ip地址未知 */
    String UNKNOWN = "unknown";

    /** 日期格式：yyyyMMdd */
    String DATE_PATTEN1 = "yyyyMMdd";

    String DATE_PATTEN2 = "yyyy-MM-dd HH:mm:ss";

    String DATE_PATTEN3 = "yyyy-MM-dd";

    /** 随机数seed */
    int RANDOM_BOUND = 999999;

    /** 一天的秒数 */
    long ONE_DAY_SECONDS = 24 * 60 * 60L;

    /** 老项目的成功retCode */
    String SUCCESS = "000000";

    /** 全局id */
    String CORRELATION_ID = "correlationId";

    /** 支持新行卡信息 */
    interface Bank {

        /** xml文件的位置 */
        String BANK_PATH = "config/support-bank.xml";

        /** 银行code */
        String BANK_CODE_ELEMENT = "bankCode";

        /** 银行名 */
        String BANK_NAME_ELEMENT = "bankName";

        /** 银行logo */
        String BANK_PIC_URL_ELEMENT = "bankPicUrl";
    }

    /** ajax请求的参数 */
    interface AjaxParam {
        String ACCEPT = "accept";
        String APPLICATION_JSON = "application/json";
        String APPLICATION_JSON_CHARSET = "application/json;charset=utf-8";
        String X_REQUESTED_WITH = "X-Requested-With";
        String XML_HTTP_REQUEST = "XMLHttpRequest";
    }

    /** 签约失败代码 */
    interface ApplySignError {
        String ALREADY_SIGN_ERROR = "银行卡已签约";
        String CREDIT_CARD_ERROR = "输入的有效期或CVV2有误";
        String CARD_NO_ERROR = "暂不支持该卡或卡号输入有误";
        String PHONE_NO_ERROR = "手机号有误";
        String BELONG_SELF_ERROR = "非本人银行卡";
        String VERIFY_CODE_ERROR = "安全码错误";
        String APPLY_SIGNING_ERROR = "签约处理中";
    }

}
