package smartbox;

import mvc.*;


public class ContainerFactory implements AppFactory {

	public Model makeModel() {return new Container();}
	
	public String[] getEditCommands() 
	{
		return new String[] {"Add", "Rem", "Run"};
	}
	
	public Command makeEditCommand(Model model, String type)
	{

		if(type == "Add") return new AddCommand(model);
		if(type == "Rem")  return new RemCommand(model);
		if(type == "Run") return new RunCommand(model);
		return null;
		
	}
	
	public String getTitle() {return "Smart Box";}
	
	public String[] getHelp()
	{
		return new String[] {"click buttons to make changes"};
	}
	

	public String about()
	{
		return "Smart Box version1.0. Copyright 2020.";
	}

}
