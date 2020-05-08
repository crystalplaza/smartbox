package smartbox;

import mvc.*;
public class RunCommand extends Command{

	public RunCommand(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}
    
	protected void execute() {
		// TODO Auto-generated method stub
		Container container = (Container) model;
		String name = Utilities.ask("Component name?");
		try {
			container.launch(name);
		}catch(Exception e) {
			//Utilities.error("must be component name");
			Utilities.error(e.getMessage());
			//System.out.println("The name:" + name);
		}
	}
	
	
}
