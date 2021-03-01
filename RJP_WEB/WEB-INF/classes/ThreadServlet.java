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

        //POST�v���ɂ���đ��M���ꂽ��������N���C�A���g��
        //�G���R�[�h�����Ƃ��̕����R�[�h���w�肷��
        //������w�肵�Ȃ��ƕ�����������\��������
        res.setContentType("text/html; charset=Windows-31J");
		req.setCharacterEncoding("Windows-31J");
		PrintWriter out = res.getWriter();

        //POST�v���ɂ���đ��M���ꂽ�p�����[�^���擾����
        String ti = req.getParameter("Thread_ID");
        String tt = req.getParameter("Thread_Title");
        String tu = req.getParameter("Thread_User");
        String td = req.getParameter("Thread_Date");

        //Integer tii=Integer.parseInt(ti);

        //UserBean���C���X�^���X�����A�f�[�^���Z�b�g����
		ThreadBean thread=new ThreadBean();
		thread.setThreadID(ti);
		thread.setThreadTitle(tt);
        thread.setThreadUser(tu);
        thread.setThreadDate(td);
		
        db.threadInsert(/*thread.getThreadID(),*/thread.getThreadTitle(),/*,thread.getThreadDate()*/thread.getThreadUser());
        //db.threadInsert(tt,tu);
		//���X�g�ɒǉ�����@ArrayList�ɂ����
		//threads.add(thread);

        //HttpServletRequest�̎����N���X�̃C���X�^���X��
        req.setAttribute("threads", threads);
        req.setAttribute("newlist",newlist);
        
        //RequestDispatcher�C���^�[�t�F�C�X����������N���X��
        //�C���X�^���X���擾����
        //�����͓]�����URL
        //RequestDispatcher dispatcher =
        //        req.getRequestDispatcher("threadlist");

        //�]����ɗv����]������
        //dispatcher.forward(req, res);
        
        doGet(req,res);
    }
}