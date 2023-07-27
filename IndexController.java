package jp.co.internous.sunflower.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.sunflower.model.domain.MstCategory;
import jp.co.internous.sunflower.model.domain.MstProduct;
import jp.co.internous.sunflower.model.form.SearchForm;
import jp.co.internous.sunflower.model.mapper.MstCategoryMapper;
import jp.co.internous.sunflower.model.mapper.MstProductMapper;
import jp.co.internous.sunflower.model.session.LoginSession;

/**
 * 商品検索に関する処理を行うコントローラー
 * @author インターノウス
 *
 */
@Controller
@RequestMapping("/sunflower")
public class IndexController {
	
	/*
	 * フィールド定義
	 */
	// 使用するMapperクラスのインスタンス化
	@Autowired
	private MstCategoryMapper categoryMapper;
	@Autowired
	private MstProductMapper productMapper;
	// sessionクラスのインスタンス化
	@Autowired
	private LoginSession loginSession;
	
	/**
	 * トップページを初期表示する。
	 * @param m 画面表示用オブジェクト
	 * @return トップページ
	 */
	@RequestMapping("/")
	public String index(Model m) {
		
		// 未ログイン時かつ仮ユーザIDを保持していない(0)状態かどうかの判定
		boolean logined = false;
		int tmpUserId = loginSession.getTmpUserId();
		if ( logined == loginSession.isLogined() && tmpUserId == 0) {
			// 9桁のランダムな整数を作成
			Random random = new Random();
			int r;
			do {
				r = random.nextInt(1000000000);
			} while (r < 100000000);// 8桁以下はループ
			// 生成した仮ユーザーIDをsessionへ登録(負の整数になるように調整)
			loginSession.setTmpUserId(-r);
		}
		// トップページのカテゴリーの表示
		List<MstCategory> categories = categoryMapper.find();
		// トップページの初期状態の設定(検索商品すべて表示)
		List<MstProduct> products = productMapper.find();
		// htmlに全商品情報を提供
		m.addAttribute("products", products);
		// htmlに全カテゴリー情報を提供
		m.addAttribute("categories", categories);
		// プルダウンの初期値を設定
		m.addAttribute("selected", 0);
		// page_header.htmlでsessionの変数を表示させているため、loginSessionも画面に送る。
		m.addAttribute("loginSession", loginSession);
		// トップページ画面(index.html)へ遷移
		return "index";
		
	}
	
	/**
	 * 検索処理を行う
	 * @param f 検索用フォーム
	 * @param m 画面表示用オブジェクト
	 * @return トップページ
	 */
	@RequestMapping("/searchItem")
	public String searchItem(SearchForm f, Model m) {
		
		// 商品リストの作成
		List<MstProduct> products = null; 
		// 検索文字とカテゴリーIDによる判別用にローカル変数で格納
		String keyword = f.getKeywords();
		int category = f.getCategory();
		
		/**
		 * 検索文字の修正作業
		 * 1 全角スペースを半角スペースに変換
		 */
		keyword = keyword.replace("　", " ");
		// 2.空白が二つ以上の時一つに変換
		keyword = keyword.replaceAll("\\s+"," ");
		// 3.前後の空白削除
		keyword = keyword.trim();
		// 4.配列型に変更
		String[] keywords = keyword.split(" ");
		
		/**
		 * 検索情報から商品データの抽出
		 */ 
		if (category != 0) {
			// カテゴリーIDが選択されている場合、該当するカテゴリー上で商品情報表示
			products = productMapper.findByCategoryAndProductName(category, keywords);
		} else if (keyword != "" && category == 0) {
			// 検索文字が空文字ではないが、カテゴリーIDが選択されていない場合キーワードに一致する商品情報表示
			products = productMapper.findByProductName(keywords);
		} else {
			// 検索文字が空文字で、かつカテゴリーIDが選択されていない場合、全商品情報表示
			products = productMapper.find();
		}
		// トップページのカテゴリーの表示
		List<MstCategory> categories = categoryMapper.find();
		// htmlに検索条件をもとに商品情報を提供
		m.addAttribute("products", products);
		// htmlにカテゴリー情報を提供
		m.addAttribute("categories", categories);
		// htmlに修正したキーワードを提供
		m.addAttribute("keywords", keyword);
		// 検索時にカテゴリーが反映されるようにカテゴリー情報を提供
		m.addAttribute("selected", f.getCategory()); 
		// page_header.htmlでsessionの変数を表示させているため、loginSessionも画面に送る。
		m.addAttribute("loginSession", loginSession);
		// トップページ画面(index.html)へ遷移
		return "index";
		
	}
	
}
