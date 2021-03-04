import java.io.IOException;
import java.util.ArrayList;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tera.ThreadBean;
import tera.DBAccess;


public class SearchServlet extends HttpServlet {

    private ArrayList<ThreadBean> search = new ArrayList<ThreadBean>();
    DBAccess db  = new DBAccess();

    public void doGet(HttpServletRequest req,HttpServletResponse res)
        throws ServletException,IOException {
        
        res.setContentType("text/html; charset=Windows-31J");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        //POST要求によって送信された文字列をクライアントで
        //エンコードしたときの文字コードを指定する
        //これを指定しないと文字化けする可能性がある
        res.setContentType("text/html; charset=Windows-31J");
		req.setCharacterEncoding("Windows-31J");
		PrintWriter out = res.getWriter();

        //POST要求によって送信されたパラメータを取得する
        String tt = req.getParameter("Thread_Title");

        //UserBeanをインスタンス化し、データをセットする
		ThreadBean thread=new ThreadBean();
		thread.setThreadTitle(tt);

        //HttpServletRequestの実装クラスのインスタンスに
        req.setAttribute("tt", tt);
        
        search=db.threadSearch(thread.getThreadTitle(),search);
        
        if(search==null || search.size() == 0){
            String nodata = "該当結果がありませんでした";
            req.setAttribute("nodata",nodata);
        }else{

            req.setAttribute("search",search);
        }
        RequestDispatcher dispatcher = 
            req.getRequestDispatcher("searchlist");
        
        dispatcher.forward(req,res);
        //doGet(req,res);
    }
}
