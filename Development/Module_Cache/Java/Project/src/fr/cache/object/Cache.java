package fr.cache.object;

/*
 * Copyright 2015-2017 Emmanuel ZIDEL-CAUFFET
 *
 * This class is used in a project designed by some Ecole Centrale de Lille students.
 * This program is distributed in the hope that it will be useful.
 * 
 * It is a free code: you can redistribute it and/or modify it under the terms of the GNU General Public License 
 * as published by the Free Software Foundation, either Version 3 of the License.
 *
 * However the source code is distributed without any warranty
 * See the GNU General Public License for more details.
 *
 */


import com.google.gson.annotations.*;
import java.util.Date;
import fr.webservicecore.object.APIObject;

/**
 * Indicates when the last updates were made on the server
 * @author Zidmann (Emmanuel ZIDEL-CAUFFET)
 * @version 1.1.0
 */
public class Cache implements APIObject
{
	/**
	 * Date of the last update on the server
	 */
	@Expose
	@Since(1.0)
	private Date lastUpdate 	= null;

	/**
	 * Date of the last POST update on the server
	 */
	@Expose
	@Since(1.0)
	private Date lastPostUpdate	= null;

	/**
	 * Date of the last PUT update on the server
	 */
	@Expose
	@Since(1.0)
	private Date lastPutUpdate 	= null;

	/**
	 * Date of the last DELETE update on the server
	 */
	@Expose
	@Since(1.0)
	private Date lastDeleteUpdate = null;

	/**
	 * Constructor Cache
	 */ 
	public Cache(){
		
	}

	/**
	 * Constructor Cache
	 * @param lastUpdate Date of the last update on the server
	 * @param lastPostUpdate Date of the last POST update on the server
	 * @param lastPutUpdate Date of the last PUT update on the server
	 * @param lastDeleteUpdate Date of the last DELETE update on the server
	 */ 
	public Cache(Date lastUpdate, Date lastPostUpdate, 
				 Date lastPutUpdate, Date lastDeleteUpdate){
		this.lastUpdate 	  = lastUpdate;
		this.lastPostUpdate   = lastPostUpdate;
		this.lastPutUpdate 	  = lastPutUpdate;
		this.lastDeleteUpdate = lastDeleteUpdate;
	}

	public Date getLastUpdate(){
		return this.lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate){
		this.lastUpdate = lastUpdate;
	}
	public Date getLastPostUpdate(){
		return this.lastPostUpdate;
	}
	public void setLastPostUpdate(Date lastPostUpdate){
		this.lastPostUpdate = lastPostUpdate;
	}
	public Date getLastPutUpdate(){
		return this.lastPutUpdate;
	}
	public void setLastPutUpdate(Date lastPutUpdate){
		this.lastPutUpdate = lastPutUpdate;
	}
	public Date getLastDeleteUpdate(){
		return this.lastDeleteUpdate;
	}
	public void setLastDeleteUpdate(Date lastDeleteUpdate){
		this.lastDeleteUpdate = lastDeleteUpdate;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((this.lastDeleteUpdate == null) ? 0 : this.lastDeleteUpdate.hashCode());
		result = prime * result
				+ ((this.lastPostUpdate == null) ? 0 : this.lastPostUpdate.hashCode());
		result = prime * result
				+ ((this.lastPutUpdate == null) ? 0 : this.lastPutUpdate.hashCode());
		result = prime * result
				+ ((this.lastUpdate == null) ? 0 : this.lastUpdate.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Cache other = (Cache) obj;
		if (this.lastDeleteUpdate == null) {
			if (other.lastDeleteUpdate != null)
				return false;
		} else if (!this.lastDeleteUpdate.equals(other.lastDeleteUpdate))
			return false;
		if (this.lastPostUpdate == null) {
			if (other.lastPostUpdate != null)
				return false;
		} else if (!this.lastPostUpdate.equals(other.lastPostUpdate))
			return false;
		if (this.lastPutUpdate == null) {
			if (other.lastPutUpdate != null)
				return false;
		} else if (!this.lastPutUpdate.equals(other.lastPutUpdate))
			return false;
		if (this.lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!this.lastUpdate.equals(other.lastUpdate))
			return false;
		return true;
	}

	/**
	 * Implementation of 'isEmpty' function to respect APIObject interface
	 * @return Always false
	 */
	public boolean isEmpty() {
		return false;
	}
}