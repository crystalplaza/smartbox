package smartbox;

import mvc.*;
public class RemCommand extends Command {

	public RemCommand(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}
    
	protected void execute() {
		// TODO Auto-generated method stub
		Container container = (Container) model;
		String name = Utilities.ask("Component name?");
		try {
			container.remComponent(name);
		}catch(Exception e) {
			Utilities.error("must be component name");
		}
	}
	
	
}
