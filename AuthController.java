package jp.co.internous.sunflower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import jp.co.internous.sunflower.model.domain.MstUser;
import jp.co.internous.sunflower.model.form.UserForm;
import jp.co.internous.sunflower.model.mapper.MstUserMapper;
import jp.co.internous.sunflower.model.mapper.TblCartMapper;
import jp.co.internous.sunflower.model.session.LoginSession;


/**
 * 認証に関する処理を行うコントローラー
 * @author インターノウス
 *
 */
@RestController
@RequestMapping("/sunflower/auth")
public class AuthController {
	
	/*
	 * フィールド定義
	 */
	@Autowired
	private TblCartMapper cartMapper;
	@Autowired
	private MstUserMapper userMapper;
	@Autowired
	private LoginSession loginSession;
	// JSON形式でクライアント側に情報を送るためのインスタンス作成
	private Gson gson = new Gson();
	
	/**
	 * ログイン処理をおこなう
	 * @param f ユーザーフォーム
	 * @return ログインしたユーザー情報(JSON形式)
	 */
	@ResponseBody
	@PostMapping("/login")
	public String login(@RequestBody UserForm f) {
		
		// DBから登録情報の引き出し
		MstUser user = userMapper.findByUserNameAndPassword(f.getUserName(), f.getPassword());
		// 仮IDでカート追加されていれば、本ユーザーIDに更新する。
		int tmpUserId = loginSession.getTmpUserId();
		if (user != null && tmpUserId != 0) {
			int count = cartMapper.findCountByUserId(tmpUserId);
			if (count > 0) {
				cartMapper.updateUserId(user.getId(), tmpUserId);
			}
		}
		
		// DBにユーザー情報が登録されているかの判別(該当するユーザー名とパスワードがあるか)
		if(user != null) {
			//認証成功時のログインセッション情報の内容変更
			loginSession.setUserId(user.getId());
			loginSession.setTmpUserId(0);
			loginSession.setUserName(user.getUserName());
			loginSession.setPassword(user.getPassword());
			loginSession.setLogined(true);
		}else {
			// 認証失敗時のログインセッション情報の内容変更
			loginSession.setUserId(0);
			loginSession.setUserName(null);
			loginSession.setPassword(null);
			loginSession.setLogined(false);
		}
		// JavaScriptにログインセッション情報の提供
		return gson.toJson(user);
		
	}
	
	/**
	 * ログアウト処理をおこなう
	 * @return 空文字
	 */
	@ResponseBody
	@PostMapping("/logout")
	public String logout() {
		
		// ログアウト時のログインセッション情報の変更
		loginSession.setUserId(0);
		loginSession.setTmpUserId(0);
		loginSession.setUserName(null);
		loginSession.setPassword(null);
		loginSession.setLogined(false);
		// JavaScriptにログインセッション情報の提供
		return "";
		
	}

	/**
	 * パスワード再設定をおこなう
	 * @param f ユーザーフォーム
	 * @return 処理後のメッセージ
	 */
	@ResponseBody
	@PostMapping("/resetPassword")
	public String resetPassword(@RequestBody UserForm f) {
		
		// ユーザーのパスワード情報の確認と新パスワードのチェック
		String newPassword = f.getNewPassword();
		MstUser user = userMapper.findByUserNameAndPassword(f.getUserName(), f.getPassword());
		if (user == null) {
			return "現在のパスワードが正しくありません。";
		}
		if (user.getPassword().equals(newPassword)) {
			return "現在のパスワードと同一文字列が入力されました。";
		}
		// mst_userとloginSessionのパスワードを更新する
		userMapper.updatePassword(user.getUserName(), f.getNewPassword());
		loginSession.setPassword(f.getNewPassword());
		// 更新後のメッセージを送信
		return "パスワードが再設定されました。";
		
	}
	
}
