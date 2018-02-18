<%@page import="co.mil.ejercito.leccionesaprendidas.modelo.NoticiasService"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@page import="co.mil.ejercito.leccionesaprendidas.modelo.CategoriaService" %>
<%@page import="java.util.List" %>
<%@page import="co.mil.ejercito.leccionesaprendidas.modelo.Categoria" %>
<%@page import="co.mil.ejercito.leccionesaprendidas.modelo.Noticia" %>
<%-- khkhjk--%>

<%!  
    CategoriaService service = new CategoriaService();
    NoticiasService noticiaService= new NoticiasService();
    List<Categoria> categorias = service.consultarCategorias();
    Noticia noticia1 =  noticiaService.consultarNoticias().get(0);
    Noticia noticia2 =  noticiaService.consultarNoticias().get(1);
%>

<html>
<head>
	<title>Your Company Website</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body leftmargin=0 topmargin=0 marginheight="0" marginwidth="0" bgcolor="#ffffff">

<table border="0" cellspacing="0" cellpadding="0" width="102%" height="100%">
  <tr>
	<td width="50%" background="images/bg.gif"><img src="images/px1.gif" width="1" height="1" alt="" border="0"></td>
	<td valign="bottom" background="images/bg_left.gif"><img src="images/bg_left.gif" alt="" width="17" height="16" border="0"></td>
	<td valign="top">
      <table width="780" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td background="images/fon05.gif"> 
            <table width="780" border="0" cellspacing="0" cellpadding="0">
              <tr> 
                <td width="137"></td>
                <td width="100%"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr> 
                      <td width="20%"></td>
                      <td class="title"><b>SEARCH</b>&nbsp;&nbsp; 
                        <input type="Text" name="Input" value="" size="10" align="absmiddle">
                        <input type="Image" src="images/b_go3.gif" width="22" height="28" alt="" border="0" hspace="10" align="absmiddle" name="Image">
                      </td>
                      <td width="10%"></td>
                    </tr>
                  </table>
                </td>
                <td width="360"> 
                  <table width="360" border="0" cellspacing="0" cellpadding="0">
                    <tr> 
                      <td width="2"><img src="images/separator.gif" width="2" height="67"></td>
                      <td width="88"> 
                        <table width="100%" border="0" cellspacing="0" cellpadding="5">
                          <tr> 
                            <td> 
                              <div align="center"><img src="images/arrow.gif" width="11" height="11"></div>
                            </td>
                          </tr>
                          <tr> 
                            <td> 
                              <div align="center"> 
                                <p class="menu01"><a href=""><font color="#000000">HOME</font></a></p>
                              </div>
                            </td>
                          </tr>
                        </table>
                      </td>
                      <td width="2"><img src="images/separator.gif" width="2" height="67"></td>
                      <td width="88"> 
                        <table width="100%" border="0" cellspacing="0" cellpadding="5">
                          <tr> 
                            <td> 
                              <div align="center"><img src="images/arrow.gif" width="11" height="11"></div>
                            </td>
                          </tr>
                          <tr> 
                            <td> 
                              <div align="center"> 
                                <p class="menu01"><a href=""><font color="#000000">FAQ</font></a></p>
                              </div>
                            </td>
                          </tr>
                        </table>
                      </td>
                      <td width="2"><img src="images/separator.gif" width="2" height="67"></td>
                      <td width="88"> 
                        <table width="100%" border="0" cellspacing="0" cellpadding="5">
                          <tr> 
                            <td> 
                              <div align="center"><img src="images/arrow.gif" width="11" height="11"></div>
                            </td>
                          </tr>
                          <tr> 
                            <td> 
                              <div align="center"> 
                                <p class="menu01"><a href=""><font color="#000000">HELP</font></a></p>
                              </div>
                            </td>
                          </tr>
                        </table>
                      </td>
                      <td width="2"><img src="images/separator.gif" width="2" height="67"></td>
                      <td width="88"> 
                        <table width="100%" border="0" cellspacing="0" cellpadding="5">
                          <tr> 
                            <td> 
                              <div align="center"><img src="images/arrow.gif" width="11" height="11"></div>
                            </td>
                          </tr>
                          <tr> 
                            <td> 
                              <div align="center"> 
                                <p class="menu01"><a href=""><font color="#000000">SITE 
                                  MAP </font></a></p>
                              </div>
                            </td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
        <tr>
          <td height="29" background="images/fon06.gif"><img src="images/main01.jpg" width="224" height="29"></td>
        </tr>
        <tr>
          <td><img src="images/main02.jpg" width="266" height="151"><img src="images/main03.jpg" width="514" height="151"></td>
        </tr>
      </table>
<table border="0" cellpadding="0" cellspacing="0" width="780">
<tr>
	<td><img src="images/top11.gif" width="224" height="17" alt="" border="0"></td>
	<td><img src="images/top12.gif" width="556" height="17" alt="" border="0"></td>
</tr>
<tr>
	<td><img src="images/top21.gif" width="224" height="39" alt="" border="0"></td>
	<td background="images/fon_top.gif">
<table border="0" cellpadding="0" cellspacing="0" background="" width="95%">
<tr align="center">
	<td><p class="menu01"><a href=""><img src="images/e01.gif" width="19" height="19" alt="" border="0" align="absmiddle">&nbsp;&nbsp;ABOUT US</a></p></td>
	<td><p class="menu01"><a href=""><img src="images/e01.gif" width="19" height="19" alt="" border="0" align="absmiddle">&nbsp;&nbsp;SERVICES</a></p></td>
	<td><p class="menu01"><a href=""><img src="images/e01.gif" width="19" height="19" alt="" border="0" align="absmiddle">&nbsp;&nbsp;PRODUCTS</a></p></td>
	<td><p class="menu01"><a href=""><img src="images/e01.gif" width="19" height="19" alt="" border="0" align="absmiddle">&nbsp;&nbsp;CLIENTS</a></p></td>
	<td><p class="menu01"><a href=""><img src="images/e01.gif" width="19" height="19" alt="" border="0" align="absmiddle">&nbsp;&nbsp;CONTACT US</a></p></td>
</tr>
</table>
	</td>
</tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" width="779">
<tr valign="top">
	<td width="224"><img src="images/top01.jpg" width="224" height="149" alt="" border="0"></td>
	<td width="333" background="images/fon_top01.gif">
<p class="title">MEMBERS LOGIN </p>
<form action="LeccionesAprendidasServlet" method="post">
<div style="margin-left: 30px; margin-top: 30px; ">
  <span class="title01">User:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
  <input type="Text" name="usuario" value="" size="15"><br>
  <span class="title01">Password</span>:
<input type="password" name="password" value="" size="15"><input type="Image" src="images/b_go2.gif" width="22" height="27" alt="" border="0" hspace="5" align="absmiddle">
${1+2}

</div>
</form>
    </td>
	<td width="222" background="images/fon_top02.gif">
<p class="title">FIND YOUR  SERVER HERE</p>
	</td>
</tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" width="780">
<tr valign="top">
	<td background="images/fon02.gif" width="224" rowspan="2">
<!-- LEFT -->
<table border="0" cellpadding="0" cellspacing="0" width="224" height="31" background="images/fon01.gif">
<tr>
	<td><p class="title">BROWSE CATEGORIES</p></td>
</tr>
<form action="" method="post">
</form></table>
<p align="center" style="margin-top: 10px;">
<div align="center">
  <select name="select" style="width: 150px;">
      <%  
         
           for(Categoria cat : categorias){
               out.println("<option value=" + cat.getId()
               +"> " + cat.getNombre());
           }
      
      %>      
    
    </select>
</div>
<p></p>
<table border="0" cellpadding="0" cellspacing="0" width="224" height="31" background="images/fon01.gif">

<tr>
	<td><p class="title">LATEST NEWS</p></td>
</tr>
</table>
<p class="px5">
<p class="left"><img src="images/dot_g.gif" width="5" height="5" alt="" border="0" align="middle">&nbsp;&nbsp;<%=noticia1.getDescripcion()%>.</p>
<p class="left"><a href="<%=noticia1.getLink()%>">Visitar...</a></p>
<p class="px5">
<p class="left"><img src="images/dot_g.gif" width="5" height="5" alt="" border="0" align="middle">&nbsp;&nbsp;<%=noticia2.getDescripcion()%>.</p>
<p class="left"><a href="<%=noticia2.getLink()%>">Visitar...</a></p>
<p class="px5">
<br>
<!-- /LEFT -->
	</td>
	<td width="556">
<!-- main -->
<br>
<table border="0" cellpadding="0" cellspacing="0" width="90%" align="center">
<tr>
	<td width="50%">
<!-- left tab -->
<table border="0" cellpadding="0" cellspacing="0" width="230">
<tr valign="top">
	<td background="images/t_fon.gif"><img src="images/t01.gif" width="41" height="37" alt="" border="0"></td>
	<td background="images/t_fon.gif" width="100%"><p class="title01">BROWSE CATEGORIES</p></td>
	<td background="images/t_fon.gif" align="right"><img src="images/t02.gif" width="15" height="37" alt="" border="0"></td>
</tr>
<tr>
	<td colspan="3">
<table border="0" cellpadding="0" cellspacing="0" width="100%">
<tr>
	<td bgcolor="#C8C8C8"><img src="images/px1.gif" width="1" height="1" alt="" border="0"></td>
	<td bgcolor="#C8C8C8"><img src="images/px1.gif" width="1" height="1" alt="" border="0"></td>
	<td bgcolor="#C8C8C8"><img src="images/px1.gif" width="1" height="1" alt="" border="0"></td>
</tr>
<tr>
	<td bgcolor="#C8C8C8"><img src="images/px1.gif" width="1" height="1" alt="" border="0"></td>
	<td width="100%" background="images/fon01.jpg" style="background-position: center; background-repeat: repeat-y;">
<p class="px5"><img src="images/temp01.gif" alt="" width="58" height="110" hspace="10" vspace="10" border="0" align="right"></p>
<p class="left"><img src="images/dot_g.gif" width="5" height="5" alt="" border="0" align="middle">&nbsp;&nbsp;Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh dolor sit elit, sed diam nonummy nibh commodo consequat.</p>
<p class="left"><a href="">Read more</a></p>
<p class="px5">	</td>
	<td bgcolor="#C8C8C8"><img src="images/px1.gif" width="1" height="1" alt="" border="0"></td>
</tr>
<tr>
	<td bgcolor="#C8C8C8"><img src="images/px1.gif" width="1" height="1" alt="" border="0"></td>
	<td bgcolor="#C8C8C8"><img src="images/px1.gif" width="1" height="1" alt="" border="0"></td>
	<td bgcolor="#C8C8C8"><img src="images/px1.gif" width="1" height="1" alt="" border="0"></td>
</tr>
</table>	</td>
</tr>
</table>
<!-- /left tab -->	</td>
	<td width="50%" align="right">
<!-- right tab -->
<table border="0" cellpadding="0" cellspacing="0" width="230">
<tr valign="top">
	<td background="images/t_fon.gif"><img src="images/t01.gif" width="41" height="37" alt="" border="0"></td>
	<td background="images/t_fon.gif" width="100%"><p class="title01">BROWSE CATEGORIES</p></td>
	<td background="images/t_fon.gif" align="right"><img src="images/t02.gif" width="15" height="37" alt="" border="0"></td>
</tr>
<tr>
	<td colspan="3">
<table border="0" cellpadding="0" cellspacing="0" width="100%">
<tr>
	<td bgcolor="#C8C8C8"><img src="images/px1.gif" width="1" height="1" alt="" border="0"></td>
	<td bgcolor="#C8C8C8"><img src="images/px1.gif" width="1" height="1" alt="" border="0"></td>
	<td bgcolor="#C8C8C8"><img src="images/px1.gif" width="1" height="1" alt="" border="0"></td>
</tr>
<tr>
	<td bgcolor="#C8C8C8"><img src="images/px1.gif" width="1" height="1" alt="" border="0"></td>
	<td width="100%" background="images/fon01.jpg" style="background-position: center; background-repeat: repeat-y;">
<p class="px5"><img src="images/temp02.gif" alt="" width="58" height="110" hspace="10" vspace="10" border="0" align="right"></p>
<p class="left"><img src="images/dot_g.gif" width="5" height="5" alt="" border="0" align="middle">&nbsp;&nbsp;Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh dolor sit elit, sed diam nonummy nibh commodo consequat.</p>
<p class="left"><a href="">Read more</a></p>
<p class="px5">	</td>
	<td bgcolor="#C8C8C8"><img src="images/px1.gif" width="1" height="1" alt="" border="0"></td>
</tr>
<tr>
	<td bgcolor="#C8C8C8"><img src="images/px1.gif" width="1" height="1" alt="" border="0"></td>
	<td bgcolor="#C8C8C8"><img src="images/px1.gif" width="1" height="1" alt="" border="0"></td>
	<td bgcolor="#C8C8C8"><img src="images/px1.gif" width="1" height="1" alt="" border="0"></td>
</tr>
</table>	</td>
</tr>
</table>
<!-- /right tab -->	</td>
</tr>
</table>

<br>
<table border="0" cellpadding="0" cellspacing="0" align="center" width="90%">
<tr valign="top">
	<td background="images/t_fon.gif"><img src="images/t01.gif" width="41" height="37" alt="" border="0"></td>
	<td background="images/t_fon.gif" width="100%"><p class="title01">WELCOME TO OUR COMPANY</p></td>
	<td background="images/t_fon.gif" align="right"><img src="images/t02.gif" width="15" height="37" alt="" border="0"></td>
</tr>
<tr>
	<td colspan="3">
<table border="0" cellpadding="0" cellspacing="0" width="100%">
<tr>
	<td bgcolor="#C8C8C8"><img src="images/px1.gif" width="1" height="1" alt="" border="0"></td>
	<td bgcolor="#C8C8C8"><img src="images/px1.gif" width="1" height="1" alt="" border="0"></td>
	<td bgcolor="#C8C8C8"><img src="images/px1.gif" width="1" height="1" alt="" border="0"></td>
</tr>
<tr>
	<td bgcolor="#C8C8C8"><img src="images/px1.gif" width="1" height="1" alt="" border="0"></td>
	<td width="100%" background="images/fon01.jpg" style="background-position: center; background-repeat: repeat-y;">
<table border="0" cellpadding="10" cellspacing="0" width="100%" background="">
<tr valign="top">
	<td>
&nbsp;&nbsp;<img src="images/e03.gif" width="240" height="21" alt="" border="0">
<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim </p>	</td>
	<td align="center"><img src="images/temp01.jpg" width="153" height="135" alt="" border="0"></td>
</tr>
</table>	</td>
	<td bgcolor="#C8C8C8"><img src="images/px1.gif" width="1" height="1" alt="" border="0"></td>
</tr>
<tr>
	<td bgcolor="#C8C8C8"><img src="images/px1.gif" width="1" height="1" alt="" border="0"></td>
	<td bgcolor="#C8C8C8"><img src="images/px1.gif" width="1" height="1" alt="" border="0"></td>
	<td bgcolor="#C8C8C8"><img src="images/px1.gif" width="1" height="1" alt="" border="0"></td>
</tr>
</table>	</td>
</tr>
</table>
<!-- /main -->	</td>
</tr>
<tr valign="bottom">
	<td align="right">
<table border="0" cellpadding="0" cellspacing="0" width="95%" height="58" background="images/fon_bot.gif">
<tr>
	<td>
<br>
<p class="menu02">
<a href="">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="">About Us</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="">Support</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="">Services</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="">Contacts</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="">Help</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="">FAQ</a></p>
<p class="menu02" style="font-size: 10px; font-weight: 400; margin-top: 5px;">Copyright &copy;2003 CompanyName.com</p>	</td>
</tr>
</table>	</td>
</tr>
</table>
	</td>
	<td valign="bottom" background="images/bg_right.gif"><img src="images/bg_right.gif" alt="" width="17" height="16" border="0"></td>
	<td width="50%" background="images/bg.gif"><img src="images/px1.gif" width="1" height="1" alt="" border="0"></td>
</tr>
</table>

</body>
</html>
