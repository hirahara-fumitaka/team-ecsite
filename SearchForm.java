package jp.co.internous.sunflower.model.form;

import java.io.Serializable;

/**
 * 検索フォーム
 * @author インターノウス
 *
 */
public class SearchForm  implements Serializable{
	
	// シリアライズversionの設定
	private static final long serialVersionUID = 1L;
	// htmlからの検索情報項目の作成
	private int category;
	private String keywords;
	
	// category(categoryテーブルの商品ID)の設定と取得
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	// keywords(検索時の入力されたキーワード)の設定と取得
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
}
