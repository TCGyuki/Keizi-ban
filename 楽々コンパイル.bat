cd C:\RJP_WEB\WEB-INF\classes\tera
set classpath=.;c:/jar/ojdbc7.jar

javac -cp C:\RJP_WEB\WEB-INF\classes ThreadBean.java
javac -cp C:\RJP_WEB\WEB-INF\classes ResBean.java
javac -cp C:\RJP_WEB\WEB-INF\classes DBAccess.java
javac -cp C:\RJP_WEB\WEB-INF\classes NgCheck.java


cd C:\RJP_WEB\WEB-INF\classes
javac -cp C:\tomcat8.5\lib\servlet-api.jar;C:\tomcat8.5\lib\jstl.jar;C:\tomcat8.5\lib\standard.jar;C:\RJP_WEB\WEB-INF\classes ResponseServlet.java
javac -cp C:\tomcat8.5\lib\servlet-api.jar;C:\tomcat8.5\lib\jstl.jar;C:\tomcat8.5\lib\standard.jar;C:\RJP_WEB\WEB-INF\classes ThreadServlet.java
javac -cp C:\tomcat8.5\lib\servlet-api.jar;C:\tomcat8.5\lib\jstl.jar;C:\tomcat8.5\lib\standard.jar;C:\RJP_WEB\WEB-INF\classes SearchServlet.java
pause