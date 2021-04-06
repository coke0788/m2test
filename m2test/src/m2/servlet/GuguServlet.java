//model에서 값을 가져와서 view로 요청하는ㄴ controller 
package m2.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import m2.model2.GuguService;

@WebServlet("/mvc/gugu")
public class GuguServlet extends HttpServlet {
	//request 와 response는 매개변수로 자동으로 들어오기 때문에 jsp 파일에서 reguest.getParameter와 responseredirect를 사용할 수 있음.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Integer 클래스의 parseInt 메서드 실행. request의 getparameter 메서드 실행.(String 타입의 값을 요청.) -> int는 값 타입, String은 참조타입으로 Integer로 String 박싱 후 int 타입으로 언박싱해서 값 타입으로 변경 시켜줌.
		// 요청 분석
		int dan = Integer.parseInt(request.getParameter("dan"));
		System.out.println("dan"+dan);
		
		//GuguService의 생성자 선언.
		//요청 처리 요구
		GuguService service = new GuguService();
		ArrayList<String> list = service.getGugudanList(dan);
		
		//출력을 위임(요청과 응답을 포워딩 + 모델 값 list) : jsp는 출력만 담당.
		//getRequestDispatcher << 위임할 수 있는 메서드
		//list도 위임해야하는데 forward메서드에 공간이 없으므로 request안에 list를 포함시킨다.
		request.setAttribute("list", list); // 넣을 때는 object(모든 참조타입이 들어갈 수 있음)를 넣을 수 있지만, 다시 빼올 때는 ArrayList로 형변환을 해야함.
		RequestDispatcher rd = request.getRequestDispatcher("/gugu2.jsp");
		//rd의 response와 request를 위임할 것이다. 위의 경로로.
		rd.forward(request, response);
	}

}
