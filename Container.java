package smartbox;

import java.util.*;
import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import mvc.*;

public class Container extends Model {

	private Map<Class<?>, Component> providedInterfaces = new HashMap<Class<?>, Component>();
	private Map<Class<?>, Component> requiredInterfaces = new HashMap<Class<?>, Component>();
    private Map<String, Component> components = new HashMap<String, Component>();

	public Collection<Component> getComponents() {
		return components.values();
	}

	public void addComponent(String name) throws Exception {
		String qualName = "smartbox.components." +  name;
		//Object obj = a new instance of qualName;
		Class c = Class.forName(qualName);
		Object obj = c.getDeclaredConstructor().newInstance();
		addComponent((Component)obj);
	}


	private void addComponent(Component component) throws Exception {
		component.setContainer(this);
		// add new guy to the components table:
		components.put(component.name, component);
		// components.put(component.get(name), component);
		// update provided interfaces table:
		for(Class<?> intf: component.getProvidedInterfaces()) {
			providedInterfaces.put(intf,  component);
		}
		// update required interfaces table:
		for(Class<?> intf: component.getRequiredInterfaces()) {
			requiredInterfaces.put(intf,  component);
		}
		//find providers for the new component and hook him up:
		findProviders();
		// mvc stuff:
		changed();
	}

	public void remComponent(String name) throws Exception {
		Component component = components.get(name);
		components.remove(name);
		// unhook removed guy from any clients:
		for(Class<?> intf: component.getProvidedInterfaces()) {
			for(Component client: components.values()) {
				if (client.getRequiredInterfaces().contains(intf)) {
					client.setProvider(intf,  null);
					requiredInterfaces.put(intf, client);
				}
			}
		}
		changed();
	}

	// each time we add a new component we try to connect as many clients and providers as we can:
	private void findProviders() throws Exception {
		Set<Class<?>> reqInterfaces = requiredInterfaces.keySet();
		for(Class<?> intf: reqInterfaces) {
			Component client = requiredInterfaces.get(intf);
			Component provider = providedInterfaces.get(intf);
			if (client != null && provider != null) {
				client.setProvider(intf,  provider);
				//requiredInterfaces.remove(intf);///?? why remove. We found the couple here, I should
				// remove it from it.
				requiredInterfaces.put(intf,null);
			}
		}
	}

	public void launch(String name) throws Exception {
		// look up component and call main if it's an App
		//System.out.println("launch:" + name);
		try {
		Component com = components.get(name); 
		if(com == null) {
			throw new Exception("Component does not exist: " + name);
		}
		if(!(com instanceof App) ) {
			throw new Exception("Component must be an App");
			
		}
		((App)com).main();
		}catch(Exception e) {
			mvc.Utilities.error(e.getMessage());
			e.printStackTrace();
		}
		//System.out.println("launch");
		
		// check if it is null or if it is instance of app
		
}
}
