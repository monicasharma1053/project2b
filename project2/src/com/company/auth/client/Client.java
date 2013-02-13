package com.company.auth.client;

import javax.jws.WebService;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.company.auth.bean.Employee;
import com.company.auth.service.AuthService;

@WebService(targetNamespace = "http://client.auth.company.com/", portName = "ClientPort", serviceName = "ClientService", endpointInterface = "com.company.auth.client.client_sei")
public final class Client implements client_sei {

    private Client() {
    } 

    public static void main(String args[]) throws Exception {

    	JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

    	factory.setBindingId("http://cxf.apache.org/bindings/xformat");
    	factory.getInInterceptors().add(new LoggingInInterceptor());
    	factory.getOutInterceptors().add(new LoggingOutInterceptor());
    	factory.setServiceClass(AuthService.class);
    	factory.setAddress("http://localhost:7001/authManager/services/cxfAuth");
    	AuthService client = (AuthService) factory.create();

    	Employee employee = client.getEmployee("0223938");
    	System.out.println("Server said: " + employee.getLastName() + ", " + employee.getFirstName());
    	System.exit(0);

    }

}