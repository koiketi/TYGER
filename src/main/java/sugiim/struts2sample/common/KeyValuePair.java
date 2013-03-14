package sugiim.struts2sample.common;

import java.io.Serializable;

/**
 * KeyValue定義用クラス
 *
 * @author 杉井
 *
 */
public class KeyValuePair implements Serializable {

	/**
	 * シリアル値
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * キー
	 */
	private Integer key;

	/**
	 * 値
	 */
	private String Value;

	/**
	 * keyを取得する
	 *
	 * @return key
	 */
	public Integer getKey() {
		return key;
	}

	/**
	 * keyを設定する
	 *
	 * @param key
	 *            key
	 */
	public void setKey(Integer key) {
		this.key = key;
	}

	/**
	 * valueを取得する
	 *
	 * @return value
	 */
	public String getValue() {
		return Value;
	}

	/**
	 * valueを設定する
	 *
	 * @param value
	 *            value
	 */
	public void setValue(String value) {
		Value = value;
	}

	/**
	 * コンストラクタ
	 *
	 * @param key
	 *            key
	 * @param value
	 *            value
	 */
	public KeyValuePair(Integer key, String value) {
		super();
		this.key = key;
		Value = value;
	}
}
