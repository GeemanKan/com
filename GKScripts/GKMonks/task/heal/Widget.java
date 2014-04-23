package GKScripts.GKMonks.task.heal;

import java.awt.Dimension;

import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;

import GKScripts.GKMonks.task.Task;

public class Widget extends Task {

	public Widget(ClientContext ctx) {
		super(ctx);
	}

	public boolean activate() {
		
		Dimension c = new Dimension(1191, 11);
		Dimension c1 = new Dimension(1184, 11);
		Dimension c2 = new Dimension(1186, 3);
		Dimension h = new Dimension(1188, 12);

		
		Dimension[] array = {c, c1, c2, h};
		for(Dimension d : array){
			int x = d.width;
			int y = d.height;
			if(ctx.widgets.component(x, y).valid()){
				return true;
			}
		}
		
		return false;
	}

	public void execute() {
		
		Dimension c = new Dimension(1191, 11);
		Dimension c1 = new Dimension(1184, 11);
		Dimension c2 = new Dimension(1186, 3);
		Dimension h = new Dimension(1188, 12);
		
		Dimension[] array = {c, c1, c2, h};
		for(Dimension d : array){
			int x = d.width;
			int y = d.height;
			Component current = ctx.widgets.component(x, y);
			if(current.valid()){
				ctx.widgets.component(x, y).click();
			}
		}
	}

	
	
}
