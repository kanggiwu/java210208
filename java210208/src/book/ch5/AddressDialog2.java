package book.ch5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.vo.DeptVO;

public class AddressDialog2 extends JDialog implements	ActionListener{
	
	//StringBUffer///멀티스레드(한정된 자원을 여러사람이 공유)에 안전 속도느림
	//Stringbuilder//싱글스레드에 안전
	
	JScrollPane		jsp				=	new	JScrollPane();
	JMenuItem 		jmi_dbTest		=	new	JMenuItem("오라클 연결");
	JPanel			jp_center		=	new	JPanel();
	JPanel			jp_south		=	new	JPanel();
	//화면을 처리할 떄 해당 옵션을 두 가지로 설정가능함 - setter getter형식으로 코딩해 보기
	JLabel			jlb_deptno   	= 	new JLabel("부서번호");
	JTextField    	jtf_deptno    	= 	new JTextField();
	JLabel       	jlb_dname    	=	new JLabel("부서이름");
	JTextField    	jtf_dname    	= 	new JTextField();
	JLabel       	jlb_loc     	= 	new JLabel("지역");
	JTextField    	jtf_loc    		= 	new JTextField(); 
	JButton			jbtn_account	=	new	JButton("처리");
	JButton			jbtn_close		=	new	JButton("닫기");
	DeptVO 			dVO				= 	null;
	static	AddressBook2	aBook	=	null;
	String			title			=	null;
	public	AddressDialog2() {
		initDisplay();
	}
	public void initDisplay() {
		JFrame jf = new JFrame();
	    jp_center.setLayout(null);
	    jlb_deptno.setBounds(20, 20, 100, 20);
	    jtf_deptno.setBounds(130, 20, 100, 20);
	    jp_center.add(jlb_deptno);
	    jp_center.add(jtf_deptno);
	    jsp = new JScrollPane(jp_center);
	    jlb_deptno.setBounds(20, 20, 100, 20);
	    jtf_deptno.setBounds(130, 20, 100, 20);
	    jlb_dname.setBounds(20, 45, 100, 20);
	    jtf_dname.setBounds(130, 45, 150, 20);
	    jlb_loc.setBounds(20, 70, 100, 20);
	    jtf_loc.setBounds(130, 70, 150, 20);
	    jp_center.add(jlb_deptno);
	    jp_center.add(jtf_deptno);
	    jp_center.add(jlb_dname);
	    jp_center.add(jtf_dname);
	    jp_center.add(jlb_loc);
	    jp_center.add(jtf_loc);
	    jsp = new JScrollPane(jp_center);
	    jf.setSize(500,700);
	    jf.setVisible(true);

		jbtn_account.addActionListener(this);
		jbtn_close.addActionListener(this);
		jp_south.add(jbtn_account);
		jp_south.add(jbtn_close);
		this.add("Center",jsp);
		this.add("South",jp_south);
		this.setTitle(title);
		this.setSize(400,500);
		this.setVisible(false);//버튼을 눌릴때 이벤트 처리에서 보이도록 함(Addressbook클래스)
	}
	/*******************************************
	 * 
	 * @param dVO 
	 * @param string 사용자가 선택한 요청에 대한 제목을 정함.
	 * @param aBook 부모창에서 화면처리에 대한 원본주소번지가 필요함
	 * 입력일때는 새창을 열어서 입력 받아야 함.-writeable
	 * 수정일 때는 오라클을 경유한 후 그 결과를 화면에 출력해 놓고 수정할 정보만 새로 입력을 받는다.writeable
	 * 상세조회일 때, 오라클을 경유하여 한 건만 출력을 해야 함--readonly
	 * 수정과 상세조회 하나로 묶고 입력을 하나로 묶어 처리
	 * 오라클을 경유했을 때 VO를 유지해야함
	 * 그 값을 가진 주소번지를 부모창에서 받아서 자식창의 이벤트 처리 메소드인
	 * actionPerformed에서 재사용해야 하므로 전역변수로 선언한 다음 지변과 초기화를 하여 사용하기로 한다.
	 * 
	 ********************************************/
	//////////////////////////////////[[1부모창에서 set메소드를 호출]]////////////////////////////////////////
	public void set(String title, DeptVO dVO, AddressBook2 aBook, boolean isFlag) {
		////////////자식창은 입력,세부정보조회,수정을 하는 역할을 한다. 이를 위한 정보들을 초기화해준다.
		this.aBook	=	aBook;	//부모창이 누구인지 확인(전변)
		this.setTitle(title);	//업무처리 내용(지변)-static(X) 이유: 내용이 바뀌는 부분
		this.dVO	=	dVO;	//어떤 VO를 쓰는지 불러옴(전변)

		//입력모드|수정모드|상세조회모드를 설정	true이면 수정가능 false이면 수정 불가능
		this.setEnabled(isFlag);//입력받는 JTextField클래스에 대한 상태값을 조정하기-메소드 중심의 코딩으로 일괄처리
		//각 기능별로 텍스트필드에 값을 설정해준다. 입력의 경우 빈값, 상세조회와 수정의 경우는 해당 기능을 수행할 값을 넣어준다.
		this.setValue(this.dVO);//클래스 전체에서 공유되는 값이 되는것이다.

	
	}

	//텍스트필드에 값을 입력하기 위해 사용하는 메소드,,
	private void setValue(DeptVO dVO) {
		//입력을 위한 윈도우(Dialog창) 설정	-	모든 값을 null로 셋팅합니다.
		//aDia.set("입력",null,aBook,true);
		if(dVO	==	null) {
			setJtf_deptno("");
			setJtf_dname("");
			setJtf_loc("");
		}
		//상세조회, 수정 시에는 오라클에서 조회된 값으로 초기화해야한다.
		//setJtf 함수를 이용해서 전역변수로 선언된 해당 텍스트필드들에게 텍스트값을 넣어준다. 
		else {
			setJtf_deptno(String.valueOf(dVO.getDeptno()));
			setJtf_dname(dVO.getDname());
			setJtf_loc(dVO.getLoc());
		}
		
		
		
	}
	//set메소드를 통해서 넘어온 4번째 값에 따라서 화면을 처리하는 컴포넌트 클래스의 수정 모드에 대한 설정을 바꾸어 줍니다,
	//만일 true이면 setEnabled(true)로 설정하고
	//만일 false이면 setEabled(false)로 설정하여 수정할 수 없도록 할 계획입니다.
	public void setEnabled(boolean isFlag) {
		jtf_deptno.setEnabled(isFlag);
		jtf_dname.setEnabled(isFlag);
		jtf_loc.setEnabled(isFlag);
	}
	//setter/getter처리해보기
	///////////////////////////////////////[[화면처리에 대한 setter와 getter 구현시작]]/////////////////////////////////////////
	//Text필드에 정보를 불러오려면 필요하겠구나
	public String getJtf_deptno() {
		return jtf_deptno.getText();
	}
	public void setJtf_deptno(String deptno) {
		this.jtf_deptno.setText(deptno);//int값을 String으로 바꿔줄 수 있다.
	}
	public String getJtf_dname() {
		return jtf_dname.getText();
	}
	public void setJtf_dname(String dname) {
		this.jtf_dname.setText(dname);
	}
	public String getJtf_loc() {
		return jtf_loc.getText();
	}
	public void setJtf_loc(String loc) {
		this.jtf_loc.setText(loc);
	}
	
	
	///////////////////////////////////////[[화면처리에 대한 setter와 getter 구현 끝]]/////////////////////////////////////////
	@Override
	public void actionPerformed(ActionEvent e) {
		//처리버튼을 눌렀을 때
		//입력을 처리, 수정을 처리
		//목적지가 다시 부모창의 목록페이지로 돌아가서 새로고침이 일어남.
		//부모창의 주번이 있어야 새로고침을 처리하는 메소드를 호출가능함.
		String command	=	e.getActionCommand();
		if("처리".equals(command)){
			//입력 혹은 수정처리
			if(dVO == null) {//입력일 떄
				DeptVO pdVO	= new DeptVO();
				pdVO.setDeptno(Integer.parseInt(getJtf_deptno()));//NumberFormatException
				pdVO.setDname(getJtf_dname());//NumberFormatException
				pdVO.setLoc(getJtf_loc());//NumberFormatException
				
			}else {//수정일 떄
				DeptVO pdVO	= new DeptVO();
				pdVO.setDeptno(Integer.parseInt(getJtf_deptno()));//NumberFormatException+858
				pdVO.setDname(getJtf_dname());//NumberFormatException
				pdVO.setLoc(getJtf_loc());//NumberFormatException
			}
				
			aBook.refresh();//자녀창에서 부모창의 refresh()를 불러올 수 있어야한다.
		}else if("닫기".contentEquals(command)) {
			this.dispose();
		}
		//닫기 버튼을 눌렀을 때
	}
	/* public static void main(String[] args) {
		 AddressDialog2 ad2 = new AddressDialog2();//화면 그리는 단위테스트,,setVisable(true);
		 ad2.title = "상세";
		 ad2.set(ad2.title, ad2.dVO, aBook, false);
		 ad2.initDisplay();//해당함수에서 setVisiable(false)가 있기 때문에 setVisible은 이 함수 다음에 와야한다.
	     ad2.setVisible(true);//인스턴스화를 해서 해당 함수를  true로 바꿔줘야한다.(static이 아니기 때문에)
		 //this.setVisiable(true);//static으로 정의된 메소드라면 이렇게 해당 함수부분을 불러올 수 있다. 
	  }*/
	
}
