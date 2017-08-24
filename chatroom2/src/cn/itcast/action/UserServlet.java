package cn.itcast.action;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.service.UserService;
import cn.itcast.utils.BaseServlet;
import cn.itcast.vo.User;

public class UserServlet extends BaseServlet {
	/**
	 * 妫�煡session鏄惁杩囨湡
	 * @throws IOException 
	 */
	public String check(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		// 浠巗ession涓幏寰楃敤鎴风殑淇℃伅
		User existUser = (User) req.getSession().getAttribute("existUser");
		// 鍒ゆ柇session涓殑鐢ㄦ埛鏄惁杩囨湡
		if(existUser == null){
			// 鐧诲綍鐨勪俊鎭凡缁忚繃鏈熶簡!
			resp.getWriter().println("1");
		}else{
			// 鐧诲綍鐨勪俊鎭病鏈夎繃鏈�
			resp.getWriter().println("2");
		}
		return null;
	}
	
	/**
	 *  閫�嚭鑱婂ぉ瀹�
	 * @throws IOException 
	 */
	public String exit(HttpServletRequest request,HttpServletResponse response) throws IOException{
		// 鑾峰緱session瀵硅薄
		HttpSession session = request.getSession();
		// 灏唖ession閿�瘉.
		session.invalidate();
		// 椤甸潰杞悜.
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		return null;
	}
	
	/**
	 * 鍙戦�鑱婂ぉ鍐呭
	 * @throws IOException 
	 */
	public String sendMessage(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		// 1.鎺ユ敹鏁版嵁 銆�
		System.out.println("sendMessage invoke....");
		String from = req.getParameter("from"); // 鍙戣█浜�
		String face = req.getParameter("face"); // 琛ㄦ儏
		String to = req.getParameter("to"); // 鎺ユ敹鑰�
		String color = req.getParameter("color"); // 瀛椾綋棰滆壊
		String content = req.getParameter("content"); // 鍙戣█鍐呭
		// 鍙戣█鏃堕棿 姝ｅ父鎯呭喌涓嬩娇鐢⊿impleDateFormat
		String sendTime = new Date().toLocaleString(); // 鍙戣█鏃堕棿
		// 鑾峰緱ServletContext瀵硅薄.
		ServletContext application = getServletContext();
		//  浠嶴ervletContext涓幏鍙栨秷鎭�
		String sourceMessage = (String) application.getAttribute("message");
		// 鎷兼帴鍙戣█鐨勫唴瀹�xx 瀵�yy 璇�xxx
		sourceMessage += "<font color='blue'><strong>" + from
				+ "</strong></font><font color='#CC0000'>" + face
				+ "</font>瀵�font color='green'>[" + to + "]</font>璇达細"
				+ "<font color='" + color + "'>" + content + "</font>锛�"
				+ sendTime + "锛�br>";
		// 灏嗘秷鎭瓨鍏ュ埌application鐨勮寖鍥�
		application.setAttribute("message", sourceMessage);
		return getMessage(req, resp);
	}
	
	/**
	 * 鑾峰彇娑堟伅鐨勬柟娉�
	 * @throws IOException 
	 */
	public String getMessage(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String message = (String) getServletContext().getAttribute("message");
		if(message != null){
			resp.getWriter().println(message);
		}
		return null;
	}
	/**
	 * 韪汉鐨勫姛鑳�
	 * @throws IOException 
	 */
	public String kick(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		// 1.鎺ユ敹鍙傛暟
		int id = Integer.parseInt(req.getParameter("id"));
		// 2.韪汉:浠巙serMap涓皢鐢ㄦ埛瀵瑰簲鐨剆ession閿�瘉.
		// 鑾峰緱userMap闆嗗悎(鍦ㄧ嚎鍒楄〃)
		Map<User, HttpSession> userMap = (Map<User, HttpSession>) getServletContext()
				.getAttribute("userMap");
		// 鑾峰緱杩欎釜鐢ㄦ埛瀵瑰簲鐨剆ession.濡備綍鐭ラ亾鏄摢涓敤鎴峰憿? id宸茬粡浼犻�杩囨潵.鍘绘暟鎹簱涓煡璇�
		// 閲嶅啓user鐨別quals 鍜�hashCode 鏂规硶 閭ｄ箞鍙鐢ㄦ埛鐨刬d鐩稿悓灏辫涓烘槸鍚屼竴涓敤鎴�
		User user = new User();
		user.setId(id);
		// 浠巑ap闆嗗悎涓幏寰楃敤鎴风殑瀵瑰簲鐨剆ession 
		HttpSession session = userMap.get(user);
		// 閿�瘉session
		session.invalidate();
		// 閲嶅畾鍚戝埌椤甸潰
		resp.sendRedirect(req.getContextPath()+"/main.jsp");
		return null;
	}
	
	/**
	 * 鐧诲綍鐨勫姛鑳�
	 */
	public String login(HttpServletRequest req,HttpServletResponse resp){
		// 鎺ユ敹鏁版嵁
		Map<String, String[]> map = req.getParameterMap();
		User user = new User();
		// 灏佽鏁版嵁
		try {
			BeanUtils.populate(user, map);
			// 璋冪敤Service灞傚鐞嗘暟鎹�
			UserService us = new UserService();
			User existUser = us.login(user);
			if (existUser == null) {
				// 鐢ㄦ埛鐧诲綍澶辫触
				req.setAttribute("msg", "鐢ㄦ埛鍚嶆垨瀵嗙爜閿欒!");
				return "/index.jsp";
			} else {
				// 鐢ㄦ埛鐧诲綍鎴愬姛
				// 绗竴涓狟UG鐨勮В鍐�绗簩涓敤鎴风櫥褰曞悗灏嗕箣鍓嶇殑session閿�瘉!
				req.getSession().invalidate();
				
				// 绗簩涓狟UG鐨勮В鍐�鍒ゆ柇鐢ㄦ埛鏄惁宸茬粡鍦∕ap闆嗗悎涓�瀛樺湪锛氬凡缁忓湪鍒楄〃涓�閿�瘉鍏秙ession.
				// 鑾峰緱鍒癝ervletCOntext涓瓨鐨凪ap闆嗗悎.
				Map<User, HttpSession> userMap = (Map<User, HttpSession>) getServletContext()
						.getAttribute("userMap");
				// 鍒ゆ柇鐢ㄦ埛鏄惁宸茬粡鍦╩ap闆嗗悎涓�
				if(userMap.containsKey(existUser)){
					// 璇寸敤map涓湁杩欎釜鐢ㄦ埛.
					HttpSession session = userMap.get(existUser);
					// 灏嗚繖涓猻ession閿�瘉.
					session.invalidate();
				}
				
				// 浣跨敤鐩戝惉鍣�HttpSessionBandingListener浣滅敤鍦↗avaBean涓婄殑鐩戝惉鍣�
				req.getSession().setAttribute("existUser", existUser);
				ServletContext application = getServletContext();

				String sourceMessage = "";

				if (null != application.getAttribute("message")) {
					sourceMessage = application.getAttribute("message")
							.toString();
				}

				sourceMessage += "绯荤粺鍏憡锛�font color='gray'>"
						+ existUser.getUsername() + "璧拌繘浜嗚亰澶╁锛�/font><br>";
				application.setAttribute("message", sourceMessage);

				resp.sendRedirect(req.getContextPath() + "/main.jsp");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}

}
