package com.wlopera.cliente.cmf.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.wlopera.cliente.cmf.soap.Campeonato;
import com.wlopera.cliente.cmf.soap.ClienteCMFServicio;

public class MundialFutbolClienteImpl implements MundialFutbolClienteApi {

	private static ClienteCMFServicio instance = null;

	// retorna la instancia singleton creada
	public static ClienteCMFServicio getInstance() {

		if (null == instance) {
			JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

			// Agregar el endpoint del WSDL
			factory.setAddress("http://localhost:8080/MundialesFutbol/services/ClienteCMFServicioPort");

			// Uso de clase autogenerada por Apache CXF wsdl2java
			factory.setServiceClass(ClienteCMFServicio.class);

			instance = (ClienteCMFServicio) factory.create();
		}
		return instance;
	}

	@Override
	public List<Campeonato> getListaCMFPorCampeonatoGanado(String numeroCMFGanados) {
		List<Campeonato> campeones = new ArrayList<>();
		try {
			campeones = getInstance().getListaCMFPorCampeonatoGanado(numeroCMFGanados);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return campeones;
	}

	@Override
	public List<Campeonato> getListaCMFTodos() {
		List<Campeonato> campeones = new ArrayList<>();
		try {
			campeones = getInstance().getListaCMFTodos();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return campeones;
	}

	@Override
	public Campeonato getCMFPorAnnio(String annio) {
		Campeonato campeonato = new Campeonato();
		try {
			campeonato = getInstance().getCMFPorAnnio(annio);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return campeonato;
	}

	public static void main(String[] arg) {
		MundialFutbolClienteImpl cmf = new MundialFutbolClienteImpl();
		List<Campeonato> campeones = cmf.getListaCMFTodos();
		for (Campeonato campeon : campeones) {
			System.out.println(campeon.getAnnio() + " -- " + campeon.getNombreCampeon() + " -- "
					+ campeon.getNonbreSubcampeon() + " -- " + campeon.getResultado());
		}
	}
}