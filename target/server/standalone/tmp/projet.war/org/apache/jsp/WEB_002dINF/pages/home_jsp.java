/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: WildFly Full 29.0.1.Final (WildFly Core 21.1.1.Final) - 2.3.7.Final
 * Generated at: 2023-09-15 13:09:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private jakarta.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
        throws java.io.IOException, jakarta.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(jakarta.servlet.http.HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JBWEB004248: JSPs only permit GET POST or HEAD");
return;
}

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      response.addHeader("X-Powered-By", "JSP/2.3");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("    <title>Mood of the month</title>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap CSS -->\n");
      out.write("    <link href=\"resources/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Custom CSS -->\n");
      out.write("    <link href=\"resources/css/style.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Custom Fonts -->\n");
      out.write("    <link href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <div id=\"wrapper\">\n");
      out.write("\n");
      out.write("        <!-- Navigation -->\n");
      out.write("        <nav class=\"navbar navbar-default navbar-static-top container-fluid\" role=\"navigation\" style=\"margin-bottom: 0\">\n");
      out.write("            <div class=\"navbar-header\">\n");
      out.write("                <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n");
      out.write("                    <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                </button>\n");
      out.write("                <a class=\"navbar-brand\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/home\">Mood of the month</a>\n");
      out.write("            </div>\n");
      out.write("            <!-- /.navbar-header -->\n");
      out.write("\n");
      out.write("            <ul class=\"nav navbar-top-links navbar-right\">\n");
      out.write("                <li class=\"dropdown\">\n");
      out.write("                    <a class=\"dropdown-toggle navlink\" data-toggle=\"dropdown\" href=\"#\">\n");
      out.write("                        <i class=\"fa fa-gear fa-fw\"></i> Manage MOTMs <i class=\"fa fa-caret-down\"></i>\n");
      out.write("                    </a>\n");
      out.write("                    <ul class=\"dropdown-menu dropdown-user\">\n");
      out.write("                        <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/add_member\"><i class=\"fa fa-user fa-fw\"></i> Add member</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/edit_motm\"><i class=\"fa fa-calendar fa-fw\"></i> Change MOTM Template</a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div id=\"page-wrapper\" class=\"container-fluid\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-12\">\n");
      out.write("                    <h1 class=\"page-header\">Administration Panel</h1>\n");
      out.write("                </div>\n");
      out.write("                <!-- /.col-lg-12 -->\n");
      out.write("            </div>\n");
      out.write("            <!-- /.row -->\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-4 col-md-4\">\n");
      out.write("                    <div class=\"panel panel-primary\">\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-xs-3\">\n");
      out.write("                                    <i class=\"fa fa-user fa-5x\"></i>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-xs-9 text-right\">\n");
      out.write("                                    <div class=\"huge\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${nbrMembre}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("                                    <div class=\"huge-label\">Registered members</div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/add_member\">\n");
      out.write("                            <div class=\"panel-footer\">\n");
      out.write("                                <span class=\"pull-left\">Add member</span>\n");
      out.write("                                <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\n");
      out.write("                                <div class=\"clearfix\"></div>\n");
      out.write("                            </div>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-4 col-md-4\">\n");
      out.write("                    <div class=\"panel panel-green\">\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-xs-3\">\n");
      out.write("                                    <i class=\"fa fa-smile-o fa-5x\"></i>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-xs-9 text-right\">\n");
      out.write("                                    <div class=\"huge\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${nbrMood}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("                                    <div class=\"huge-label\">Moods Closed</div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/edit_motm\">\n");
      out.write("                            <div class=\"panel-footer\">\n");
      out.write("                                <span class=\"pull-left\">Edit MOTM content</span>\n");
      out.write("                                <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\n");
      out.write("                                <div class=\"clearfix\"></div>\n");
      out.write("                            </div>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-4 col-md-4\">\n");
      out.write("                    <div class=\"panel panel-blue\">\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-xs-3\">\n");
      out.write("                                    <i class=\"fa fa-tachometer fa-5x\"></i>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-xs-9 text-right\">\n");
      out.write("                                    <div class=\"huge\">Dashboard</div>\n");
      out.write("                                    <div class=\"huge-label\">View & Export</div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/dashboard\">\n");
      out.write("                            <div class=\"panel-footer\">\n");
      out.write("                                <span class=\"pull-left\">Show dashboard</span>\n");
      out.write("                                <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\n");
      out.write("                                <div class=\"clearfix\"></div>\n");
      out.write("                            </div>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- /.row -->\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-8\">\n");
      out.write("                    <!-- /.panel -->\n");
      out.write("                    <div class=\"panel panel-default\">\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <i class=\"fa fa-user fa-fw\"></i> Manage Members\n");
      out.write("                        </div>\n");
      out.write("                        <!-- /.panel-heading -->\n");
      out.write("                        <div class=\"panel-body\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-lg-12\">\n");
      out.write("                                    <div class=\"table-responsive\">\n");
      out.write("                                        <table class=\"table table-hover table-striped\">\n");
      out.write("                                            <thead>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th>FirstName</th>\n");
      out.write("                                                    <th>LastName</th>\n");
      out.write("                                                    <th>Email</th>\n");
      out.write("                                                    <th>Birthdate</th>\n");
      out.write("                                                    <th class=\"text-right\">Action</th>\n");
      out.write("                                                </tr>\n");
      out.write("                                            </thead>\n");
      out.write("                                            <tbody>\n");
      out.write("                                                ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                            </tbody>\n");
      out.write("                                        </table>\n");
      out.write("                                        <div class=\"text-center\">\n");
      out.write("                                            <ul class=\"pagination\">\n");
      out.write("                                                <li><a href=\"#\">1</a></li>\n");
      out.write("                                                <li><a href=\"#\">2</a></li>\n");
      out.write("                                                <li><a href=\"#\">3</a></li>\n");
      out.write("                                            </ul>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- /.table-responsive -->\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- /.row -->\n");
      out.write("                        </div>\n");
      out.write("                        <!-- /.panel-body -->\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.panel -->\n");
      out.write("                </div>\n");
      out.write("                <!-- /.col-lg-8 -->\n");
      out.write("                <div class=\"col-lg-4\">\n");
      out.write("                    <div class=\"panel panel-default\">\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <i class=\"fa fa-tachometer fa-fw\"></i> Stats\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"panel-body\" id=\"stats\">\n");
      out.write("\n");
      out.write("                            <div class=\"note\">\n");
      out.write("                                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${average}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("<small>/5</small>\n");
      out.write("                                <p>Avg Mood</p>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"details\">\n");
      out.write("                                <div class=\"mood\">\n");
      out.write("                                    <div class=\"img-container\">\n");
      out.write("                                        <img src=\"resources/img/1.png\" alt=\"super\"/>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"progress-bar-container\">\n");
      out.write("                                        <span class=\"desc\">Vote count: 10</span>\n");
      out.write("                                        <div class=\"progress\">\n");
      out.write("                                            <div class=\"progress-bar progress-bar-danger\" role=\"progressbar\" aria-valuenow=\"10\"\n");
      out.write("                                                 aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:10%\">\n");
      out.write("                                                <span class=\"\">10%</span>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"mood\">\n");
      out.write("                                    <div class=\"img-container\">\n");
      out.write("                                        <img src=\"resources/img/2.png\" alt=\"super\"/>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"progress-bar-container\">\n");
      out.write("                                        <span class=\"desc\">Vote count: 5</span>\n");
      out.write("                                        <div class=\"progress\">\n");
      out.write("                                            <div class=\"progress-bar progress-bar-warning\" role=\"progressbar\" aria-valuenow=\"5\"\n");
      out.write("                                                 aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:5%\">\n");
      out.write("                                                <span class=\"\">5%</span>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"mood\">\n");
      out.write("                                    <div class=\"img-container\">\n");
      out.write("                                        <img src=\"resources/img/3.png\" alt=\"super\"/>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"progress-bar-container\">\n");
      out.write("                                        <span class=\"desc\">Vote count: 15</span>\n");
      out.write("                                        <div class=\"progress\">\n");
      out.write("                                            <div class=\"progress-bar progress-bar-neutral\" role=\"progressbar\" aria-valuenow=\"15\"\n");
      out.write("                                                 aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:15%\">\n");
      out.write("                                                <span class=\"\">15%</span>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"mood\">\n");
      out.write("                                    <div class=\"img-container\">\n");
      out.write("                                        <img src=\"resources/img/4.png\" alt=\"super\"/>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"progress-bar-container\">\n");
      out.write("                                        <span class=\"desc\">Vote count: 45</span>\n");
      out.write("                                        <div class=\"progress\">\n");
      out.write("                                            <div class=\"progress-bar progress-bar-midsuccess\" role=\"progressbar\" aria-valuenow=\"45\"\n");
      out.write("                                                 aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:45%\">\n");
      out.write("                                                <span class=\"\">45%</span>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"mood\">\n");
      out.write("                                    <div class=\"img-container\">\n");
      out.write("                                        <img src=\"resources/img/5.png\" alt=\"super\"/>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"progress-bar-container\">\n");
      out.write("                                        <span class=\"desc\">Vote count: 25</span>\n");
      out.write("                                        <div class=\"progress\">\n");
      out.write("                                            <div class=\"progress-bar progress-bar-success\" role=\"progressbar\" aria-valuenow=\"25\"\n");
      out.write("                                                 aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:25%\">\n");
      out.write("                                                <span class=\"\">25%</span>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/stats\" class=\"btn btn-default btn-block\">View more reports</a>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- /.panel-body -->\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.panel -->\n");
      out.write("\n");
      out.write("                    <div class=\"panel panel-default\">\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <i class=\"fa fa-cog fa-fw\"></i> Settings\n");
      out.write("                        </div>\n");
      out.write("                        <!-- /.panel-heading -->\n");
      out.write("                        <div class=\"panel-body\">\n");
      out.write("                            <table class=\"table settings\">\n");
      out.write("                                <tbody>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>Mailing Date</td>\n");
      out.write("                                        <td>Last friday of each month</td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>Time </td>\n");
      out.write("                                        <td>10:00</td>\n");
      out.write("                                    </tr>\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("                            <table class=\"table editsettings hidden\">\n");
      out.write("                                <tbody>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Mailing Date</td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <select name=\"date\" class=\"form-control\" id=\"senddate\">\n");
      out.write("                                            <option value=\"1\">Last friday of each month</option>\n");
      out.write("                                            <option value=\"2\">Last office-day of each month</option>\n");
      out.write("                                            <option value=\"3\">First monday of each month</option>\n");
      out.write("                                            <option value=\"4\">First office-day of each month</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Time </td>\n");
      out.write("                                    <td><input type=\"text\" class=\"form-control\"></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr><td colspan=\"2\" align=\"right\"><input type=\"submit\" class=\"btn btn-sm btn-primary\"></td></tr>\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("\n");
      out.write("                            <!-- /.list-group -->\n");
      out.write("                            <a class=\"btn btn-default btn-block edit\">Change Settings</a>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- /.panel-body -->\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.panel -->\n");
      out.write("                </div>\n");
      out.write("                <!-- /.col-lg-4 -->\n");
      out.write("            </div>\n");
      out.write("            <!-- /.row -->\n");
      out.write("        </div>\n");
      out.write("        <!-- /#page-wrapper -->\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <!-- /#wrapper -->\n");
      out.write("    <footer class=\"footer\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row text-center\">\n");
      out.write("                Resourcepool &bullet; 2017\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </footer>\n");
      out.write("\n");
      out.write("    <!-- jQuery -->\n");
      out.write("    <script src=\"resources/js/jquery-3.1.1.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- togggle.js -->\n");
      out.write("    <script src=\"resources/js/toggle.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap Core JavaScript -->\n");
      out.write("    <script src=\"resources/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new jakarta.servlet.ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(jakarta.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    jakarta.servlet.jsp.PageContext pageContext = _jspx_page_context;
    jakarta.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/pages/home.jsp(155,48) name = items type = jakarta.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true deferredMethod = false expectedTypeName = java.lang.Object methodSignature = null 
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/pages/home.jsp(155,48) '${membres}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${membres}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/pages/home.jsp(155,48) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false deferredMethod = false expectedTypeName = null methodSignature = null 
    _jspx_th_c_005fforEach_005f0.setVar("member");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != jakarta.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                                    <tr>\n");
          out.write("                                                       <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${member.firstName}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                                       <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${member.lastName}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                                       <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${member.email}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                                       <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${member.birthdate}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                                       <td  class=\"text-right\">\n");
          out.write("                                                           <a href=\"#\" class=\"btn btn-sm btn-warning\"><i class=\"fa fa-pencil\"></i> Edit</a>\n");
          out.write("                                                           <a href=\"#\" class=\"btn btn-sm btn-danger\"><i class=\"fa fa-trash\"></i> Remove</a>\n");
          out.write("                                                       </td>\n");
          out.write("                                                    </tr>\n");
          out.write("                                               ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != jakarta.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == jakarta.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
