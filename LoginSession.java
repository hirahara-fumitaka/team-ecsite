package jp.co.internous.sunflower.model.session;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * ログインセッション
 * @author インターノウス
 * @ Componentで自動生成インスタンス機能追加
 * @ ScopeでSession機能追加
 */
@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class LoginSession implements Serializable {
	
	// シリアライズversionの設定
	private static final long serialVersionUID = -4505629762363906244L;
	// session情報の作成
	private int userId;
	private int tmpUserId;
	private String userName;
	private String password;
	private boolean logined;
	
	/*
	 * 以下にGetter / Setter メソッドを作成
	 */
	// userId(ユーザーID)の設定と取得
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	// tempUserId(仮ユーザーID)の設定と取得
	public int getTmpUserId() {
		return tmpUserId;
	}
	public void setTmpUserId(int tmpUserId) {
		this.tmpUserId = tmpUserId;
	}
	// userName(ユーザー名)の取得と設定
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	// password(パスワード)の取得と設定
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	// Logined(ユーザー登録済みのアカウントの判定)の取得と設定
	public boolean isLogined() {
		return logined;
	}
	public void setLogined(boolean logined) {
		this.logined = logined;
	}
	
}
