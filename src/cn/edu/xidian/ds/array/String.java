package cn.edu.xidian.ds.array;

import java.util.Arrays;
/**
 * 
 * 类名称：String   
 * 类描述：默认String的实现   
 * 创建人：WangPeng  
 * 创建时间：2014-7-29 下午11:32:08   
 * 修改人：WangPeng   
 * 修改时间：2014-7-29 下午11:32:08   
 * 修改备注：   
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
	/** 无参构造器 */
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
	 * 字符串是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return value.length == 0 ;
	}
	/**
	 * 返回字符串长度
	 */
	@Override
	public int length() {
		return value.length;
	}
	/**
	 * 比较两个字符串的大小
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
	 * 返回指定索引处的字符
	 */
	@Override
	public char charAt(int index) {
		if(index<0 || index >= value.length){
			throw new ArrayIndexOutOfBoundsException("Size:" + value.length + "Index:" + index) ;
		}
		return value[index];
	}
	/**
	 * 连接两个字符串
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
	 * 返回指定字符在字符串中的索引,从第fromIndex个索引开始向后查找
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
	 * 返回指定字符在字符串中的索引，从第0个索引开始向后查找
	 * @param ch
	 * @return
	 */
	public int indexOf(char ch){
		return indexOf(ch,0) ;
	}
	/**
	 * 返回指定字符在字符串中的索引,从第fromIndex个索引开始向前查找
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
	 * 返回指定字符在字符串中的索引,从第0个索引开始向前查找
	 * @param ch
	 * @return
	 */
	public int lastIndexOf(char ch){
		return lastIndexOf(ch,value.length-1) ;
	}
	/**
	 * 判断两个字符串是否相等
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
	 * 从指定位置开始搜索字符串，判断子字符串是否以前缀prefix开始
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
	 * 从0开始搜索字符串，判断子字符串是否以前缀prefix开始
	 * @param prefix
	 * @return
	 */
	public boolean startsWith(String prefix){
		return startsWith(prefix,0) ;
	}
	/**
	 * 判断字符串是否以后缀suffix结尾
	 * @param suffix
	 * @return
	 */
	public boolean endsWith(String suffix){
		return startsWith(suffix,value.length - suffix.value.length) ;
	}
	/**
	 * 用新字符替换旧字符
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
