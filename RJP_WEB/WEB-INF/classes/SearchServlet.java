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

        //POST�v���ɂ���đ��M���ꂽ��������N���C�A���g��
        //�G���R�[�h�����Ƃ��̕����R�[�h���w�肷��
        //������w�肵�Ȃ��ƕ�����������\��������
        res.setContentType("text/html; charset=Windows-31J");
		req.setCharacterEncoding("Windows-31J");
		PrintWriter out = res.getWriter();

        //POST�v���ɂ���đ��M���ꂽ�p�����[�^���擾����
        String tt = req.getParameter("Thread_Title");

        //Integer tii=Integer.parseInt(ti);

        //UserBean���C���X�^���X�����A�f�[�^���Z�b�g����
		ThreadBean thread=new ThreadBean();
		thread.setThreadTitle(tt);
		
        //db.threadInsert(tt,tu);
		//���X�g�ɒǉ�����@ArrayList�ɂ����
		//threads.add(thread);

        //HttpServletRequest�̎����N���X�̃C���X�^���X��
        req.setAttribute("tt", tt);
        
        //RequestDispatcher�C���^�[�t�F�C�X����������N���X��
        //�C���X�^���X���擾����
        //�����͓]�����URL
        //RequestDispatcher dispatcher =
        //        req.getRequestDispatcher("threadlist");

        //�]����ɗv����]������
        //dispatcher.forward(req, res);
        
        search=db.threadSearch(thread.getThreadTitle(),search);
        
        req.setAttribute("search",search);

        RequestDispatcher dispatcher = 
            req.getRequestDispatcher("searchlist");
        
        dispatcher.forward(req,res);
        //doGet(req,res);
    }
}
