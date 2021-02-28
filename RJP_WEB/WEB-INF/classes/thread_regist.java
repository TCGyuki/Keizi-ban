import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tera.DBAccess;
import tera.ThreadBean;


public class thread_regist extends HttpServlet {

    private ArrayList<ThreadBean> threads = new ArrayList<ThreadBean>();

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        //POST要求によって送信された文字列をクライアントで
        //エンコードしたときの文字コードを指定する
        //これを指定しないと文字化けする可能性がある
        req.setCharacterEncoding("Windows-31J");

        //POST要求によって送信されたパラメータを取得する
        String tn = req.getParameter("thread_Name");
        String pn = req.getParameter("pen_Name");

        //UserBeanをインスタンス化し、データをセットする
		ThreadBean thread=new ThreadBean();
		thread.setThreadName(tn);
		thread.setPenName(pn);
		
        DBAccess db=new DBAccess();
        //db.insertRes(2,thread.getRes_name(),うんたらかんたら)

		//リストに追加する　ArrayListにいれる
		threads.add(thread);

        //HttpServletRequestの実装クラスのインスタンスに
        //threadsという名前とpassという名前でデータを登録する threadのArraylist情報を送っている
        req.setAttribute("threads", threads);
        
        //RequestDispatcherインターフェイスを実装するクラスの
        //インスタンスを取得する
        //引数は転送先のURL
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("threadslist");

        //転送先に要求を転送する
        dispatcher.forward(req, res);
    }

    protected void doGet(HttpservletRequest req,HttpServletResponse res)throws ServletException,IOException {

    }
}