/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-04-22 02:42:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class queryGrade_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no\" />\r\n");
      out.write("\t\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t\t<title></title>\r\n");
      out.write("\t\t<link href=\"https://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/queryGrade.css\" />\r\n");
      out.write("\t\t<script src=\"https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"https://res.wx.qq.com/open/libs/weuijs/1.1.2/weui.min.js\"></script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\r\n");
      out.write("\t<body style=\"background-color: wheat;\">\r\n");
      out.write("\t\t<div class=\"page\">\r\n");
      out.write("\t\t\t<div class=\"page__hd\">\r\n");
      out.write("\t\t\t\t<div class=\"page__title\">\r\n");
      out.write("\t\t\t\t\t<h2 style=\"text-align: center;\">成绩查询</h2></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"page__bd page__bd_spacing\">\r\n");
      out.write("\t\t\t\t<div class=\"weui-cells\">\r\n");
      out.write("\t\t\t\t\t<form action=\"\" method=\"post\" id=\"queryFrom\">\r\n");
      out.write("\t\t\t\t\t<div class=\"weui-cell weui-cell_select\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"weui-cell__bd\">\r\n");
      out.write("\t\t\t\t\t\t\t<select class=\"weui-select\" name=\"sel_xn\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option  value=\"2016\">2016-2017学年</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"2015\">2015-2016学年</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"2014\">2014-2015学年</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"weui-cell weui-cell_select\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"weui-cell__bd\">\r\n");
      out.write("\t\t\t\t\t\t\t<select class=\"weui-select\" name=\"sel_xq\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option  value=\"0\">第一学期</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"1\">第二学期</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"weui-cell weui-cell_select\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"weui-cell__bd\">\r\n");
      out.write("\t\t\t\t\t\t\t<select class=\"weui-select\" name=\"SJ\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"1\">有效成绩</option>\r\n");
      out.write("\t\t\t\t\t          <option value=\"0\">原始成绩</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\"  name=\"btn_search\" value=\"检索\"/>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"SelXNXQ\" value=\"2\"/>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"zfx_flag\"  value=\"0\"/>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"zxf\" value=\"0\"/>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"weui-cells\" style=\"overflow-x:scroll; border:10px solid springgreen;\" hidden=\"hidden\" id=\"showImg\">\r\n");
      out.write("\t\t\t\t\t<img src=\"\" id=\"resultShow\" />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"weui-btn-area\">\r\n");
      out.write("\t\t\t\t\t<button class=\"weui-btn weui-btn_primary\"  id=\"select-btn\">查询成绩</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t            <div class=\"weui-footer\">\r\n");
      out.write("\t                <p class=\"weui-footer__links\">\r\n");
      out.write("\t                    <a href=\"javascript:void(0);\" class=\"weui-footer__link\">太原师范学院校园助手</a>\r\n");
      out.write("\t                </p>\r\n");
      out.write("\t                <p class=\"weui-footer__text\">Copyright &copy; 2017-2018 wuzhe</p>\r\n");
      out.write("\t            </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</body>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$().ready(function() {\r\n");
      out.write("\t\t\t$(\"#select-btn\").click(function() {\r\n");
      out.write("\t\t\t\tvar loading = weui.loading('查询中', {\r\n");
      out.write("\t\t\t\t\tclassName: 'custom-classname'\r\n");
      out.write("\t\t\t\t}); \r\n");
      out.write("\t\t\t\t $.ajax({\r\n");
      out.write("\t\t\t\t\t\tasync:false,\r\n");
      out.write("\t\t\t\t\t\ttype:\"POST\",\r\n");
      out.write("\t\t\t\t\t\turl:\"/TysfHelper/queryGrade.do\",\r\n");
      out.write("\t\t\t\t\t\tdata:$(\"#queryFrom\").serialize(),\r\n");
      out.write("\t\t\t\t\t\tsuccess:function  (data) {\r\n");
      out.write("\t\t\t\t\t\t\tconsole.log(data);\r\n");
      out.write("\t\t\t\t\t\t\tif(data==1){\r\n");
      out.write("\t\t\t\t\t\t\t\tloading.hide();\r\n");
      out.write("\t\t\t\t\t\t\t\tvar dt = new Date();\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#resultShow\").attr(\"src\",\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/showGrade.do?t=\"+dt.getMilliseconds());\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#showImg\").show();       \r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\terror:function(data){\r\n");
      out.write("\t\t\t\t\t\t\tweui.alert(\"很抱歉,发生一个错误\")\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\r\n");
      out.write("\t\t})\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /WEB-INF/jsp/student/queryGrade.jsp(4,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/student/queryGrade.jsp(4,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/jsp/student/queryGrade.jsp(4,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("path");
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }
}
