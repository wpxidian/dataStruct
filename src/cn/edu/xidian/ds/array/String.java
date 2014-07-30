package cn.edu.xidian.ds.array;

import java.util.Arrays;
/**
 * 
 * �����ƣ�String   
 * ��������Ĭ��String��ʵ��   
 * �����ˣ�WangPeng  
 * ����ʱ�䣺2014-7-29 ����11:32:08   
 * �޸��ˣ�WangPeng   
 * �޸�ʱ�䣺2014-7-29 ����11:32:08   
 * �޸ı�ע��   
 * @version 1.0   
 *
 */
class String implements java.io.Serializable,Comparable<String>,CharSequence{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3806675484850399143L;
	private final char[] value ;
	private int hash ;
	/** �޲ι����� */
	public String(){
		value = new char[0] ;
	}
	/**
	 * 
	 * @param original
	 */
	public String(String original){
		this.value = original.value ;
		this.hash = original.hash ;
	}
	/**
	 * 
	 * @param value
	 */
	public String(char[] value){
		this.value = Arrays.copyOf(value, value.length) ;
	}
	/**
	 * 
	 * @param value
	 * @param offset
	 * @param count
	 */
	public String(char value[], int offset, int count){
		if (offset < 0) {
            throw new StringIndexOutOfBoundsException(offset);
        }
        if (count < 0) {
            throw new StringIndexOutOfBoundsException(count);
        }
        // Note: offset or count might be near -1>>>1.
        if (offset > value.length - count) {
            throw new StringIndexOutOfBoundsException(offset + count);
        }
        this.value = Arrays.copyOfRange(value, offset, offset+count);
	}
	/**
	 * �ַ����Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return value.length == 0 ;
	}
	/**
	 * �����ַ�������
	 */
	@Override
	public int length() {
		return value.length;
	}
	/**
	 * �Ƚ������ַ����Ĵ�С
	 */
	@Override
	public int compareTo(String anotherString) {
		char[] v1 = this.value ;
		char[] v2 = anotherString.value ;
		int minLen = Math.min(v1.length, v2.length) ;
		for(int i=0;i<minLen;i++){
			if(v1[i]!=v2[i]){
				return v1[i] - v2[i] ;
			}
		}
		return v1.length - v2.length ;
	}
	/**
	 * ����ָ�����������ַ�
	 */
	@Override
	public char charAt(int index) {
		if(index<0 || index >= value.length){
			throw new ArrayIndexOutOfBoundsException("Size:" + value.length + "Index:" + index) ;
		}
		return value[index];
	}
	/**
	 * ���������ַ���
	 * @param anotherString
	 * @return
	 */
	public String concat(String anotherString){
		if(anotherString == null || anotherString.isEmpty()){
			return this ;
		}
		char[] v1 = this.value ;
		char[] v2 = anotherString.value ;
		int len1 = v1.length ;
		int len2 = v2.length ;
		char[] v3 = new char[len1 + len2] ;
		System.arraycopy(v1, 0, v3, 0, len1) ;
		System.arraycopy(v2, 0, v3, len1, len2) ;
		return new String(v3) ;
	}
	/**
	 * ����ָ���ַ����ַ����е�����,�ӵ�fromIndex��������ʼ������
	 * @param ch
	 * @param fromIndex
	 * @return
	 */
	public int indexOf(char ch, int fromIndex){
		final int max = this.value.length ;
		if(fromIndex<0){
			fromIndex = 0 ;
		}else if(fromIndex>=max){
			return -1 ;
		}
		final char[] value = this.value ;
		for(int i=fromIndex;i<max;i++){
			if(value[i] == ch){
				return i ;
			}
		}
		return -1 ;
	}
	/**
	 * ����ָ���ַ����ַ����е��������ӵ�0��������ʼ������
	 * @param ch
	 * @return
	 */
	public int indexOf(char ch){
		return indexOf(ch,0) ;
	}
	/**
	 * ����ָ���ַ����ַ����е�����,�ӵ�fromIndex��������ʼ��ǰ����
	 * @param ch
	 * @param fromIndex
	 * @return
	 */
	public int lastIndexOf(char ch,int fromIndex){
		final int max = this.value.length ;
		if(fromIndex>=max){
			fromIndex = max - 1 ;
		}else if(fromIndex<0){
			return -1 ;
		}
		final char[] value = this.value ;
		for(int i=fromIndex;i>=0;i--){
			if(value[i] == ch){
				return i ;
			}
		}
		return -1 ;
	}
	/**
	 * ����ָ���ַ����ַ����е�����,�ӵ�0��������ʼ��ǰ����
	 * @param ch
	 * @return
	 */
	public int lastIndexOf(char ch){
		return lastIndexOf(ch,value.length-1) ;
	}
	/**
	 * �ж������ַ����Ƿ����
	 */
	@Override
	public boolean equals(Object obj){
		if(obj == this){
			return true ;
		}else{
			if(obj.getClass() == String.class){
				String anotherString = (String)obj ;
				char[] v1 = this.value ;
				char[] v2 = anotherString.value ;
				int len1 = v1.length ;
				int len2 = v2.length ;
				if(len1 != len2){
					return false ;
				}else{
					for(int i=0;i<len1;i++){
						if(v1[i] != v2[i]){
							return false ;
						}
					}
					return true ;
				}
			}
			return false ;
		}
	}
	/**
	 * ��ָ��λ�ÿ�ʼ�����ַ������ж����ַ����Ƿ���ǰ׺prefix��ʼ
	 * @param prefix
	 * @param offset
	 * @return
	 */
	public boolean startsWith(String prefix,int offset){
		char[] v1 = this.value ;
		char[] v2 = prefix.value ;
		int len1 = v1.length ;
		int len2 = v2.length ;
		if(offset<0 || offset>len1-len2){
			return false ;
		}
		int i = offset ;
		int j = 0 ;
		while(i<len1 && j<len2){
			if(v1[i++] != v2[j++]){
				return false ;
			}
		}
		return true ;
	}
	/**
	 * ��0��ʼ�����ַ������ж����ַ����Ƿ���ǰ׺prefix��ʼ
	 * @param prefix
	 * @return
	 */
	public boolean startsWith(String prefix){
		return startsWith(prefix,0) ;
	}
	/**
	 * �ж��ַ����Ƿ��Ժ�׺suffix��β
	 * @param suffix
	 * @return
	 */
	public boolean endsWith(String suffix){
		return startsWith(suffix,value.length - suffix.value.length) ;
	}
	/**
	 * �����ַ��滻���ַ�
	 * @param oldChar
	 * @param newChar
	 * @return
	 */
	public String replace(char oldChar, char newChar){
		if(oldChar != newChar){
			char[] newValue = new char[value.length] ;
			for(int i=0;i<value.length;i++){
				newValue[i] = (charAt(i) == oldChar ? newChar : charAt(i)) ;
			}
			return new String(newValue) ;
		}
		return this ;
	}
	/**
	 * toString
	 */
	@Override
	public java.lang.String toString(){
		return new java.lang.String(this.value) ;
	}
	@Override
	public CharSequence subSequence(int start, int end) {
		return null;
	}

}
