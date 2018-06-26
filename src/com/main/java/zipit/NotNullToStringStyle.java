package com.main.java.zipit;

import java.util.Collection;

import org.apache.commons.lang.builder.ToStringStyle;

public final class NotNullToStringStyle extends ToStringStyle {
    public static final ToStringStyle NOT_NULL_STYLE = new NotNullToStringStyle();

    public static final String CONTENT_START_SPACE = " ";
    public static final String FIELD_SEPARATOR_COMMA = ", ";
    public static final String CONTENT_END_DOT = ".";
    private static final long serialVersionUID = 1L;

    /**
     * <p>Ensure <code>Singleton</code> after serialization.</p>
     *
     * @return the singleton
     */
    private Object readResolve() {
        return NOT_NULL_STYLE;
    }

    @Override
    public void append(StringBuffer buffer, String fieldName, Object value, Boolean fullDetail) {
        if (value != null) {
            appendFieldStart(buffer, fieldName);
            appendInternal(buffer, fieldName, value, isFullDetail(fullDetail));
            appendFieldEnd(buffer, fieldName);
        }
    }
    
    @Override
    protected void appendDetail(StringBuffer buffer, String fieldName, Collection coll) {
    	// TODO Auto-generated method stub
    	buffer.append(fieldName);
    	super.appendDetail(buffer, fieldName, coll);
    }
    
    public NotNullToStringStyle contentStart(String contentStart){
		this.setContentStart(contentStart);
		return this;
	}
	public NotNullToStringStyle contentEnd(String contentEnd){
		this.setContentEnd(contentEnd);
		return this;
	}
	
	public NotNullToStringStyle fieldSeparator(String fieldSeparator){
		this.setFieldSeparator(fieldSeparator);
		return this;
	}
	
	public NotNullToStringStyle isFieldSeparatorAtStart(boolean isFieldSeparatorAtStart){
		this.setFieldSeparatorAtStart(isFieldSeparatorAtStart);
		return this;
	}
	
	public NotNullToStringStyle useFieldName(boolean useFieldName){
		this.setUseFieldNames(useFieldName);
		return this;
	}
	
	public NotNullToStringStyle useClassName(boolean useClassName){
		this.setUseClassName(useClassName);
		return this;
	}
	
	public NotNullToStringStyle useIdentityHashCode(boolean useIdentityHashCode){
		this.setUseIdentityHashCode(useIdentityHashCode);
		return this;
	}
	
	public NotNullToStringStyle useFielNameValueSeparator(String nameValueSeparator){
		this.setFieldNameValueSeparator(nameValueSeparator);
		return this;
	}
	
}
