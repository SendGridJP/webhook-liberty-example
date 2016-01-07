package jp.co.kke.sendgrid;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class ParseReceiver
 */
@WebServlet("/ParseReceiver")
public class ParseReceiver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParseReceiver() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Apache commons FileUpload/IOを利用してmultipart/form-dateからデータを抽出
			List<FileItem> items = new ServletFileUpload(
					new DiskFileItemFactory()).parseRequest(request);
			for (FileItem item : items) {
				if (item.isFormField()) {
					String fieldName = item.getFieldName();
					System.out.println("ParseReceiver#doPost(): fieldName: " + fieldName);
					System.out.println("ParseReceiver#doPost(): fieldValue: " + item.getString("UTF-8"));
				} else {
					String fieldName = item.getFieldName();
					String fileName = item.getName();
					System.out.println("ParseReceiver#doPost(): fieldName: " + fieldName);
					System.out.println("ParseReceiver#doPost(): fileName: " + fileName);
					// 添付ファイルはitem.getInputStream()から取得可能
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
