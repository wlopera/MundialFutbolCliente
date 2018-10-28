package com.wlopera.cliente.cmf.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.wlopera.cliente.cmf.api.MundialFutbolClienteApi;
import com.wlopera.cliente.cmf.soap.Campeonato;
import com.wlopera.cliente.cmf.soap.ClienteCMFServicio;

public class MundialFutbolClienteService implements MundialFutbolClienteApi {

	@Override
	public List<Campeonato> getListaCMFPorCampeonatoGanado(String numeroCMFGanados) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Campeonato> getListaCMFTodos() {

		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

		// Agregar el endpoint del WSDL
		factory.setAddress("http://localhost:8080/MundialesFutbol/services/ClienteCMFServicioPort");

		// Uso de clase autogenrada por Apache CXF wsdl2java
		factory.setServiceClass(ClienteCMFServicio.class);

		Object cliente = factory.create();

		List<Campeonato> campeones = new ArrayList<>();

		try {

			// Call the Web Service to perform an operation
			campeones = ((ClienteCMFServicio) cliente).getListaCMFTodos();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return campeones;
	}

	@Override
	public Campeonato getCMFPorAnnio(String annio) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] arg) {
		System.out.println("test...");
		MundialFutbolClienteService cmf = new MundialFutbolClienteService();
		List<Campeonato> campeones = cmf.getListaCMFTodos();

		for (Campeonato campeon : campeones) {
			System.out.println(campeon.getAnnio() + " -- " + campeon.getNombreCampeon() + " -- "
					+ campeon.getNonbreSubcampeon() + " -- " + campeon.getResultado());
		}

	}

}
