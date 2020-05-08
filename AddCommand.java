package smartbox;

import mvc.*;
import turtle.Turtle;

public class AddCommand extends Command{

	public AddCommand(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Container container = (Container) model;
		String name = Utilities.ask("Component name?");
		try {
			container.addComponent(name);
		}catch(Exception e) {
			Utilities.error("must be component name");
		}
				
	}	
}

