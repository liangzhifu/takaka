package com.takata.kirikae.constant;

public interface Url {
    String BASE = "/kirikae";

    String ORDER = "/order";
    String QUESTION = "/question";
    String ORGQUESTION= "/orgQuestion";

    //定单
    String ORDER_ADD_DIALOG = BASE + ORDER + "/getDialog.do";
    String ORDER_ADD = BASE + ORDER + "/add.do";
    String ORDER_EDIT = BASE + ORDER + "/edit.do";
    String ORDER_DETAIL = BASE + ORDER + "/detail.do";
    String ORDER_PAGEINOF = BASE + ORDER + "/queryPageInfo.do";
    String ORDER_PAGEINOF_DIALOG = BASE + ORDER + "/queryPageInfoDialog.do";

    //切替问题点
    String QUESTION_DIALOG = BASE + QUESTION + "/getDialog.do";
    String QUESTION_ADD = BASE + QUESTION + "/add.do";
    String QUESTION_DELETE = BASE + QUESTION + "/delete.do";
    String QUESTION_PAGEINFO = BASE + QUESTION + "/queryPageInfo.do";

    //组织关联问题点
    String ORGQUESTION_DIALOG = BASE + ORGQUESTION + "/getDialog.do";
    String ORGQUESTION_ADD = BASE + ORGQUESTION + "/add.do";
    String ORGQUESTION_DELETE = BASE + ORGQUESTION + "/delete.do";
    String ORGQUESTION_LIST = BASE + ORGQUESTION + "/queryList.do";
    String ORGQUESTION_ADDLIST = BASE + ORGQUESTION + "/queryAddList.do";

}
