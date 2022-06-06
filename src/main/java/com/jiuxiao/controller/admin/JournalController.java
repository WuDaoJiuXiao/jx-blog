package com.jiuxiao.controller.admin;

import com.jiuxiao.constants.BackendConstants;
import com.jiuxiao.pojo.Journal;
import com.jiuxiao.service.journal.JournalService;
import com.jiuxiao.tools.PageInfoTools;
import com.jiuxiao.tools.TurnPageTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import java.util.List;

/**
 * 日志控制器
 * @Author: 悟道九霄
 * @Date: 2022年06月04日 15:29
 * @Version: 1.0.0
 */
@Controller
@RequestMapping("/admin")
public class JournalController {

    @Autowired
    private JournalService journalService;

    /**
     * @return: java.lang.String
     * @decription 跳转友链管理页面
     * @date 2022/6/5 9:57
     */
    @RequestMapping("/log")
    public String log(@RequestParam(defaultValue = "1") Integer currentPage, Model model) {
        List<Journal> journalList = journalService.queryAllJournalList();

        Integer journalCount = journalList.size();
        Integer pageSize = BackendConstants.JOURNAL_PAGE_SIZE;
        TurnPageTools<Journal> pageTools = new TurnPageTools<>();
        PageInfoTools<Journal> pageInfo = pageTools.getPageInfo(journalList, currentPage, pageSize);

        setAllModelInfo(model);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("journalCount", journalCount);
        return "backend/control/logControl";
    }

    /**
     * @param operateName
     * @param success
     * @param requestIp
     * @param requestClassName
     * @param requestMethodName
     * @param requestURL
     * @param journal
     * @param model
     * @return: java.lang.String
     * @decription 日志查询结果
     * @date 2022/6/6 17:59
     */
    @PostMapping("/queryLog")
    public String queryJournal(@RequestParam("operateName") String operateName,
                               @RequestParam("success") String success,
                               @RequestParam("requestIp") String requestIp,
                               @RequestParam("requestClassName") String requestClassName,
                               @RequestParam("requestMethodName") String requestMethodName,
                               @RequestParam("requestURL") String requestURL,
                               Journal journal,
                               Model model) {

        //全部为空，就显示全部信息
        if ((operateName.equals("") || StringUtils.isEmpty(operateName))
                && (success.equals("") || StringUtils.isEmpty(success))
                && (requestIp.equals("") || StringUtils.isEmpty(requestIp))
                && (requestClassName.equals("") || StringUtils.isEmpty(requestClassName))
                && (requestMethodName.equals("") || StringUtils.isEmpty(requestMethodName))
                && (requestURL.equals("") || StringUtils.isEmpty(requestURL))) {
            return "redirect:/admin/log";
        }

        System.out.println("operateName --> " + operateName);
        System.out.println("success --> " + success);
        System.out.println("requestIp --> " + requestIp);
        System.out.println("requestClassName --> " + requestClassName);
        System.out.println("requestMethodName --> " + requestMethodName);
        System.out.println("requestURL --> " + requestURL);

        //不是全部为空，有哪个有查询哪个
        journal.setOperateName(operateName);
        journal.setSuccess(success);
        journal.setRequestIp(requestIp);
        journal.setRequestClassName(requestClassName);
        journal.setRequestMethodName(requestMethodName);
        journal.setRequestUrl(requestURL);

        setAllModelInfo(model);

        List<Journal> logList = journalService.queryJournalByUncertainCondition(journal);
        model.addAttribute("logList", logList);
        return "backend/show/showLogSearch";
    }

    /**
     * @param model
     * @return: void
     * @decription 设置下拉框信息
     * @date 2022/6/6 17:59
     */
    private void setAllModelInfo(Model model) {
        List<String> operateName = journalService.queryOperateName();
        List<String> querySuccess = journalService.querySuccess();
        List<String> requestIp = journalService.queryRequestIp();
        List<String> requestClassName = journalService.queryRequestClassName();
        List<String> requestMethodName = journalService.queryRequestMethodName();
        List<String> requestUrl = journalService.queryRequestUrl();

        model.addAttribute("operateName", operateName);
        model.addAttribute("querySuccess", querySuccess);
        model.addAttribute("requestIp", requestIp);
        model.addAttribute("requestClassName", requestClassName);
        model.addAttribute("requestMethodName", requestMethodName);
        model.addAttribute("requestUrl", requestUrl);
    }
}