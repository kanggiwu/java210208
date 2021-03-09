package com.pattern;

import java.util.Vector;

import com.vo.DeptVO;
import com.vo.EmpVO;

public class SalaryMgrLogic {//데이터를 관리하고 처리하는 클래스
   SalaryMgrView smView = null;
   public SalaryMgrLogic(SalaryMgrView salaryMgrView) {
      this.smView = salaryMgrView;
   }

public void getEmpDetail(int pempno) {
      EmpVO  eVO  = new EmpVO();
      eVO.setEname("김유신");
      DeptVO dVO  = new DeptVO();
      dVO.setDname("형상관리팀");
      eVO.setdVO(dVO);//issue
      Vector oneRow = new Vector();
      oneRow.addElement(eVO.getEname());
      oneRow.addElement(eVO.getdVO().getDname());
      smView.dtm_sal.addRow(oneRow);   //View의 DefaultTableModel에 해당 데이터를 넘겨준다.
   }
}