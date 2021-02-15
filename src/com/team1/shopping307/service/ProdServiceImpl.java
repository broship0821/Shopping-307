package com.team1.shopping307.service;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team1.shopping307.DAO.ProdDAO;
import com.team1.shopping307.Libs.Libs;
import com.team1.shopping307.VO.ProdVO;
import com.team1.shopping307.controller.Common;

public class ProdServiceImpl implements ProdService {
   private final String className = "ProdServiceImpl";
   private final String prefix = "  > ";
   
   @Override
   public ArrayList<ProdVO> selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println(className + ".selectAll()");
      ArrayList<ProdVO> lstResult = ProdDAO.selectAll();
      request.setAttribute("lstAll", lstResult);
      return lstResult;
   }

   @Override
   public ProdVO selectOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println(className + ".selectOne()");
      String productId = (String) request.getParameter("productId");
      ProdVO result = ProdDAO.selectOne(productId);
      request.setAttribute("item", result);
      return result;   
   }
   
   @Override
   public String insert(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException {
      System.out.println(className + ".insert()");
      ProdVO vo = getMultiParamsAndUpload(request);
      String result = ProdDAO.insert(vo);
      request.setAttribute("result", Libs.isEmpty(result) ? "등록 실패" : "상품아이디(" + result + ") 등록 성공");
      return result;
   }

   // 출처: https://m.blog.naver.com/PostView.nhn?blogId=seonjun92&logNo=221590991183&proxyReferer=https:%2F%2Fwww.google.com%2F
   private ProdVO getMultiParamsAndUpload(HttpServletRequest request) throws ParseException, IOException {
      // 가상공간에서 작업이되기때문에 실제경로와 다르다. 
      ServletContext ctx = request.getServletContext(); // 현재 실행중인 프로젝트 정보 접근.

      // .getRealPath()에 가상경로를 넣어주면, 그것("/upload")을 "실제경로" 변경한다.
      String realPath = ctx.getRealPath(Common.strUpload);   // 2 번째 인자: 경로설정
      System.out.println(prefix + realPath);    // 경로확인.
      
      int max = 5 * 1024 * 1024; //3 번째 인자: 업로드크기(바이트단위),  5 * 1024(KB) * 1024(MB) = 5MB
      
      // MultipartRequest 클래스: request 객체기능 + 하여 업로드할수있게 만듬.
      // MultipartRequest 업로드를 위해 객체생성, cos.jar파일사용
      // MultipartRequest(request, 경로, 크기, 인코딩, 같은이름의 파일 구별 )  5개의 인자(파라미터)를 가지고있다. 
      MultipartRequest multi = new MultipartRequest(request, 
            realPath, max, "utf-8", new DefaultFileRenamePolicy()) ;

      ProdVO result = getMultiParams(multi);
      
      // 모든 parameter의 이름과 값을 출려한다.
      Enumeration e1 = multi.getParameterNames();
      
      while(e1.hasMoreElements()){
         String name = (String)e1.nextElement();  // 엘리먼트 값(key 값) id= user, title
         String value = multi.getParameter(name);
         System.out.println(prefix + name + ": " + value);
      }
      
      // 모든 파일 정보를 출력한다.
      Enumeration e2 = multi.getFileNames(); // 업로드파일의 이름을 얻기위한 메서드
      while(e2.hasMoreElements()) {
         String name = (String)e2.nextElement();      // 엘리먼트 값(key 값)

         if(name != null) {
            String sysName = multi.getFilesystemName(name);
            
            switch(name) {
            case "image1": result.setImage1(sysName); break;
            case "image2": result.setImage2(sysName); break;
            case "image3": result.setImage3(sysName); break;
            }
            
            System.out.println(prefix + "component name: " + name);
            System.out.println(prefix + "실제 파일명 : " + multi.getOriginalFileName(name));
            System.out.println(prefix + "저장될 파일명 : " + sysName);
            System.out.println(prefix + "파일 타입 : " + multi.getContentType(name)); // 파일의 확장자
         
            // getFile()메서드가 File형식으로 받게끔 되어있다.
            File fi = multi.getFile(name);  // 파일정보 얻기.
            System.out.println(prefix + "파일의 크기 : " + fi.length() + "byte(s)");
            
            //fi.delete(); // 파일을 삭제한다.
         }
      }
      
      return result;
   }
   
   private ProdVO getMultiParams(MultipartRequest multi) throws ParseException {
      // 상품ID
      String productId = (String) multi.getParameter("productId"); 

      // 상품명
      String productName = (String) multi.getParameter("productName");

      // 카테고리
      String category = (String) multi.getParameter("category");
  
      // 신상/이월
      String isNew = (String) multi.getParameter("isNew");
  
      // 규격
      String standard = (String) multi.getParameter("standard");

      // 가격 
      String price = multi.getParameter("price");

      // 수량 
      String stock = multi.getParameter("stock");
      
      // 상품설명
      String bigo = (String) multi.getParameter("bigo");

      // 판매시작일
      String startDate = multi.getParameter("startDate"); 

      ProdVO result = new ProdVO(productId, productName, category, isNew, standard,
                     price, stock, bigo, startDate, "", "", "");
      
      return result;
   }

   private ProdVO getRequesParams(HttpServletRequest request) throws ParseException {
      // 상품ID
      String productId = (String) request.getParameter("productId"); 

      // 상품명
      String productName = (String) request.getParameter("productName");

      // 카테고리
      String category = (String) request.getParameter("category");
  
      // 신상/이월
      String isNew = (String) request.getParameter("isNew");
  
      // 규격
      String standard = (String) request.getParameter("standard");

      // 가격 
      String price = request.getParameter("price");

      // 수량 
      String stock = request.getParameter("stock");
      
      // 상품설명
      String bigo = (String) request.getParameter("bigo");

      // 판매시작일
      String startDate = request.getParameter("startDate"); 

      // 대표 이미지
      String image1 = (String) request.getParameter("image1");

      // 상세이미지1
      String image2 = (String) request.getParameter("image2");
  
      // 상세이미지2
      String image3 = (String) request.getParameter("image3");

      ProdVO result = new ProdVO(productId, productName, category, isNew, standard,
                     price, stock, bigo, startDate, image1, image2, image3);
      
      return result;
   }

   @Override
   public int update(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException {
      System.out.println(className + ".update()");
      ProdVO vo = getRequesParams(request);
      int result = ProdDAO.update(vo);
      request.setAttribute("result", result == 1 ? "수정 성공" : "수정 실패");
      return result;
   }

   @Override
   public int delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println(className + ".delete()");
      String productId = (String) request.getParameter("productId"); 
      int result = ProdDAO.delete(productId);
      request.setAttribute("result", result == 1 ? "삭제 성공" : "삭제 실패");
      return result;
   }
}
