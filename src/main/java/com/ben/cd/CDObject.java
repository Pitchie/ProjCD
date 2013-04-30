package com.ben.cd;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public abstract class CDObject implements Comparable<CDObject> {

	public static final String COLUMN_DEFINITION_TEXT = "text";
	
    @XmlElement
    public abstract Long getId();

    @Override
    public int hashCode() {
        return getId() == null ? 0 : getId().hashCode();
    }
    
    @Override
    public boolean equals(Object o) {
        return o instanceof CDObject
                && ((getId() == null && ((CDObject) o).getId() == null) 
                || (getId() != null && getId().equals(((CDObject) o).getId())));
    }

    
    public int compareTo(CDObject co) {
        return getId().compareTo(co.getId());
    }
}