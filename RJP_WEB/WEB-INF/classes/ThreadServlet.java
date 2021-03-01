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
import tera.ResBean;

public class ThreadServlet extends HttpServlet {

    private ArrayList<ThreadBean> threads = new ArrayList<ThreadBean>();
    DBAccess db  = new DBAccess();
    private ArrayList<ResBean> newlist = new ArrayList<ResBean>();

    public void doGet(HttpServletRequest req,HttpServletResponse res)
        throws ServletException,IOException {
        
        res.setContentType("text/html; charset=Windows-31J");

        threads=db.threadSelect(threads);
        newlist = db.newList(newlist);
        
        req.setAttribute("threads",threads);
        req.setAttribute("newlist",newlist);

        RequestDispatcher dispatcher = 
            req.getRequestDispatcher("threadlist");
        
        dispatcher.forward(req,res);
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
        String ti = req.getParameter("Thread_ID");
        String tt = req.getParameter("Thread_Title");
        String tu = req.getParameter("Thread_User");
        String td = req.getParameter("Thread_Date");

        //Integer tii=Integer.parseInt(ti);

        //UserBeanをインスタンス化し、データをセットする
		ThreadBean thread=new ThreadBean();
		thread.setThreadID(ti);
		thread.setThreadTitle(tt);
        thread.setThreadUser(tu);
        thread.setThreadDate(td);
		
        db.threadInsert(/*thread.getThreadID(),*/thread.getThreadTitle(),/*,thread.getThreadDate()*/thread.getThreadUser());
        //db.threadInsert(tt,tu);
		//リストに追加する　ArrayListにいれる
		//threads.add(thread);

        //HttpServletRequestの実装クラスのインスタンスに
        req.setAttribute("threads", threads);
        req.setAttribute("newlist",newlist);
        
        //RequestDispatcherインターフェイスを実装するクラスの
        //インスタンスを取得する
        //引数は転送先のURL
        //RequestDispatcher dispatcher =
        //        req.getRequestDispatcher("threadlist");

        //転送先に要求を転送する
        //dispatcher.forward(req, res);
        
        doGet(req,res);
    }
}