// ���ڴ洢HTTPͷ���������ִ������ʱ��Ҫ�Ĳ���
// ����HTTPͷ����HeaderField=FieldName:FieldValue
package http;

import java.util.Map;
import java.util.TreeMap;

public abstract class Fields {
	Map<String, String> fields = new TreeMap<String, String>();
	// ����һ��ͷ����
	public void addFieldValue(String fieldName, String value) {
		if (validateFieldValue(fieldName, value))
			fields.put(fieldName, value);
	}
	// ���һ��ͷ�����ֵ
	public String getValue(String fieldName) {
		return fields.get(fieldName);
	}
	// У��һ��ͷ������ֵ�Ƿ�Ϸ�
	protected abstract boolean validateFieldValue(String fieldName, String value);
}
