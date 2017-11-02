package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"br\">\n");
      out.write("    <head>\n");
      out.write("        <title>Aulas Particulares</title>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar fixed-top navbar-dark bg-primary\">\n");
      out.write("            <h1 class=\"display-4\" id=\"titulo\">Aulas Particulares</h1>\n");
      out.write("            <form class=\"form-inline\">\n");
      out.write("                <div class=\"input-group login\">\n");
      out.write("                    <span class=\"input-group-addon\" id=\"basic-addon1\">@</span>\n");
      out.write("                    <input id=\"emailLogin\" type=\"text\" class=\"form-control\" placeholder=\"E-mail\" aria-label=\"Email\" aria-describedby=\"basic-addon1\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"input-group login\">\n");
      out.write("                    <span class=\"input-group-addon\" id=\"basic-addon1\">**</span>\n");
      out.write("                    <input id=\"senhaLogin\" type=\"text\" class=\"form-control\" placeholder=\"Senha\" aria-label=\"Password\" aria-describedby=\"basic-addon1\">\n");
      out.write("                </div>\n");
      out.write("                <button id=\"btnLogin\" class=\"btn btn-light login\">\n");
      out.write("                    <span class=\"glyphicon glyphicon-send\"></span>\n");
      out.write("                    Login\n");
      out.write("                </button>\n");
      out.write("                <span>'   '</span>\n");
      out.write("                <input type=\"checkbox\" id=\"alterarCadastro\" value=\"false\" class=\"form-control\">Alterar Cadstro</>\n");
      out.write("            </form>\n");
      out.write("        </nav>\n");
      out.write("        </br></br></br></br></br>\n");
      out.write("        <div class=\"container corpo\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"container\">  \n");
      out.write("                    <div id='msg' class=\"form-group\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div if=\"imagem\" class=\"container col\"> \n");
      out.write("                    <img src=\"imgs/study-icon.png\" class=\"img-fluid\" alt=\"Responsive image\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col\">\n");
      out.write("                    <form id=\"addUser\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"inputName\">Nome</label>\n");
      out.write("                            <input id=\"inputName\" type=\"text\" class=\"form-control\" placeholder=\"Nome completo\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"inputTel\">Telefone</label>\n");
      out.write("                            <input id=\"inputTel\" type=\"text\" class=\"form-control\" placeholder=\"Telefone\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"inputEmail\">E-mail</label>\n");
      out.write("                            <input id=\"inputEmail\" type=\"email\" class=\"form-control\" placeholder=\"Endereço de e-mail\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"inputPassword\">Senha</label>\n");
      out.write("                            <input id=\"inputPassword\" type=\"password\" class=\"form-control\"  placeholder=\"Crie uma senha\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"inputPasswordTest\">Confirmação</label>\n");
      out.write("                            <input id=\"inputPasswordTest\" type=\"password\" class=\"form-control\" placeholder=\"Repita a senha\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <input id=\"idUser\" type=\"text\" class=\"form-control\" placeholder=\"id user\">\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <form>\n");
      out.write("                                <div class=\"form-check form-check-inline\">\n");
      out.write("                                    <label class=\"form-check-label\">\n");
      out.write("                                        <input class=\"form-check-input\" type=\"radio\" name=\"radioAluno\" value=\"true\"> Aluno\n");
      out.write("                                    </label>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-check form-check-inline\">\n");
      out.write("                                    <label class=\"form-check-label\">\n");
      out.write("                                        <input class=\"form-check-input\" type=\"radio\" name=\"radioAluno\" value=\"false\"> Professor\n");
      out.write("                                    </label>\n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("\n");
      out.write("                        <button id=\"btnCadastro\" class=\"btn btn-primary cadastro\">Cadastrar-se</button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script src=\"js/jquery-3.2.1.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.mask.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/popper.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        \n");
      out.write("        <script src=\"js/jsutil.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/cadastro.js\" type=\"text/javascript\"></script>\n");
      out.write("        \n");
      out.write("        <!-- <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js\" integrity=\"sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js\" integrity=\"sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1\" crossorigin=\"anonymous\"></script> -->\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
