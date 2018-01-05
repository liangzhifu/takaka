package com.takata.alteration.constant;

public interface Url {

    String BASE = "/alteration";

    String ORDER = "/order";
    String FOURORDER = "/fourOrder";
    String KIRIKAEORDER = "/kirikaeOrder";

    String ORDER_ADDOREDITDIALOG = BASE + ORDER + "/getAddOrEditDialog.do";
    String ORDER_DETAILDIALOG = BASE + ORDER + "/getDetailDialog.do";
    String ORDER_GET = BASE + ORDER + "/getOrder.do";
    String ORDER_ADD = BASE + ORDER + "/add.do";
    String ORDER_EDIT = BASE + ORDER + "/edit.do";
    String ORDER_TODODIALOG = BASE + ORDER + "/getTodoDialog.do";
    String ORDER_TODOPAGEINFO = BASE + ORDER + "/getTodoPageInfo.do";

    String FOURORDER_DIALOG = BASE + FOURORDER + "/getDialog.do";
    String FOURORDER_PAGEINFO = BASE + FOURORDER + "/getPageInfo.do";

    String KIRIKAEORDER_DIALOG = BASE + KIRIKAEORDER + "/getDialog.do";
    String KIRIKAEORDER_PAGEINFO = BASE + KIRIKAEORDER + "/getPageInfo.do";

}
