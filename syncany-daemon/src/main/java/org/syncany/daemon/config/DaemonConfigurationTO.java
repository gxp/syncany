/*
 * Syncany, www.syncany.org
 * Copyright (C) 2011-2013 Philipp C. Heckel <philipp.heckel@gmail.com> 
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.syncany.daemon.config;

import java.io.File;
import java.util.logging.Logger;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Commit;
import org.simpleframework.xml.core.Complete;
import org.simpleframework.xml.core.Persist;
import org.simpleframework.xml.core.Persister;

/**
 * @author Vincent Wiencek <vwiencek@gmail.com>
 */
@Root(name="syncany-gui-config")
public class DaemonConfigurationTO {
	private static final Logger log = Logger.getLogger(DaemonConfigurationTO.class.getSimpleName());
	
	@Element(name="proxyHost", required=false)
	private String proxyHost;
	
	@Element(name="proxyPort", required=false)
	private String proxyPort;
	
	@Element(name="proxyUsername", required=false)
	private String proxyUsername;
	
	@Element(name="proxyPassword", required=false)
	private String proxyPassword;
	
	@Element(name="proxyAuth", required=false)
	private boolean proxyAuth;

	@Element(name="proxyType", required=true)
	private String proxyType;

	public static DaemonConfigurationTO load(File file) throws Exception {
		try {
			return new Persister().read(DaemonConfigurationTO.class, file);
		}
		catch (Exception ex) {
			log.warning("Application configuration file does not exist or is invalid: " + file);
			throw ex;
		}
	}


	@Persist
	public void prepare() {
		
	}

	@Complete
	public void release() {
	}
	
	
	@Commit
	public void commit() {

	}

	public String getProxyHost() {
		return proxyHost;
	}

	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	public String getProxyPort() {
		return proxyPort;
	}

	public void setProxyPort(String proxyPort) {
		this.proxyPort = proxyPort;
	}

	public String getProxyUsername() {
		return proxyUsername;
	}

	public void setProxyUsername(String proxyUsername) {
		this.proxyUsername = proxyUsername;
	}

	public String getProxyPassword() {
		return proxyPassword;
	}

	public void setProxyPassword(String proxyPassword) {
		this.proxyPassword = proxyPassword;
	}

	public boolean isProxyAuth() {
		return proxyAuth;
	}

	public void setProxyAuth(boolean proxyAuth) {
		this.proxyAuth = proxyAuth;
	}
	
	public void setProxyType(String proxyType) {
		this.proxyType = proxyType;
	}
	
	public String getProxyType(){
		return proxyType;
	}
}
