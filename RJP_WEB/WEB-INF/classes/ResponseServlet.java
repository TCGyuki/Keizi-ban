import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

import tera.ThreadBean;
import tera.ResBean;
import tera.DBAccess;
import tera.NgCheck;
import tera.newLine;

public class ResponseServlet extends HttpServlet {

    private ArrayList<ResBean> responses = new ArrayList<ResBean>();
    DBAccess db  = new DBAccess();
    NgCheck nc = new NgCheck();
    newLine nl = new newLine();
    private String t_id; 
    private ArrayList<ThreadBean> r_list = new ArrayList<ThreadBean>();

    //private String th_id;//THREAD_ID格納用

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        //POST要求によって送信された文字列をクライアントで
        //エンコードしたときの文字コードを指定する
        //これを指定しないと文字化けする可能性がある
        req.setCharacterEncoding("Windows-31J");
        
        //POST要求によって送信されたパラメータを取得する
        String ri = req.getParameter("Res_ID");
        String rd = req.getParameter("Res_Date");
        String ru = req.getParameter("Res_User");
        String rc = req.getParameter("Res_comment");
        
        //Integer rii=Integer.parseInt(ri);
        
        //改行処理
        //rc = nl.htmlEscape(rc);
        //NGチェック処理
        String result=nc.doCheck(rc);
        if(result == ""){
        }else{
            rc = result;
        }

        
        //UserBeanをインスタンス化し、データをセットする
		ResBean response=new ResBean();
		response.setResID(ri);
		response.setResDate(rd);
        response.setResUser(ru);
        response.setResComment(rc);
        
        t_id=req.getParameter("id");
        db.resInsert(t_id,/*response.getResID(),*/response.getResUser(),/*response.getResDate(),*/response.getResComment());
        //db.resInsert(ru,rc);

        req.setAttribute("t_id",t_id);
		//リストに追加する　ArrayListにいれる
		//responses.add(response);

        //HttpServletRequestの実装クラスのインスタンスに
        //threadsという名前とpassという名前でデータを登録する threadのArraylist情報を送っている
        //req.setAttribute("responses", responses);
        
        //RequestDispatcherインターフェイスを実装するクラスの
        //インスタンスを取得する
        //引数は転送先のURL
        //RequestDispatcher dispatcher =
        //        req.getRequestDispatcher("responselist");

        //転送先に要求を転送する
        //dispatcher.forward(req, res);
        
        
        doGet(req,res);
    }

    protected void doGet(HttpServletRequest req,HttpServletResponse res)
        throws ServletException,IOException {
        //普通にレスを全部出す
        res.setContentType("text/html; charset=Windows-31J");

        PrintWriter out = res.getWriter();
        
        t_id = req.getParameter("id");
        r_list=db.selectThid(t_id,r_list);
        responses=db.resSelect(t_id,responses);
        //responses = db.getData();//セットしなきゃいけないかも 
        req.setAttribute("r_list",r_list);
        req.setAttribute("responses",responses);
        req.setAttribute("t_id",t_id);

        RequestDispatcher dispatcher = 
            req.getRequestDispatcher("responselist");
        
        dispatcher.forward(req,res);
    }
}