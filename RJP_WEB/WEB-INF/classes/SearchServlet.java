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

        //Integer tii=Integer.parseInt(ti);

        //UserBeanをインスタンス化し、データをセットする
		ThreadBean thread=new ThreadBean();
		thread.setThreadTitle(tt);
		
        //db.threadInsert(tt,tu);
		//リストに追加する　ArrayListにいれる
		//threads.add(thread);

        //HttpServletRequestの実装クラスのインスタンスに
        req.setAttribute("tt", tt);
        
        //RequestDispatcherインターフェイスを実装するクラスの
        //インスタンスを取得する
        //引数は転送先のURL
        //RequestDispatcher dispatcher =
        //        req.getRequestDispatcher("threadlist");

        //転送先に要求を転送する
        //dispatcher.forward(req, res);
        
        search=db.threadSearch(thread.getThreadTitle(),search);
        
        req.setAttribute("search",search);

        RequestDispatcher dispatcher = 
            req.getRequestDispatcher("searchlist");
        
        dispatcher.forward(req,res);
        //doGet(req,res);
    }
}
