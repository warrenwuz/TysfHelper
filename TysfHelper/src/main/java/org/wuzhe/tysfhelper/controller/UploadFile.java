package org.wuzhe.tysfhelper.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.wuzhe.tysfhelper.pojo.AttachFile;
import org.wuzhe.tysfhelper.service.IAttachFileService;
import org.wuzhe.tysfhelper.utils.UUIDUtils;

@Controller
public class UploadFile {
	@Resource
	private IAttachFileService attachFileService;

	@RequestMapping("Uploadfile.do")
	public void releaseHomework(MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if (id == null) {
				out.write("0");// 在未登陆下禁止上传文件
			} else {
				// 获取容器路径
				String filePath = session.getServletContext().getRealPath("/file");
				File parent=new File(filePath);
				if(!parent.exists()){//如果路径不存在则创建路径
					parent.mkdir();
				}
				// 获取文件姓名
				String fileName = file.getOriginalFilename();
				// 去除后缀名名字
				String realFileName = fileName.substring(0, fileName.lastIndexOf("."));
				// 建立一个附件的唯一标识
				String afid = UUIDUtils.getUUID();
				// 获得保存路径的文件名
				String savefileName = fileName.replace(realFileName, afid);
				// 建立文件
				File filedest = new File(parent, savefileName);
				// 上传到本地
				file.transferTo(filedest);
				// 建立时间戳
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				AttachFile attachFile = new AttachFile(afid, fileName, timestamp);
				attachFileService.addAttachFile(attachFile);
				out.write(afid);
			}
		} catch (IllegalStateException e) {
			out.write("0");
			e.printStackTrace();
		} catch (IOException e) {
			out.write("0");
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
   /**
    * 下载文件
    * @param response
    * @param request
    * @param hid
    */
	@RequestMapping("downloadFile.do")
	public void downloadFile(HttpServletResponse response, HttpServletRequest request, String afid) {
		String attachFileName = attachFileService.queryAttachFileName(afid);
		String parent = request.getSession().getServletContext().getRealPath("/file");
		String fileName = attachFileName.replaceAll(attachFileName.substring(0, attachFileName.lastIndexOf(".")), afid);
		File file = new File(parent, fileName);
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
		byte[] b=new byte[1024];
		int length=0;
		InputStream  in=null;
		OutputStream out=null;
		try {
		in=new FileInputStream(file);
		out=response.getOutputStream();
			while((length=in.read(b))>0){
				out.write(b, 0, length);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
