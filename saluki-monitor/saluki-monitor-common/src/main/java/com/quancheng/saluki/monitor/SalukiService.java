package com.quancheng.saluki.monitor;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import com.google.common.collect.Sets;

public class SalukiService implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String      application;

    private final String      version;

    private final String      serviceName;

    private Set<SalukiHost>   providerHost;

    private Set<SalukiHost>   consumerHost;

    public SalukiService(String application, String version, String serviceName){
        this.application = application;
        this.version = version;
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getApplication() {
        return application;
    }

    public Set<SalukiHost> getProviderHost() {
        return providerHost;
    }

    public void setProviderHost(Set<SalukiHost> providerHost) {
        this.providerHost = providerHost;
    }

    public void addProviderHosts(Collection<SalukiHost> provideHost) {
        if (this.providerHost == null) {
            this.providerHost = Sets.newConcurrentHashSet();
        }
        this.providerHost.addAll(provideHost);
    }

    public Set<SalukiHost> getConsumerHost() {
        return consumerHost;
    }

    public void setConsumerHost(Set<SalukiHost> consumerHost) {
        this.consumerHost = consumerHost;
    }

    public void addConsumerHosts(Set<SalukiHost> consumerHosts) {
        if (this.consumerHost == null) {
            this.consumerHost = Sets.newConcurrentHashSet();
        }
        this.consumerHost.addAll(consumerHosts);
    }

    public String getVersion() {
        return version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((application == null) ? 0 : application.hashCode());
        result = prime * result + ((serviceName == null) ? 0 : serviceName.hashCode());
        result = prime * result + ((version == null) ? 0 : version.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        SalukiService other = (SalukiService) obj;
        if (application == null) {
            if (other.application != null) return false;
        } else if (!application.equals(other.application)) return false;
        if (serviceName == null) {
            if (other.serviceName != null) return false;
        } else if (!serviceName.equals(other.serviceName)) return false;
        if (version == null) {
            if (other.version != null) return false;
        } else if (!version.equals(other.version)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "SalukiService [serviceName=" + serviceName + ", prividerHost=" + providerHost + ", consumerHost="
               + consumerHost + "]";
    }

}
