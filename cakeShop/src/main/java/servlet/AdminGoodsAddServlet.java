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
 * Servlet implementation class AdminGoodsAddServlet
 */
@WebServlet("/admin/goods_add")
public class AdminGoodsAddServlet extends HttpServlet {
	
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

        try {
            List<FileItem> list = upload.parseRequest(request);
            Goods goods = new Goods();
            for (FileItem item : list) {
                if (item.isFormField()) {
                    handleFormField(item, goods);
                } else {
                    handleFileUpload(item, goods);
                }
            }
            gService.insert(goods);
            request.getRequestDispatcher("/admin/goods_list").forward(request, response);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
	
	//check different word input fields. 
    private void handleFormField(FileItem item, Goods goods) throws IOException {
	   String fieldName = item.getFieldName();
	    if ("name".equals(fieldName)) {
	        goods.setName(item.getString());
	    } else if ("price".equals(fieldName)) {
	        goods.setPrice(Integer.parseInt(item.getString()));
	    } else if ("intro".equals(fieldName)) {
	        goods.setIntro(item.getString());
	    } else if ("stock".equals(fieldName)) {
	        goods.setStock(Integer.parseInt(item.getString()));
	    } else if ("typeid".equals(fieldName)) {
	        goods.setTypeid(Integer.parseInt(item.getString()));
	    }
    }

    //check different image input fields.
    private void handleFileUpload(FileItem item, Goods goods) throws IOException {
        if (item.getInputStream().available() <= 0) return;

        String fileName = item.getName();
        fileName = fileName.substring(fileName.lastIndexOf("."));
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
        
        String fieldName = item.getFieldName();
        if ("cover".equals(fieldName)) {
            goods.setCover("/picture" + fileName);
        } else if ("image1".equals(fieldName)) {
            goods.setImage1("/picture" + fileName);
        } else if ("image2".equals(fieldName)) {
            goods.setImage2("/picture" + fileName);
        }
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
