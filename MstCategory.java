
package jp.co.internous.sunflower.model.domain;

import java.sql.Timestamp;

/**
 * mst_categoryのドメイン
 * @author インターノウス
 *
 */
public class MstCategory {
	
	// mst_categoryテーブルのカラム列の作成；
	private int id;
	private String categoryName;
	private String categoryDescription;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	// idの設定と取得
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	// categoryNameの設定と取得
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	// categoryDescriptionの設定と取得
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	// createdAtの設定と取得
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	// updateAtの設定と取得
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
