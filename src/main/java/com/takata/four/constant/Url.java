package com.takata.four.constant;

public interface Url {

    String BASE = "/four";

    String TEMPLATE = "/template";
    String TACHE = "/tache";

    //模板相关
    String TEMPLATE_QUERYTEMPLATEATTRLIST = BASE + TEMPLATE + "/queryTemplateAttrList.do";

    //模板工单相关
    String TACHE_LIST = BASE + TACHE + "/queryList.do";
    String TACHE_MANAGERLIST = BASE + TACHE + "/queryManagerList.do";
    String TACHE_MANAGERADD = BASE + TACHE + "/managerAdd.do";
    String TACHE_MANAGERDELETE = BASE + TACHE + "/managerDelete.do";
    String TACHE_USERLIST = BASE + TACHE + "/queryUserList.do";
    String TACHE_USERADD = BASE + TACHE + "/userAdd.do";
    String TACHE_USERDELETE = BASE + TACHE + "/userDelete.do";

}
