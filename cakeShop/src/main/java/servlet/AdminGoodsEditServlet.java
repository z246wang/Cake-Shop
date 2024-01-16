package servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
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

import model.Goods;
import service.GoodsService;

/**
 * Servlet implementation class AdminGoodsEditServlet
 */
@WebServlet("/admin/goods_edit")
public class AdminGoodsEditServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GoodsService gService;
	
	@Override
    public void init() throws ServletException {
        gService = new GoodsService();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  DiskFileItemFactory factory = new DiskFileItemFactory();
	        ServletFileUpload upload = new ServletFileUpload(factory);
	        Goods g = new Goods();
	        int pageNo = 1;
	        int type = 0;
	        
	        try {
	            List<FileItem> list = upload.parseRequest(request);
	            for (FileItem item : list) {
	                if (item.isFormField()) {
	                    handleFormField(item, g, pageNo, type);
	                } else {
	                    handleFileUpload(item, g);
	                }
	            }
	            
	            gService.update(g);
	            request.getRequestDispatcher("/admin/goods_list?pageNo=" + pageNo + "&type=" + type).forward(request, response);
	        } catch (FileUploadException e) {
	            e.printStackTrace();
	        }
	}
	
    //check different word input fields. 
    private void handleFormField(FileItem item, Goods g, int pageNo, int type) {
        String fieldName = item.getFieldName();
        String fieldValue = item.getString();
        
        if ("id".equals(fieldName)) g.setId(Integer.parseInt(fieldValue));
        else if ("name".equals(fieldName)) g.setName(fieldValue);
        else if ("price".equals(fieldName)) g.setPrice(Float.parseFloat(fieldValue));
        else if ("intro".equals(fieldName)) g.setIntro(fieldValue);
        else if ("cover".equals(fieldName)) g.setCover(fieldValue);
        else if ("image1".equals(fieldName)) g.setImage1(fieldValue);
        else if ("image2".equals(fieldName)) g.setImage2(fieldValue);
        else if ("stock".equals(fieldName)) g.setStock(Integer.parseInt(fieldValue));
        else if ("typeid".equals(fieldName)) g.setTypeid(Integer.parseInt(fieldValue));
        else if ("pageNo".equals(fieldName)) pageNo = Integer.parseInt(fieldValue);
        else if ("type".equals(fieldName)) type = Integer.parseInt(fieldValue);
    }

    //check different image input fields.
    private void handleFileUpload(FileItem item, Goods g) throws IOException {
        if (item.getInputStream().available() <= 0) return;

        String fileName = item.getName().substring(item.getName().lastIndexOf('.'));
        fileName = "/" + new Date().getTime() + fileName;
        String path = this.getServletContext().getRealPath("/picture") + fileName;

        try (InputStream in = item.getInputStream(); FileOutputStream out = new FileOutputStream(path)) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        }

        item.delete();

        if ("cover".equals(item.getFieldName())) g.setCover("/picture" + fileName);
        else if ("image1".equals(item.getFieldName())) g.setImage1("/picture" + fileName);
        else if ("image2".equals(item.getFieldName())) g.setImage2("/picture" + fileName);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
