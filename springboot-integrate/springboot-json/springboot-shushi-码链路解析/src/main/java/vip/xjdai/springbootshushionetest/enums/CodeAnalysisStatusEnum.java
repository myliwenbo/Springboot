package vip.xjdai.springbootshushionetest.enums;

import pro.shushi.pamirs.meta.common.enmu.BaseEnum;

public class CodeAnalysisStatusEnum extends BaseEnum<CodeAnalysisStatusEnum, Integer> {
    public static final String DICTIONARY = "qts.tracecode.CodeAnalysisStatusEnum";

    public final static CodeAnalysisStatusEnum ANALYSIS_SUCCESS = create("ANALYSIS_SUCCESS", 0, "解析成功", "解析成功");
    public final static CodeAnalysisStatusEnum ANALYSIS_EX_BARCODE = create("ANALYSIS_EX_BARCODE", 1, "解析异常", "解析异常");
    public final static CodeAnalysisStatusEnum ANALYSIS_SUCCESS_LIMITED = create("ANALYSIS_SUCCESS_LIMITED", 2, "解析成功，不允许出入库", "解析成功，不允许出入库");


}
