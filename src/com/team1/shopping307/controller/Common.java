package com.team1.shopping307.controller;

public class Common {
   //----------
   // 작성자 정보
   //----------
   public static final String strMaker = "(c)opyleft 2021 307-Team1";
   
   //----------
   // admin, 쇼핑몰 관리자 ID 정의 / 사용자 Role구분 
   //----------
   public static final String strAdminId   = "su"; // Super User
   public static final String strManagerId = "manager";
   
   public static final String strAdmin     = "A";              // Admin(Super user)
   public static final String strManager   = "M";            // Manager(쇼핑몰 관리자)
   public static final String strUser      = "U";               // User: 일반 사용자(client)
   public static final String strAnynimous = "Y";          // 익명(anonymous) 사용자(로긴하지 않은 사용자)


   //----------
   // 상태 상수
   //----------

   // 결제 상태
   public static final String strPayStatusPayed     = "입금완료";
   public static final String strPayStatusApproval  = "결제승인";
   public static final String strPayStatusRelease   = "출고";
   public static final String strPayStatusExcange   = "교환";
   public static final String strPayStatusRefund    = "환불";
   public static final String strPayStatusDone      = "구매완료";

   // 상품 출고 상태
   public static final String strReleStatusPayed    = "입금완료";
   public static final String strReleStatusApproval = "결제승인";
   public static final String strReleStatusRelease  = "출고";
   public static final String strReleStatusExcange  = "교환";
   public static final String strReleStatusRefund   = "환불";
   public static final String strReleStatusDone     = "구매완료";
   
   // 교환/환불 상태
   public static final String strExchStatusExchangeRequest = "교환신청";
   public static final String strExchStatusRefundRequest   = "환불신청";
   public static final String strExchStatusExchangeDone    = "교환완료";
   public static final String strExchStatusRefundDone      = "환불완료";


   //----------
   // 기타 상수
   //----------
   // 끝임을 의미
   public static final String strEnd = "[<-끝->]";
   
   // .do
   public static final String strDo = ".do";
   
   // .jsp
   public static final String strJsp = ".jsp";
   
   //----------
   // Upload
   //----------
   public static final String strUpload = "upload";
   public static final String strUpload2 = "/" + strUpload;


   // Result
   public static final String strResult = "Result";
   
   //----------
   // Mapping 정보
   //----------
   
   // 로그인 관련
   public static final String strUserLogin        = "UserLogin";
   public static final String strUserLoginDo     = strUserLogin + strDo;
   
   public static final String strUserLogout       = "UserLogout";
   public static final String strUserLogoutDo     = strUserLogout + strDo; 
   
   public static final String strUserFindid       = "UserfindId";
   public static final String strUserFindidDo     = strUserFindid + strDo;
   
   public static final String strUserfindPw       = "UserfindPw";
   public static final String strUserfindPwDo     = strUserfindPw + strDo;
   
   // 1. 사용자 정보
   public static final String strUsersSelectAll   = "UsersSelectAll";
   public static final String strUsersSelectAllDo = strUsersSelectAll + strDo;

   public static final String strUsersSelectOne   = "UsersSelectOne";
   public static final String strUsersSelectOneDo = strUsersSelectOne + strDo;
   
   public static final String strUsersInsert      = "UsersInsert";  
   public static final String strUsersInsertDo    = strUsersInsert + strDo;  

   public static final String strUsersUpdate      = "UsersUpdate";  
   public static final String strUsersUpdateDo    = strUsersUpdate + strDo;  

   public static final String strUsersDelete      = "UsersDelete";  
   public static final String strUsersDeleteDo    = strUsersDelete + strDo;  
   
   
   // 2. login 히스토리 정보
   public static final String strLogHistSelectAll   = "LogHistSelectAll";  
   public static final String strLogHistSelectAllDo = strLogHistSelectAll + strDo;  

   public static final String strLogHistSelectOne   = "LogHistSelectOne";
   public static final String strLogHistSelectOneDo = strLogHistSelectOne + strDo;
   
   public static final String strLogHistInsert      = "LogHistInsert";
   public static final String strLogHistInsertDo    = strLogHistInsert + strDo;
   
   public static final String strLogHistUpdate      = "LogHistUpdate";
   public static final String strLogHistUpdateDo    = strLogHistUpdate + strDo;
   
   public static final String strLogHistDelete      = "LogHistDelete";
   public static final String strLogHistDeleteDo    = strLogHistDelete + strDo;
   
   
   // 3. 카테고리 정보
   public static final String strCateComboName     = "category"; // Component명

   public static final String strCateSelectAll     = "CateSelectAll";
   public static final String strCateSelectAllDo   = strCateSelectAll + strDo;

   public static final String strCateGetComboAll   = "CateGetComboAll";
   public static final String strCateGetComboAllDo = strCateGetComboAll + strDo;

   public static final String strCateSelectOne     = "CateSelectOne";
   public static final String strCateSelectOneDo   = strCateSelectOne + strDo;
   
   public static final String strCateInsert        = "CateInsert";
   public static final String strCateInsertDo      = strCateInsert + strDo;
   public static final String strCateInsertResult  = strCateInsert + strResult;
   
   public static final String strCateUpdate        = "CateUpdate";
   public static final String strCateUpdateDo      = strCateUpdate + strDo;
   public static final String strCateUpdateResult  = strCateUpdate + strResult;
   
   public static final String strCateDelete        = "CateDelete";
   public static final String strCateDeleteDo      = strCateDelete + strDo;
   public static final String strCateDeleteResult  = strCateDelete + strResult;
   
   
   // 4. 상품 정보
   public static final String strProdSelectAll         = "ProdSelectAll";
   public static final String strProdSelectAllDo       = strProdSelectAll + strDo;

   public static final String strProdSelectOne         = "ProdSelectOne";
   public static final String strProdSelectOneDo       = strProdSelectOne + strDo;
   
   public static final String strProdInsert            = "ProdInsert";
   public static final String strProdInsertDo          = strProdInsert + strDo;
   public static final String strProdInsertResult      = strProdInsert + strResult;
   
   public static final String strProdUpdate            = "ProdUpdate";
   public static final String strProdUpdateDo          = strProdUpdate + strDo;
   public static final String strProdUpdateResult      = strProdUpdate + strResult;
   
   public static final String strProdDelete            = "ProdDelete";
   public static final String strProdDeleteDo          = strProdDelete + strDo;
   public static final String strProdDeleteResult      = strProdDelete + strResult;
   
   // 유저 쇼핑 화면
   public static final String strProdUserSelectAll = "ProdUserSelectAll";
   public static final String strProdUserSelectAllDo = strProdUserSelectAll + strDo; 
   
   public static final String strProdUserSelectOne = "ProdUserSelectOne";
   public static final String strProdUserSelectOneDo = strProdUserSelectOne + strDo;
   
   
   // 5. 상품 출고 히스토리(판매 History)
   public static final String strReleHistSelectAll    = "ReleHistSelectAll";
   public static final String strReleHistSelectAllDo  = strReleHistSelectAll + strDo;

   public static final String strReleHistSelectOne    = "ReleHistSelectOne";
   public static final String strReleHistSelectOneDo  = strReleHistSelectOne + strDo;
   
   public static final String strReleHistInsert       = "ReleHistInsert";
   public static final String strReleHistInsertDo     = strReleHistInsert + strDo;
   
   public static final String strReleHistUpdate       = "ReleHistUpdate";
   public static final String strReleHistUpdateDo     = strReleHistUpdate + strDo;

   public static final String strReleHistDelete       = "ReleHistDelete";
   public static final String strReleHistDeleteDo     = strReleHistDelete + strDo;
   
   public static final String strRelePayInsert        = "RelePayInsert";
   public static final String strRelePayInsertDo      = strRelePayInsert + strDo;
   public static final String strRelePayInsertResult  = strRelePayInsert + strResult;
   


   // 6. 장바구니(안 만들어도 됨)
   public static final String strBagSelectAll   = "BagSelectAll";
   public static final String strBagSelectAllDo = strBagSelectAll + strDo;

   public static final String strBagSelectOne   = "BagSelectOne";
   public static final String strBagSelectOneDo = strBagSelectOne + strDo;
   
   public static final String strBagInsert      = "BagInsert";
   public static final String strBagInsertDo    = strBagInsert + strDo;
   
   public static final String strBagUpdate      = "BagUpdate";
   public static final String strBagUpdateDo    = strBagUpdate + strDo;
   
   public static final String strBagDelete      = "BagDelete";
   public static final String strBagDeleteDo    = strBagDelete + strDo;
   
   public static final String strBagDeleteAll   = "BagDeleteAll";
   public static final String strBagDeleteAllDo = strBagDeleteAll + strDo;
   
   
   // 7. 결제 정보
   public static final String strPaySelectAll           = "PaySelectAll";
   public static final String strPaySelectAllDo         = strPaySelectAll + strDo;
   
   public static final String strPaySelectOne           = "PaySelectOne";
   public static final String strPaySelectOneDo         = strPaySelectOne + strDo;
   
   public static final String strPayInsert              = "PayInsert";
   public static final String strPayInsertDo            = strPayInsert + strDo;
   public static final String strPayInsertResult        = strPayInsert + strResult;
   
   public static final String strPayUpdate              = "PayUpdate";
   public static final String strPayUpdateDo            = strPayUpdate + strDo;
   public static final String strPayUpdateResult        = strPayUpdate + strResult;
   
   public static final String strPayDelete              = "PayDelete";
   public static final String strPayDeleteDo            = strPayDelete + strDo;
   public static final String strPayDeleteResult        = strPayDelete + strResult;

   public static final String strPayGetStatus           = "PayGetStatus";
   public static final String strPayGetStatusDo         = strPayGetStatus + strDo;
   public static final String strPayGetStatusResult     = strPayGetStatus + strResult;

   public static final String strPayUpdateStatus       = "PayUpdateStatus";
   public static final String strPayUpdateStatusDo     = strPayUpdateStatus + strDo;
   public static final String strPayUpdateStatusResult = strPayUpdateStatus + strResult;


   // 8. 후기 정보
   public static final String strRevuSelectAll   = "RevuSelectAll";
   public static final String strRevuSelectAllDo = strRevuSelectAll + strDo;

   public static final String strRevuSelectOne   = "RevuSelectOne";
   public static final String strRevuSelectOneDo = strRevuSelectOne + strDo;
   
   public static final String strRevuInsert      = "RevuInsert";
   public static final String strRevuInsertDo    = strRevuInsert + strDo;
   
   public static final String strRevuUpdate      = "RevuUpdate";
   public static final String strRevuUpdateDo    = strRevuUpdate + strDo;
   
   public static final String strRevuDelete      = "RevuDelete";
   public static final String strRevuDeleteDo    = strRevuDelete + strDo;
   
   
   // 9. 교환/환불 정보
   public static final String strExchSelectAll   = "ExchSelectAll";
   public static final String strExchSelectAllDo = strExchSelectAll + strDo;
   
   public static final String strExchSelectOne   = "ExchSelectOne";
   public static final String strExchSelectOneDo = strExchSelectOne + strDo;

   public static final String strExchInsert       = "ExchInsert";
   public static final String strExchInsertDo     = strExchInsert + strDo;
   public static final String strExchInsertResult = strExchInsert + strResult;
   
   public static final String strExchUpdate       = "ExchUpdate";
   public static final String strExchUpdateDo     = strExchUpdate + strDo;
   public static final String strExchUpdateResult = strExchUpdate + strResult;

   public static final String strExchDelete       = "ExchDelete";
   public static final String strExchDeleteDo     = strExchDelete + strDo;
   public static final String strExchDeleteResult = strExchDelete + strResult;
}
